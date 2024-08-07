package tests;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import testdata.DataBuilder;
import utils.BaseComponent3;

public class BaseComponent3Test extends BaseComponent3{
	
	@Test
	public void postTodoWithToken() {
		
		Response response = doRequest("POST","save", DataBuilder.buildTodo().toJSONString());
		
		System.out.println(response.asPrettyString());
	}

}
