package ecommerse.eccommers.PageUI;




import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ecommerse.eccommers.basePage.BasePage;





public class CustomerRegistration extends BasePage
{
	public static final Logger Log=Logger.getLogger(CustomerRegistration.class.getName());

	//customer registration properties//
	@FindBy(linkText="Sign in") public WebElement signIn;
	@FindBy( id="email_create")WebElement emailcreate;
	@FindBy(id="SubmitCreate")WebElement submit;
	@FindBy(xpath="//h1[text()='Create an account']")WebElement verifyAccountTittle;
	@FindBy(id="id_gender2") WebElement mrs;
	@FindBy(id="customer_firstname") WebElement firstname;
	@FindBy(id="customer_lastname")WebElement lastname;
	@FindBy(id="passwd")WebElement password;
	@FindBy(id="days")WebElement days;
	@FindBy(id="months")WebElement months ;
	@FindBy(id="years")WebElement years ;
	@FindBy(id="address1" )WebElement Address ;
	@FindBy(id="city")WebElement city ;
	@FindBy(id="id_state")WebElement state ;
	@FindBy(id="postcode")WebElement zipcode ;
	@FindBy(id="id_country")WebElement country ;
	@FindBy(id="phone_mobile") WebElement mobile;
	@FindBy(id="submitAccount")WebElement register;
	@FindBy(xpath="//h1[text='MY ACCOUNT']") WebElement verifyMYACCOUNT;

public CustomerRegistration(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void customerRegistration()

{
	try {
		signIn.click();
		Log.info("clicked n SignIn using with objec"+signIn.toString());
		emailcreate.sendKeys(getData("firstname")+getData("lastname")+randomNumber()+getData("domainName"));
		Log.info("Email User Name is"+emailcreate.getAttribute("value")+"Usingg with object"+emailcreate.toString());
		submit.click();
		Thread.sleep(3000);
		//elementVisible(60, verifyAccountTittle);
		//Assert.assertTrue(verifyAccountTittle.getText().equalsIgnoreCase("Create an account"));
		//assertEquals("Create an account", verifyAccountTittle.getText());
		mrs.click();
		firstname.sendKeys(getData("firstname"));
		lastname.sendKeys(getData("lastname"));
		password.sendKeys(getData("password"));
		selectOption(days, 2);
		selectOption(months, 2);
		selectOption(years, 26);
		Address.sendKeys("errgadda");
		city.sendKeys("hyderaad");
		state.sendKeys("Florida");
		zipcode.sendKeys("00000");
		country.sendKeys("unitedstates");
		mobile.sendKeys("9063254874");
		register.click();
		//Assert.assertEquals("MY ACCOUNT", verifyMYACCOUNT.getText());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
