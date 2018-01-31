package com.Indigo.Commercial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;
//covers 133,134
public class TC_133_BM_VerifyUserToNavigateBroadCast extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Commercial");
	
	@Test(dataProvider = "testData")
	public void TC_133_VerifyUserToNavigationBroadCast(String Username,String Password,String Mainmenu,String Submenu,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			CommBM_VerifyBroadcastPage();
			Reporter.SuccessReport("TC_133", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_133,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_133", "Username"),
	    			xls.getCellValue("TC_133", "Password"),
	    			xls.getCellValue("TC_133", "MainMenu"),
	    			xls.getCellValue("TC_133", "SubMenu"),
	    			
	    		
	    			
	    			"To verify PAX Adhoc in Commercial Module"
	    		}};
	}

}

