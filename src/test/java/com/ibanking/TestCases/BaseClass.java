package com.ibanking.TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ibanking.Utilitys.ReadConfig;

public class BaseClass {
	public static WebDriver driver;
	public ReadConfig r=new ReadConfig();
	
	  public String url=r.getUrl();
	  public String	  userid=r.getUserid(); 
	  public String userpwd=r.getUserPwd();
	 public Logger logger;
	 
	 
	/*
	 * public ExtentHtmlReporter htmlrep; public ExtentReports extent; public
	 * ExtentTest test;
	 * 
	 * @BeforeTest public void setExtent() { String time= new
	 * SimpleDateFormat("YYYY.MM.DD.HH.MM.SS").format(new Date());
	 * 
	 * 
	 * htmlrep=new ExtentHtmlReporter(System.getProperty("user.dir")+
	 * "/test-output/myreport"+time+".html");
	 * //htmlrep.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	 * 
	 * htmlrep.config().setDocumentTitle("automation report");
	 * htmlrep.config().setReportName("my first report");
	 * htmlrep.config().setTheme(Theme.DARK); extent=new ExtentReports();
	 * extent.attachReporter(htmlrep);
	 * extent.setSystemInfo("host name","local host");
	 * extent.setSystemInfo("OS","window");
	 * extent.setSystemInfo("Tester name","madhuri");
	 * extent.setSystemInfo("browser","chrome"); System.out.println("before test");
	 * 
	 * }
	 * 
	 * @AfterTest public void endReport() { extent.flush(); }
	 */
	
			
			
	 
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String b) {
		if(b.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", r.getChropath());
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		}else if(b.equalsIgnoreCase("firefox")) {
			System.out.println("firefox");
			System.setProperty("webdriver.gecko.driver", r.getFirepath());
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			
			
		}
		logger=Logger.getLogger("ibanking");
		PropertyConfigurator.configure("log4j.properties");
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public static void captureScreenshot(WebDriver driver, String name) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());
		 TakesScreenshot ts = (TakesScreenshot) BaseClass.driver; File
	  src= ts.getScreenshotAs(OutputType.FILE);
		 String path="./Screenshots/"+name+".png";
		 File des=new File(path);
		 FileUtils.copyFile(src, des);
	}

}
