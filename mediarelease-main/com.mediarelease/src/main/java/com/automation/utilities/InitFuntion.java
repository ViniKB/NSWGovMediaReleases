package com.automation.utilities;

import java.io.File;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.configReader.AssessmentProjectConfig;

public class InitFuntion {

	public AssessmentProjectConfig init() {
		 DOMConfigurator.configure("src/test/resources/config/"+"log4j.xml");
		 AssessmentProjectConfig config= ConfigFactory.create(AssessmentProjectConfig.class);
		// writeExtentReport(config);
		 return config;
	}

	public static void writeExtentReport(AssessmentProjectConfig config) {
		System.out.println(config.getExtentReport());
		 //Reporter.loadXMLConfig(new File(config.getExtentReport()));
		 }
}
