package Keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.sun.glass.events.KeyEvent;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class keywords {
	public static RemoteWebDriver driver;
	public static Alert alert;
	public static WebElement element = null;
	public static List<WebElement> elements=null;

	/**
	 * This method will open specified browser
	 * 
	 * @param browserName
	 *            It can be any browser like Chrome,IE,Firefox etc
	 */
	public static void openBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser name: ");
		}

	}

	/**
	 * This method will open specified url in browser
	 * 
	 * @param url
	 *            {@code string} url to open
	 */
	public static void openURL(String url) {
		driver.get(url);
	}

	/**
	 * Thie method will allow you to enter text in TextBox
	 * 
	 * @param LocatorType
	 *            It will allow LocatorType CSS, XPATH,ID,NAME etc
	 * @param LocatorValue
	 * @param TextToEnter
	 *            Textto enter in textbox
	 */
	public static void enterText(String LocatorType, String LocatorValue, String TextToEnter) {
		getWebElement(LocatorType, LocatorValue).sendKeys(TextToEnter);

	}

	public static WebElement getWebElement(String LocatorType, String LocatorValue) {
		
		switch (LocatorType) {
		case "XPATH":
			element = driver.findElement(By.xpath(LocatorValue));
			break;
		case "ID":
			element = driver.findElement(By.id(LocatorValue));
			break;
		case "CLASSNAME":
			element = driver.findElement(By.className(LocatorValue));
			break;
		case "NAME":
			element = driver.findElement(By.name(LocatorValue));
			break;
		case "CSS":
			element = driver.findElement(By.cssSelector(LocatorValue));
			break;
		case "TAGNAME":
			element = driver.findElement(By.tagName(LocatorValue));
			break;
		case "LINKTEXT":
			element = driver.findElement(By.linkText(LocatorValue));
			break;
		case "PARTAIL_LINK_TEXT":
			element = driver.findElement(By.partialLinkText(LocatorValue));
			break;
		default:
			System.err.println("Please enter valid LocatorType :" + LocatorType
					+ "Expected: CSS,XPATH,ID,NAME,CLASSNAME,TAGNAME,LINTEXT,PARTIAL_LINK_TEXT");

		}

		return element;

	}
