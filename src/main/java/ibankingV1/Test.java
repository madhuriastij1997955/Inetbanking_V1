package ibankingV1;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {
public static	WebDriver driver;
public static String today_d="18";
public static String tommrow_d="22";
public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	 driver=new ChromeDriver();
	driver.manage().window().maximize();
	// driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com/");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//label[@for='fromCity']/child::span")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("hyderabad");
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.DOWN ,Keys.ENTER);
	
	driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("delhi");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(Keys.DOWN ,Keys.ENTER);
	// String td="18";
	 System.out.println(driver.findElement(By.xpath("//div[@class='dateInnerCell']/p")).getText());
	List<WebElement> l1 = driver.findElements(By.xpath("//div[@class='dateInnerCell']/p"));
	list(l1,today_d);
	
	driver.findElement(By.xpath("//span[@class='swipCircle']/following::div[3]")).click();
	List<WebElement> l2 = driver.findElements(By.xpath("//div[@class='dateInnerCell']/p"));
	list(l2,tommrow_d);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//p[@class='makeFlex vrtlCenter ']/a")).click();
	
	TakesScreenshot ts=   (TakesScreenshot) (driver);
	Thread.sleep(3000);
	File src=ts.getScreenshotAs(OutputType.FILE);
	File des=new File("G:\\media3\\selenium\\ibankingV1\\Screenshots\\img.jpg");
	FileUtils.copyFile(src, des);
	
	driver.close();
            
	//Actions act=new Actions(driver);


	
}

public static  void list(List<WebElement> l,String date) throws Exception {
	
	Iterator<WebElement> i = l.iterator();
    while(i.hasNext()) {
   	    WebElement ele = i.next();
   	    System.out.println(ele.getText());
   	    if(ele.getText().equalsIgnoreCase(date)) {
   	    	System.out.println(ele.getText());
   	    	Thread.sleep(2000);
   	    	Actions act=new Actions(driver);
   	    	act.moveToElement(ele).click().build().perform();
   	    	break;
   	    	//ele.click();
   	    }
   	    
   	    
   	    
   	    
    }
   
  	 
}
}
