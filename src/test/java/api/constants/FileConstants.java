package api.constants;

import api.utils.commonUtilities;

public class FileConstants {
	public static final String URI_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\java\\api\\testdata\\uriconfigs.json";
	public static final String USER_CONFIG_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\java\\api\\testdata\\userconfig.json";
	public static final String LOGIN_SCHEMA_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\java\\api\\testdata\\schema\\loginschema.json";
	public static final String REPORT_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\API_report-"+commonUtilities.getStringDateTimeStamp()+".html";
	

}
