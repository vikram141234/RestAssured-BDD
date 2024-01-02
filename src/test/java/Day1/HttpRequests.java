package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*
 * METHODS AVAILABLE IN REST ASSURED ARE:-GIVEN(),WHEN(),THEN(),AND(it is a part of then).
 *                                                          when multiple validations are there
given()
(ALL PRE REQUISITS WE HAVE TO KEEP INSIDE GIVEN)
(When ever we are sending requests we need some pre requisits)
(Type of content,Authentication,Query Parameters,Path Parameters,Cookies,Header Info etc
are used expecially in Post requests)

when()
(ALL REQUESTS WE HAVE TO KEEP INSIDE WHEN)
(In the when section we have to specify the request Type)
(get,put,post,delete. all the request URLs we have to keep inside When Section)

then()
(ALL VALIDATIONS WE HAVE TO KEEP INSIDE THEN)
(All validations we have to done in then section)
ex:-(validate status code,extract response,extract headers,cookies and response bodies.etc)

Url for Get Users List:-200 is Response Code
https://reqres.in/api/users?page=2     //Return Multiple Users Based on Page No.

Url for Get User :-200 is Response Code
https://reqres.in/api/users/2

Url For Post/Create User Request:-201 is Response Code
https://reqres.in/api/users
For Post/Create user we have to provide body
{
    "name": "morpheus",
    "job": "leader"
}

Url for Put/Update User:-200 is Response Code
https://reqres.in/api/users/2--->Here 2 is id(we have to give id of post/create Request   
And also Same as Get Users Url--Here we have to send the updated body
{
    "name": "morpheus",
    "job": "zion resident"
}

Url for Delete Request--->204 is the Response code
https://reqres.in/api/users/2-->Instead of 2 we have to provide User id //And Same as Get & Put/Upade Users Url 
                                      
                                       * 



*/
public class HttpRequests {
	
    @Test(priority=1)
	void getUsers() 
    {
		given()
		
		.when()
		     .get("https://reqres.in/api/users?page=2")
		.then()
		     .statusCode(200)
		     .body("page",equalTo(2))
		     .log().all();
		     
		     
	}
    @Test
    void createUser()
    {
    	HashMap data=new HashMap();
    	data.put("name", "vikram");
    	data.put("job", "tester");
    	
    	given()
    	     .contentType("application/json")
    	     .body(data)
    	
    	.when()
    	     .post("https://reqres.in/api/users")
    	.then()
    	     .statusCode(201)
    	     .log().all();
    	
    //	Upto ----->1.15 min completed
    }
}