/**
 * this method will allow you to click on web element
 * @param LocatorType
 * @param LocatorValue
 */
	public static void clickOnElement(String LocatorType, String LocatorValue) {
		getWebElement(LocatorType, LocatorValue).click();

	}
	/**
	 * It will accept the alert 
	 */
	public static void acceptAlert() {
		alert=driver.switchTo().alert();
		alert.accept();

	}
	/**
	 * It will cancel the alert
	 */
	public static void rejectAlert() {
		alert=driver.switchTo().alert();
		alert.dismiss();
		
	}
	public static void typeTextIntoAlert(String text) {
		alert=driver.switchTo().alert();
		alert.getText();

	}
	/**
	 * It will maximise the browser Window
	 */
	public static void maximiseBrowser() {
		driver.manage().window().maximize();

	}
	/**
	 * It will close the current browser
	 */
	public static void closeBrowser() {
		driver.close();

	}
	/**
	 * It will close all browsers
	 */
	public static void closeAllBrowser() {
		driver.quit();
		
	}
	/**
	 * It will allow you select value from dropdown
	 * @param LocatorType
	 * @param LocatorValue
	 * @param TextToSelect
	 */
	public static void selectValueFromDropDown(String LocatorType, String LocatorValue, String TextToSelect) {
		WebElement element=getWebElement(LocatorType, LocatorValue);
        Select select=new Select(element);
        select.selectByVisibleText(TextToSelect);
	}
	public static void switchToWindow(String WindowTitle) {
		Set<String> windows=driver.getWindowHandles();
		for(String window:windows) {
			driver.switchTo().window(window).getTitle().equals(WindowTitle);		
		}
	}
	public static void switchToFrameByIndex(int index) {
       driver.switchTo().frame(index);

	}
	public static void deleteCookies() {
		driver.manage().deleteAllCookies();

	}
	
	public static void implicitWait(Integer time,String TimeUnit) {
	switch(TimeUnit) {
	case "MILISECONDS" :
		driver.manage().timeouts().implicitlyWait(time,java.util.concurrent.TimeUnit.MILLISECONDS);
		break;
	case "SECONDS" :
		driver.manage().timeouts().implicitlyWait(time,java.util.concurrent.TimeUnit.SECONDS);
		break;
	case "NANOSECONDS" :
		driver.manage().timeouts().implicitlyWait(time,java.util.concurrent.TimeUnit.NANOSECONDS);
		break;
	case "MICROSECONDS" :
		driver.manage().timeouts().implicitlyWait(time,java.util.concurrent.TimeUnit.MICROSECONDS);
		break;
	case "MINUTES" :
		driver.manage().timeouts().implicitlyWait(time,java.util.concurrent.TimeUnit.MINUTES);
		break;
	case "HOURS" :
		driver.manage().timeouts().implicitlyWait(time,java.util.concurrent.TimeUnit.HOURS);
		break;
	case "DAYS" :
		driver.manage().timeouts().implicitlyWait(time,java.util.concurrent.TimeUnit.DAYS);
		break;
		default:
			System.out.println("please insert proper TimeUnit : Valid TimeUnits are-> SECONDS,MICROSECONDS,MILISECONDS,NANOSECONDS,MINUTES,HOURS,DAYS");
	}

	}
	public static void takeScreenShots(String pathToSaveScreenShot) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src,new File (pathToSaveScreenShot));

	}
	
	public static void navigateForward() {
		driver.navigate().forward();

	}
	
	public static void navigateBackward() {
		driver.navigate().back();

	}
	
	public static void refresh() {
		driver.navigate().refresh();

	}
	public static void dragAndDrop(WebElement SourceLocation,WebElement DestinationLocation) {
		
		Actions action=new Actions(driver);
		action.dragAndDrop(SourceLocation, DestinationLocation).build().perform();

	}
	public static void validateBrokenLinks() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("no of links: " + links.size());
		for (int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			verifyActiveLink(url);
		}
	}

	public static void verifyActiveLink(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpUrlConnect = (HttpURLConnection) url.openConnection();
			httpUrlConnect.setConnectTimeout(3000);
			httpUrlConnect.connect();
			if (httpUrlConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + "-" + httpUrlConnect.getResponseMessage());
			}
			if (httpUrlConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(
						linkUrl + "-" + httpUrlConnect.getResponseMessage() + "-" + HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider
	public static Object[][] excelFileReading(String filepath) {
		Object[][] emails = null;
		try {
			FileInputStream file = new FileInputStream(filepath);
			XSSFWorkbook book = new XSSFWorkbook(file);
			XSSFSheet sheet = book.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			XSSFRow row = sheet.getRow(0);
			int columns = row.getLastCellNum();
			emails = new Object[rows][columns];
			for (int i = 0; i < rows; i++) {
				row = sheet.getRow(i);

				for (int j = 0; j < columns; j++) {

					XSSFCell cell = row.getCell(j);

					switch (cell.getCellType()) {
					case 0:
						emails[i][j] = cell.getNumericCellValue();
						break;

					case 1:
						emails[i][j] = cell.getStringCellValue();
						break;

					case 2:
						emails[i][j] = cell.getCellFormula();
						break;

					case 3:
						emails[i][j] = "";
						break;

					case 4:
						emails[i][j] = cell.getBooleanCellValue();
						break;

					case 5:
						emails[i][j] = cell.getErrorCellValue();
						break;

					default:
						System.out.println("Invalid data");
						break;
					}

				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emails;

	}
	
	
	/**
	 * This method will take screenshot of full page.
	 * @param fileFormat Format of the image file like jpeg,jpg,png,etc.
	 * @param filepath Path of the file where it should be stored.
	 */
	public static void fullPageScreenshot(String fileFormat,String filepath) {
		AShot ashot=new AShot();
		Screenshot screenshot=ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000)).takeScreenshot(driver);
		BufferedImage image=screenshot.getImage();
		try {
			ImageIO.write(image, fileFormat, new File(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	

	}

	public static void failedTestCaseScreenshot() {
		
		String dateFormat=new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		

		try {
			FileUtils.copyFile(source, new File("KeywordDrivenFramework\\Screenshots\\screenshot_"+dateFormat+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}
		
		public static void clickOnElementbyJS(String Locatortype, String Locatorvalue) {
			WebElement element=getWebElement(Locatortype, Locatorvalue);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView()", element);
			element.click();

		}
		
		public static void clickByActionsClass(String LocatorType, String LocatorValue) {
			WebElement element=getWebElement(LocatorType, LocatorValue);
			Actions action=new Actions(driver);
			action.moveToElement(element).click(element).build().perform();

		}
		
		
		public static void Scrollup() {
			try {
				Robot robot=new Robot();
				robot.keyPress(KeyEvent.VK_PAGE_UP);
			} catch (AWTException e) {
				
				e.printStackTrace();
			}
			

		}
		public static void ScrollDown() {
			
			try {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		
		public static void pressEnter(String LocatorType,String LocatorValue) {
			WebElement element=getWebElement(LocatorType, LocatorValue);
			Actions action=new Actions(driver);
			action.keyDown(element, Keys.ENTER).build().perform();
			

		}
		public static void doubleClick(String LocatorType,String LocatorValue) {
			WebElement element=getWebElement(LocatorType, LocatorValue);
			Actions action=new Actions(driver);
			action.doubleClick(element).build().perform();
		}
		public static void clickAndHold(String LocatorType,String LocatorValue) {
			WebElement element=getWebElement(LocatorType, LocatorValue);
			Actions action=new Actions(driver);
			action.clickAndHold(element).build().perform();
		}
		public static void moveToElement(String LocatorType,String LocatorValue) {
			WebElement element=getWebElement(LocatorType, LocatorValue);
			Actions action=new Actions(driver);
			action.moveToElement(element).build().perform();

		}
		
		public static List<WebElement> getWebElements(String LocatorType, String LocatorValue) {
			
			switch (LocatorType) {
			case "XPATH":
				elements = driver.findElements(By.xpath(LocatorValue));
				break;
			case "ID":
				elements = driver.findElements(By.id(LocatorValue));
				break;
			case "CLASSNAME":
				elements = driver.findElements(By.className(LocatorValue));
				break;
			case "NAME":
				elements = driver.findElements(By.name(LocatorValue));
				break;
			case "CSS":
				elements = driver.findElements(By.cssSelector(LocatorValue));
				break;
			case "TAGNAME":
				elements = driver.findElements(By.tagName(LocatorValue));
				break;
			case "LINKTEXT":
				elements = driver.findElements(By.linkText(LocatorValue));
				break;
			case "PARTAIL_LINK_TEXT":
				elements = driver.findElements(By.partialLinkText(LocatorValue));
				break;
			default:
				System.err.println("Please enter valid LocatorType :" + LocatorType
						+ "Expected: CSS,XPATH,ID,NAME,CLASSNAME,TAGNAME,LINTEXT,PARTIAL_LINK_TEXT");

			}
			
			
			return elements;
			

		}
}
