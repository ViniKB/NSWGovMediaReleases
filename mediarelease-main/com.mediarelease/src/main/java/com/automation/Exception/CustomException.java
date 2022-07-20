package com.automation.Exception;

import static org.testng.Assert.fail;

public class CustomException extends Exception{
	
	public CustomException(String message,Exception e) {
		e.printStackTrace();
		fail(message+" :"+e.getMessage()+e.getCause());
	}

}
