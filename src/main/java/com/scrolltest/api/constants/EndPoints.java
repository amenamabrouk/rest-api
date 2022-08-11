package com.scrolltest.api.constants;

public class EndPoints {

	/** These are consents thats why we use all caps
	 * 
	 * 1. Public: makes classes, attributes, methods, and constructors accessible by another class. 
	 * 2. Static: can be accessed without creating an object of class
	 * 3. Final: proven variables from being overridden or modified 
	 * 
	 */

	public static final String GET_ALL_PERSON = "/users";
	public static final String SINGLE_PERSON = "/users/{id}";
	public static final String CREATE_PERSON = "/users";
	public static final String UPDATE_PERSON = "/users/{id}";

}
