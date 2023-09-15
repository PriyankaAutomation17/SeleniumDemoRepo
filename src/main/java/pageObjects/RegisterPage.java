package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
		
		WebDriver driver;
		
		public RegisterPage(WebDriver driver) {
			
			this.driver=driver;
			
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(name="firstname")
		private WebElement firstName;
		
		@FindBy(name="lastname")
		private WebElement lastName;
		
		@FindBy(name="email")
		private WebElement Email;
		
		@FindBy(name="telephone")
		private WebElement telephone;
		
		@FindBy(name="password")
		private WebElement password;
		
		@FindBy(name="confirm")
		private WebElement confirmPassword;
		
		@FindBy(name="agree")
		private WebElement agreePolicy;
		
		@FindBy(xpath="//*[@id='content']/form/div/div/input[2]")
		private WebElement continueButton;
		
		public WebElement firstName() {
			 return firstName;
			 }

		public WebElement lastName() {
			 return lastName;
			 }
		
		
		public WebElement Email() {
			 return Email;
			 }
		
		public WebElement telephone() {
			 return telephone;
			 }
		
		public WebElement password() {
			 return password;
			 }
		
		public WebElement confirmPassword() {
			 return confirmPassword;
			 }
		public WebElement agreePolicy() {
			 return agreePolicy;
			 }
		public WebElement continueButton() {
			 return continueButton;
			 }
		
}
