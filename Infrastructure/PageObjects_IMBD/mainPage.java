package PageObjects_IMBD;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPage {
	
	@FindBy(how = How.ID, using = "navbar-query")
	public WebElement searchBox;
	
	@FindBy(how = How.CSS, using = "select[name='s']")
	public WebElement selectSearchDropDown;

	@FindBy(how = How.ID, using = "navbar-submit-button")
	public WebElement searchButton;
	
	
}
