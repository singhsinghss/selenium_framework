package apitests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.JsonPath;
import api.constants.FileConstants;
import api.testdata.AddUser;
import api.testdata.DeleteUser;
import api.testdata.UpdateUser;
import api.utils.commonUtilities;
import apireusableutils.RestUtils;
import io.restassured.RestAssured;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


//@Listeners(Listener.class)
public class APILoginTest extends APIBastTest{
	String token;
	
	@BeforeClass	
	public void setURI() throws IOException
	{
		
		String uri=commonUtilities.readFileAndReturnString(FileConstants.URI_FILE_PATH);
		RestAssured.baseURI=JsonPath.read(uri,"$.login.prod");	
		System.out.println(RestAssured.baseURI);
	}
	@Test(enabled=true, groups = "login")
	public void login_TC01(Method name) {
		//RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
		//APIBastTest.test=extent.createTest(name.getName());
		token="";
		//token.equals("");
		System.out.println("token :"+token);
		HashMap<String, String>headers=new HashMap<>();
		headers.put("Content-Type", "application/json");
		
		HashMap<String, String> logincreds = new HashMap<>();
		logincreds.put("username", "singh@tekarch.com");
		logincreds.put("password", "Admin123");
		
		test.info("login_TC01 :"+name.getName()+" :headers and credentials have been passed");
		Response res1=RestUtils.postReq(logincreds, headers, "/login")
				.then().assertThat().statusCode(201)
				.body(matchesJsonSchema(new File(FileConstants.LOGIN_SCHEMA_FILE_PATH))).extract().response();
		token=JsonPath.read(res1.asString(), "$.[0].token");
		System.out.println("token from loginTest: "+token);
		Assert.assertEquals(res1.getStatusCode(), 201);
		test.info(name.getName()+" :token is received.");
		logger.info(name.getName()+" :token from login has been received.");
	}
	
	@Test(enabled = true,dependsOnGroups = "login")
	public void getUserData(Method name)
	{
		//System.out.println(token);
		 HashMap<String, String>headers=new HashMap<>(); 
		  headers.put("token",token); 
		  headers.put("Content-Type", "application/json");
		  
		  //Response getUserData=RestAssured.given().headers(headers).when().get("/getdata");
		  Response getUsrData=RestUtils.getReq(headers, "/getdata").then()
				  .statusCode(200).extract().response();
		 // System.out.println(getUsrData.prettyPrint());
		  List<String>accountNumbers=getUsrData.jsonPath().getList("accountno");
		  System.out.println("getUserData: data size: "+accountNumbers.size());
		  test.info(name.getName()+" : User data has been fetched");
		  logger.info(name.getName()+" : User data has been fetched");
		  assertThat(accountNumbers.size(), greaterThan(10000));
	}
	
	@Test(enabled = true,dependsOnGroups = "login")
	public void addUserData(Method name) throws JsonProcessingException
	{
		HashMap<String, String>headers=new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("token",token);
		System.out.println(token);
		//HashMap<String, String>body=new HashMap<>();
		AddUser au=new AddUser("TA-8989888", "6", "300000", "400905");
		String sPayload=commonUtilities.serializeObject(au);
		Response resAddUser=RestUtils.postReq(au, headers, "/addData");
		System.out.println("addUser status: "+resAddUser.prettyPrint());
		Assert.assertEquals(resAddUser.getStatusCode(), 201);
		test.info(name.getName()+" : User data has been added");
		logger.info(name.getName()+" : User data has been added");
	}
	
	@Test(enabled = true,dependsOnGroups = "login")
	public void updateData(Method name) throws JsonProcessingException
	{
		HashMap<String, String>headers=new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("token",token);
		
		UpdateUser update=new UpdateUser("TA-2121212", "8", "100005", "303030", "qukNrE6oXWZYEhDpL71e", "AUHm67b6HK7MtpMCsBh2");
		String payload=commonUtilities.serializeObject(update);
		Response updateUser=RestUtils.putReq(payload, headers, "/updateData");
		System.out.println("updateUser status code: "+updateUser.getStatusCode());
		System.out.println(updateUser.prettyPrint());
		test.warning(name.getName()+" : "+updateUser.getStatusLine());
		logger.warn("updateData: "+updateUser.getStatusLine()+" You don't have permission to edit data.");
	}
	
	@Test(enabled = true,dependsOnGroups = "login")
	public void deleteData(Method name) throws JsonProcessingException
	{
		HashMap<String, String>headers=new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("token",token);
		
		DeleteUser du=new DeleteUser("EktC0pr6Pi2jKLm2F463", "qukNrE6oXWZYEhDpL71e");
		String payload=commonUtilities.serializeObject(du);
		Response deleteUser=RestUtils.deleteReq(payload, headers, "/deleteData");
		System.out.println(deleteUser.prettyPrint());
		System.out.println("delete user: "+deleteUser.getStatusCode());
		Assert.assertEquals(deleteUser.getStatusCode(), 200);
		test.info(name.getName()+" : user has been deleted" );
		logger.info(name.getName()+" : user has been deleted");
	}
}
