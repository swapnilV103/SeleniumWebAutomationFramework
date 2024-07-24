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
		ele.getWebElement("xpath", LoginPageElements.emailAddereddField).sendKeys("rmishra@gmail.com");
		ele.getWebElement("xpath", LoginPageElements.passwordField).sendKeys("12345");
		
	}
	
	

}
