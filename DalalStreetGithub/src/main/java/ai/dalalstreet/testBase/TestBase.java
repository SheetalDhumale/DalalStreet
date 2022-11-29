package ai.dalalstreet.testBase;

import java.time.Duration;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import ai.dalalstreet.pageLayer.LoginPage;
import ai.dalalstreet.utility.CommonMethods;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase
{
	public static WebDriver driver;
	public static Logger logger;
	public LoginPage login;
	public CommonMethods methods;
	
	@BeforeClass
	public void start()
	{
		logger = Logger.getLogger("Framework for Dalal Street");
		PropertyConfigurator.configure("Log4jFile.properties");
		logger.info("Framework execution started");
	}
	@AfterClass
	public void end()
	{
		logger.info("Framework execution completed");
	}
	@Parameters("browser")
	@BeforeMethod
	public void setup(String br)
	{
		if(br.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please enter valid browser.");
		}
		driver.get("https://apps.dalalstreet.ai/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		//====================OBJECT CREATION================================
		login = new LoginPage();
				
		//=======================LOGIN SCRIPT=================================
		login.enterEmailText("amarwaghmare573@gmail.com");
		login.enterPasswordText("Test@1234");
		login.clickOnSignin();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}