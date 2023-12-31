import model.Post;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class PatchPostTest extends  BaseTest{
    @Test
    public void patchPost() {
        Post post = new Post("Zaktualizowany");

        Post createdPost = given()
                                .spec(requestSpec)
                                .pathParam("postId", 6)
                                .body(post)
                            .when()
                                .patch("{postId}")
                            .then()
                                .spec(responseSpec)
                                .extract().body().as(Post.class);

        assertEquals(createdPost.getTitle(),post.getTitle());
        assertEquals(createdPost.getAuthor(),"Kasia");
    }

    @Test
    public void ResponseTimeTest() {

        Post post = new Post("Zaktualizowany");
        given()
                .spec(requestSpec)
                .pathParam("postId", 6)
                .body(post)
        .when()
                .get("{postId}")
        .then()
                .spec(responseSpec)
                .time(Matchers.lessThan(responseTime), TimeUnit.MILLISECONDS);
    }

}
