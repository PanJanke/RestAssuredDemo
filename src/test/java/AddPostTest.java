import io.restassured.http.ContentType;
import model.Post;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class AddPostTest extends  BaseTest{
    @Test
    public void addPost() {
        Post post = new Post("Nowy tytul","Nieznany");

        Post createdPost = given()
                                .spec(requestSpec)
                                .body(post)
                            .when()
                                .post()
                            .then()
                                .statusCode(201)
                                .contentType(ContentType.JSON)
                                .extract().body().as(Post.class);

        assertEquals(createdPost,post);
    }

    @Test
    public void ResponseTimeTest() {
        Post post = new Post("Nowy tytul","Nieznany");

        given()
                .spec(requestSpec)
                .body(post)
        .when()
                .post()
        .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .time(Matchers.lessThan(responseTime), TimeUnit.MILLISECONDS);
    }
}
