package pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CheckoutCompleted {

	WebDriver driver;
	
	// WebElement
	@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/span")
	private WebElement checkoutCompletedTitle;
		
	@FindBy(xpath="//*[@id=\"checkout_complete_container\"]/h2")
	private WebElement orderCompletedMessage;
	
	@FindBy(xpath="//*[@id=\"checkout_complete_container\"]/div")
	private WebElement orderCompletedDescription;
	
	@FindBy(xpath="//*[@id=\"back-to-products\"]")
	private WebElement backHomeButton;
	
	@FindBy(xpath="//*[@id=\"react-burger-menu-btn\"]")
	private WebElement bmBurgerButton;
	
	@FindBy(xpath="//*[@id=\"menu_button_container\"]/div/div[2]/div[1]/nav/a")
	private List<WebElement> bmItemList;
	
	@FindBy(xpath="//*[@id=\"logout_sidebar_link\"]")
	private WebElement logout;
	
	// Constructor
	public CheckoutCompleted(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	// Methods
	public void checkoutCompletedTitle()
	{
		Reporter.log("CHECKOUT COMPLETED TITLE: "+checkoutCompletedTitle.getText(), true);
	}
	
	public void orderCompletedMessage()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Reporter.log("ORDER COMPLETED MESSAGE: "+orderCompletedMessage.getText(), true);
	}
	
	public void orderCompletedDescription()
	{
		Reporter.log("RDER COMPLETED DESCRIPTION: "+orderCompletedDescription.getText(), true);
	}
	
	public void backHomeButton()
	{
		Reporter.log("BACK BUTTON TEXT: "+backHomeButton.getText(), true);
		backHomeButton.click();
	}
	
	public void bmBurgerButton()
	{
		String list = null;
		bmBurgerButton.click();
		for(int i=0; i<=bmItemList.size();i++)
		{
			list = bmItemList.get(i).getText();
			Reporter.log("TEXT LIST: "+list, true);
			if(list.equalsIgnoreCase("logout"))
			{
				logout.click();
			}
		}
	}
	
	public void successfullyCheckoutCompleted()
	{
		Reporter.log("CHECKOUT SUCCESSFULLY COMPLETED", true);
		Reporter.log("", true);
	}
	
}
