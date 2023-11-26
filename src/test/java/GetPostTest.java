import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPostTest extends BaseTest {
    @Test
    public void getPost(){
        given()
                .pathParam("postId",1)
                .spec(requestSpec)
        .when()
                .get("{postId}")
        .then()
                .spec(responseSpec)
                .assertThat().body("title", Matchers.equalTo("pierwszy"))
                .assertThat().body("author", Matchers.equalTo("Bartek"));
    }

}
