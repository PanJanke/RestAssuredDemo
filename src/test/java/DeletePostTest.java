import org.hamcrest.Matchers;
import org.testng.annotations.Test;

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
}
