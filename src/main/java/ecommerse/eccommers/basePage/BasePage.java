package ecommerse.eccommers.basePage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{

	public static WebDriver driver;
	public static final String path="./config.properties";
	
	public static String getData(String key) throws Exception
	{
		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		Properties p=new Properties();
		p.load(fis);
		
		return p.getProperty(key);
		
	}
	
		
	public static void browserLaunch(String browser,String url)
	{
		if(browser.equalsIgnoreCase("CHROME"))
		{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver=new ChromeDriver();
		
		}
		else if(browser.equalsIgnoreCase("FIREFOX"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"//Drivers//IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
	}
	/**
	 * T
	 * @return
	 */
	public static int randomNumber()
	{
		Random r=new Random();
		int random=r.nextInt(9999);
		return 0;
		
	}
	
	
	public static void elementVisible(int Time,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static  void selectOption(WebElement element,int option)
	{
		Select sel=new Select(element);
		sel.selectByIndex(option);
	}

	}


