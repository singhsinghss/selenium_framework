package apitests;

import java.util.HashMap;

import org.testng.annotations.Test;

import apireusableutils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class APILoginTest extends APIBastTest{
	String token;
	@Test
	public void login_TC01() {
		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
		
		HashMap<String, String>headers=new HashMap<>();
		headers.put("Content-Type", "application/json");
		
		HashMap<String, String> logincreds = new HashMap<>();
		logincreds.put("username", "singh@tekarch.com");
		logincreds.put("password", "Admin123");
		
		Response res1=RestUtils.postReq(logincreds, headers, "/login");
		token = res1.jsonPath().getString("token").replace("[", "").replace("]", "");
		System.out.println(token);
		//System.out.println(res1.prettyPrint());
		
		 

	}
	
	@Test(dependsOnMethods = "login_TC01")
	public void getUserData()
	{
		 HashMap<String, String>headers=new HashMap<>(); 
		  headers.put("Token",token); 
		  headers.put("Content-Type", "application/json");
		  
		  //Response getUserData=RestAssured.given().headers(headers).when().get("/getdata");
		  Response getUserData=RestUtils.getReq(headers, "/getdata");
		  System.out.println(getUserData.prettyPrint());
	}
	
	@Test(dependsOnMethods = "login_TC01")
	public void addUserData()
	{
		HashMap<String, String>headers=new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Token",token);
		
		HashMap<String, String>body=new HashMap<>(); 
		body.put("accountno", "TA-8989888");
		body.put("departmentno", "6");
		body.put("salary", "30000");
		body.put("pincode","400905");
		Response addUser=RestUtils.postReq(body, headers, "addData");
		System.out.println(addUser.prettyPrint());
	}
	
	@Test(dependsOnMethods = "login_TC01")
	public void updateData()
	{
		HashMap<String, String>headers=new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Token",token);
		
		HashMap<String, Object>body=new HashMap<>(); 
		body.put("accountno","TA-2175744");
		body.put("departmentno", 9);
		body.put("salary",100000);
		body.put("pincode",400909);
		body.put("userid", "qukNrE6oXWZYEhDpL71e");
		body.put("id","mYf8rrNL5HJ6RSjuTVUR");
		Response updateUser=RestUtils.putReq(body, headers, "/updateData");
		System.out.println(updateUser.prettyPrint());
	}
	
	@Test(dependsOnMethods = "login_TC01")
	public void deleteData()
	{
		HashMap<String, String>headers=new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Token",token);
		
		HashMap<String, String>body=new HashMap<>(); 
		body.put("id","EktC0pr6Pi2jKLm2F463");
		body.put("userid", "qukNrE6oXWZYEhDpL71e");
		
		Response deleteUser=RestUtils.deleteReq(body, headers, "/deleteData");
		System.out.println(deleteUser.prettyPrint());
	}
}
