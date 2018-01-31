package com.Indigo.Commercial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_156_QA_VerifyExportToExcel extends HelperClass {
	//156,162,163,164
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Commercial");
	
	@Test(dataProvider = "testData")
	public void TC_156_QA_VerifyExportToExcel(String Username,String Password,String Mainmenu,String Submenu,String queue,String DaysOut,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			Comm_QA_SelectQueue(queue);
			Comm_QA_ClickSearch();
			Comm_QA_VerifyExportToExcel();
			Comm_QA_VerifyHyperlinks();
			
			Reporter.SuccessReport("TC_156", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_156,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_156", "Username"),
	    			xls.getCellValue("TC_156", "Password"),
	    			xls.getCellValue("TC_156", "MainMenu"),
	    			xls.getCellValue("TC_156", "SubMenu"),
	    			xls.getCellValue("TC_156", "Queue"),
	    			xls.getCellValue("TC_156", "DaysOut"),
	    			
	    			
	    			"To verify Queue Approval page"
	    		}};
	}

}

