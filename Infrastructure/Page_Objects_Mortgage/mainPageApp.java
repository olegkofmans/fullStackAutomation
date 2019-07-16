package Page_Objects_Mortgage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPageApp {
	
	
	@FindBy(how = How.ID, using = "etAmount")
	public WebElement amount;
	
	@FindBy(how = How.ID, using = "etTerm")
	public WebElement term;
	
	@FindBy(how = How.ID, using = "etRate")
	public WebElement rate;
	
	@FindBy(how = How.ID, using = "add_schedule_text")
	public WebElement calculate;
	
	@FindBy(how = How.ID, using = "tvRepayment")
	public WebElement repayment;
	

}
