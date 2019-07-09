package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Extensions.verify;
import Utilities.commonOps;
import Utilities.managePages;
import WorkFlows.web_search;

public class IMBD01 extends commonOps{
	
	@BeforeClass
	public void StartSession() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    managePages.init();
	    driver.manage().window().maximize();
		driver.get("https://www.imdb.com");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
	} 
	@AfterClass
	public void closeSession() {
		driver.quit();
	} 
	@Test
	public void test01() {
		web_search.go("The Lion King");
		verify.textInElement(imbdResults.resulField, "The Lion King (2019)");
	}

}
