package com.automation.stepDefinition;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.automation.pages.BasePage;
import com.automation.pages.HomePage;
import com.automation.Exception.CustomException;
import com.automation.configReader.AssessmentProjectConfig;
import com.automation.utilities.Browser;
import com.automation.utilities.InitFuntion;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

/**** Step Definition class corresponding to Filtering Testcases***/

/**
 * @author vinithakumari
 *
 */
public class FilterByMinisterStepDef {

   public WebDriver driver;

   public static AssessmentProjectConfig assessmentProjectConfig;

   static Logger logger = Logger.getLogger(FilterByMinisterStepDef.class);

   public FilterByMinisterStepDef() {
      driver = Browser.getDriver();
      assessmentProjectConfig = new InitFuntion().init();
      logger.info("Step completed - TC01_FilterByMinister");
   }

   @Given("^User is in 'NSWGovAu' Page$")
   public void userIsInNSWGovAuPage() {
      try {
      driver.get(assessmentProjectConfig.gerNSWGovAuUrl());
      }catch(Exception e) {
         logger.info(e.getMessage());
      }
      BasePage.initPage(HomePage.class).verifyHomePage();
   }

   @When("^Select a (.+)$")
   public void selectCategory(String selection) {
      BasePage.initPage(HomePage.class).selectMinister(selection.split(","));
   }

   @When("^I Click on 'Search' button$")
   public void searchItemCards() throws CustomException {
      BasePage.initPage(HomePage.class).searchMinister();
   }

   @Then("^I validate the item cards are displayed$")
   public void validateItemCardsDisplayed() throws CustomException {
      BasePage.initPage(HomePage.class).verifyTheItemCardsExist();
   }

   @Then("^Filtered for the given minister$")
   public void verifyItemCardsAreFiltered() throws CustomException {
      BasePage.initPage(HomePage.class).validateTheItemCards();
   }

   @Given("^User has filtered by (.+)$")
   public void userIsFilteredByMinister(String minister)throws CustomException {
     try { 
    	 driver.get(assessmentProjectConfig.gerNSWGovAuUrl());
     	}catch(Exception e)
     	{
     		System.out.println(e.getMessage());
     	}
      BasePage.initPage(HomePage.class).filteredByMinister(minister.split(","));
   }
   
   @When("^I click on 'Reset' button$")
   public void resetButton() throws CustomException {
      BasePage.initPage(HomePage.class).resetFilters();
   }
   
   @Then("^I verify the 'Reset' button is not visible$")
   public void verifyTheResetIsRemoved() throws CustomException {
      BasePage.initPage(HomePage.class).verifyResetRemoved();
   }
   
   @Then("^I verify no filters are selected$")
   public void verifyNoFiltersSelected() throws CustomException {
      BasePage.initPage(HomePage.class).verifyNoFilters();
   }
   
   @Then("^I validate the filter is removed$")
   public void verifyItemCardsFilterIsRemoved() throws CustomException {
      BasePage.initPage(HomePage.class).validateFilterIsRemoved();
   }


   @AfterStep
   public void addScreenshot(Scenario scenario) throws IOException {
      try {
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
      scenario.attach(fileContent, "image/png", "screenshot");
      }catch(Exception e) {
         System.out.println(e.getMessage());
      }

   }

   @After
   public void afterScenario(Scenario scenario) {
      Browser.closeDriver();

   }

}

