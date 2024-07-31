package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileProcessor { // implementeaza un map, adica perechi Key,Value
	

	// citesc din fisier 
	
	public static String readPropertiesFile(String Key, String file) { 
		
		
		//try inchide canalul de comunicare
		try(FileInputStream input = new FileInputStream(file)) { //fisierul trebuie sa existe
			
			Properties propFile = new Properties();// am creat fisierul pt a citi din el
			propFile.load(input);
			
			return propFile.getProperty(Key);			
			
		} catch(IOException e) {
			
			System.out.println("Nu am putut citi fisierul!");
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}
