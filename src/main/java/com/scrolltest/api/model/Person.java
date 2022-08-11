package com.scrolltest.api.model;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * This is a POJO Users classes because it does not extends or implement
 * properties from any technology or framework-related classes and interface.
 * This class is used to represent data.
 * 
 * 
 * Every field releated to firstName, lastName, will be maped to this Users class. 
 * 
 * { "firstName": "Nancy",
 * 	 "lastName": "Ella's", 
 *   "age": 23, 
 *   "subjectId": 6, 
 *   "id": 6, "address":
 *   "Chicago, USA", 
 *   "phoneNumber": "123-456-7890" 
 * }
 * 
 * Resources: https://www.jsonschema2pojo.org/ 
 * This will generate Plain Old Java Objects (POJO) from JSON or JSON-Schema 
 * 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ 
	"firstName", 
	"lastName", 
	"age", 
	"subjectId", 
	"id", 
	"address", 
	"phoneNumber" 
	})

public class Person {
	/**
	* We are mappping the firstName with a String. 
	* To make sure that "sensitive" data is hidden from users, we declare class variable as private. 
	* This is called Encapsulation. 
	*/
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("age")
	private Integer age;
	@JsonProperty("subjectId")
	private Integer subjectId;
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("address")
	private String address;
	@JsonProperty("phoneNumber")
	private String phoneNumber;
	/**
	 * This additionalProperty ignors any additional propers added to JSON
	 * Example: We add a phoneNumber to this JSON, we are ignoring it and not mapping it to 
	 * this class. 
	 */
	@JsonIgnore 
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * Because we're useing Encapsulation, we need public get and set methods to access and update the value of a 
	 * private variable. Whenever we create a new object we set the JSON and get JSON as shown below. 
	 * 
	 * The get method returns the value of the variable name. The set method takes a parameter (firstName) 
	 * and assigns it to the name variable. The this keyword is used to refer to the current object.
	 * 
	 */
	@JsonProperty("firstName")
	public String getFirstName() { // Getter
		return firstName;
	}

	@JsonProperty("firstName")
	public void setFirstName(String firstName) {  // Setter
		this.firstName = firstName;
	}

	@JsonProperty("lastName")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty("age")
	public Integer getAge() {
		return age;
	}

	@JsonProperty("age")
	public void setAge(Integer age) {
		this.age = age;
	}

	@JsonProperty("subjectId")
	public Integer getSubjectId() {
		return subjectId;
	}

	@JsonProperty("subjectId")
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@JsonProperty("phoneNumber")
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
