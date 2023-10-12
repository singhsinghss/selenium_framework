package apireusableutils;

import java.util.HashMap;

import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestUtils {

	public static Response postReq(HashMap<String, String>payload,HashMap<String, String> headers,String endPoint)
	{
		return RestAssured.given().headers(headers).when().body(payload).post(endPoint);
	}
	public static Response postReq(Object payload,HashMap<String, String> headers,String endPoint)
	{
		return RestAssured.given().headers(headers).when().body(payload).post(endPoint);
	}
	public static Response getReq(HashMap<String, String> headers,String endPoint)
	{
		return RestAssured.given().headers(headers).when().get(endPoint);
	}
	public static Response putReq(Object payload,HashMap<String, String> headers,String endPoint)
	{
		return RestAssured.given().headers(headers).when().body(payload).put(endPoint);
	}
	public static Response deleteReq(Object payload,HashMap<String, String> headers,String endPoint)
	{
		return RestAssured.given().headers(headers).when().body(payload).delete(endPoint);
	}
}
