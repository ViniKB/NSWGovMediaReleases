package com.automation.configReader;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.DefaultValue;
import org.aeonbits.owner.Config.Key;
import org.aeonbits.owner.Config.Sources;

/** Config file Reader
 * @author vinithakumari
 *
 */
@Sources({ "classpath:config/assessmentProject.properties" })
public interface AssessmentProjectConfig extends Config {

	@Key("nswGovAu.url")
	@DefaultValue("https://www.nsw.gov.au/media-releases")
	String gerNSWGovAuUrl();
	
	@Key("driverPath")
	@DefaultValue("C:/Users/Vkumari/Documents/GitHub/MediaReleases/NSWGovMediaReleases/mediarelease-main/com.mediarelease/src/test/resources/drivers/chromedriver")
	String getDriverPath();
		
	@Key("extentReport")
	@DefaultValue("/Users/Vkumari/Documents/GitHub/MediaReleases/NSWGovMediaReleases/mediarelease-main/com.mediarelease/src/test/resources/config/extent-config.xml")
	String getExtentReport();
	
	@Key("weatherbit.apitoken")
	@DefaultValue("<Put the token here>")
	String getApitoken();
	
	@Key("weatherbit.currentWeather")
	@DefaultValue("current")
	String getCurrentWeather();
	
	@Key("weatherbit.forecastDaily")
	@DefaultValue("forecast/daily")
	String getForecastDaily();
	

}
