package testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.annotations.*;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	public ResourceBundle bundle;
	
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String br)
	{
		logger = LogManager.getLogger(this.getClass());
		bundle = ResourceBundle.getBundle("config"); // load config.properties
		if(br.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
//		   driver = new GeckoDriverInfo();	
		}
		
		driver.get(bundle.getString("appURL2"));
//		driver.get("https://demo.opencart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	public void tearDown()
	{
		driver.close();
	}
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generatedString2 = RandomStringUtils.randomNumeric(5);
		return generatedString2;
	}
	
	public String randomAlphaNumeric()
	{
		String st = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(5);
		return st + num;
		
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}	

}
