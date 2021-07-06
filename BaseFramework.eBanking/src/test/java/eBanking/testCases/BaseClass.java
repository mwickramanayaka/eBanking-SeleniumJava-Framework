/**
 * 
 */
package eBanking.testCases;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import eBanking.utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
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
	
	public static String captureScreen(WebDriver driver, String tname) throws IOException {

		String dateName = new SimpleDateFormat("yyyy-MM-dd/hh.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		//after execution you will see a folder "FaiiedTestsScreenshots" under src folder
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/" + tname + "-" + dateName + ".png";
		File finalDestination = new File(screenshotPath);
		System.out.println("Screenshot taken");
		FileUtils.copyFile(source, finalDestination);
		return screenshotPath;
	}
	

}
