package pageEvent;

import org.testng.Assert;

import Utils.ElementFetch;
import pageObject.LoginPageElements;

public class LoginPageEvents {
	
	ElementFetch ele = new ElementFetch();
	
	public void VerifyIfLoginPageLoaded() {
		Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.loginpagetext).size()>0, "Element Not Found");
	}
	
	public void enterCredentials() {
		ele.getWebElement("XPATH", LoginPageElements.emailAddereddField).sendKeys("rmishra@gmail.com");
		ele.getWebElement("XPATH", LoginPageElements.passwordField).sendKeys("12345");
		
	}
	
	

}
