package Utilities;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import PageObjects_IMBD.mainPage;
import PageObjects_IMBD.resultsPage;

public class base {
	
	public static WebDriver driver;
	public static Screen screen;
	public static mainPage imbdMain;
	public static resultsPage imbdResults;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());

}
