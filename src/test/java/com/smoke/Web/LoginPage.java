package com.smoke.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;

public class LoginPage extends BaseMethod{

	public LoginPage (){
		PageFactory.initElements(getWebDriver(), this);
	}
	
	@FindBy(id= "enterbtn")
	WebElement btn_Enter;
	
	@FindBy(xpath= "//input[@ng-model='Email']")
	WebElement txt_Email;
	
	@FindBy(xpath= "//input[@ng-model='Password']")
	WebElement txt_Password;

	
	public boolean login(String email, String password) {
		inputText(txt_Email, email,"Enter Email");
		inputText(txt_Password, password,"Enter Password");
		click(btn_Enter, "Click on enter");
		return true;
	}
}
