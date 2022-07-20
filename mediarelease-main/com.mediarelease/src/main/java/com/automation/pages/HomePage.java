package com.automation.pages;

import static org.openqa.selenium.support.How.XPATH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


import com.automation.utilities.Browser;
import com.automation.utilities.WaitUtil;
import com.automation.Exception.CustomException;

/** Page elements and functions of HomePage
 * @author vinithakumari
 *
 */

public class HomePage extends BasePage {
   
   static String[] selectedMinisters; 
   static List <WebElement> itemCards ; 
   
   @FindBy(how = XPATH , using = "//button[contains(text(),'Filter by Minister')]")
   private WebElement filterButton;
   
   @FindBy(how = XPATH, using = "//input[@value='Search']")
   private WebElement searchButton;
   
   @FindBy(how = XPATH, using = "//header//child::h1[contains(text(),'Ministerial media releases')]")
   private WebElement titleText;
   
   @FindBy(how = XPATH, using = "//input[@value='Reset']")
   private WebElement resetButton;
      
   static Logger logger = Logger.getLogger(HomePage.class);

   /**
    * Verifies HomePage webelements
    */
   public void verifyHomePage() {
      WaitUtil.waitForJsPageReady();
      assert(titleText.isDisplayed());
   }

   public void clickWebElement(WebElement we){
      try {
         we.click();
      }catch(WebDriverException e){
         if(e.getMessage().contains("cannot determine loading status") || e.getMessage().contains("unexpected command response") ){
            logger.info(e.getMessage());
         }else
            throw e;
      }
   }

   /**
    * Verifies Selects table minister from displayed category
    */
   public void selectMinister(String[] selections) {
      selectedMinisters = selections;
      clickWebElement(filterButton);
      for(int i =0; i< selections.length; i++)
      {
         WebElement filterCheckBox = Browser.getDriver().findElement(By.xpath("//label[contains(text(),'"+ selections[i]+"')]"));
         WaitUtil.waitForJsPageReady();
         clickWebElement(filterCheckBox);
      }
      WaitUtil.waitForJsPageReady();
   }
   
   /**
    * Clicks on search button
    */
   public void searchMinister(){
      JavascriptExecutor js = (JavascriptExecutor) Browser.getDriver();
      try {
      js.executeScript("window.scrollBy(0,1000)", "");
      }catch(Exception e)
      {
    	  System.out.println(e.getMessage());
      }
      WaitUtil.PageLoadCompletedJquery();
      clickWebElement(searchButton);
      WaitUtil.waitForJsPageReady();
   }
   
   /**
    * Verifies the displayed Item cards
    */
   public void verifyTheItemCardsExist() {
      
      try {
      Thread.sleep(2000);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      WaitUtil.waitForJsPageReady();
      List<WebElement> itemTags = Browser.getDriver().findElements(By.xpath("//div[@class=\"nsw-card__tag\"]"));
      itemCards = itemTags;
      for(WebElement w :itemCards)
      {
      assert(w.isDisplayed());
      }
   }
   
   /**
    * validates if the item cards displayed are as per the filter
    */
   public void validateTheItemCards() throws CustomException {
      boolean validateFlag = false;
      WaitUtil.PageLoadCompletedJquery();
      for(WebElement w :itemCards)
      {
         System.out.println("wget: "+w.getText());
         System.out.println(new ArrayList<>(Arrays.asList(selectedMinisters)));
         System.out.println(new ArrayList<>(Arrays.asList(selectedMinisters)).contains(w.getText()));
         String []uiValue=w.getText().split(",");
         for (String value:uiValue) {
            validateFlag = new ArrayList<>(Arrays.asList(selectedMinisters)).contains(value.trim());
            if(validateFlag)
               break;
         }
         if(!validateFlag)
            break;
      }
      assert(validateFlag);
   }

   /**
    * Composite method for filtering the minister
    */
   public void filteredByMinister(String[] selections) throws CustomException
   {  selectedMinisters = selections;
      selectMinister(selections);
      searchMinister();
      verifyTheItemCardsExist();
      validateTheItemCards();
   }
   
   /**
    * Reset button click
    */
   public void resetFilters()
   {
      WaitUtil.waitForJsPageReady();
      WaitUtil.visibilityOf(resetButton);
      WaitUtil.elementToBeClickable(resetButton);
     clickWebElement(resetButton);
      WaitUtil.waitForJsPageReady();
   }
   
   /**
    * Verify on reset the button is not visible on screen.
    */
   public void verifyResetRemoved()
   {
	   try {
		      List<WebElement> resetBtnVisibility = Browser.getDriver().findElements(By.xpath("//input[@value='Reset']"));
		      Assert.assertEquals(resetBtnVisibility.size(), 0);
	   }catch(Exception e)
	   {
		   System.out.println(e.getMessage());
	   }
   }
   
   /**
    * Verify that filters unchecked in the category list
    */
   public void verifyNoFilters()
   {
      List<WebElement> checkBoxOptions = Browser.getDriver().findElements(By.xpath("//label[@class='nsw-form__checkbox-label option']"));
      for(WebElement w :checkBoxOptions)
      {
      Assert.assertFalse(w.isSelected());
      }
   }
   
   /**
    * validate if the filters are removed on the item cards
    */
   public void validateFilterIsRemoved() throws CustomException {
      List<WebElement> itemTags = Browser.getDriver().findElements(By.xpath("//div[@class=\"nsw-card__tag\"]"));
      itemCards = itemTags;
      boolean filterFlag = false;
      try {
         Thread.sleep(2000);
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      for(int i = 0; i< selectedMinisters.length; i++)
      {
      
      for(WebElement w :itemCards)
      {
         if(!(w.getText().contains(selectedMinisters[i])))
         {
         filterFlag = true; 
         }
      }
      if(filterFlag)
      {
         assert(true);
      }
      else
      {
         assert(false);
      }
      }
   }

}