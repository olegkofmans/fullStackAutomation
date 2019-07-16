package Test;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import Extensions.verify;
import Utilities.commonOps;
import WorkFlows.mobile_mortgage;

public class MorgageApp_01 extends commonOps{

	@Test
	public void test01_verifyRepayment() throws IOException, ParserConfigurationException, SAXException, FindFailed {
		
		mobile_mortgage.calculate("1000", "3", "4");
		verify.textInElement(mortgageMain.repayment, "£30.03");
	}
}