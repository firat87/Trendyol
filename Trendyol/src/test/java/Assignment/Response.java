package Assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.CSVWriter;

import io.restassured.RestAssured;


public class Response {
	
	public String[] data;
	 //CSVWriter writeto;
	
	@Test
	public void ResponseTime() throws IOException {
		
		CSVWriter writer = new CSVWriter(new FileWriter("./CSV/outputresponse.csv"));
    	String[] header = { "ResponseTime", "ResponseCode" };
    	writer.writeNext(header);
    	
		String s=null;  int x=1; String rsptime=null;   
		
	while(x!=39) {
			s=String.valueOf(x);
			long rsp = RestAssured.given().queryParam("page",s).when().get("https://www.trendyol.com/api/homepage/components")
			          .getTime();
			rsptime=String.valueOf(rsp);
			String rspcode=RestAssured.given().queryParam("page",s).when().get("https://www.trendyol.com/api/homepage/components")
				           .getStatusLine();
			System.out.println(rsp);
			System.out.println(rspcode);
			
			data = new String[] { rsptime, rspcode };
			writer.writeNext(data);
			x++;
		}
	writer.close();
		
	}

}
