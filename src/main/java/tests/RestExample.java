

package tests;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RestExample {
	
	@Test
	public void restExampleTest() {
		
		Response response = given()
				.headers("Content-Type", "application/json")
				.body("{\n"
							+ "    \"name\":\"Test\",\n"
							+ "    \"email\":\"test@test1234.com\",\n"
							+ "    \"age\":\"33\",\n"
							+ "    \"gender\":\"m\"\n"
							+ "    }")
				.when()
					.post("https://keytrcrud.herokuapp.com/api/users/")
				.then()
				.assertThat().statusCode(201).extract().response();
		
		System.out.println(response);
		System.out.println(response.asString());
		System.out.println(response.asPrettyString());

	}
	
	

}
