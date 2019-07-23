package Utilities;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpRequest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import com.relevantcodes.extentreports.ExtentReports;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.restassured.RestAssured;


public class commonOps extends base {

	public static String getData (String nodeName) throws ParserConfigurationException, SAXException, IOException
	{
		File fXmlFile = new File("./Configuration/DataConfig.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile); 
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}

	public static void initBrowser(String browserType) throws ParserConfigurationException, SAXException, IOException {

		switch (browserType.toLowerCase()) {
		case "chrome":
			driver = initChromeDriver();
			break;  
		case "firefox":
			driver = initffDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.get(getData("URL"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		screen = new Screen();
	}
	public static WebDriver initChromeDriver() throws ParserConfigurationException, SAXException, IOException {
		System.setProperty("webdriver.chrome.driver", getData("ChromeDriverPath"));
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	public static WebDriver initffDriver() throws ParserConfigurationException, SAXException, IOException {
		System.setProperty("webdriver.gecko.driver", getData("FFDriverPath"));
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	public static void initMobile() throws ParserConfigurationException, SAXException, IOException {
		dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_Package"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_Activity"));
        driver = new AndroidDriver<>(new URL(getData("Appium_Server_Adress")), dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static void initAPI() throws ParserConfigurationException, SAXException, IOException {
		RestAssured.baseURI = getData("API_URL");
		httpRequest = RestAssured.given();
	}

	public static void instanceReport() throws ParserConfigurationException, SAXException, IOException {
		extent = new ExtentReports(getData("ReportFilePath") +"Execution_" + timeStamp + "/" + getData("ReportFileName") + ".html");
	}

	public static void initReportTest(String testName,String testDescription)
	{
		test = extent.startTest(testName, testDescription);

	}
	public static void finilizeReportTest()
	{
		extent.endTest(test);

	}

	public static void finilizeExtentReport()
	{
		extent.flush();
		extent.close();
	}

	public static String takeSS() throws IOException, ParserConfigurationException, SAXException {

		String SSPath = getData("ReportFilePath") +"Execution_" + timeStamp + "/" + "screenshot_" + getRandomNumber() + ".png";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(SSPath));
		return SSPath;

	}
	
	public static int getRandomNumber() {
		Random rand =new Random();
		return rand.nextInt(99999) +1;
		
	}
	@BeforeClass
	public void StartSession() throws ParserConfigurationException, SAXException, IOException {
        if(getData("AutomationType").toLowerCase().equals("web")) 
		initBrowser(getData("BrowserType"));
        
        else if (getData("AutomationType").toLowerCase().equals("mobile")) {
			initMobile();
		}  
        else if (getData("AutomationType").toLowerCase().equals("api")) {
			initAPI();
		}
        
		managePages.init();
		instanceReport();

	} 
	@AfterClass
	public void closeSession() throws ParserConfigurationException, SAXException, IOException {
		if(!getData("AutomationType").equals("API"))
		    driver.quit();	
		finilizeExtentReport();
	} 
	
	@BeforeMethod
	public void doBeforeTestMethod(Method method) {
		initReportTest(method.getName().split("_")[0], method.getName().split("_")[1]);
	}
	@AfterMethod
	public void doAfterTest() {
		finilizeReportTest();
	} 
	
	
}
