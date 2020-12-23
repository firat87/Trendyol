package Assignment;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeClass
	@Parameters("browser")
	public void Start(String browsername) throws InterruptedException {
		
		if(browsername.equalsIgnoreCase("chrome")) {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		Dimension n = new Dimension (600,800);
		driver.manage().window().setSize(n);
		driver.get("https://www.trendyol.com/");
		driver.manage().window().setPosition(new Point(700,100));
		Thread.sleep(2000);}
		
		else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			Dimension n = new Dimension(600,800);
			driver.manage().window().setSize(n);
			driver.get("https://www.trendyol.com/");
			driver.manage().window().setPosition(new Point(100,100));
			Thread.sleep(2000);}
			
		}
}
