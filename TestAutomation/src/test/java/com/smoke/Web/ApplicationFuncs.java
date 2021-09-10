package com.smoke.Web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import utils.ConfigReader;

public class ApplicationFuncs extends ObjectOR{
	LoginPage login = new LoginPage();
	Common common=new Common();
	WelcomePage welcome= new WelcomePage();
	RegistrationPage registration = new RegistrationPage();
	
	public void openLoginPage() {
		navigateToUrl(ConfigReader.getValue("BASE_URL"));
	}

	public boolean isLoginPageOpened() {
		return getWebDriver().
				getCurrentUrl().
				equalsIgnoreCase(ConfigReader.getValue("BASE_URL"));
	}

	public boolean signUp(String email) {
		inputText(welcome.txt_email, email,"Enter Email");
		click(welcome.img_enter, "Click on enter icon");
		return true;
	}
	public boolean login(String email, String password) {
		click(welcome.btn_signin, "Click on Sign on button");
		inputText(login.txt_Email, email,"Enter Email");
		inputText(login.txt_Password, password,"Enter Password");
		click(login.btn_Enter, "Click on enter");
		return true;
	}
	public boolean registerNewUser(String firstname, String lastname, String adress, String email, String phone) {
		inputText(registration.txt_FirstName, firstname,"Enter FirstName");
		inputText(registration.txt_LastName, lastname,"Enter LastName");
		inputText(registration.txt_Adress, adress,"Enter Adress");
		inputText(registration.txt_EmailAdress, email,"Enter EmailAdress");
		inputText(registration.txt_Phone, phone,"Enter Phone");
		
		return true;
	}
	public boolean selectGender(String gender) {
		By genderElement = By.xpath("//input[@value='"+gender+"']");
		click(genderElement, "Click on "+gender);
		return true;
	}
	public boolean selectHobbies(String hobbies) {
		
		String[] allhobbies= hobbies.split(",");
		for (String hobby :allhobbies){
			By hobbyElement = By.xpath("//input[@value='"+hobby+"']");
			click(hobbyElement, "Click on "+hobby);				
		}
		return true;
	}

	public boolean selectSkills(String skills) {
		selectByValue(registration.drp_Skills, skills, "Select skills");
		/*Select skill = new Select(getWebElement(registration.drp_Skills));
		skill.selectByValue(skills);*/
		return true;
	}
	public boolean selectCountry(String country) {
		selectByVisibleText(registration.drp_Countries, country, "Select Country");
		/*Select Countries = new Select(getWebElement(registration.drp_Countries));
		Countries.selectByVisibleText(country);*/
		return true;
	}
	public boolean selectDOB(String year, String month, String day) {
		
		selectByVisibleText(registration.drp_Year, year, "Select year");
		selectByVisibleText(registration.drp_Month, month, "Select month");
		selectByVisibleText(registration.drp_Day, day, "Select day");
		
		/*new Select(getWebElement(registration.drp_Year)).selectByVisibleText(year);
		new Select(getWebElement(registration.drp_Month)).selectByVisibleText(month);
		new Select(getWebElement(registration.drp_Day)).selectByVisibleText(day);*/
		return true;
	}
	public boolean uploadProfile(String profile_path) {
		inputText(registration.txt_Profile, profile_path,"Upload Profile Photo");
		return true;
	}
	public boolean setPassword(String password) {
		inputText(registration.txt_Password, password,"Enter Password");
		inputText(registration.txt_ConfirmPassword, password,"Enter Confirm Password");
		return true;
	}
	
	public boolean submit() {
		click(registration.btn_Submit, "Click on Submit");
		return true;
	}
	
	public boolean verifyHeader() {
		isWebElementVisible(registration.tab_Home, "Verify Home tab");
		return true;
	}
}
