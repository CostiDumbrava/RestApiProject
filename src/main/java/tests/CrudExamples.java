package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;

/*
 *  POST
 *  https://keytodorestapi.herokuapp.com/api/delete/66955026918f8b0014c
 *  GET
 *  https://keytodorestapi.herokuapp.com/api/:id
 *  GET ALL
 *  https://keytodorestapi.herokuapp.com/api
 *  PUT
 *  https://keytodorestapi.herokuapp.com/api/todos/:id
 *  DELETE
 *  https://keytodorestapi.herokuapp.com/api/delete/:id
 */


public class CrudExamples {
	
	JSONObject requestBody, requestBodyUpdate;
	
	String id = null;
	
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://keytodorestapi.herokuapp.com/";
		
		requestBody = new JSONObject();
		requestBodyUpdate = new JSONObject();
		Faker fake = new Faker();
		
		requestBody.put("title", fake.food().dish());
		requestBody.put("title", fake.chuckNorris().fact());
		
		requestBodyUpdate.put("title", fake.food().dish());
		requestBodyUpdate.put("title", fake.chuckNorris().fact());
		
	}
	
	@Test(priority=1)
	public void createTodo() {
		
	Response response =	
   given().
	  //headers("Content-Type", "application/json")
	  contentType(ContentType.JSON).
	  body(requestBody.toJSONString()).
	when().
	   post("api/save").
	then().
	   statusCode(200).
	   body("info", equalTo("Todo saved! Nice job!")).
       body("id", anything()).
       log().all().extract().response();
	
	id = response.jsonPath().getString("id");
	
	}
	
	@Test(priority=2)
	public void getTodo() {
		
		
		Response response = given().get("api/"+id).then()
				.statusCode(200)
		        .extract().response();
		
		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());
		System.out.println(response.jsonPath().getString("_id"));
		
		//testNG assert
		assertEquals(id, response.jsonPath().getString("_id"));
		
		//hamcrest assert --> e recomandat pentru RestAssure, nu in testNG
		assertThat(id, is(equalTo(response.jsonPath().getString("_id"))));
		
	}
	
	@Test(priority=3)
	public void updateTodo() {
		
		Response response = given().body(requestBodyUpdate.toJSONString()).put("api/todos/"+id).then().extract().response();
		
		System.out.println(response.asPrettyString());
		System.out.println(requestBodyUpdate.toJSONString());
	}
	
	@Test(priority=4)
	public void deleteTodo() {
		
		Response response = given().delete("api/delete/"+id).then().extract().response();
		
		System.out.println(response.asPrettyString());
	
	}
		

}
