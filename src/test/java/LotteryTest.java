import at.reinisoft.Application;
import at.reinisoft.CsvFileReader;
import at.reinisoft.repository.LotteryNumberRepository;
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
public class LotteryTest {

    @Autowired
    LotteryNumberRepository repository;


    @Value("${local.server.port}")
            int port;

    @Before
    public void setUp() {

        String fileName = System.getProperty("user.home")+"/Documents/Zahlem.cvs";


        System.out.println("\nRead CSV file:");
        // CsvFileReader.readCsvFile(fileName);

        // 8
        repository.deleteAll();
        repository.save(CsvFileReader.readCsvFile(fileName));

        // 9
        RestAssured.port = port;
    }

    @Test
    public void fetchLotteryNumbers() {

        when().get("/lottery/{id}", 1).prettyPrint();
    }


}