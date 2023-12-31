import model.Post;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class UpdatePostTest extends  BaseTest{
    @Test
    public void updatePost(){
        Post post = new Post("Nowy tytul","Nowy autor");

        Post createdPost = given()
                                .spec(requestSpec)
                                .pathParam("postId",4)
                                .body(post)
                            .when()
                                .put("{postId}")
                            .then()
                                .spec(responseSpec)
                                .extract().body().as(Post.class);

        assertEquals(post,createdPost);
    }
    @Test
    public void ResponseTimeTest() {
        Post post = new Post("Nowy tytul","Nowy autor");

        given()
                .spec(requestSpec)
                .pathParam("postId",4)
                .body(post)
        .when()
                .put("{postId}")
        .then()
                .spec(responseSpec)
                .time(Matchers.lessThan(responseTime), TimeUnit.MILLISECONDS);
    }


}
