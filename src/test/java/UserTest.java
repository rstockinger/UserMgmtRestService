import at.reinisoft.Application;
import at.reinisoft.domain.*;
import at.reinisoft.repository.UserRepository;
import com.jayway.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.*;

import static com.jayway.restassured.RestAssured.when;


/**
 * Created by stocki on 04.01.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class UserTest {

    @Autowired
    UserRepository repository;

    User mickey = new User();
    User minnie = new User();
    User pluto = new User();

    UserRole adminRole = new UserRole();
    UserRolePermission permission = new UserRolePermission();

    HashSet<UserRolePermission> permissionHashSet = new HashSet<UserRolePermission>();
    HashSet<UserRole> userRoleHashSet = new HashSet<UserRole>();

    LastChange lastChange = new LastChange();


    @Value("${local.server.port}")
            int port;

    @Before
    public void setUp() {

        permission.setPermission(UserPermission.PERM_USERADMINISTRATION);
        permission.setUserRole(adminRole);
        permissionHashSet.add(permission);

        adminRole.setName("Admin");
        adminRole.setDescription("That's the Admin Role");
        adminRole.setRolePermissions(permissionHashSet);

        userRoleHashSet.add(adminRole);

        lastChange.setUser("Admin");
        lastChange.setDate(new Date(1263534231));

        mickey.setLastname("Mickey Mouse");
        mickey.setUsername("miMouse");
        mickey.setLastChange(lastChange);
        mickey.setUserRoles(userRoleHashSet);


        minnie.setLastname("Minnie Mouse");
        minnie.setUsername("minnie");
        minnie.setLastChange(lastChange);
        minnie.setUserRoles(userRoleHashSet);


        pluto.setLastname("Pluto");
        pluto.setUsername("pPluto");
        pluto.setLastChange(lastChange);
        pluto.setUserRoles(userRoleHashSet);

        // 8
        repository.deleteAll();
        repository.save(Arrays.asList(mickey,minnie,pluto));
        // repository.save(generateLongUserList(userRoleHashSet,lastChange));

        // 9
        RestAssured.port = port;
    }

    @Test
    public void canFetchMickey() {
        Long mickeyId = mickey.getId();

        when().get("/user/{id}", mickeyId).prettyPrint();

        when().get("/user/{id}/userRoles", mickeyId).prettyPrint();

        when().get("/userRole/{id}/users", adminRole.getId()).prettyPrint();

        when().
                get("/user/{id}", mickeyId).
        then().
                statusCode(HttpStatus.SC_OK).
                body("lastname", Matchers.is("Mickey Mouse"));
    }


    private List<User> generateLongUserList(HashSet<UserRole> userRoles, LastChange lastChange) {

        User tempUser = new User();
        List<User> longUserList = new ArrayList<User>();

        tempUser.setLastname("Mickey Mouse");
        tempUser.setUsername("miMouse");
        tempUser.setLastChange(lastChange);
        tempUser.setUserRoles(userRoles);


        for (int i = 0; i < 100; i++) {
            longUserList.add(tempUser);
        }

        return longUserList;
    }

}