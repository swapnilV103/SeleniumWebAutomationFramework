package qa.tests;

import org.testng.annotations.Test;

import Base.BaseTest;
import Utils.ElementFetch;
import pageEvent.HomePageEvents;
import pageEvent.LoginPageEvents;

public class Testcase1 extends BaseTest{
	
	ElementFetch ele = new ElementFetch();
	HomePageEvents homePage = new HomePageEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	
  @Test
  public void Verify_if_Login_Works_Using_Correct_Credintials() {
	  homePage.clickSignInButton();
	  loginPage.VerifyIfLoginPageLoaded();
	  loginPage.enterCredentials();
	  
  }
}
