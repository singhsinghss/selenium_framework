package api.utils;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class commonUtilities {
	
	public static String readFileAndReturnString(String filePath)
	{
		byte[] fileContent=Files.readAllBytes(Paths.get(filePath));
		return new String(fileContent,StandardCharsets.UTF_8);
	}

}
