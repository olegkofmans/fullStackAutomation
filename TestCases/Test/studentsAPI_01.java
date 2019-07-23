package Test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import Extensions.verify;
import Utilities.commonOps;
import WorkFlows.api_actions;

public class studentsAPI_01 extends commonOps{
	
	@Test
	public void test01_verifyStudentCreated() throws ParserConfigurationException, SAXException, IOException{
		api_actions.post_newStudent();
		verify.containsAPI(api_actions.getDetails().getBody().asString(),"olegkofmans@gmail.com");
	}

}
