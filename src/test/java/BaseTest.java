import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    @BeforeSuite
    public void setUp(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:3000")
                .setBasePath("posts")
                .setContentType(ContentType.JSON)
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        RequestLoggingFilter reqLog = new RequestLoggingFilter();
        ResponseLoggingFilter resLog = new ResponseLoggingFilter();
        RestAssured.filters(resLog,reqLog);
    }
}
