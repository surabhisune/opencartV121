package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("**********Starting TC001_AccountRegistrationTest**********");
		try {
		HomePage hp = new HomePage(driver);
		driver.navigate().refresh();
		hp.clickMyAccount();
		logger.info("Clicked on myAccount link");
		hp.clickRegister();
		logger.info("Clicked on Register link");
		System.out.println("done");
		
		AccountRegistrationPage regpge=new AccountRegistrationPage(driver);
		logger.info("Providing Customer Details");
		regpge.setFirstName(randomString().toUpperCase());
		regpge.setLastName(randomString().toUpperCase());
		regpge.setEmail(randomString()+"@gmail.com");
		regpge.settelephone(randomnumber());
		String pwd=randomAlphaNummeric();
		regpge.setPassword(pwd);
		regpge.setConfPassword(pwd);
		regpge.setPrivacyPolicy();
		regpge.clickContinue();
		
		logger.info("validating expected message");
		String Confmsg=regpge.getConfirmationMsg();
		System.out.println(Confmsg);
		if(Confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test Failed");
			logger.debug("debug logs");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(Confmsg,"Your Account Has Been Created!");
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		
		logger.info("**********Finished TC001_AccountRegistrationTest**********");
	}
	

}
