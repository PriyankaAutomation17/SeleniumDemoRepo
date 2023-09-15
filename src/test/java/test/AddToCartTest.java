package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import resources.Base;

public class AddToCartTest extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeTest
	public void LaunchBrowser() throws Exception {
		log = LogManager.getLogger(AddToCartTest.class.getName());

		driver = initializeBrowser();
		log.debug("Browser is launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");

	}

	@Test(dataProvider = "getLoginData")
	public void addToCart(String email, String password) throws Exception {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropDown().click();
		log.debug("Clicked on My Account dropdown");

		landingPage.loginOption().click();
		log.debug("Clicked on login option");

		Thread.sleep(3000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddress().sendKeys(email);
		log.debug("Email addressed got entered");
		Thread.sleep(3000);

		loginPage.password().sendKeys(password);
		log.debug("Password got entered");
		Thread.sleep(3000);

		loginPage.loginButton().click();
		log.debug("Clicked on Login Button");
		Thread.sleep(3000);

		landingPage.phonesOption().click();
		log.debug("Clicked on Phones&PDAs");
		Thread.sleep(3000);
		
		ProductPage productPage = new ProductPage(driver);
		productPage.cartButton().click();
		Thread.sleep(3000);
	}


	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = { { "arun.selenium@gmail.com", "Second@123" } };
		return data;
	}

}
