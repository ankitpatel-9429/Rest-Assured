package APITesing;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Local_api_tests {

	@Test
	public void test_get() {

		baseURI = "http://localhost:3000/";

		given().get("users").then().statusCode(200).log().all();

	}

	@Test
	public void test_get_01() {

		baseURI = "http://localhost:3000/";

		given().param("name", "computer").get("subjects").then().statusCode(200).log().all();

	}

	// @Test
	public void test_post() {
		JSONObject request = new JSONObject();

		request.put("firstname", "Tom");
		request.put("lastname", "Patel");
		request.put("subjectId", 1);

		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "Application/Json")
				.body(request.toJSONString()).when().post("users").then().statusCode(201).log().all();

	}

	// @Test
	public void test_patch() {
		JSONObject request = new JSONObject();

		request.put("lastname", "Shah");

		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "Application/Json")
				.body(request.toJSONString()).when().patch("users/4").then().statusCode(200).log().all();

	}

	// @Test
	public void test_put() {
		JSONObject request = new JSONObject();

		request.put("firstname", "Marry");
		request.put("lastname", "Patel");
		request.put("subjectId", 1);

		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "Application/Json")
				.body(request.toJSONString()).when().put("users/4").then().statusCode(200).log().all();

	}

	@Test
	public void test_delete() {

		baseURI = "http://localhost:3000/";

		when().delete("users/4").then().statusCode(200);
	}

}
