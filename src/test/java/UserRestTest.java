import at.reinisoft.Application;
import at.reinisoft.domain.Address;
import at.reinisoft.domain.Title;
import at.reinisoft.domain.UserLite;
import at.reinisoft.repository.UserLiteRepository;
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
    UserLiteRepository repository;

    UserLite mickey = new UserLite();
    UserLite minnie = new UserLite();
    UserLite pluto = new UserLite();

    Address addressOne = new Address();
    Address addressTwo = new Address();
    Address addressthree = new Address();


    @Value("${local.server.port}")
            int port;

    @Before
    public void setUp() {
        // 7
        addressOne.setStreet("Hasendorferstrasse");
        addressOne.setStreetNumber(41);
        addressOne.setPostcode("8043");
        addressOne.setCountry("Leibnitz");


        addressTwo.setStreet("Franzsteinergasse");
        addressTwo.setStreetNumber(17);
        addressTwo.setPostcode("8020");
        addressTwo.setCountry("Graz");

        mickey.setLastName("Mickey Mouse");
        mickey.setTitle(Title.DI);
        mickey.setUserAddress(addressTwo);

        minnie.setLastName("Minnie Mouse");
        minnie.setTitle(Title.MAG);
        minnie .setUserAddress(addressOne);


        pluto.setLastName("Pluto");
        pluto.setTitle(Title.ING);
        pluto.setUserAddress(addressthree);

        // 8
        repository.deleteAll();
        repository.save(Arrays.asList(mickey, minnie, pluto));

        // 9
        RestAssured.port = port;
    }

    @Test
    public void canFetchMickey() {
        Long mickeyId = mickey.getId();

        when().get("/userLite/{id}", mickeyId).prettyPrint();
        when().get("/userLite/{id}/userAddress", mickeyId).prettyPrint();
        when().get("/userLite/{id}/shippingAddresses", mickeyId).prettyPrint();

        when().
                get("/userLite/{id}", mickeyId).
        then().
                statusCode(HttpStatus.SC_OK).
                body("lastName", Matchers.is("Mickey Mouse"));
    }

     @Test
    public void canFetchAll() {

        when().get("/userLite").prettyPrint();

        when().
                get("/userLite").
        then().
                statusCode(HttpStatus.SC_OK).
                body("_embedded.userLite.lastName", Matchers.hasItems("Mickey Mouse", "Minnie Mouse", "Pluto"));
    }

    @Test
    public void canDeletePluto() {
        Long plutoId = pluto.getId();

        when()
                .delete("/userLite/{id}", plutoId).
        then().
                statusCode(HttpStatus.SC_NO_CONTENT);

        when().get("/userLite").prettyPrint();
    }
}