package com.smoke.Web;
import org.openqa.selenium.By;

import controllers.BaseMethod;


public class ObjectOR extends BaseMethod {
	
	class WelcomePage{
		
		public By txt_email =By.id("email");
		public By img_enter =By.id("enterimg");
		public By btn_signin =By.id("btn1");
		public By btn_skipsignIn =By.id("btn2");
		public By img_logo =By.id("logo");
			
	}
	class LoginPage{
		
		
		public By txt_Email =By.xpath("//input[@ng-model='Email']");
		public By txt_Password =By.xpath("//input[@ng-model='Password']");
		public By btn_Enter =By.id("enterbtn");
				
	}
	
	class RegistrationPage{
		public By tab_Home =By.xpath("//a[text()='Home']");
		public By tab_Register =By.xpath("//a[text()='Register']");		
		public By txt_FirstName =By.xpath("//input[@ng-model='FirstName']");		
		public By txt_LastName =By.xpath("//input[@ng-model='LastName']");		
		public By txt_Adress =By.xpath("//textarea[@ng-model='Adress']");		
		public By txt_EmailAdress =By.xpath("//input[@ng-model='EmailAdress']");		
		public By txt_Phone =By.xpath("//input[@ng-model='Phone']");		
		public By rb_Male =By.xpath("//input[@value='Male']");		
		public By rb_Female =By.xpath("//input[@value='Female']");		
		public By chk_Cricket =By.xpath("//input[@value='Cricket']");		
		public By chk_Movies =By.xpath("//input[@value='Movies']");		
		public By chk_Hockey =By.xpath("//input[@value='Hockey']");		
		public By drp_Languages =By.id("msdd");		
		public By lbl_Icelandic =By.xpath("//a[text()='Icelandic']");		
		public By lbl_Greek =By.xpath("//div[text()='Greek']/span");		
		public By drp_Skills =By.id("Skills");		
		public By drp_Countries =By.id("countries");		
		public By drp_Year =By.id("yearbox");		
		public By drp_Month =By.xpath("//select[@ng-model='monthbox']");		
		public By drp_Day =By.id("daybox");		
		public By txt_Password =By.id("firstpassword");		
		public By txt_ConfirmPassword =By.id("secondpassword");		
		public By btn_Submit =By.id("submitbtn");		
		public By btn_Refresh =By.id("Button1");		
		public By txt_Profile =By.id("imagesrc");		
		
	}
	
	class Common{
		public By btn_Done =By.xpath("//button[text()='Done']");
		
	}
	
	
    
}

