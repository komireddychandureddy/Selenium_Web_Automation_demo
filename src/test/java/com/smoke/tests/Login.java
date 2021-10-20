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
import com.smoke.Web.LoginPage;
import com.smoke.Web.RegistrationPage;
import com.smoke.Web.WelcomePage;

import controllers.InitMethod;
import listeners.CustomListener;
import utils.ConfigReader;
import utils.ExcelTestDataReader;
import utils.ExtentTestManager;
@Listeners(CustomListener.class)
public class Login extends ApplicationFuncs
{	

	@Test(dataProvider="getExcelTestData",description ="Verify the Sign up with Student")
	public void test_29507(HashMap<String, String> data,Method method) throws Exception
	{
		WelcomePage welcome =new WelcomePage();
		welcome.signIn();
		LoginPage login =new LoginPage();
		login.login(data.get("Email"),data.get("Password"));
		RegistrationPage reg =new RegistrationPage();
		Assert.assertTrue(reg.verifyHeader(), "Home page is not visiable");
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
