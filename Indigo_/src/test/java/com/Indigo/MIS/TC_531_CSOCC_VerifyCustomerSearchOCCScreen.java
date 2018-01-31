package com.Indigo.MIS;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_531_CSOCC_VerifyCustomerSearchOCCScreen extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"MIS");
	//531,532
	@Test(dataProvider = "testData")
	public void TC_531_VErifycustomerSearchOCCScreen(String Username,String Password,String Mainmenu,String Submenu,String queue,String DaysOut,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			MIS_CS_VerifyCustomerSearchOCCPage();
			Reporter.SuccessReport("TC_511", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_511,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_531", "Username"),
	    			xls.getCellValue("TC_531", "Password"),
	    			xls.getCellValue("TC_531", "MainMenu"),
	    			xls.getCellValue("TC_531", "SubMenu"),
	    			xls.getCellValue("TC_531", "Queue"),
	    			xls.getCellValue("TC_531", "DaysOut"),
	    			
	    			
	    			"To verify Customer Search page"
	    		}};
	}

}

