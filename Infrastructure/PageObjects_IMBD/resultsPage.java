package PageObjects_IMBD;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class resultsPage 
{

	@FindBy(how = How.XPATH, using = "//tr[1]/td[2]")
	public WebElement resulField;
	
}
