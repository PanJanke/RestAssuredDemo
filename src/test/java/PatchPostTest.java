import model.Post;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class PatchPostTest extends  BaseTest{
    @Test
    public void patchPost() {
        Post post = new Post("Zaktualizowany");

        Post createdPost = given()
                                .spec(requestSpec)
                                .pathParam("postId", 3)
                                .body(post)
                            .when()
                                .patch("{postId}")
                            .then()
                                .spec(responseSpec)
                                .extract().body().as(Post.class);

        assertEquals(createdPost.getTitle(),post.getTitle());
        assertEquals(createdPost.getAuthor(),"Kasia");
    }
}
