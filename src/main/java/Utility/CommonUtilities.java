package Utility;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class CommonUtilities {
	static Connection con;

	public static int RandomNumber(int start, int finish) {

		Random num = new Random();
		int random = num.nextInt(finish + 1 - start) + start;

		System.out.println("random Number is " + random);

		return random;
	}

	public static int RandomNumber(int finish) {

		Random num = new Random();
		// int random = num.nextInt(finish + 1 - start) + start;
		int random = num.nextInt(finish);
		if (random == 0)
			random = random + 1;
		System.out.println("random Number is " + random);

		return random;
	}

	public static String randomString(int lenghth) {
		String randomString = "";
		// Return a string which does not exist "I,O,Q" character to generate valid VIN
		// number.
		String Contain = "ABCDEFGHJKLMNPRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random rnd = new Random();
		for (int i = 0; i < lenghth; i++) {
			sb.append(Contain.charAt(rnd.nextInt((Contain.length()))));
			randomString = sb.toString();

		}

		return randomString;
	}

	public static String toCamelCase(String inputString) {
		String result = "";
		if (inputString.length() == 0) {
			return result;
		}
		char firstChar = inputString.charAt(0);
		char firstCharToUpperCase = Character.toUpperCase(firstChar);
		result = result + firstCharToUpperCase;
		for (int i = 1; i < inputString.length(); i++) {
			char currentChar = inputString.charAt(i);
			char previousChar = inputString.charAt(i - 1);
			if (previousChar == ' ') {
				char currentCharToUpperCase = Character.toUpperCase(currentChar);
				result = result + currentCharToUpperCase;
			} else {
				char currentCharToLowerCase = Character.toLowerCase(currentChar);
				result = result + currentCharToLowerCase;
			}
		}
		return result;
	}

	public static Connection getDBConnection(String connectionString, String dbUser, String dbPassword)
			throws ClassNotFoundException, SQLException, IOException {

		if (con == null) {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			DriverManager.getConnection(connectionString, dbUser, dbPassword);
			return con;
		}

		return con;

	}

//	public static ResultSet getResultSet() throws ClassNotFoundException, SQLException, IOException {
//		ResultSet rs = null;
//		Properties configFile = PropertyFileOperations.propertyfileRead(FilePaths.configFile);
//		String connectionString = configFile.getProperty("connectionstring");
//		String dbuser = configFile.getProperty("dbuser");
//		String dbpassword = configFile.getProperty("dbpassword");
//		con = getDBConnection(connectionString, dbuser, dbpassword);
//
//		rs = con.createStatement().executeQuery(configFile.getProperty("selectvehicle"));
//		rs.next();
//		if (!rs.next())
//			con.close();
//		return rs;
//
//	}

	public static String GetTodaysDate() {
		Date currentdate = new Date();
		System.out.println(currentdate.toString());

		// Date format string is passed as an argument to the Date format object
		SimpleDateFormat objSDF = new SimpleDateFormat("dd.MM.yyyy");

		// Date formatting is applied to the current date
		System.out.println(objSDF.format(currentdate));
		String Todaysdate = objSDF.format(currentdate);

		return Todaysdate;
	}

	public static String getPreviousDate(String date) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		String className = new Object() {
		}.getClass().getEnclosingClass().getSimpleName();
		String previousDate;
		String finalOldDate;
		try {
			String[] tempDates = date.split("\\.");
			date = tempDates[2];
			int tempIntDate = Integer.parseInt(date);
			tempIntDate = tempIntDate - 1;
			previousDate = String.valueOf(tempIntDate);
			tempDates[2] = tempDates[2].replaceAll(tempDates[2], previousDate);
			finalOldDate = String.join(".", tempDates);
			return finalOldDate;
		} catch (Exception e) {
			System.err.println("Exception occurred in: \nMethod Name: " + methodName + "\nClass name: " + className
					+ "\nExpection Details: " + e);
		}
		return null;
	}

	public static String getFutureDate(String date) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		String className = new Object() {
		}.getClass().getEnclosingClass().getSimpleName();
		String previousDate;
		String finalOldDate;
		try {
			String[] tempDates = date.split("\\.");
			date = tempDates[2];
			int tempIntDate = Integer.parseInt(date);
			tempIntDate = tempIntDate + 1;
			previousDate = String.valueOf(tempIntDate);
			tempDates[2] = tempDates[2].replaceAll(tempDates[2], previousDate);
			finalOldDate = String.join(".", tempDates);
			return finalOldDate;
		} catch (Exception e) {
			System.err.println("Exception occurred in: \nMethod Name: " + methodName + "\nClass name: " + className
					+ "\nExpection Details: " + e);
		}
		return null;
	}
	
	
	public static String encryptPwd() {
		String nonEncryptedPwd="";
		String encryptedPwd="";
		 try   
	        {  
	            /* MessageDigest instance for MD5. */  
	            MessageDigest m = MessageDigest.getInstance("MD5");  
	              
	            /* Add plain-text password bytes to digest using MD5 update() method. */  
	            m.update(nonEncryptedPwd.getBytes());  
	              
	            /* Convert the hash value into bytes */   
	            byte[] bytes = m.digest();  
	              
	            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
	            StringBuilder s = new StringBuilder();  
	            for(int i=0; i< bytes.length ;i++)  
	            {  
	                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
	            }  
	              
	            /* Complete hashed password in hexadecimal format */  
	            encryptedPwd = s.toString();  
	        }   
	        catch (NoSuchAlgorithmException e)   
	        {  
	            e.printStackTrace();  
	        }  
	          
	        /* Display the unencrypted and encrypted passwords. */  
	        System.out.println("Plain-text password: " + nonEncryptedPwd);  
	        System.out.println("Encrypted password using MD5: " + encryptedPwd); 
	        
		return nonEncryptedPwd;
		
	}
}
