package tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TestRequestWithLombok {
	
	BookingDates bookDates =  new BookingDates("2024-01-01", "2024-09-09");
	Booking booking = new Booking("Ion", "Ion", 123, false, bookDates, "Dinner");
	
	@Test
	public void createBooking() {
		
		Response response = given().contentType(ContentType.JSON).body(booking).
				when().post("https://restful-booker.herokuapp.com/booking").then().extract().response();
		
		System.out.println(response.asString());
		
		BookingId bookingid = response.as(BookingId.class);
		System.out.println(bookingid.toString());
	}

}
