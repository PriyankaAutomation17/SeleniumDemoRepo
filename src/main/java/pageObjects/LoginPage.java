package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-email")
	private WebElement emailAddress;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	public WebElement emailAddress() {
		 return emailAddress;
	}
	
	public WebElement password() {
		 return password;
	}
	
	public WebElement loginButton() {
		 return loginButton;
	}
	
}
