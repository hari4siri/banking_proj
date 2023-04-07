package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	
	public static WebDriver driver;
	Properties prop;
	protected Logger log;
	@BeforeTest
	public void setup() throws IOException {
		prop=new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\utilities\\config.properties");
		prop.load(fis);
		String browser=prop.getProperty("browser");
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			//temporary set up coz they have issues with thier latest browser
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(ops);
		}
		else if(browser.equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		log=Logger.getLogger("my log");
		PropertyConfigurator.configure("C:\\Users\\Thanuja\\eclipse-workspace\\prasanna-maven\\log4j.properties");
		log.info("opening url");
		driver.get(prop.getProperty("url"));
		log.info("maxise window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
