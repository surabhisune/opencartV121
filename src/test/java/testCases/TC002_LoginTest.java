package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void Verify_login() {

		logger.info("*********Starting TC002_LoginTest************");
		try {
			HomePage hp = new HomePage(driver);
			logger.info("click on MyAccount");
			hp.clickMyAccount();
			logger.info("click on Login");
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			logger.info("enter email");
			lp.setEmail(p.getProperty("email"));
			logger.info("enter password");
			lp.setPassword(p.getProperty("password"));
			logger.info("clicked on login");
			lp.clickLogin();

			MyAccount ma = new MyAccount(driver);
			boolean targetPage = ma.isMyAccountPageExists();
			// Assert.assertEquals(targetPage,true,"Login Failed");
			Assert.assertTrue(targetPage);
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*********Finished TC002_LoginTest************");

	}
}
