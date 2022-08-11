package com.scrolltest.api.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import com.scrolltest.api.helpers.PersonServicesHelper;
import com.scrolltest.api.model.Person;

public class TestGETPerson {

	private PersonServicesHelper personServiceHelper;

	@BeforeClass
	public void init() {
		// create an instance it will run the constructor in the
		// PersonServiesHelper.java file
		personServiceHelper = new PersonServicesHelper();

	}

	@Test
	public void testGetAllPerson() {
		List<Person> personList = personServiceHelper.getAllPerson();
		
		assertNotNull(personList, "person List is not Empty");
		assertFalse(personList.isEmpty(), "person List is not True");
		

	}

}
