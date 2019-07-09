package Extensions;

import org.openqa.selenium.WebElement;

import Utilities.commonOps;

public class click extends commonOps {

	public static void go(WebElement elm) {
		try 
		{
			// Can implement explicitly wait here
			elm.click();
			System.out.println("Element clicked Successfuly");		

		} 
		catch (Exception e) 
		{
			System.out.println("Fail to click on Element, See details: " + e);		
		}
	}
}
