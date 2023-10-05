package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentReport {
	public static ExtentReports report;
	public static ExtentHtmlReporter htmlReporter;

	public static ExtentReports getReportInstance() {

		report = new ExtentReports();
		 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Report\\report_"+System.currentTimeMillis()+".html");
			report.attachReporter(htmlReporter);
			
			report.setSystemInfo("Machine", "SOM");
			report.setSystemInfo("Environment", "DevOps");
			report.setSystemInfo("Browser", "Chrome");
			report.setSystemInfo("Windows", "Windows-10");
			
			htmlReporter.config().setDocumentTitle("Hackathon Automation Results");
			htmlReporter.config().setReportName("Hackathon COURSERA Test Report");
		return report;
	}
	
}
