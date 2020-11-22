package adapters;

import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpHeaders.CONTENT_TYPE;

public class BaseAdapter {

    private static final String TOKEN = "34ce88e4f9e6e8ebd92234678d0603c1d0f6aadc";
    private static final String URL = "https://api.qase.io/";

    Gson converter = new Gson();

    public String get(String uri) {
        return given()
                .header("Token", TOKEN)
                .header(CONTENT_TYPE, JSON)
                .log().all()
                .when()
                .get(URL + uri)
                .then()
                .log().all()
                .extract().body().asString();
    }

    public Response post(String uri, String body) {
        return given()
                .header("Token", TOKEN)
                .header(CONTENT_TYPE, JSON)
                .body(body)
                .log().all()
                .when()
                .post(URL + uri)
                .then()
                .log().all()
                .extract().response();
    }

    public void delete(String uri) {
        given()
                .header("Token", TOKEN)
                .header(CONTENT_TYPE, JSON)
                .log().all()
                .when()
                .delete(URL + uri)
                .then()
                .log().all();
    }
}
