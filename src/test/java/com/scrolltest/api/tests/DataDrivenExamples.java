package com.scrolltest.api.tests;

import static io.restassured.RestAssured.*; //will import everything 

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExamples extends DataForTests {

	/**
	 * DDT (data driven test): learn to provide data externally and be able to run
	 * the test multiple times equal to the sets of data we have
	 * 
	 * We use TestNG DataProvider: This helps to write data driven tests, some test
	 * can be run multiple times with different sets of data, we use the
	 * annotation @DataProvider, the annotated method is used return object
	 * containing test data, the test data can be used in actual tests
	 * 
	 */

	@SuppressWarnings("unchecked")
	//@Test(dataProvider = "DataForPost")
	public void test_POST(String firstName, String lastName, int subjectId) { // give the arguments in the function

		JSONObject request = new JSONObject();

		request.put("firstName", firstName);// three values
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);

		baseURI = ("http://localhost:3000");

		given().header("Content-Type", "application/jason").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("/users:").then().statusCode(201).log().all();
	}

	@DataProvider(name = "deleteData")
	public void test_delete(int userId) {

		baseURI = ("http://localhost:3000");

		when().delete("/users:/" + userId).then().statusCode(200).log().all();

	}

	/**
	 * 
	 * @param userId is used when you do not have lots of data. right click on this
	 * file in package explorer, click on TestNG, then convert to
	 * TestNG. this will create a test.xml file and thats where you
	 * specify the value for the parameters. You run the test from the test.xml file
	 * 
	 */
	@Parameters({ "userId", "name" })
	@DataProvider(name = "deleteData") // import from org.testng
	public void test_delete2(int userId) {

		baseURI = ("http://localhost:3000");

		when().delete("/users:/" + userId).then().statusCode(200).log().all();

	}

}
