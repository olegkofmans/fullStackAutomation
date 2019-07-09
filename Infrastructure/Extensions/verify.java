package Extensions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.WebElement;

public class verify {

	public static void textInElement(WebElement elm, String textexpected) {

		try 
		{

			assertEquals(elm.getText(), textexpected);	

			System.out.println("The Result asserted");		

		} 
		catch (Exception e) 
		{
			System.out.println("Fail asserted: " + e);	
			fail("Fail asserted");
		}
		catch (AssertionError e) 
		{
			System.out.println("Fail asserted: " + e);
			fail("Fail asserted");
		}
	}

}
