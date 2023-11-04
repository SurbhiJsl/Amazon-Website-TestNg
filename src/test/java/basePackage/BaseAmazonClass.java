package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

public class BaseAmazonClass {

	public static Properties prop= new Properties();
	public static WebDriver driver;
	
	 public BaseAmazonClass()
	 {
		 try {
		 FileInputStream file= new FileInputStream("C:\\Surbhi-QA Course\\Eclipse_WorkSpace\\AmazonWebsite\\src\\test\\java\\environmentvariables\\Config.properties" );
	     prop.load(file);
		 
		 }
		 catch(FileNotFoundException e){
			e.printStackTrace(); 
		 }
		 catch(IOException a) {
			 a.printStackTrace();
		 }
	 }
		 public static void initiation()
		 {
		String browsername=	 prop.getProperty("browser");
		if(browsername.equals("Firefox")) {
			System.setProperty("Webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}
			else if(browsername.equals("Chrome")) {
				System.setProperty("Webdriver.chrome.driver", "chrome.exe");
				driver=new ChromeDriver();
			}
		
		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeUtils.timepage));
		 driver.get(prop.getProperty("url"));
		 
		 }
	 
	
	
}
