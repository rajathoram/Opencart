package pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//input[@name='firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath = "//input[@name='lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath = "//input[@name='email']")
    WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement msgConfrmation;
	
	public void setFirstname(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickPrivacyPolicy() {
//		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		mywait.until(ExpectedConditions.elementToBeClickable(chkPolicy));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(chkPolicy)); 
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
//		chkPolicy.click();
	
	}
	
	public void clickContinue() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnContinue)); 
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		
//		btnContinue.click();
	}
	
	public String getConfirmationMsg()
	{
		return msgConfrmation.getText();
	}
}
