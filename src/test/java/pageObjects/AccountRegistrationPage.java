package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txttelephone;
		
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkpolicy;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement btnContinue;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	public void settelephone(String ph) {
		txttelephone.sendKeys(ph);
	}
	
	
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	public void setConfPassword(String pwd) {
		txtConfpassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy() {
		chkpolicy.click();
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", chkpolicy);
	}
	public void clickContinue() {
		btnContinue.click();
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", btnContinue);
	}
	
	public String getConfirmationMsg() {
		try {
			return(msgConfirmation.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
		
	
	
	
	
	
	
	
	
	

}
