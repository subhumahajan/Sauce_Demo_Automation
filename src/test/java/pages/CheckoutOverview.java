package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CheckoutOverview {

	WebDriver driver;
	
	// WebElement
	@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/span")
	private WebElement checkoutOveriewTitle;
	
	@FindBy(xpath="//*[@id=\"item_2_title_link\"]/div")
	private WebElement selectProductCheckoutOverviewTitle;
	
	@FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[1]")
	private WebElement selectProductCheckoutOverviewDescription;
	
	@FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
	private WebElement selectProductCheckoutOverviewPrice;
	
	@FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[2]/div[1]")
	private WebElement paymentInformation;
	
	@FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[2]/div[2]")
	private WebElement paymentInfomrationdata;
	
	@FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[2]/div[3]")
	private WebElement shippingInformation;
	
	@FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[2]/div[4]")
	private WebElement shippingInformationData;
	
	@FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]")
	private WebElement totalPrice;
	
	@FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]")
	private WebElement totalPriceItemPrice;
	
	@FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]")
	private WebElement totalPriceItemPricetax;
	
	@FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")
	private WebElement finalPrice;

	@FindBy(xpath="//*[@id=\"cancel\"]")
	private WebElement cancelButton;
	
	@FindBy(xpath="//*[@id=\"finish\"]")
	private WebElement finishButton;
	
	// COnstructor
	public CheckoutOverview(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	// Methods
	public void checkoutOveriewTitle()
	{
		Reporter.log("CHECKOUT OVERVIEW TITLE: "+checkoutOveriewTitle.getText(), true);
	}
	
	public void checkoutOveriewDescription()
	{
		String title = selectProductCheckoutOverviewTitle.getText();
		String description = selectProductCheckoutOverviewDescription.getText();
		String price = selectProductCheckoutOverviewPrice.getText();
		Reporter.log("CHECKOUT OVERVIEW DESCRIPTION: "+title+": "+description+": "+price, true);
	}
	
	public void paymentInformationData()
	{
		String paymentInformationTitle = paymentInformation.getText();
		String paymentInfomrationdataData = paymentInfomrationdata.getText();
		Reporter.log("PAYMENT INFORMATION DATA: "+paymentInformationTitle+": "+paymentInfomrationdataData);
	}
	
	public void shippingInformationData()
	{
		String shoppingInformationTitle = shippingInformation.getText();
		String shoppingInfomrationdataData = shippingInformationData.getText();
		Reporter.log("SHOPPING INFORMATION DATA: "+shoppingInformationTitle+": "+shoppingInfomrationdataData);
	}
	
	public void Price()
	{
		String price = totalPrice.getText();
		String itemPrice = totalPriceItemPrice.getText();
		String itemPriceTax = totalPriceItemPricetax.getText();
		String finalPr = finalPrice.getText();
		Reporter.log("PRICE: "+price+": "+itemPrice+": "+itemPriceTax+"::"+finalPr, true);
	}
	
	public void finishButton()
	{
		Reporter.log("CANCEL BUTTON TEXT: "+cancelButton.getText());
		Reporter.log("FINISH BUTTON TEXT: "+finishButton.getText());
		finishButton.click();
	}
	
	public void successfullyCheckoutOveriew()
	{
		Reporter.log("SUCCESSFULLY CHECKOUT OVERVIEW DATA", true);
		Reporter.log("", true);
	}
}


