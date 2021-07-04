/**
 * 
 */
package eBanking.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

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

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		logger = LogManager.getLogger(BaseClass.class);	

		if(br.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", readConfig.getChromePath() );
		driver = new ChromeDriver();
		}else if(br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath() );
			driver = new FirefoxDriver();
		}else if(br.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", readConfig.getEdgePath() );
			driver = new EdgeDriver();
		}

		driver.get(baseURL);
		logger.info("URL is Opened");

	}

	@AfterClass
	public void tearDown() {

		driver.quit();

	}

}
