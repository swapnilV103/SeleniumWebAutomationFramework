package pageEvent;

import org.testng.Assert;

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
	
	public void clickonSignin() {
		ele.getWebElement("xpath", LoginPageElements.signin_Button).click();
		
	}

}
