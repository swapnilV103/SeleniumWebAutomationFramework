package pageObject;

public interface LoginPageElements {
	
	String loginpagetext = "//div[@class='ui fluid large blue submit button']";
	String emailAddereddField = "//input[@placeholder='Email']";
	String passwordField = "//input[@placeholder='Password']";
	
	String signin_Button = "(//div[.='Login'])[2]";
	
	String forgot_passwordLink = "//a[.='Forgot your password?']";
	
	String Setting_button_link = "//div[@role='listbox' ]";
	
	String Invalid_login_error_message_text = "//div[.='Something went wrong...']";
	
	
	

}
