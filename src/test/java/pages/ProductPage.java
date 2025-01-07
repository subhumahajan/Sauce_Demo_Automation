package pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class ProductPage{

	WebDriver driver;
	
	// Element
	@FindBy(xpath="//*[@class=\"inventory_item_description\"]")
	private List<WebElement> invetories;
	
	@FindBy(xpath="//*[@class='inventory_item_label']/a")
	private List<WebElement> inventoryTitle;
	
	@FindBy(xpath="//*[@class='inventory_item_desc']")
	private List<WebElement> inventoryItemDescription;
	
	@FindBy(xpath="//*[@class=\"inventory_item_price\"]")
	private List<WebElement> inventoryPrice;
	
	@FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-onesie\"]")
	private WebElement addToCard;
	
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a")
	private WebElement shoppingCard;
	
	@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/div/span/select")
	private WebElement clickToFilterProduct;
	
 	@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/div/span/select/option")
 	private List<WebElement> productFilterType;
 	
 	@FindBy(xpath="//*[@id=\"page_wrapper\"]/footer/ul/li")
 	private List<WebElement> socialText; 
 	
 	@FindBy(xpath="//*[@id=\"page_wrapper\"]/footer/ul/li/a")
 	private List<WebElement> socialLinks; 
	
	// Constructor
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	// Methods
	public void inventory()
	{
		
		for(int i=0; i<invetories.size(); i++)
		{
			String title = inventoryTitle.get(i).getText();
			String description = inventoryItemDescription.get(i).getText();
			String price = inventoryPrice.get(i).getText();
			
			String inventoryDetails= title+" :: "+description+" :: "+price;
			Reporter.log("INVENTORY DETAILS: "+i+": "+inventoryDetails,true);
		}
		Reporter.log(" ", true);
	}
	
	public void produtFilter()
	{
		clickToFilterProduct.click();
		for(int i=0; i<productFilterType.size(); i++)
		{
			Reporter.log("PRODUCT FILTER: "+i+": "+productFilterType.get(i).getText(),true);
		}
		Reporter.log(" ", true);
	}
	
	public void addToCard()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", addToCard);
	    addToCard.click();
		js.executeScript("arguments[0].scrollIntoView(true);", shoppingCard);
	}
	
	public void social()
	{
		for(int i=0; i<socialText.size(); i++)
		{
			Reporter.log("SOCIAL LINKS TEXT: "+i+": "+socialText.get(i).getText(), true);
			Reporter.log("SOCIAL LINKS: "+i+": "+socialLinks.get(i).getAttribute("href"), true);
		}
		Reporter.log(" ", true);
	}
	
	
	public void successfullyProductFetch()
	{
		Reporter.log("PRODUCT SUCCESSFULLY FETCHED", true);
		Reporter.log("", true);
	}

}
