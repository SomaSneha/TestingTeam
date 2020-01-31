package TestCases;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Keywords.Keywords;
public class SignInTestCases {
	Logger log = Logger.getLogger(SignInTestCases.class);
    @BeforeTest
	@Test(priority=1)
	public void signInWithGmail() {
		Keywords.openBrowser("Chrome");
		log.info("browser opened successfully...");
		Keywords.openURL("https://eagercrow.com/Home");
		log.info("URl opened");
		Keywords.maximiseBrowser();
		Keywords.implicitWait(10, "SECONDS");
		Keywords.clickOnElementbyJS("XPATH", "//div[@class=\"header-icons\"]/a[contains(text(),'Sign In')]");
		System.out.println("hi");
		Keywords.clickOnElement("XPATH", "//span[contains(text(),'Sign in with email')]");
		Keywords.enterText("XPATH", "//input[@class=\"mdl-textfield__input firebaseui-input firebaseui-id-email\"]",
				"soma.sneha215@gmail.com");
		Keywords.clickOnElement("XPATH",
				"//button[@class=\"firebaseui-id-submit firebaseui-button mdl-button mdl-js-button mdl-button--raised mdl-button--colored\"]");
		Keywords.enterText("XPATH", "//input[@class=\"mdl-textfield__input firebaseui-input firebaseui-id-name\"]",
				"Sneha Soma");
		Keywords.enterText("XPATH",
				"//input[@class=\"mdl-textfield__input firebaseui-input firebaseui-id-new-password\"]", "Testing@123");
		Keywords.clickOnElement("XPATH", "//button[@type=\"submit\"]");
		Keywords.rejectAlert();
	}
    public void signInWithFacebook() {
		Keywords.openBrowser("Chrome");
		log.info("browser opened successfully...");
		Keywords.openURL("https://eagercrow.com/Home");
		log.info("URl opened");
		Keywords.maximiseBrowser();
		Keywords.implicitWait(10, "SECONDS");
		Keywords.clickOnElementbyJS("XPATH", "//div[@class=\"header-icons\"]/a[contains(text(),'Sign In')]");
		Keywords.clickOnElement("XPATH", "//span[contains(text(),'Sign in with Facebook')]");
		Keywords.switchToWindow("Log in to Facebook | Facebook");
		Keywords.enterText("XPATH", "//input[@id=\"email\"]", "ssoma350@gmail.com");
		Keywords.enterText("XPATH", "//input[@id=\"pass\"]", "");
		Keywords.clickOnElement("XPATH", "//button[@type=\"submit\"]");

	}
    
	public static void signinWithGoogle() {
		Keywords.openBrowser("Chrome");
		Keywords.openURL("https://eagercrow.com/Home");
		Keywords.implicitWait(10, "SECONDS");
		Keywords.maximiseBrowser();
		Keywords.clickOnElementbyJS("XPATH", "//div[@class=\"header-icons\"]/a[contains(text(),'Sign In')]");
	
		Keywords.clickOnElement("XPATH", "//button[@class=\"firebaseui-idp-button mdl-button mdl-js-button mdl-button--raised firebaseui-idp-google firebaseui-id-idp-button\"]");
		Keywords.switchToWindow("Sign in - Google Accounts");
		Keywords.enterText("XPATH", "//input[@type=\"email\"]", "rosesinghritu");
		Keywords.clickOnElement("XPATH", "//span[contains(text(),'Next')]");
		Keywords.enterText("XPATH", "//input[@type=\"password\"]", "");
		Keywords.clickOnElement("XPATH", "//span[contains(text(),'Next')]");

	}
}
