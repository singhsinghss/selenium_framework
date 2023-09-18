package sfdcUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


import Constants.FileConstants;;

public class FileUtils {
	
	public static String readLoginTestDataFile(String filePath,String key) throws IOException
	{
		File file=new File(filePath);
		FileReader fr=new FileReader(file);
		Properties pFile=new Properties();
		pFile.load(fr);
		return pFile.getProperty(key);
	}
	
	public static String readUserMenuTestDataFile(String key) throws IOException
	{
		File file=new File(FileConstants.USER_MENU_TESTDATA_FILE_PATH);
		FileReader fr=new FileReader(file);
		Properties pFile=new Properties();
		pFile.load(fr);
		return pFile.getProperty(key);
		
	}
  public static String readUserMenuMySettingData(String key) throws IOException
  {
	  File file=new File(FileConstants.USER_MENU_MYSETTING_FILE_PATH);
	  FileReader fr=new FileReader(file);
	  Properties pFile=new Properties();
	  pFile.load(fr);
	  return pFile.getProperty(key);
  }
  
  public static String readCreateAccount(String key) throws IOException
  {
	  File file=new File(FileConstants.CREATE_ACCOUNT_FILE_PATH);
	  FileReader fr=new FileReader(file);
	  Properties pFile=new Properties();
	  pFile.load(fr);
	  return pFile.getProperty(key);
  }
  
  public static String readOpportunities(String key) throws IOException
  {
	  File file=new File(FileConstants.OPPORTUNITY_FILE_PATH);
	  FileReader fr=new FileReader(file);
	  Properties pFile=new Properties();
	  pFile.load(fr);
	  return pFile.getProperty(key);
  }
  public static String readLeadsTestData(String Key) throws IOException
  {
	  File file=new File(FileConstants.LEADS_FILE_PATH);
	  FileReader fr=new FileReader(file);
	  Properties pFile=new Properties();
	  pFile.load(fr);
	  return pFile.getProperty(Key);
  }
  
  public static String readContactsTestData(String Key) throws IOException
  {
	  File file=new File(FileConstants.CONTACTS_FILE_PATH);
	  FileReader fr=new FileReader(file);
	  Properties pFile=new Properties();
	  pFile.load(fr);
	  return pFile.getProperty(Key);
  }
  
  public static String readRandomTestData(String Key) throws IOException
  {
	  File file=new File(FileConstants.RANDOM_SCENARIOS_FILE_PATH);
	  FileReader fr=new FileReader(file);
	  Properties pFile=new Properties();
	  pFile.load(fr);
	  return pFile.getProperty(Key);
  }
}
