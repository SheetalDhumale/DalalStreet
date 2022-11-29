package ai.dalalstreet.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ai.dalalstreet.testBase.TestBase;

public class LoginPage extends TestBase
{
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@name='email']")
	private WebElement email_txt;
	@FindBy(xpath="//input[@name='password']")
	private WebElement pswrd_txt;
	@FindBy(xpath="//*[text()='Log In']")
	private WebElement login_btn;
	
	public void enterEmailText(String email)
	{
		email_txt.sendKeys(email);
	}
	public void enterPasswordText(String pswrd)
	{
		pswrd_txt.sendKeys(pswrd);
	}
	public void clickOnSignin()
	{
		login_btn.click();
	}
	public String currentUrl()
	{
		String c_url = driver.getCurrentUrl();
		return c_url;
	}
}
