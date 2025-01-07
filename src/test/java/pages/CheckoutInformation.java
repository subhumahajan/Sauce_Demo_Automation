package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CheckoutInformation {

	WebDriver driver;
	
	// WebElement
	@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/span")
	private WebElement checkoutInformationTitle;
	
	@FindBy(xpath="//*[@id=\"first-name\"]")
	private WebElement firstName;
	
	@FindBy(xpath="//*[@id=\"last-name\"]")
	private WebElement lastName;
	
	@FindBy(xpath="//*[@id=\"postal-code\"]")
	private WebElement postalCode;
	
	@FindBy(xpath="//*[@id=\"cancel\"]")
	private WebElement cancelButton;
	
	@FindBy(xpath="//*[@id=\"continue\"]")
	private WebElement continueButton;
	
	
	// Constructor
	public CheckoutInformation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;;
	}
	
	// Methods 
	public void checkoutInformationTitle()
	{
		Reporter.log("CHECKOUT INFORMATION TITLE: "+checkoutInformationTitle.getText(), true);
	}
	
	public void firstName(String userFirstName)
	{
		firstName.sendKeys(userFirstName);
		Reporter.log("FIRST NAME: "+firstName.getAttribute("value"),true);
	}
	
	public void lastName(String userLastName)
	{
		lastName.sendKeys(userLastName);
		Reporter.log("LAST NAME: "+lastName.getAttribute("value"),true);
	}
	
	public void postalCode(String userPostalCode)
	{
		postalCode.sendKeys(userPostalCode);
		Reporter.log("POSTAL CODE: "+postalCode.getAttribute("value"),true);
	}
	
	public void continueButton()
	{
		Reporter.log("CANCEL BUTTON TEXT: "+cancelButton.getText());
		Reporter.log("CONTINUE BUTTON TEXT: "+continueButton.getText());
		continueButton.click();
	}
	
	public void successfullyCheckoutInformation()
	{
		Reporter.log("CHECKOUT INFORMATION SUCCESSFULLY FETCHED", true);
		Reporter.log("", true);
	}
}
