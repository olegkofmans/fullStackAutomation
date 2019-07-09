package Extensions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utilities.commonOps;

public class update extends commonOps {

	public static void text(WebElement elm, String value) {

		try 
		{
			
			// Can implement explicitly wait here
			
			
			elm.sendKeys(value);	
			System.out.println("text inserted Successfuly");		

		} 
		catch (Exception e) 
		{
			System.out.println("Fail to insert text,See details: " + e);		
		}
	}
	public static void dropDownText(WebElement elm, String  dropdownText) {

		try 
		{
			// Can implement explicitly wait here

			Select myValue = new Select(elm);
			myValue.selectByVisibleText(dropdownText);

			System.out.println("dropDown updated Successfuly");		

		} 
		catch (Exception e) 
		{
			System.out.println("Fail to find dropDown,See details: " + e);		
		}
	}

}
