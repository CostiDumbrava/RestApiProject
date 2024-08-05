package tests;

import com.github.fge.jsonschema.main.cli.Main;

public class TestUserDetails {
	
	public static void main(String[] args) {
		
	
	
	UserDetails userDetails = new UserDetails();
	
	userDetails.setFirstName("Ion");
	userDetails.setLastName("Popescu");
	userDetails.setCity("Brasov");
	userDetails.setAddress("Calea Sperantei Parter");
	
	System.out.println(userDetails.getFirstName());
	System.out.println(userDetails.getLastName());
	System.out.println(userDetails.getCity());
	System.out.println(userDetails.getAddress());

}
}