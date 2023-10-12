package api.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;


import api.testdata.AddUser;


public class commonUtilities {
	
	public static String readFileAndReturnString(String filePath) throws IOException
	{
		byte[] fileContent=Files.readAllBytes(Paths.get(filePath));
		return new String(fileContent,StandardCharsets.UTF_8);
		
	}

	public static String serializeObject(Object user) throws JsonProcessingException
	{
		ObjectMapper om=new ObjectMapper();
		om.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CASE);
		String sJaysonPayload=om.writeValueAsString(user);
		System.out.println(sJaysonPayload);
		return sJaysonPayload;
	}
	
	public static Object DeSerializeObject(String Json) throws JsonMappingException, JsonProcessingException
	{
		ObjectMapper om=new ObjectMapper();
		AddUser au=om.readValue(Json, AddUser.class);
		return au;
	}
	public static String getStringDateTimeStamp()
	{
		String value=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		return value;
	}
}
