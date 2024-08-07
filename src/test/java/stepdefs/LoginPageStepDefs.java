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



public class LoginPageStepDefs extends BaseTest{
	
	
	
	@Given(value = "I am on the login page on opem CRM")
	public void IamontheloginpageonopemCRM() {
		System.out.println("I am on the login page on opem CRM");	}
	
	@Given(value = "I have Entered a valid username and password")
	public void I_have_Entered_a_valid_username_and_password() {
		System.out.println("I am on the login page on opem CRM");	
	}
	
	@Given(value="I have Entered Invalid <{string}> and <{string}>")
	public void I_have_Entered_Invalid_and(String username, String password) {
		System.out.println("I am on the login page on opem CRM");	
	}
	
	
	@When(value = "I Click on the login button")
	public void I_Click_on_the_login_button() {
		System.out.println("I am on the login page on opem CRM");	
		
	}
	
	@Then(value = "I should be logged in Successfully")
	public void I_should_be_logged_in_Successfully() {
		System.out.println("I am on the login page on opem CRM");	
	}
	
	
	@Then(value = "I should see and error message <{string}>")
	public void I_should_see_and_error_message(String string) {
		System.out.println("I am on the login page on opem CRM");	
	}
	
	@When(value = "I click on forgotten password link")
	public void I_click_on_forgotten_password_link() {
		System.out.println("I am on the login page on opem CRM");	
	}
	
	@Then(value = "I should be redirected to password reset page")
	public void I_should_be_redirected_to_password_reset_page(){
		System.out.println("I am on the login page on opem CRM");	
	}
	
	
}
