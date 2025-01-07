package base;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testcases.ModuleTestCases;

public class SauceDemoAutomation extends ModuleTestCases {
	@BeforeClass
	public void start_up()
	{
		startUp();
	}
	
	@Test(priority=1, retryAnalyzer=utilities.RetryMechanism.class)
	public void login_page()
	{
		loginPage();
	}
	
	@Test(priority=2, retryAnalyzer=utilities.RetryMechanism.class)
	public void product_page()
	{
		productPage();
	}
	
	@Test(priority=3, retryAnalyzer=utilities.RetryMechanism.class)
	public void shopping_page()
	{
		shopingPage();
	}
	
	@Test(priority=4, retryAnalyzer=utilities.RetryMechanism.class)
	public void checkout_information()
	{
		checkoutInformation();
	}
	
	@Test(priority=5, retryAnalyzer=utilities.RetryMechanism.class)
	public void checkout_overview()
	{
		checkoutOverview();
	}
	
	@Test(priority=6, retryAnalyzer=utilities.RetryMechanism.class)
	public void checkout_completed()
	{
		checkoutCompleted();
	}
	
	@AfterClass	
	public void tear_down()
	{
		tearDown();
	}

}
