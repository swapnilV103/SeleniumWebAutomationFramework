package pageEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import Base.BaseTest;
import Utils.ElementFetch;
import pageObject.LoginPageElements;

public class LoginPageEvents {
	
	ElementFetch ele = new ElementFetch();
	
	

	

	public void VerifyIfLoginPageLoaded() {
		Assert.assertTrue(ele.getWebElements("xpath", LoginPageElements.loginpagetext).size()>0, "Element Not Found");
	}
	
	public void enterCredentials() {
		ele.getWebElement("xpath", LoginPageElements.emailAddereddField).sendKeys("swapnilidawate103@gmail.com");
		ele.getWebElement("xpath", LoginPageElements.passwordField).sendKeys("Swapnil101@");
		
	}
	
	public void enterInvalidCredentials(String username, String password) {
		ele.getWebElement("xpath", LoginPageElements.emailAddereddField).sendKeys(username);
		ele.getWebElement("xpath", LoginPageElements.passwordField).sendKeys(password);
		
	}
	
	public void clickonSignin() {
		ele.getWebElement("xpath", LoginPageElements.signin_Button).click();
		
	}
	
	public void clickonforgotPassword() {
		ele.getWebElement("xpath", LoginPageElements.forgot_passwordLink).click();
		
		
	}
	
	public boolean checkforgotPwdLink() {
		return ele.getWebElement("xpath", LoginPageElements.forgot_passwordLink).isDisplayed();
	}
	
	public boolean checklogoutLink() {
		return ele.getWebElement("xpath", LoginPageElements.Setting_button_link).isDisplayed();
	}
	
	public boolean isErrormessagedisplayed() {
		return ele.getWebElement("xpath", LoginPageElements.Invalid_login_error_message_text).isDisplayed();
	}
	
	/*public String getforgotPwdPageUrl() {
		LoginPageEvents.this.clickonforgotPassword();
		String url = BaseTest.driver.getCurrentUrl();
		return url;
		
	}*/
	
	public String getforgotPwdPageUrl() {
		LoginPageEvents.this.clickonforgotPassword();
		String url = BaseTest.getDriver().getCurrentUrl();
		return url;
		
	}

}
