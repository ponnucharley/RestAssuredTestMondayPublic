package restClasses;

import excelUtils.GettingDataFromExcel;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.io.IOException;

public class RestClass1 {

    String baseUri1 = GettingDataFromExcel.getDataFromExcel();

    RequestSpecification requestSpecification = RestAssured.given()
                                                .log().all()
                                                 .baseUri(baseUri1);

    public RestClass1() throws IOException {
    }

    @Test

    public void getData()
    {

        RestAssured.given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200);

    }

    @Test
public void verifyBody()
{

    String response = RestAssured.given()
            .log().all()
            .baseUri(baseUri1)
            .when()
            .get()
            .then()
            .log().all()
            .extract()
            .body().asString();

    System.out.println(response);
    JsonPath json = new JsonPath(response);
        String title = json.getString("title");
System.out.println( "Title is " + title);
}

@Test
public void getPostById(){

    Response response =RestAssured.given()
            .log().all()
            .baseUri("https://jsonplaceholder.typicode.com/posts/1")
            .when()
            .get()
            .then()
            .log().all()
            .extract().response();
    System.out.println("Response is " + response);

    }

    @Test
    public void newPost()
    {
        RestAssured.given()
                .log().all()
                .baseUri(baseUri1)
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(404);


    }




}
