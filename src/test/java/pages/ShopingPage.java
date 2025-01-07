package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class ShopingPage{

	WebDriver driver;
	
	// Element
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a")
	private WebElement shoppingCard;
	
	@FindBy(xpath="//*[@id=\"item_2_title_link\"]/div")
	private WebElement selectedProductTitle;
	
	@FindBy(xpath="//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]")
	private WebElement selectedProductDescription;
	
	@FindBy(xpath="//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
	private WebElement selectedProductPrice;
	
	@FindBy(xpath="//*[@id=\"remove-sauce-labs-onesie\"]")
	private WebElement selectedProductRemoveButton;
	
	@FindBy(xpath="//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]")
	private WebElement selectCardDescription;
	
	@FindBy(xpath="//*[@id=\"continue-shopping\"]")
	private WebElement continueShoppingButton;
	
	@FindBy(xpath="//*[@id=\"checkout\"]")
	private WebElement checkoutButton;
	
	@FindBy(xpath="//*[@id=\"remove-sauce-labs-onesie\"]")
	private WebElement removeButton;
	
	
	// Constructor
	public ShopingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	// Methods
	public void shoppingCard()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", shoppingCard);
		shoppingCard.click();
	}
	
	public void selectCardDescription()
	{
		String title = selectedProductTitle.getText();
		String description = selectedProductDescription.getText();
		String price = selectedProductPrice.getText();
		Reporter.log("SELECTED CARD META DESCRIPTION: "+title+": "+description+": "+price, true);
	}
	
	public void verifyButton()
	{
		Reporter.log("REMOVE BUTTON TEXT: "+removeButton.getText(), true);
		Reporter.log("CONTINUE BUTTON TEXT: "+continueShoppingButton.getText(), true);
		Reporter.log("CHECKOUT BUTTON TEXT: "+checkoutButton.getText(), true);
		checkoutButton.click();	
		Reporter.log(" ", true);
	}
	
	public void successfullyFetchShoppingData()
	{
		Reporter.log("SHOPPING DATA SUCCESSFULLY FETCHED", true);
		Reporter.log("", true);
	}
}
