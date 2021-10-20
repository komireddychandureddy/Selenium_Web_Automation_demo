package com.smoke.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;

public class RegistrationPage extends BaseMethod{

	private WebDriver driver;
	public RegistrationPage (){
		this.driver=getWebDriver();
		PageFactory.initElements(getWebDriver(), this);
	}
	
	@FindBy(id= "msdd")
	WebElement drp_Languages;
	@FindBy(xpath= "//a[text()='Home']")
	WebElement tab_Home;
	
	@FindBy(xpath= "//a[text()='Register']")
	WebElement tab_Register;
	@FindBy(xpath= "//input[@ng-model='FirstName']")
	WebElement txt_FirstName;
	@FindBy(xpath= "//input[@ng-model='LastName']")
	WebElement txt_LastName;
	@FindBy(xpath= "//textarea[@ng-model='Adress']")
	WebElement txt_Adress;
	@FindBy(xpath= "//input[@ng-model='EmailAdress']")
	WebElement txt_EmailAdress;
	@FindBy(xpath= "//input[@ng-model='Phone']")
	WebElement txt_Phone;
	@FindBy(xpath= "//input[@value='Male']")
	WebElement rb_Male;
	@FindBy(xpath= "//input[@value='Female']")
	WebElement rb_Female;
	@FindBy(xpath= "//input[@value='Cricket']")
	WebElement chk_Cricket;
	@FindBy(xpath= "//input[@value='Movies']")
	WebElement chk_Movies;
	@FindBy(xpath= "//input[@value='Hockey']")
	WebElement chk_Hockey;
	@FindBy(xpath= "//a[text()='Icelandic']")
	WebElement lbl_Icelandic;
	@FindBy(xpath= "//div[text()='Greek']/span")
	WebElement lbl_Greek;
	
	@FindBy(id= "Skills")
	WebElement drp_Skills;
	@FindBy(id= "countries")
	WebElement drp_Countries;
	@FindBy(id= "yearbox")
	WebElement drp_Year;
	@FindBy(xpath= "//select[@ng-model='monthbox']")
	WebElement drp_Month;
	@FindBy(id= "daybox")
	WebElement drp_Day;
	@FindBy(id= "firstpassword")
	WebElement txt_Password;
	@FindBy(id= "secondpassword")
	WebElement txt_ConfirmPassword;
	@FindBy(id= "submitbtn")
	WebElement btn_Submit;
	@FindBy(id= "Button1")
	WebElement btn_Refresh;
	@FindBy(id= "imagesrc")
	WebElement txt_Profile;
	
	public boolean registerNewUser(String firstname, String lastname, String adress, String email, String phone) {
		inputText(txt_FirstName, firstname,"Enter FirstName");
		inputText(txt_LastName, lastname,"Enter LastName");
		inputText(txt_Adress, adress,"Enter Adress");
		inputText(txt_EmailAdress, email,"Enter EmailAdress");
		inputText(txt_Phone, phone,"Enter Phone");
		
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
		selectByValue(drp_Skills, skills, "Select skills");
		/*Select skill = new Select(getWebElement(drp_Skills));
		skill.selectByValue(skills);*/
		return true;
	}
	public boolean selectCountry(String country) {
		selectByVisibleText(drp_Countries, country, "Select Country");

		return true;
	}
	public boolean selectDOB(String year, String month, String day) {
		
		selectByVisibleText(drp_Year, year, "Select year");
		selectByVisibleText(drp_Month, month, "Select month");
		selectByVisibleText(drp_Day, day, "Select day");
		
		return true;
	}
	public boolean uploadProfile(String profile_path) {
		inputText(txt_Profile, profile_path,"Upload Profile Photo");
		return true;
	}
	public boolean setPassword(String password) {
		inputText(txt_Password, password,"Enter Password");
		inputText(txt_ConfirmPassword, password,"Enter Confirm Password");
		return true;
	}
	
	public boolean submit() {
		click(btn_Submit, "Click on Submit");
		return true;
	}
	
	public boolean verifyHeader() {
		return isWebElementVisible(tab_Home, "Verify Home tab");
	}
}
