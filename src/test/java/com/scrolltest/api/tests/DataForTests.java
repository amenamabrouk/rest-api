package com.scrolltest.api.tests;

import org.testng.annotations.DataProvider;

public class DataForTests {
	
	/*
	if we want to create multiple users with different sets of data, 
	we would need to manually change the data and run the test. 

	@DataProvider(name = "DataForPost") // convert function to supplying data for a test method
	public Object[][] dataForPost() {

		Object[][] data = new Object[2][3]; // can store strings, and objects

		data[0][0] = "Albert";
		data[0][1] = "Einstein";
		data[0][2] = 2;

		data[1][0] = "Thomas";
		data[1][1] = "Edison";
		data[1][2] = 1;

		return data;
	}
	 */	
	
	/**
	 * Return data without specifying the exact number of rows and col as
	 * shown in the above example.
	 */
	@DataProvider(name = "DataForPost")
	public Object[][] dataForPost() {

		return new Object[][] { { "Graham", "Bell", 1 }, { "Haneen", "Nour", 2 }

		};
	}
	
	@DataProvider(name="deleteData")
	public Object[] dataForDelete() {
		return new Object[] {
				4,5,6,7 //delete id starting from 4 through 7		
		};
	}
	


	

}
