package com.automation.utilities;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.automation.configReader.AssessmentProjectConfig;

public class Browser {
	public static AssessmentProjectConfig assessmentProjectConfig;
	private static WebDriver driver=null;

	public static WebDriver getDriver() {
		assessmentProjectConfig=ConfigFactory.create(AssessmentProjectConfig.class);
		System.setProperty("webdriver.chrome.driver", assessmentProjectConfig.getDriverPath());  
		
		if(driver!=null) {
			return driver;
		}else
			return getNewDriver();
		
	}
	
	public static void closeDriver() {
		driver.close();
		driver.quit();
		driver=null;
	}
	
	private static WebDriver getNewDriver() {
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
		return driver;
	}
	
	
}
