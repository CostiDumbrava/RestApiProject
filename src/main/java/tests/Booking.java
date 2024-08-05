package tests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
	
	
	/*
	 *  '{
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}'
	 * 
	 */
	
	
	public String firstname;
	public String lastname;
	public int totalprice;
	public boolean depositpaid;
	public BookingDates bookingdates;
	public String additionalneeds;
	

}
