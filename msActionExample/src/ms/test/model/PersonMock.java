package ms.test.model;

import java.util.ArrayList;
import java.util.List;

public class PersonMock {

	public static List<Person> getPersons(){
		List<Person> persons= new ArrayList<Person>();
		Person p = new Person();
		
		for(int i=1;i<20;i++){
			p= new Person(1, "Luca "+i, "Molini "+i, 20+1, i+" 339 4468972", i+"luca@gmail.com");
			persons.add(p);
		}
		
		
		return persons;
 	}
	
}
