package com.scrolltest.api.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scrolltest.api.helpers.PersonServicesHelper;

public class TestPOSTPerson {
	
	//initilize PersonServiceHelper 
	//Assert Create the Person and Verify it 
	
	private PersonServicesHelper personServiceHelper; 
	
	
	
	@BeforeClass 
	public void init() {
		personServiceHelper = new PersonServicesHelper();
	}
	
	
	//create a new test function
	@Test
	public void testPOSTCreatePerson() {
		String id = personServiceHelper.CreatePerson().jsonPath().getString("id");
		System.out.println(id);
		
		assertNotNull(id, "person ID is not Empty");
		
		
		
	}

}
