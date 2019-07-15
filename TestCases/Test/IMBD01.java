package Test;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import Extensions.verify;
import Utilities.commonOps;
import WorkFlows.web_search;

public class IMBD01 extends commonOps{


	@Test
	public void test01_searchValue() throws IOException, ParserConfigurationException, SAXException, FindFailed {
		web_search.go("The Lion King");
		verify.textInElement(imbdResults.resulField, "The Lion King (2019)");
		verify.image(System.getProperty("user.dir") +"./imageRepository/logo.png");
	}
}
