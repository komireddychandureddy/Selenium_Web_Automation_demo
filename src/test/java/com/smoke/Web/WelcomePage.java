package com.smoke.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;

public class WelcomePage extends BaseMethod{

	
	
	public WelcomePage (){
		PageFactory.initElements( getWebDriver(), this);
	}
	
	@FindBy(id= "email")
	 WebElement txt_email;
	@FindBy(id= "enterimg")
	WebElement img_enter;
	@FindBy(id= "btn1")
	WebElement btn_signin;
	@FindBy(id= "btn2")
	WebElement btn_skipsignIn;
	@FindBy(id= "logo")
	WebElement img_logo;
	
	public boolean signUp(String email) {
		inputText(txt_email, email,"Enter Email");
		click(img_enter, "Click on enter icon");
		return true;
	}
	public boolean signIn() {
		click(btn_signin, "Click on Sign on button");
		return true;
	}
	
}
