package com.Indigo.Commercial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_172_QBC_VerifyQueueBasedChangesPage extends HelperClass {
	//172,174,175
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Commercial");
	
	@Test(dataProvider = "testData")
	public void TC_172_QBC_VerifyqueueBasedChangesPage(String Username,String Password,String Mainmenu,String Submenu,String queue,String DaysOut,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			Comm_QBC_VerifyPage();
			Comm_QBC_SelectQueue(queue);
			ClickGenerate();
			VerifyConfirmation();
			ClickOKButton();
			Reporter.SuccessReport("TC_172", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_172,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_172", "Username"),
	    			xls.getCellValue("TC_172", "Password"),
	    			xls.getCellValue("TC_172", "MainMenu"),
	    			xls.getCellValue("TC_172", "SubMenu"),
	    			xls.getCellValue("TC_172", "Queue"),
	    			xls.getCellValue("TC_172", "DaysOut"),
	    			
	    			
	    			"To verify Queue based changes page"
	    		}};
	}

}

