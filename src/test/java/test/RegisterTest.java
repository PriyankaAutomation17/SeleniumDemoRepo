package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.RegisterPage;
import pageObjects.SuccessPage;
import resources.Base;

public class RegisterTest extends Base{
	
	public WebDriver driver;
	Logger log;
	
	@BeforeTest
	public void LaunchBrowser() throws Exception {
		log = LogManager.getLogger(RegisterTest.class.getName());
		
		driver = initializeBrowser();
		log.debug("Browser is launched");
		
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");

	}

	@Test
	public void register() throws Exception {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropDown().click();
		log.debug("Clicked on My Account dropdown");
		
		landingPage.registerOption().click();
		log.debug("Clicked on Register option");
		
		RegisterPage registerPage=new RegisterPage(driver);
		registerPage.firstName().sendKeys("Kumari");
		log.debug("Entered First Name");
		Thread.sleep(3000);
		
		registerPage.lastName().sendKeys("Priyanka");
		log.debug("Entered Last Name");
		Thread.sleep(3000);
		
		registerPage.Email().sendKeys("priyanka12@gmail.com");
		log.debug("Entered email");
		Thread.sleep(3000);
		
		registerPage.telephone().sendKeys("123456789");
		log.debug("Entered telephone number");
		Thread.sleep(3000);
		
		registerPage.password().sendKeys("priyanka17");
		log.debug("Entered password");
		Thread.sleep(3000);
		
		registerPage.confirmPassword().sendKeys("priyanka17");
		log.debug("Entered confirm password");
		Thread.sleep(3000);
		
		registerPage.agreePolicy().click();
		log.debug("Clicked on Agree policy");
		
		Thread.sleep(3000);
		
		registerPage.continueButton().click();
		log.debug("Clicked on continue button");
		Thread.sleep(4000);
		
		SuccessPage successPage=new SuccessPage(driver);
		
		String msg=successPage.successMsg().getText();
		
		String successMsg="Your Account Has Been Created!";
		
		if(msg.equalsIgnoreCase(successMsg)) {
			System.out.println("Registeration is completed");
			Assert.assertTrue(true);
			Thread.sleep(2000);
		}
		
		else
			System.out.println("Registeration failed");
		Assert.assertTrue(false);
		Thread.sleep(2000);
		
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
