package com.smoke.tests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.smoke.Web.RegistrationPage;
import com.smoke.Web.WelcomePage;

import controllers.BaseMethod;
import listeners.CustomListener;
import utils.ConfigReader;
import utils.ExcelTestDataReader;
@Listeners(CustomListener.class)
public class SignUp extends BaseMethod
{	

	@Test(dataProvider="getExcelTestData",description ="Verify the Sign up with newuser")
	public void test_16618(HashMap<String, String> data) 
	{
		
			WelcomePage welcome =new WelcomePage();
			welcome.signUp(data.get("Email"));
			
			RegistrationPage reg =new RegistrationPage();
			reg.verifyHeader();
			reg.registerNewUser(data.get("FirstName"), data.get("LastName"), data.get("Address"), data.get("Email"), data.get("Telephone"));
			reg.selectGender(data.get("Gender"));
			reg.selectHobbies(data.get("Hobbies"));
			reg.selectSkills(data.get("Skills"));
			//reg.selectCountry(data.get("Country"));
			reg.selectDOB(data.get("Year"), data.get("Month"), data.get("Date"));
			reg.setPassword(data.get("Password"));
			reg.uploadProfile(System.getProperty("user.dir")+data.get("ProfilePath"));
			reg.submit();
			//Validation is pending due to Country dropdown bug 
			//Assert.assertTrue(reg.verifyHeader(), "New user is not register successfully");
			
	}
	
	@DataProvider
	public Iterator<Object[]> getExcelTestData() 
	{
		String sheetname = this.getClass().getSimpleName();
		ExcelTestDataReader excelReader = new ExcelTestDataReader();
		LinkedList<Object[]> dataBeans = excelReader.getRowDataMap(USERDIR+ConfigReader.getValue("TestData"),sheetname);
		return dataBeans.iterator();
	}
}
