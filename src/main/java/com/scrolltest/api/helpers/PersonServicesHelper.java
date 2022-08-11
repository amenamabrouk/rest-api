package com.scrolltest.api.helpers;
import static org.testng.Assert.assertEquals;
import java.lang.reflect.Type;
import java.util.List;
import org.apache.http.HttpStatus;
import com.fasterxml.jackson.databind.JavaType;
//import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty.Type;
import com.scrolltest.api.constants.EndPoints;
import com.scrolltest.api.model.Person;
import com.scrolltest.api.utils.ConfigManager;
import groovyjarjarasm.asm.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;




public class PersonServicesHelper {
	
	//file will have functions which will fetch the data from end points
	//GET/POST/PUT Single/PATCH/DELETE 
	
	// we need to read the config variables
	// Rest assured about the URL, port
	// Make a Get REQUEST on this URL and send the data to TestGetPerson
	
	
	/**
	 * Whenever the object of PersonServicesHelper is created, we will have the variables 
	 * already set automatilcy - base_URl and port from the config.properties file
	 */
	private static final String BASE_URL = ConfigManager.getInstance().getString("base_URL");
	private static final String PORT = ConfigManager.getInstance().getString("port");

	
	/**
	 * create a constructor to inform RestAssured what are the defult baseURL and port
	 * 
	 * The sole purpose of the constructor is to initialize the data fields of objects in the 
	 * class. Java constructor can perform any action but specially designed to perform 
	 * initializing actions, such as initializing the instance variables. 
	 * A constructor within a class allows constructing the object of the class at runtime
	 */
	public PersonServicesHelper() {
		RestAssured.baseURI = BASE_URL;
		//change to int since its a string in our 
		RestAssured.port = Integer.parseInt(PORT);
		//because we are using a local url, we need ot use useRelaxedHTTPSValidation. This means that 
		//we'll trust all hosts regardless if the SSL certificate is invalid. 
		RestAssured.useRelaxedHTTPSValidation(BASE_URL);
	}
	
	//GET
	public List<Person> getAllPerson(){
		Response response = RestAssured
				.given().log().all()
				.contentType(ContentType.JSON)
				.get(EndPoints.GET_ALL_PERSON)
				.andReturn();

	    //we need to return with the POJO for mapping 
		//Type type = new TypeReference<List<Person>>(){}.getType();
		
		assertEquals(response.getStatusCode(), HttpStatus.SC_OK,"Ok" );
		return null;
		
		//List<Person> personList = response.as(type);
		//return personList;
		
	}
	
	//POST 
	public Response CreatePerson() {
		
		Person person = new Person();
		person.setFirstName("Amit");
		person.setLastName("Singh");
		person.setPhoneNumber("444-567-9800");
		person.setAddress("636 S 12th St. Washington DC");
		
		// make a post call 
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.when()
				.body(person)
				.post(EndPoints.CREATE_PERSON)
				.andReturn();
		
		assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED, "Created");
		
		return response;
	}
	

}
