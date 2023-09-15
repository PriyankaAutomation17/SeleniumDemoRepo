package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccountDropDown;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	private WebElement loginOption;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	private WebElement registerOption;
	
	@FindBy(xpath="//a[normalize-space()='Phones & PDAs']")
	private WebElement phonesOption;
	
	
	public WebElement myAccountDropDown() {
		 return myAccountDropDown;
	}
	
	
	public WebElement loginOption() {
		 return loginOption;
	}
	
	public WebElement registerOption() {
		 return registerOption;
	}
	
	public WebElement phonesOption() {
		 return phonesOption;
	}

}
