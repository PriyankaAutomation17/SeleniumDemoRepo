package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath="//*[@id='content']/div[2]/div[1]/div/div[2]/div[2]/button[1]/span")
	private WebElement cartButton;
	
	
	public WebElement cartButton() {
		 return cartButton;
	}
	
}
