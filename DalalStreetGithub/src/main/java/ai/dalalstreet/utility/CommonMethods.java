package ai.dalalstreet.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import ai.dalalstreet.testBase.TestBase;

public class CommonMethods extends TestBase
{
	public void Scrolling(String scroll)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(scroll);
	}
	public static void TakeScreenshot(String filename)
	{
		try
		{
			String path = "C:\\Users\\91966\\eclipse-workspace\\FrameworkDalalStreet\\Screenshot\\";
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(path+filename+".png"+System.currentTimeMillis());
			FileHandler.copy(source, dest);	
		}
		catch(IOException e)
		{
			System.out.println("IO Exception - file not found");
			e.printStackTrace();
		}
	}
}
