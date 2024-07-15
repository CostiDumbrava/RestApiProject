package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import utils.BaseComponent;
import io.restassured.response.Response;
import testdata.DataBuilder;

public class BaseComponentExample extends BaseComponent {
	
	@Test(priority=1)
	public void createNewUser() {
		
		Response response = doPostRequest("api/users", DataBuilder.buildUser().toJSONString(),201);
		
		assertEquals(response.jsonPath().getString("success"), "true");
		
	}

}
