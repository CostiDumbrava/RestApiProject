package tests;


import org.testng.annotations.Test;

import utils.BaseComponent2;
import io.restassured.response.Response;
import testdata.DataBuilder;

public class BaseComponent2Test extends BaseComponent2 {
	
	@Test
	public void postTodoWithToken() {
		
		Response response = doPostRequest("save", DataBuilder.buildTodo().toJSONString());
		
		System.out.println(response.asPrettyString());
	}
	

}
