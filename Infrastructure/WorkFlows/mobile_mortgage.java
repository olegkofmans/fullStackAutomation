package WorkFlows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Extensions.click;
import Extensions.update;
import Utilities.commonOps;

public class mobile_mortgage extends commonOps{
	
	public static void calculate(String amount, String term, String rate) throws IOException, ParserConfigurationException, SAXException 
	{
		update.text(mortgageMain.amount, amount);
		update.text(mortgageMain.term, term);
		update.text(mortgageMain.rate, rate);
		click.go(mortgageMain.calculate);
	}

}