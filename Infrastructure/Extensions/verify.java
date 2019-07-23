package Extensions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;
import Utilities.commonOps;
public class verify extends commonOps {

	public static void textInElement(WebElement elm, String textExpected) throws IOException, ParserConfigurationException, SAXException {

		try 
		{

			assertEquals(elm.getText(), textExpected);	
			test.log(LogStatus.PASS, "The result of expected text are asserted");

		} 
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL, "The result of expected text are fail to asserted because: " + test.addScreenCapture(takeSS()));
			fail("Fail Exeption");
		}
		catch (AssertionError e) 
		{
			test.log(LogStatus.FAIL, "The result of expected text are fail to asserted because: " + "See Screenshots: " + test.addScreenCapture(takeSS()));
			fail("Fail Asserted");
			
		}
	}
	public static void image(String imagePath) throws FindFailed, IOException, ParserConfigurationException, SAXException {
		try {
			screen.find(imagePath);
			
		} 
		catch (Exception e) {
			test.log(LogStatus.FAIL, "Fail to Find Image: " + test.addScreenCapture(takeSS()));
			fail("Fail to Find Image");		
			}
		
	}
	
	public static void containsAPI(String response, String text) {
		try {
		assertTrue(response.contains(text));
		test.log(LogStatus.PASS, "Assert response is passed");
	}
		catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Fail to verify text in the JSON" + e);
			fail("fail to verify text in the JSON" + e);		
		}
		}

}
