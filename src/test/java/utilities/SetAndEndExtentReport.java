package utilities;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SetAndEndExtentReport extends CapturedScreenshots {

	public ExtentReports extentreports;
	public ExtentSparkReporter sparkreports;
	public ExtentTest extenttest;
	public String reportname;
	

	public void onStart(String methodname)
	{
		reportname = "Test-report"+timeStamp+".html";
		sparkreports = new ExtentSparkReporter(".\\reports\\" +reportname);
	
		sparkreports.config().setDocumentTitle("Project Sauce Demo Automation Report");
		sparkreports.config().setReportName("Project Sauce Demo Automation");
		sparkreports.config().setTheme(Theme.DARK);
	
		extentreports = new ExtentReports();
		
		extentreports.attachReporter(sparkreports);
		extentreports.setSystemInfo("Computer Name", "localhost");
		extentreports.setSystemInfo("Environment", "QA");
		extentreports.setSystemInfo("OS", "Windows");
		extentreports.setSystemInfo("Browser Name", "Chrome");		
		extenttest = extentreports.createTest(methodname);
	}
	
	public void onTestStart(String methodname)
	{
		extenttest = extentreports.createTest(methodname);
	}
	
	public void onTestSuccess(String methodname)
	{
		extenttest = extentreports.createTest(methodname);
		extenttest.log(Status.PASS, "On Test Success: "+methodname);
	}
	
	public void onTestFailure(ITestResult resukt)
	{
		extenttest = extentreports.createTest(resukt.getName());
		extenttest.log(Status.FAIL, "On Test Failure: "+resukt.getName());
		String imagepath = new CapturedScreenshots().getScreenshot(resukt.getName());
		try
		{
			extenttest.addScreenCaptureFromPath(imagepath);
		}
		catch (Exception e)
		{
			e.getStackTrace();
		}
	}
	
	public void onTestSkipped(String methodname)
	{
		extenttest = extentreports.createTest(methodname);
		extenttest.log(Status.SKIP, "on Test Skipped"+methodname);
	}
	
	public void onFinish(String methodname)
	{
		extenttest = extentreports.createTest(methodname);
		extentreports.flush();
	}
}

