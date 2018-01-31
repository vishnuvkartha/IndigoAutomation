package com.Indigo.OCC;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_023_VrifyEditInSchedulePassengerMessage extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_023_VrifyEditInSchedulePassengerMessage(String Username,String Password,String Mainmenu,String Submenu,String SearchCity,String starttime,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			SPM_ClickEdit();
			SPM_ProvideSchedulername(SearchCity);
			SPM_Startime(starttime);
			SPM_ClickUpdate();
			
			Reporter.SuccessReport("TC_023", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_023,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_023", "Username"),
	    			xls.getCellValue("TC_023", "Password"),
	    			xls.getCellValue("TC_023", "MainMenu"),
	    			xls.getCellValue("TC_023", "SubMenu"),
	    			xls.getCellValue("TC_023", "SearchCity"),
	    			xls.getCellValue("TC_023", "Starttime"),
	    			
	    			
	    			
	    		
	    			
	    			"To verify Scheduled Passenger Message Details"
	    		}};
	}

}

