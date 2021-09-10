package com.smoke.tests;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.smoke.Web.ApplicationFuncs;

import controllers.InitMethod;
import listeners.CustomListener;
import utils.ConfigReader;
import utils.ExcelTestDataReader;
import utils.ExtentTestManager;
@Listeners(CustomListener.class)
public class VerifySignup extends ApplicationFuncs
{	

	@Test(dataProvider="getExcelTestData",description ="Verify the Sign up")
	public void test_16619(HashMap<String, String> data,Method method) throws Exception
	{
		try {
			String description=method.getAnnotation(Test.class).description();
			ExtentTestManager.getTest().setDescription(description);
			openLoginPage();
			signUp(data.get("Email"));
			verifyHeader();
			registerNewUser(data.get("FirstName"), data.get("LastName"), data.get("Address"), data.get("Email"), data.get("Telephone"));
			selectGender(data.get("Gender"));
			selectHobbies(data.get("Hobbies"));
			selectSkills(data.get("Skills"));
			selectCountry(data.get("Country"));
			selectDOB(data.get("Year"), data.get("Month"), data.get("Date"));
			setPassword(data.get("Password"));
			uploadProfile(System.getProperty("user.dir")+data.get("ProfilePath"));
			submit();
			
			} catch (Exception e) {
				InitMethod.ErrorMsg = e.getMessage();
				Assert.fail(e.getMessage());
			}
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
