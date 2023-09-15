package Constants;

import sfdcUtils.CommonUtils;

public class FileConstants {
	public static final String LOGIN_TESTDATA_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\LoginTestData.properties";
	public static final String USER_MENU_TESTDATA_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\UserMenuTestData.properties";
	public static final String PROFILE_PHOTO_PATH="C:\\Users\\seema\\Pictures\\Flower.jpg";
	public static final String UPLOAD_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\text.txt";
	public static final String REPORT_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\report"+CommonUtils.getStringDateTimeStamp()+".html";
	public static final String SCREENSHOT_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\screenshot"+CommonUtils.getStringDateTimeStamp()+".png";
	public static final String LOGIN_HISTORY_FILA_PATH="C:\\Users\\seema\\Downloads";
	public static final String USER_MENU_MYSETTING_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\mysettingsTestData.properties";
	public static final String CREATE_ACCOUNT_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\CreateAccount.properties";
	public static final String OPPORTUNITY_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\OpportunityTestData.properties";
	public static final String LEADS_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\LeadsTestData.properties";
}
