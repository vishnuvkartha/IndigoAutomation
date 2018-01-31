package com.Indigo.Commercial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_152_QA_VerifyQueueApproval extends HelperClass {
	//152,154,155
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Commercial");
	
	@Test(dataProvider = "testData")
	public void TC_152_QA_VerifyqueueApproval(String Username,String Password,String Mainmenu,String Submenu,String queue,String DaysOut,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
		
			Comm_QA_VerifyQueueApprovalPage();
			Reporter.SuccessReport("TC_152", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_152,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_152", "Username"),
	    			xls.getCellValue("TC_152", "Password"),
	    			xls.getCellValue("TC_152", "MainMenu"),
	    			xls.getCellValue("TC_152", "SubMenu"),
	    			xls.getCellValue("TC_152", "Queue"),
	    			xls.getCellValue("TC_152", "DaysOut"),
	    			
	    			
	    			"To verify Queue Approval page"
	    		}};
	}

}

