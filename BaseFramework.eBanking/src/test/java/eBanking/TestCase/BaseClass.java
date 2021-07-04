/**
 * 
 */
package eBanking.TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import eBanking.utilities.ReadConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author manul.wickramanayaka
 *
 */
public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	public String baseURL = readConfig.getApplicationURL();
	public String userName = readConfig.getUserName();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	
	// private static Logger logger;
	 public static Logger logger;
	
	@BeforeClass
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", readConfig.getChromePath() );
		driver = new ChromeDriver();
		
		//logger = LogManager.getLogger(BaseClass.class);
		logger = LogManager.getLogger(BaseClass.class);	
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		
	}

}
