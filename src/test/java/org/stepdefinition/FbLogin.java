package org.stepdefinition;

import java.util.List;
import java.util.Map;

import javax.swing.undo.CannotRedoException;
import io.cucumber.datatable.*;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.std.MapDeserializer;

import org.base.BaseClass;
import org.pojo.Fbloginpojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FbLogin extends BaseClass{
	
	Fbloginpojo s;
	
	@Given("To launch the browser and maximise the window")
	public void to_launch_the_browser_and_maximise_the_window() {
	   lanuchBrowser();
	   windowMaximize();
	}

	@When("To launch url of fb apppliction")
	public void to_launch_url_of_fb_apppliction() {
		launchurl("https://www.facebook.com/");
	   
	}

	@When("To click the create new account button")
	public void to_click_the_create_new_account_button() {
		s= new Fbloginpojo();
		clickBtn(s.getCreatenewacc());
	    
	}

	@When("To pass Firstname in Firstname text box")
	public void to_pass_Firstname_in_Firstname_text_box(DataTable d) throws InterruptedException {
		Thread.sleep(3000);
		Map<Object, Object> m = d.asMap(String.class, String.class);
		s= new Fbloginpojo();
	//passText (m.get("firstname3")) , s.getFirstname());
	 
	}

	@When("To pass secoundname in secoundname text box")
	public void to_pass_secoundname_in_secoundname_text_box() {
		s= new Fbloginpojo();
		passText("anbu", s.getSecounname());
	   
	}

	@When("To pass mobileno  or email in email text box")
	public void to_pass_mobileno_or_email_in_email_text_box(DataTable d) {
		List<List<String>> l = d.asLists();
		s= new Fbloginpojo();
		passText(l.get(1).get(3), s.getMobileemailtextbox());
	  
	}

	@When("To create new password using new password text box")
	public void to_create_new_password_using_new_password_text_box() {
		s= new Fbloginpojo();
		passText("sivasiva", s.getNewpaasword());
	  
	}

	@Then("To close the chrome browser")
	public void to_close_the_chrome_browser() {
	  // closeEntireBrowser();
	}





}
