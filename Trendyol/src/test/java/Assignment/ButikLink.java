package Assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVWriter;

import groovyjarjarasm.asm.util.Printer;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ButikLink extends BaseClass{
	
	//LoginFunction login = new LoginFunction();
	ObjectRepository repo = new ObjectRepository();
	public String[] str;
	
	
	
	@Test
	public void CloseWindow() throws InterruptedException {
		
		PageFactory.initElements(driver,repo);
		repo.close.click();
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods= {"CloseWindow"})
	public void ScrollDown() throws InterruptedException {
		
		Thread.sleep(3000);
		int count = 20;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		//js.executeScript("window.scrollTo(0,5000)");	
		while(count!=0) {
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");	
			count--;}
		
		}
	
	
	@Test(dependsOnMethods= {"ScrollDown"})
	public void CapturetheLinks() throws InterruptedException, IOException {
		
		RequestSpecification httpRequest = RestAssured.given();  
		CSVWriter writer = new CSVWriter(new FileWriter("./CSV/butiklinksoutput.csv"));
    	String[] header = { "Links","ResponseCode"};
    	writer.writeNext(header);
		List<WebElement> mylist = driver.findElements(By.xpath("//article[@class='component-item']//a"));
		System.out.println(mylist.size());
		
		for(int i=0; i<mylist.size(); i++) {
			
			System.out.println(mylist.get(i).getAttribute("href"));
			Response rsp = httpRequest.get(mylist.get(i).getAttribute("href"));	
			str = new String[] {mylist.get(i).getAttribute("href").toString(),rsp.statusLine()};
			writer.writeNext(str);
		}
	}

	
}

