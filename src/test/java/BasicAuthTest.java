import model.User;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class BasicAuthTest extends BaseTest {

    private final String authURL = "https://postman-echo.com/basic-auth";
    @Test
    public void basicAuthCorrectCredentialsTest(){
        User user = new User("postman","password");

        given()
                .auth().basic(user.getUsername(), user.getPassword())
        .when()
                .get(authURL)

        .then()
                .spec(responseSpec)
                .assertThat().body(Matchers.containsStringIgnoringCase("true"));
    }

    @Test
    public void basicAuthIncorrectCredentialsTest(){
        User user = new User("postman","WrongPassw0rd");

        given()
                .auth().basic(user.getUsername(), user.getPassword())
        .when()
                .get(authURL)
        .then()
                .assertThat().statusCode(401);
    }

    @Test
    public void ResponseTimeTest(){
        User user = new User("postman","password");

        given()
                .auth().basic(user.getUsername(), user.getPassword())
        .when()
                .get(authURL)
        .then()
                .spec(responseSpec)
                .time(Matchers.lessThan(3000L), TimeUnit.MILLISECONDS);
    }


}
