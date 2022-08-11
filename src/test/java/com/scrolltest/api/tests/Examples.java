package com.scrolltest.api.tests;

import static io.restassured.RestAssured.baseURI;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
//we use a static import so we can directly use given() method, instead of creating a class or an object.
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

@SuppressWarnings("unused")
public class Examples {
	/**
	 * REST API for testing
	 * 
	 * 1. URL: https://github.com/typicode/json-server 
	 * 2. Command to install: npm
	 * Install -g json-server 
	 * 3. Start json server: json-server --watch db.json 
	 * 4.Status code: https://restfulapi.net/http-status-codes/
	 * 
	 * db.json: is a file created with default data
	 * 
	 * After you start the local json-server, you are able to view the default data
	 * at the provided URL in terminal: localhost:3000
	 * 
	 * 
	 * If baseURI not working after importing "import static
	 * io.restassured.RestAssured.*":
	 * https://stackoverflow.com/questions/52048957/import-static-io-restassured-restassured-not-working
	 */

	// @Test
	public void test_GET() { // creating a function

		RequestSpecification request = RestAssured.given();
		request.baseUri("http://localhost:3000");
		request.param("name", "Automation");
		request.get("/subjects").then().statusCode(200).log().all();
	}

	@SuppressWarnings("unchecked")
	// @Test
	public void test_POST() {
		/**
		 * If baseURI not working after importing "import static
		 * io.restassured.RestAssured.*" - USE THIS "import static
		 * io.restassured.RestAssured.baseURI;" Reference:
		 * https://stackoverflow.com/questions/52048957/import-static-io-restassured-restassured-not-working
		 */

		/**
		 * Add in dependency in pom.xml file json-simple:
		 * https://code.google.com/archive/p/json-simple/ from
		 * https://mvnrepository.com/
		 * 
		 * JSON: JavaScript Object Notation that is a very small weighted format to
		 * store and transport data. The JSON format is very easy to understand because
		 * it has a self-describing nature. JSON is mainly used to transmit data between
		 * a server and a web application.
		 * 
		 */
		JSONObject request = new JSONObject();

		request.put("firstName", "Tom");
		request.put("lastName", "Cooper");
		request.put("subjectId", 1);

		baseURI = ("http://localhost:3000");

		given().header("Content-Type", "application/jason").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("/users:").then().statusCode(201).log().all();
	}

	// @Test
	@SuppressWarnings("unchecked")
	public void test_PATCH() {
		/**
		 * <-PATCH-> is a method of modifying resources where the client sends <-partial
		 * data-> that is to be updated without modifying the entire data. "updating the
		 * resources at a location."
		 */
		JSONObject request = new JSONObject();

		request.put("lastName", "Shephered");

		baseURI = ("http://localhost:3000");

		given().header("Content-Type", "application/jason").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().patch("/users:/4").then().statusCode(200).log().all();
	}

	@SuppressWarnings("unchecked")
	//@Test
	public void test_PUT() {
		/**
		 * <-PUT-> is a method of modifying resources where the client sends data that
		 * updates the <-entire resource->.
		 */
		JSONObject request = new JSONObject();

		request.put("firstName", "Anna");
		request.put("lastName", "Rogger");
		request.put("subjectId", 2);

		baseURI = ("http://localhost:3000");

		given().header("Content-Type", "application/jason").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().put("/users:/4").then().statusCode(200).log().all();
	}

	//@Test
	public void test_DELETE() {

		baseURI = ("http://localhost:3000");

		when().delete("/users:/4").then().statusCode(200).log().all();

	}
}
