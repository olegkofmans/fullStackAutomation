package Utilities;

import org.openqa.selenium.support.PageFactory;

import PageObjects_IMBD.mainPage;
import PageObjects_IMBD.resultsPage;

public class managePages extends base {

	public static void  init() {
		
		imbdMain = PageFactory.initElements(driver, mainPage.class);
		imbdResults = PageFactory.initElements(driver, resultsPage.class);
		
	}
}
