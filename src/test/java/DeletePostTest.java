import io.restassured.http.ContentType;
import model.Post;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class DeletePostTest extends BaseTest {
    @Test
    public void DeletePost(){
        given()
                .pathParam("postId",5)
                .spec(requestSpec)
        .when()
                .delete("{postId}")
        .then()
                .spec(responseSpec);
    }


    @Test
    public void ResponseTimeTest() {
        given()
                .pathParam("postId",7)
                .spec(requestSpec)
        .when()
                .delete("{postId}")
        .then()
                .spec(responseSpec)
                .time(Matchers.lessThan(responseTime), TimeUnit.MILLISECONDS);
    }


}
