package utils;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BaseComponent {
	
	
	@BeforeClass
	public void setup() {
		
		RestAssured.baseURI = "https://keytrcrud.herokuapp.com/";		
	}

	
	public static Response doPostRequest(String path, String reqBody, int statusCode) {
		
		Response response = given().
				contentType(ContentType.JSON).
				body(reqBody).
				when().
		        post(path).
		       then().
		       statusCode(statusCode).extract().response();
		
		return response;
	}
	
	public static Response doGetRequest(String path) {
		
		Response response = given().
				contentType(ContentType.JSON).
				when().  //poti sa nu scrii when(), e doar pt sintaxa
		        get(path).
		       then().
		       statusCode(200).extract().response();
		
		return response;
		
	}
	
	public static Response doPutRequest(String path, String reqBody, int statusCode) {
		
		Response response = given().
				contentType(ContentType.JSON).
				body(reqBody).
				when().
		        put(path).
		       then().
		       statusCode(statusCode).extract().response();
		
		return response;
	}
	
     public static Response doDeleteRequest(String path) {
		
		Response response = given().
				contentType(ContentType.JSON).
				when().  //poti sa nu scrii when(), e doar pt sintaxa
		        delete(path).
		       then().
		       statusCode(200).extract().response();
		
		return response;
		
	}
}
