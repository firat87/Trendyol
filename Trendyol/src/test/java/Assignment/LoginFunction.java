package Assignment;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFunction extends BaseClass{
	
	 ObjectRepository obj = new ObjectRepository();
	
	
	@Test
	public void RoadtoLogin() throws InterruptedException {
		
		PageFactory.initElements(driver,obj);
		obj.close.click();
		Thread.sleep(1000);
	}
		
	@Test(dependsOnMethods= {"RoadtoLogin"})
	public void RoadtoLogin2() throws InterruptedException {
		
		PageFactory.initElements(driver,obj);
		obj.login.click();
		Thread.sleep(1000);
		
	}
	
	@Test(dataProvider="loginInfos",dependsOnMethods= {"RoadtoLogin2"})
	public void Login(String mail, String password) throws InterruptedException, IOException {
		
		PageFactory.initElements(driver,obj);
		
		try {
		obj.email.sendKeys(mail);
		Thread.sleep(1000);
		obj.password.clear();
		Thread.sleep(1000);
		obj.password.sendKeys(password);
		Thread.sleep(1000);
		obj.submit.click();
		Thread.sleep(1000);
		String description = obj.message.getText();
		System.out.println(description);
		Thread.sleep(1000);
		obj.email.clear();
		Thread.sleep(2000);
		obj.password.clear();
		Thread.sleep(2000);}
		
		
		catch (Exception e) {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/ss.png"));
			System.out.println("Login başarılı");
		}
		
	}
	
	
	@DataProvider(name="loginInfos")
	public Object[][] getData(){
		
		Object[][] data = new Object[5][2];
		data[0][0]="blackkfredo@gmail.com"; 
		data[0][1]=""; 
		data[1][0]="blackkfredo@gmail.com";
		data[1][1]="443242"; 
		data[2][0]="blackkfredogmail.com"; 
		data[2][1]="1a2b3c4d"; 
		data[3][0]=""; 
		data[3][1]="1a2b3c4d"; 
		data[4][0]="blackkfredo@gmail.com"; 
		data[4][1]="1a2b3c4d"; 
		
		return data;
	}

}
