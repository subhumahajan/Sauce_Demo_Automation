package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadPropertyFile;

public class StartupAndTeardown {
	
	WebDriver driver;
	ReadPropertyFile readpropertyfile = new ReadPropertyFile(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");

	public void openBrowser()
	{
		String browser = readpropertyfile.getProperty("Browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(readpropertyfile.getProperty("URL"));
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
