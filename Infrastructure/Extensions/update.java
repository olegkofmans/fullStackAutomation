package Extensions;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.commonOps;

public class update extends commonOps {

	public static void text(WebElement elm, String value) throws IOException, ParserConfigurationException, SAXException {

		try 
		{
	
			elm.sendKeys(value);		
			test.log(LogStatus.PASS, "Text inserted Successfuly to the label");

		} 
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL, "Fail to insert text to the label,See details: " + e + "See Screenshots: " + test.addScreenCapture(takeSS()));
		}
	}
	public static void dropDownText(WebElement elm, String  dropdownText) throws IOException, ParserConfigurationException, SAXException {

		try 
		{
			// Can implement explicitly wait here

			Select myValue = new Select(elm);
			myValue.selectByVisibleText(dropdownText);	
			test.log(LogStatus.PASS, "DropDown updated Successfuly");
		} 
		catch (Exception e) 
		{	
			test.log(LogStatus.FAIL, "Fail to find or change the DropDown,See details: " + e + "See Screenshots: " + test.addScreenCapture(takeSS()));
		}
	}

}
