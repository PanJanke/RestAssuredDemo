import model.Post;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class UpdatePostTest extends  BaseTest{
    @Test
    public void updatePost(){
        Post post = new Post("Nowy tytul","Nowy autor");

        Post createdPost = given()
                                .spec(requestSpec)
                                .pathParam("postId",2)
                                .body(post)
                            .when()
                                .put("{postId}")
                            .then()
                                .spec(responseSpec)
                                .extract().body().as(Post.class);

        assertEquals(post,createdPost);
    }
}
