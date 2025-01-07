package testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import pages.CheckoutCompleted;
import pages.CheckoutInformation;
import pages.CheckoutOverview;
import pages.LoginPage;
import pages.ProductPage;
import pages.ShopingPage;
import utilities.ReadPropertyFile;
import utilities.ReadXLSXFile;

public class ModuleTestCases {
	
	public static WebDriver driver;
	SoftAssert softassert = new SoftAssert();

	
	StartupAndTeardown startupandteardown = new StartupAndTeardown();
	ReadPropertyFile readpropertyfile = new ReadPropertyFile(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
	public void startUp()
	{
		startupandteardown.openBrowser();
		driver = startupandteardown.driver;
	}
	
	public void loginPage()
	{
		LoginPage loginpage = new LoginPage(driver);
		
		String filepath = System.getProperty("user.dir")+"\\src\\test\\resources\\testdatafiles\\testdata.xlsx";
		ReadXLSXFile readxlsxfile = new ReadXLSXFile();
		String[][] loginData = readxlsxfile.readXLSXFile(filepath);
        
        for (String[] credentials : loginData) 
        {
            String username = credentials[0];
            String password = credentials[1];
            String type = credentials[2];
            
            loginpage.EnterUsername(username);
            loginpage.EnterPassword(password);
            loginpage.ClickOnLoginButton();

            
            
            if(username=="standard_user" & password=="secret_sauce" & type=="valid")
            {
                 String USERNAME = readpropertyfile.getProperty("Username");
                 softassert.assertEquals("standard_user", USERNAME,"User Name Successfully Matched");

                 String PASSWORD = readpropertyfile.getProperty("Password");
                 softassert.assertEquals("secret_sauce", PASSWORD, "Password Successfully Matched");

            }
            
            else
            {
            	Reporter.log("THERE IS NO STATEMENT FOR THIS ELSE BLOCK");
            }
            
            loginpage.loginPageStatus();
        }
    
        softassert.assertAll();
	}
	
	public void productPage()
	{
		ProductPage productpage = new ProductPage(driver);
		productpage.inventory();
		productpage.produtFilter();
		productpage.addToCard();
		productpage.social();
		productpage.successfullyProductFetch();
	}
	
	public void shopingPage()
	{
		ShopingPage shoppingpage = new ShopingPage(driver);
		shoppingpage.shoppingCard();
		shoppingpage.selectCardDescription();
		shoppingpage.verifyButton();
		shoppingpage.successfullyFetchShoppingData();
	}
	
	public void checkoutInformation()
	{
		CheckoutInformation checkoutinformation = new CheckoutInformation(driver);
		checkoutinformation.checkoutInformationTitle();
		checkoutinformation.firstName(readpropertyfile.getProperty("FirstName"));
		checkoutinformation.lastName(readpropertyfile.getProperty("LastName"));
		checkoutinformation.postalCode(readpropertyfile.getProperty("PostalCode"));
		checkoutinformation.continueButton();
		checkoutinformation.successfullyCheckoutInformation();
	}
	
	public void checkoutOverview()
	{
		CheckoutOverview checkoutoverview = new CheckoutOverview(driver);
		checkoutoverview.checkoutOveriewTitle();
		checkoutoverview.checkoutOveriewDescription();
		checkoutoverview.paymentInformationData();
		checkoutoverview.shippingInformationData();
		checkoutoverview.Price();
		checkoutoverview.finishButton();
		checkoutoverview.successfullyCheckoutOveriew();
	}
	
	public void checkoutCompleted()
	{
		CheckoutCompleted checkoutcompleted = new CheckoutCompleted(driver);
		checkoutcompleted.checkoutCompletedTitle();
		checkoutcompleted.orderCompletedMessage();
		checkoutcompleted.orderCompletedDescription();
		checkoutcompleted.backHomeButton();
		checkoutcompleted.bmBurgerButton();
		checkoutcompleted.successfullyCheckoutCompleted();
	}
	
	public void tearDown()
	{
		startupandteardown.closeBrowser();	
	}
}
