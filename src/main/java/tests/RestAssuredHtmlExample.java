package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class RestAssuredHtmlExample {
	
	@Test
	public void testHtmlResponse() {
		
		Response resp= given().
				//contentType(ContentType.JSON).
				//contentType(ContentType.XML).
				//contentType(ContentType.HTML).
				get("https://run.mocky.io/v3/1b3bfe58-5285-4e85-a6de-b99cededc337").then().extract().response();
		
		System.out.println(resp.asString());
		
		String title = resp.htmlPath().getString("html.head.title");
		System.out.println("title: " +title);
		
		String nameLabel = resp.htmlPath().getString("html.body.form.div[0].label");
		System.out.println("name label: " +nameLabel);
		
		String emailLabel = resp.htmlPath().getString("html.body.form.div.label[1]");
		System.out.println("email label: " +emailLabel);
		
		String msgTextarea = resp.htmlPath().getString("html.body.form.div[2].textarea.@id");
		
		System.out.println(msgTextarea);
		
		String inputType = resp.htmlPath().getString("html.body.form.div[1].input.@type");
		System.out.println(inputType);
		
		String button = resp.htmlPath().getString("html.body.form.div[3].button");
		System.out.println(button);
		
		
	}

}
