package TestCases;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Keywords.Keywords;

public class ChairTestCases{
	@Test
	public static void totalChairsAvailable() {
		Keywords.openBrowser("Chrome");
		Keywords.openURL("https://eagercrow.com/Home");
		Keywords.implicitWait(20, "SECONDS");
		Keywords.maximiseBrowser();
		Keywords.clickOnElement("XPATH", "//a[contains(text(),'Departments')]");
		Keywords.moveToElement("XPATH", "//div/mat-card/div/div/div[3]/a/img");
		Keywords.clickOnElement("XPATH", "//div/mat-card/div/div/div[3]/a/img");
		List<WebElement> chairs=Keywords.getWebElements("XPATH", "//div[@class=\"col-sm-12 col-md-4 col-lg-2 p-b-50\"]");
		System.out.println("Total no of chairs available:"+chairs.size());
		
	}
	
	@Test
	public void viewDetailsofParticularChair() {
		Keywords.openBrowser("Chrome");
		Keywords.openURL("https://eagercrow.com/Home");
		Keywords.implicitWait(20, "SECONDS");
		Keywords.maximiseBrowser();
		Keywords.clickOnElement("XPATH", "//a[contains(text(),'Departments')]");
		Keywords.moveToElement("XPATH", "//div/mat-card/div/div/div[3]/a/img");
		Keywords.clickOnElement("XPATH", "//div/mat-card/div/div/div[3]/a/img");
		Keywords.clickOnElement("XPATH", "//a[contains(text(),'Polytech Plastic Chair (Beige)')]");
		String chairdetails=Keywords.getWebElement("XPATH", "//div[@class=\"w-size14 p-t-30 respon5\"]").getText();
		System.out.println(chairdetails);

	}
	
	@Test
	public void addingTheQuantityOfChair() {
		Keywords.openBrowser("Chrome");
		Keywords.openURL("https://eagercrow.com/Home");
		Keywords.implicitWait(20, "SECONDS");
		Keywords.maximiseBrowser();
		Keywords.clickOnElement("XPATH", "//a[contains(text(),'Departments')]");
		Keywords.moveToElement("XPATH", "//div/mat-card/div/div/div[3]/a/img");
		Keywords.clickOnElement("XPATH", "//div/mat-card/div/div/div[3]/a/img");
		Keywords.clickOnElement("XPATH", "//a[contains(text(),'Polytech Plastic Chair (Beige)')]");
		Keywords.clickOnElement("XPATH", "//button[@class=\"btn-num-product-up color1 flex-c-m size7 bg8 eff2\"]");
		
	}
	
	@Test
	public static void addtocartwithoutSignIn() {
		Keywords.openBrowser("Chrome");
		Keywords.openURL("https://eagercrow.com/Home");
		Keywords.implicitWait(20, "SECONDS");
		Keywords.maximiseBrowser();
		Keywords.clickOnElement("XPATH", "//a[contains(text(),'Departments')]");
		Keywords.moveToElement("XPATH", "//div/mat-card/div/div/div[3]/a/img");
		Keywords.clickOnElement("XPATH", "//div/mat-card/div/div/div[3]/a/img");
		Keywords.clickOnElement("XPATH", "//a[contains(text(),'Polytech Plastic Chair (Beige)')]");
		Keywords.clickOnElement("XPATH", "//input[@class=\"size8 m-text18 t-center num-product\"]");
		String errormessage=Keywords.getWebElement("XPATH","//div[@id=\"snackbar\"]").getText();
		System.out.println(errormessage);
	}
	
	@Test
	public static void addtocartwithSignIn() {
		
		Keywords.clickOnElement("XPATH", "//a[contains(text(),'Departments')]");
		Keywords.moveToElement("XPATH", "//div/mat-card/div/div/div[3]/a/img");
		Keywords.clickOnElement("XPATH", "//div/mat-card/div/div/div[3]/a/img");
		Keywords.clickOnElement("XPATH", "//a[contains(text(),'Polytech Plastic Chair (Beige)')]");
		Keywords.clickOnElement("XPATH", "//input[@class=\"size8 m-text18 t-center num-product\"]");

	}
	
	@Test
	public static void lowestPriceProduct() throws ParseException {
		Keywords.openBrowser("Chrome");
		Keywords.openURL("https://eagercrow.com/Home");
		Keywords.implicitWait(20, "SECONDS");
		Keywords.maximiseBrowser();
		Keywords.clickOnElement("XPATH", "//a[contains(text(),'Departments')]");
		Keywords.moveToElement("XPATH", "//div/mat-card/div/div/div[3]/a/img");
		Keywords.clickOnElement("XPATH", "//div/mat-card/div/div/div[3]/a/img");

		List<WebElement> chairs=Keywords.getWebElements("XPATH", "//div[@class=\"block2-txt p-t-20 color0-hov\"]");
		Integer minprice=0,r=0;
		String productname="";
		Iterator<WebElement> itr = chairs.iterator();
		
		while (itr.hasNext()) {
			WebElement data = itr.next();
			
			String actualprice = data.findElement(By.xpath("//span[@class=\"block2-price m-text6 p-r-5\"]")).getText().substring(4);
			
			minprice=Integer.parseInt(actualprice);
			if(minprice>r) {
				r=minprice;
				productname = data.findElement(By.xpath("//a[@class=\"block2-name dis-block s-text3 p-b-5\"]")).getText();
			}
			
			
		}
		System.out.println(productname+" has lowest price:"+minprice);
		
		}
	
	@Test
	public static void informationofalltheAvailableProducts() {
		Keywords.openBrowser("Chrome");
		Keywords.openURL("https://eagercrow.com/Home");
		Keywords.implicitWait(20, "SECONDS");
		Keywords.maximiseBrowser();
		Keywords.clickOnElement("XPATH", "//a[contains(text(),'Departments')]");
		Keywords.moveToElement("XPATH", "//div/mat-card/div/div/div[3]/a/img");
		Keywords.clickOnElement("XPATH", "//div/mat-card/div/div/div[3]/a/img");
		List<WebElement> availableproducts=Keywords.getWebElements("XPATH", "//div[@class=\"block2-txt p-t-20 color0-hov\"]");
		Iterator<WebElement> itr=availableproducts.iterator();
		while(itr.hasNext()) {
			WebElement data=itr.next();
			System.out.println(data.getText());
		}

	}
	
	@Test
	public static void ContactUsLinkAvailable() {
		Keywords.openBrowser("Chrome");
		Keywords.openURL("https://eagercrow.com/Home");
		Keywords.implicitWait(20, "SECONDS");
		Keywords.maximiseBrowser();
		Keywords.clickOnElement("XPATH", "//a[@class=\"color0-hov selected\"]");
		


	}
}
