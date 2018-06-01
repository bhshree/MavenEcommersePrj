package ecommerse.eccommers;

import org.testng.annotations.Test;

import ecommerse.eccommers.PageUI.CustomerRegistration;
import ecommerse.eccommers.basePage.BasePage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;


public class TC001_Login extends BasePage
{
	public static final Logger Log=Logger.getLogger(TC001_Login.class.getName());
	
	CustomerRegistration register;
  @BeforeClass
  @Parameters("browser")
  public void beforeClass(String browser) throws Exception 
  {
	  browserLaunch(browser, getData("ecommerceurl"));
  }
  
  @Test
  public void login()
  {
	  Log.info("============Starting TC001_Login Test===========");
	  register=new CustomerRegistration(driver);
	  register.customerRegistration();
	  Log.info("============Ending TC001_Login Test=============");
  }
  

  @AfterClass
  public void afterClass() {
  }

}
