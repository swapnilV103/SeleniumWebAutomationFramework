package pageEvent;

import Utils.ElementFetch;
import pageObject.HomePageElements;

public class HomePageEvents {
	
	ElementFetch ele = new ElementFetch();
	
	public void clickSignInButton(){
		
		ele.getWebElement("xpath", HomePageElements.SignInButton).click();
		
	}
	
	

}
