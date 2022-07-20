package com.automation.pages;


import org.openqa.selenium.support.PageFactory;
import com.automation.utilities.Browser;

/** BasePage for Page Objects
 * 
 * @author vinithakumari
 *
 */
public class BasePage {

	    /** Function to initlize page elements
	     * @param <T>
	     * @param pageClass
	     * @return
	     */
	    public static <T extends BasePage> T initPage(Class<T> pageClass) {
	        return PageFactory.initElements(Browser.getDriver(), pageClass);
	    }
}