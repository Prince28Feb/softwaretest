package org.stepdefinition;

import org.Base.Baseclass;
import org.pojo.FbLoginPojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FbLogin extends Baseclass {

	FbLoginPojo f;

	@Given("To launch the chrome browser and maximaize window")
	public void to_launch_the_chrome_browser_and_maximaize_window() {
		launchBrowser();
		windowMaximize();
	}

	@When("To launch the url of facebook application")
	public void to_launch_the_url_of_facebook_application() {
		launchUrl("https://www.facebook.com/");
	}

	@When("To pass valid username in email field")
	public void to_pass_valid_username_in_email_field() {
		f = new FbLoginPojo();
		passText("Selenium", f.getEmail());

	}

	@When("To pass invalid password in password field")
	public void to_pass_invalid_password_in_password_field() {
		f = new FbLoginPojo();
		passText("sfzdsdsa", f.getPassword());
	}

	@When("To click the login button")
	public void to_click_the_login_button() {
		f = new FbLoginPojo();
		ClickBtn(f.getLoginBtn());
	}

	@When("To check whether navigate to the home page or not")
	public void to_check_whether_navigate_to_the_home_page_or_not() {
		System.out.println("To check your login credentials");
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
		CloseEntireBrowser();
	}

}
