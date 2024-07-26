package stepdefs;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageEvent.HomePageEvents;
import pageEvent.LoginPageEvents;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import Base.BaseTest;



public class LoginPageStepDefs {
	
	private WebDriver driver;
	private LoginPageEvents loginPage = new LoginPageEvents();
	private HomePageEvents homePage = new HomePageEvents();
	
	private BaseTest basetest;
	
	@Before
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("https://freecrm.com/");
	}
	
	@After
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	
	
	@Given(value = "I am on the login page on opem CRM")
	public void IamontheloginpageonopemCRM() {
		homePage.clickSignInButton();
	}
	
	@Given(value = "I have Entered a valid username and password")
	public void I_have_Entered_a_valid_username_and_password() {
		loginPage.enterCredentials();
	}
	
	@Given(value="I have Entered Invalid {string} and {string}")
	public void I_have_Entered_Invalid_user_pwd(String username, String password) {
		loginPage.enterInvalidCredentials(username, password);
	}
	
	
	@When(value = "I Click on the login button")
	public void I_Click_on_the_login_button() {
		loginPage.clickonSignin();
		
	}
	
	@Then(value = "I should be logged in Successfully")
	public void I_should_be_logged_in_Successfully() {
		Assert.assertEquals(loginPage.checklogoutLink() , true);
	}
	
	
	@Then(value = "I should see and error message {error_message}")
	public void I_should_see_and_error_message() {
		Assert.assertEquals(loginPage.isErrormessagedisplayed(), true);
	}
	
	@When(value = "I click on forgotten password link")
	public void I_click_on_forgotten_password_link() {
		loginPage.clickonforgotPassword();
	}
	
	@Then(value = "I should be redirected to password reset page")
	public void I_should_be_redirected_to_password_reset_page(){
		loginPage.getforgotPwdPageUrl();
	}
	
	
}
