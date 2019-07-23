package WorkFlows;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import Extensions.RESTAPI;
import Utilities.commonOps;
import io.restassured.response.Response;

public class api_actions extends commonOps{
	
	public static String[] details = {"Oleg","Kofman","olegkofmans@gmail.com","Engineer"};
	public static List<String> subjects = new ArrayList<String>();
	
	public static void post_newStudent() throws ParserConfigurationException, SAXException, IOException {
		subjects.add("Math");
		subjects.add("English");
		subjects.add("Grammer");
		RESTAPI.post(details, subjects);
	}
	public static Response getDetails() throws ParserConfigurationException, SAXException, IOException {
		
		
		return RESTAPI.get(getData("API_URL") + getData("API_Resource") + "/list");
				
	}

}
