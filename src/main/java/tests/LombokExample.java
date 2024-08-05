package tests;

import org.testng.annotations.Test;

public class LombokExample {
	
	@Test
	public void testLombok() {
		
		Person person1 = new Person();
		person1.setName("Oana");
		person1.setEmail("oana@ioana.com");
		person1.setAge(29);
		System.out.println(person1);
		
		
		Person person2 = new Person ("Ion","ion@ion.com",25);
		System.out.println(person2);
		
	}

}
