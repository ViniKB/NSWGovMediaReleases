package com.automation.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	static WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 60);
	
	public static void pageLoad() {
		WebDriver webDriver=Browser.getDriver();
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}
	
	
	public static void visibilityOfElementLocated(By by) {
	      wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public static void visibilityOf(WebElement we) {
	      wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	public static void elementToBeClickable(WebElement element) {
	      wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForJsPageReady()
	{
		try {
			WebDriverWait webDriverWait = new WebDriverWait(Browser.getDriver(), 300,60);
	         webDriverWait.until(PageLoadCompletedJquery());
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public static ExpectedCondition<Boolean> PageLoadCompletedJquery() {
		   return new ExpectedCondition<Boolean>() {
			      @Override
			      public Boolean apply(WebDriver webDriver) {
			         System.out.println("PageLoadCompletedJquery Waiting");
			         if(((Boolean) ((JavascriptExecutor) webDriver)
			               .executeScript("return (window.jQuery == null)"))){
			            return true;
			         }
			         return (Boolean) ((JavascriptExecutor) webDriver)
			               .executeScript("return (window.jQuery != null) && (jQuery.active == 0);");
			      }

			   };

			}
}
