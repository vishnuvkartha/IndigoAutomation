package com.Indigo.Commercial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_178_QBC_VerifyIfCheckBoxesForEmailSMSIVRInSearch extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Commercial");
	//178
	@Test(dataProvider = "testData")
	public void TC_178_VerifyIfCheckBoxesForEmailSMSIVRInSearch(String Username,String Password,String Mainmenu,String Submenu,String queue,String DaysOut,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			Comm_QBC_SelectQueue(queue);
			Comm_QBC_SelectDaysOut(DaysOut);
			ClickGenerate();
			Comm_QBC_VerifyCheckBoxes();
			Reporter.SuccessReport("TC_178", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_178,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_178", "Username"),
	    			xls.getCellValue("TC_178", "Password"),
	    			xls.getCellValue("TC_178", "MainMenu"),
	    			xls.getCellValue("TC_178", "SubMenu"),
	    			xls.getCellValue("TC_178", "Queue"),
	    			xls.getCellValue("TC_178", "DaysOut"),
	    			
	    			
	    			"To verify PAX Adhoc in Commercial Module"
	    		}};
	}

}

