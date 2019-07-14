package Extensions;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.commonOps;

public class click extends commonOps {

	public static void go(WebElement elm) throws IOException, ParserConfigurationException, SAXException {
		try 
		{
			elm.click();	
			test.log(LogStatus.PASS, "Element clicked Successfuly");
		} 
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL, "Fail to click on Element, See details: " + e + test.addScreenCapture(takeSS()));
			
		}
	}
}
