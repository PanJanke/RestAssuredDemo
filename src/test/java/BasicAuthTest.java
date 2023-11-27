import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class BasicAuthTest extends BaseTest {
    @Test
    public void basicAuthCorrectCredentialsTest(){

        given()
                .auth().basic("postman","password")
        .when()
                .get("https://postman-echo.com/basic-auth")
        .then()
                .spec(responseSpec)
                .assertThat().body(Matchers.containsStringIgnoringCase("true"));
    }

    @Test
    public void basicAuthIncorrectCredentialsTest(){

        given()
                .auth().basic("postman","WronGpassword")
        .when()
                .get("https://postman-echo.com/basic-auth")
        .then()
                .assertThat().statusCode(401);
    }

    @Test
    public void ResponseTimeTest(){

        given()
                .auth().basic("postman","password")
        .when()
                .get("https://postman-echo.com/basic-auth")
        .then()
                .spec(responseSpec)
                .time(Matchers.lessThan(3000L), TimeUnit.MILLISECONDS);
    }


}
