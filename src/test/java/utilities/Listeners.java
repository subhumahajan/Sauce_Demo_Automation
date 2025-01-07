package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners extends CapturedScreenshots implements ITestListener {
	
	SetAndEndExtentReport setandendextentreport = new SetAndEndExtentReport();

	public void onStart(ITestContext context)
	{
		setandendextentreport.onStart(context.getName());
		Reporter.log("- On Test Start",true);
	}
	
	public void onTestStart(ITestResult resukt)
	{
		setandendextentreport.onTestStart(resukt.getName());
		Reporter.log("- On Test Start",true);
	}
	
	public void onTestSuccess(ITestResult resukt)
	{
		setandendextentreport.onTestSuccess(resukt.getName());
		Reporter.log("- On Test Success",true);
	}
	
	public void onTestFailure(ITestResult resukt)
	{
		setandendextentreport.onTestFailure(resukt);
		Reporter.log("- On Test Failure",true);
	}
	
	public void onTestSkipped(ITestResult resukt)
	{
		setandendextentreport.onTestSkipped(resukt.getName());
		Reporter.log("- On Test Skipped",true);
	}
	
	public void onFinish(ITestContext context)
	{
		setandendextentreport.onFinish(context.getName());
		Reporter.log("- On Finish",true);
	}
}
