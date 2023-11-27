import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class GetPostsTest extends BaseTest {
    @Test
    public void getPosts(){
        given()
                .spec(requestSpec)
        .when()
                .get()
        .then()
                .spec(responseSpec)
                .assertThat().body("title[0]", Matchers.equalTo("pierwszy"))
                .assertThat().body("author[0]", Matchers.equalTo("Bartek"))
        .and()
                .assertThat().body("title[1]", Matchers.equalTo("drugi"))
                .assertThat().body("author[1]", Matchers.equalTo("Tomek"))
        .and()
                .assertThat().body("title[2]", Matchers.equalTo("trzeci"))
                .assertThat().body("author[2]", Matchers.equalTo("Kasia"));
    }

    @Test
    public void ResponseTimeTest() {
        given()
                .spec(requestSpec)
        .when()
                .get()
        .then()
                .spec(responseSpec)
                .time(Matchers.lessThan(responseTime), TimeUnit.MILLISECONDS);
    }

}
