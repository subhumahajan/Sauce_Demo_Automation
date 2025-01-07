package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class LoginPage {

	WebDriver driver;

    // WebElements
    @FindBy(css="#user-name")
	private WebElement enterUsername;

    @FindBy(css = "#password")
    private WebElement enterPassword;

    @FindBy(css = "#login-button")
    private WebElement loginButton;
      
       // Constructor
    public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	// Method
	public void EnterUsername(String username)
	{
		enterUsername.clear();
		enterUsername.sendKeys(username);
		Reporter.log("USERNAME: "+enterUsername.getAttribute("value"), true);
	}
	
	public void EnterPassword(String password)
	{
		enterPassword.clear();
		enterPassword.sendKeys(password);
		Reporter.log("PASSWORD: "+enterPassword.getAttribute("value"),true);
	}
	
	public void ClickOnLoginButton()
	{
		Reporter.log("LOGIN BUTTON TEXT: "+loginButton.getAttribute("value"),true);
		loginButton.click();
	}
			
	public void loginPageStatus()
	{
		Reporter.log("LOGIN SUCCESSFULLY",true);
		Reporter.log("", true);

	}
}
