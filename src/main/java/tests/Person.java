package tests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //genereaza automat @Getter, @Setter, @ToString si Equals
@NoArgsConstructor //genereaza un constructor fara parametri
@AllArgsConstructor //genereaza un constructor cu toti parametri

public class Person {
	
	private String name;
	private String email;
	private int age;
	
	

}
