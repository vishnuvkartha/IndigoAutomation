package com.Indigo.MIS;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_092_FS_VerifyUserNavigateToFlightSearch extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"MIS");
	//92,93
	@Test(dataProvider = "testData")
	public void TC_092_FS_VerifyuserNavigateToFlightSearch(String Username,String Password,String Mainmenu,String Submenu,String queue,String DaysOut,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			MIS_FS_VerifyFlightSearchPage();
			Reporter.SuccessReport("TC_092", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_092,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_092", "Username"),
	    			xls.getCellValue("TC_092", "Password"),
	    			xls.getCellValue("TC_092", "MainMenu"),
	    			xls.getCellValue("TC_092", "SubMenu"),
	    			xls.getCellValue("TC_092", "Queue"),
	    			xls.getCellValue("TC_092", "DaysOut"),
	    			
	    			
	    			"To verify FlightSearch page"
	    		}};
	}

}

