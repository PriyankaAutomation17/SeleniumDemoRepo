package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeMethod
	public void LaunchBrowser() throws Exception {
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver = initializeBrowser();
		log.debug("Browser is launched");
		
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");

	}

	@Test(dataProvider = "getLoginData")
	public void login(String email, String password, String expectedResult) throws Exception {

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

		AccountPage accountPage = new AccountPage(driver);

		String actualResult = null;
		Thread.sleep(3000);

		try {
			if (accountPage.editAccountInformation().isDisplayed()) {
				log.debug("User got logged in");
				actualResult = "SuccessFull";
				System.out.println("Successfull");
			}
			

		} catch (Exception e) {
			log.debug("User didn't log in");
			actualResult = "failure";
			System.out.println("Failure");

		}
         if(actualResult.equals(expectedResult)) {
			
			log.info("Login Test got passed");
			
		}else {
			
			log.error("Login Test got failed");
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = { { "arun.selenium@gmail.com", "Second@123", "SuccessFull" },
				{ "dummy@test.com", "dummy", "failure" } };
		return data;
	}

}
