/**
 * 
 */
package eBanking.TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author manul.wickramanayaka
 *
 */
public class BaseClass {
	
	public String baseURL = "http://demo.guru99.com/v4/index.php";
	public String userName = "mngr47659";
	public String password = "123456@";
	public static WebDriver driver;
	
	// private static Logger logger;
	 public static Logger logger;
	
	@BeforeClass
	public void setup() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		
		//logger = LogManager.getLogger(BaseClass.class);
		logger = LogManager.getLogger(BaseClass.class);
		
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		
	}

}
