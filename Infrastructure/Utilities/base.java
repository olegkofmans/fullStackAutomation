package Utilities;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.Screen;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import PageObjects_IMBD.mainPage;
import PageObjects_IMBD.resultsPage;
import Page_Objects_Mortgage.mainPageApp;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class base {
	
	public static WebDriver driver;
	public static Screen screen;
	public static mainPage imbdMain;
	public static resultsPage imbdResults;
	public static mainPageApp mortgageMain;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
    public static DesiredCapabilities dc = new DesiredCapabilities();
    public static RequestSpecification httpRequest;
    public static JSONObject requestParams = new JSONObject();
    public static Response resp;

}
