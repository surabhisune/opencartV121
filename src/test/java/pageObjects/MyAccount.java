package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {

	public MyAccount(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath = "//*[@id=\"column-right\"]/div/a[13]")
	WebElement lnkLogout;
	
	

	public boolean isMyAccountPageExists() {
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		lnkLogout.click();;
	}
}
