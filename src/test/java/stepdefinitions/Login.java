package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class Login extends Base {
	
	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;

    @Given("^Open any Browser$")
    public void openAnyBrowser() throws Exception {
    	driver=initializeBrowser();
    	
    }

    @And("^Navigate to Login page$")
    public void navigateToLoginPage() throws Exception {
    	driver.get(prop.getProperty("url"));
    	landingPage = new LandingPage(driver);
		landingPage.myAccountDropDown().click();
		landingPage.loginOption().click();
		Thread.sleep(3000);
    }

    @When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
    public void enterUsernameAndPassword(String email, String password) throws Exception {
    	loginPage = new LoginPage(driver);
		loginPage.emailAddress().sendKeys(email);
		Thread.sleep(3000);
		loginPage.password().sendKeys(password);
		Thread.sleep(3000);
    }

    @And("^User clicks on Login button$")
    public void clickLoginButton() {
    	loginPage.loginButton().click();
    }

    @Then("^Verify user is able to successfully login$")
    public void verifyLoginSuccess() {
    	accountPage = new AccountPage(driver);
    	Assert.assertTrue(accountPage.editAccountInformation().isDisplayed());
       
       
    }

//    @After("^Close the Browser$")
//    public void closeBrowser() {
//        driver.quit();
//    }

}
