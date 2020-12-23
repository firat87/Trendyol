package Assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ObjectRepository {
	
	@FindBy(xpath="//a[@title='Close']")
	WebElement close;
	@FindBy(id="login-email")
	WebElement email;
	@FindBy(id="login-password-input")
	WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	@FindBy(xpath="//div[@class='login-container']//span[@id='not-logged-in-container']")
	WebElement login;
	@FindBy(xpath="//div[@id='error-box-wrapper']//span[@class='message']")
	WebElement message;
	
	

}
