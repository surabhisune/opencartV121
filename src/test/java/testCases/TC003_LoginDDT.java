package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

//data is valid -login success- test pass-- logout
//data is valid -login fail- test failed
//data is invalid -login success- test failed -logout
//data is invalid -login failed- test pass

@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups={"DataDriven","Master"}) // getting dataprovider from diffrent class
public class TC003_LoginDDT extends BaseClass {
	public void verify_LoginDDT(String email, String pwd, String exp) {

		logger.info("*********Starting TC003_LoginTest************");

		try {
			HomePage hp = new HomePage(driver);
			logger.info("click on MyAccount");
			hp.clickMyAccount();
			logger.info("click on Login");
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			logger.info("enter email");
			lp.setEmail(email);
			logger.info("enter password");
			lp.setPassword(pwd);
			logger.info("clicked on login");
			lp.clickLogin();

			MyAccount ma = new MyAccount(driver);
			boolean targetPage = ma.isMyAccountPageExists();

			if (exp.equalsIgnoreCase("valid")) {
				if (targetPage == true) {
					ma.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					ma.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*********Finished TC002_LoginTest************");
	}

}
