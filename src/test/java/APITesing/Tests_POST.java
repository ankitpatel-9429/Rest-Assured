package APITesing;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Tests_POST {

	//@Test
	public void test_1_post() {

//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Ankit");
//		map.put("job", "Teacher");
//
//		System.out.println(map);

		JSONObject request = new JSONObject();

		request.put("name", "Ankit");
		request.put("job", "teacher");
		System.out.println(request);
		System.out.println(request.toJSONString());

		given().
				header("Contact-Type", "Application/Json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(request.toJSONString()).when().
				post("https://reqres.in/api/users").then().statusCode(201);

	}
	
	
	//@Test
	public void test_2_put() {

		JSONObject request = new JSONObject();

		request.put("name", "Ankit");
		request.put("job", "teacher");
		System.out.println(request);
		System.out.println(request.toJSONString());

		given().
				header("Contact-Type", "Application/Json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(request.toJSONString()).when().
				put("https://reqres.in/api/users/2").then().statusCode(200);

	}
	

	//@Test
	public void test_3_patch() {

		JSONObject request = new JSONObject();

		request.put("name", "Ankit");
		request.put("job", "teacher");
		System.out.println(request);
		System.out.println(request.toJSONString());

		given().
				header("Contact-Type", "Application/Json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(request.toJSONString()).when().
				patch("https://reqres.in/api/users/2").then().statusCode(200).log().all();

	}
	
	@Test
	public void test_4_dalete() {

				when().
				delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();

	}
}
