import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidationTest extends BaseTest{
    @Test
    public void SchemaVaildationTest(){
        given()
                .pathParam("postId",1)
                .spec(requestSpec)
                .when()
                .get("{postId}")
        .then()
                .assertThat().body(matchesJsonSchemaInClasspath("postSchema.json"));
    }
}
