package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement linkMyaccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement linkRegister;

	@FindBy(linkText = "Login")
	WebElement linkLogin;

	public void clickMyAccount() {
		linkMyaccount.click();

		// Actions act = new Actions(driver);
		// act.moveToElement(linkMyaccount).click().perform();

		// JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("argument[0].click();", linkMyaccount);
	}

	public void clickRegister() {
		linkRegister.click();

		// Actions act = new Actions(driver);
		// act.moveToElement(linkRegister).click().perform();

		// JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("argument[0].click();", linkRegister);
	}

	public void clickLogin() {
		linkLogin.click();

	}
}
