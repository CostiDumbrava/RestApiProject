package utils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import reportutils.ExtentManager;
import testdata.DataBuilder;

public class BaseComponent3 {
	
	String token;
	public static RequestSpecification requestSpec;
	public static ResponseSpecification responseSpec, negativeResponseSpec;
	
	@BeforeSuite                   //suita este cea mai inalta ierarhic
	public void beforeSuite() {
		
		ExtentManager.setReport();
	}
	
	@AfterSuite
	public void afterSuite() {
		
		ExtentManager.endReport();
		
	}
	
	
	@BeforeClass
	public void setup() {
	
		Response responseToken = given(). 
				contentType(ContentType.JSON). 
				body(DataBuilder.buildToken().toJSONString()). 
				post("https://dev-todo-b369f85c9f07.herokuapp.com/api/login")
				.then().extract().response();
				
		token = responseToken.jsonPath().getString("token");
		
		requestSpec = new RequestSpecBuilder(). 
				setContentType(ContentType.JSON). 
				setBaseUri("https://dev-todo-b369f85c9f07.herokuapp.com/"). 
				setBasePath("api/"). 
				addHeader("Authorization", "Bearer " +token).
				addHeader("accept", "application/json").build();
		
		
		responseSpec = new ResponseSpecBuilder(). 
				expectStatusCode(either(is(200)).or(is(201)).or(is(204)))
				.build();
		
		negativeResponseSpec = new ResponseSpecBuilder(). 
				expectStatusCode(either(is(403)).or(is(405)).or(is(406)))
				.build();
	}
	
	
	public static Response doRequest(String method, String param, String body) {
		
		Response result = null;
		
		switch(method.toUpperCase()) {
		
		case "GET" : result = given().spec(requestSpec).get(param);
		break;
		case "POST": result = given().spec(requestSpec).body(body).post(param);
		break;
		case "PATCH": result = given().spec(requestSpec).body(body).patch(param);
		break;
		case "DELETE": result = given().spec(requestSpec).body(body).delete(param);
		
		}
		
		if (result!=null)
			result = result.then().spec(responseSpec).extract().response();
		return result;
		
	}

}
