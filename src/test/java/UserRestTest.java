import at.reinisoft.Application;
import at.reinisoft.domain.Title;
import at.reinisoft.domain.User;
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

import java.util.Arrays;

import static com.jayway.restassured.RestAssured.when;

/**
 * Created by stocki on 04.01.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class UserRestTest {

    @Autowired
    UserRepository repository;

    User mickey = new User();
    User minnie = new User();
    User pluto = new User();


    @Value("${local.server.port}")
            int port;

    @Before
    public void setUp() {
        // 7
        mickey.setLastName("Mickey Mouse");
        minnie.setLastName("Minnie Mouse");
        pluto.setLastName("Pluto");

        // 8
        repository.deleteAll();
        repository.save(Arrays.asList(mickey, minnie, pluto));

        // 9
        RestAssured.port = port;
    }

    @Test
    public void canFetchMickey() {
        Long mickeyId = mickey.getId();

        when().get("/user/{id}", mickeyId).prettyPrint();

        when().
                get("/user/{id}", mickeyId).
        then().
                statusCode(HttpStatus.SC_OK).
                body("lastName", Matchers.is("Mickey Mouse"));
                // body("id", Matchers.is(mickeyId));
    }

    /*@Test
    public void canFetchAll() {
        when().
                get("/characters").
                then().
                statusCode(HttpStatus.SC_OK).
                body("name", Matchers.hasItems("Mickey Mouse", "Minnie Mouse", "Pluto"));
    }

    @Test
    public void canDeletePluto() {
        Integer plutoId = pluto.getId();

        when()
                .delete("/characters/{id}", plutoId).
                then().
                statusCode(HttpStatus.SC_NO_CONTENT);
    }*/
}