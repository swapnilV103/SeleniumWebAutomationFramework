Feature: Login Functionality for the open CRM website

I want to able to login into the open CRM website
with the correct credentials

Background: I am on the login page on opem CRM


Scenario: Successfull login with valid credentials
	Given I have Entered a valid username and password
	When  I Click on the login button
	Then I should be logged in Successfully


Scenario: Unsuccessfull login with Invalid credentials
	Given I have Entered Invalid <"username"> and <"password">
	When  I Click on the login button
	Then I should see and error message <"error_message">


Examples: 
      | username  | password | error_message           |
      | swapn     | new12    | Something went wrong... |
      | vidha     | jpag1    | Something went wrong... |

 Scenario: Nevigating to forgotten password page
 	When I click on forgotten password link
 	Then I should be redirected to password reset page
 	
 
 
 
 
 
 