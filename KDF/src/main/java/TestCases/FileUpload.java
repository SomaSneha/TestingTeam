package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {
public void fileUpload() throws Exception {
	WebDriverManager.chromedriver().setup();
	RemoteWebDriver driver=new ChromeDriver();
	driver.get("https://www.naukri.com/");
	System.out.println("opened");
	//driver.findElement(By.id("postjob")).click();
//	driver.findElement(By.id("input_3")).sendKeys("Gaurav");
	System.out.println("not able to click");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
WebElement element=	driver.findElement(By.xpath("//input[@value=\"Post your CV\"]"));
System.out.println("hi");//
	//JavascriptExecutor js=(JavascriptExecutor)driver;
//	js.executeScript("arguments[0].scrollIntoView()", element);
	element.click();
	Runtime.getRuntime().exec("D:\\autoit\\File2.exe");
	System.out.println("file uploaded successfully");
	
}
public static void main(String[] args) throws Exception  {
FileUpload fl=new FileUpload();
fl.fileUpload();
	
}
}
