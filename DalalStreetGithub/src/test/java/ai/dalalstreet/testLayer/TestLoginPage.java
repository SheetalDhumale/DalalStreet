package ai.dalalstreet.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import ai.dalalstreet.testBase.TestBase;

public class TestLoginPage extends TestBase
{
	String expected_url="https://www.apps.dalalstreet.ai/dashboard";
	@Test
	public void verifyLoginpage() throws InterruptedException
	{
		Thread.sleep(3000);
		String current_url = login.currentUrl();
		Assert.assertEquals(current_url,expected_url);
	}
}
