package utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//handle screenshots,alerts,windows,frames,sync issues,
	
	public static void captureScreenshot(WebDriver driver) {
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//
	try {
		//FileHandler.copy(src,new File("./Screenshots/Login.png"))	;
		FileHandler.copy(src,new File("./Screenshots/"+ getCurrentDateTime()+ ".png"))	;
		System.out.println("captured");
	} 
	catch (IOException e) {
		System.out.println("unable to capture scrrenshot"+e.getMessage());
	}
		
	}
	public static String getCurrentDateTime() {
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);
		
	}
	public void handleFrames() {
		
	}
	public void handleAlerts() {
		
	}

}
