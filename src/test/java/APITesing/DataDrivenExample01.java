package APITesing;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataDrivenExample01 extends DataForTest {

	

	@Test(dataProvider = "dataForPost1")
	public void test_POST(String fname, String lname, String stdId) {
		int b = Integer.parseInt(String.valueOf(stdId).split("\\.")[0]);
		baseURI = "http://localhost:3000/";
		
		
		JSONObject data = new JSONObject();

		data.put("firstname", fname.toString());
		data.put("lastname", lname.toString());
		data.put("subjectId", b);

		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Contant-Type", "Application/json")
				.body(data.toJSONString()).when().post("users").then().statusCode(201).log().all();

	}
	
	//@Test(dataProvider = "dataForDelete")
	public void test_delete(int userId ) {
		baseURI = "http://localhost:3000/";
		
		when().delete("users/"+userId).then().statusCode(200).log().all();
		
	}
	
	
	//@Parameters ({"userId"})
	//@Test()
	public void test_delete01(int userId ) {
		baseURI = "http://localhost:3000/";
		
		when().delete("users/"+userId).then().statusCode(200).log().all();
		
	}

}
