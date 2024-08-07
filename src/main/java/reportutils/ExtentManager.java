package reportutils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setReport() {                                            //test-output folderul din rooth ul proiectului meu, aici salvam raportul
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport/TestExecutionReport.html");
		
	//	htmlReporter.loadXMLConfig(System.getProperty("user.dir" + "/extent-config.xml"));
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	
	public static void endReport() {
		
		extent.flush();
	}
	

}
