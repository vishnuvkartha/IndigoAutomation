package com.Indigo.Commercial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_191_QBC_VerifyQueueWithDifferentOptions extends HelperClass {
	//191,192,193,194,195,196,197,198,199,200,201,202,203
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Commercial");
	
	@Test(dataProvider = "testData")
	public void TC_191_QBC_VerifyQueueWithDifferentOptions(String Username,String Password,String Mainmenu,String Submenu,String queue,String DaysOut,String queue2,String queue3,String queue4,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			Comm_QBC_SelectQueue(queue);
			Comm_QBC_SelectDaysOut(DaysOut);
			ClickGenerate();
			Comm_QBC_VerifyHyperlinks();
			Comm_QBC_SelectQueue(queue2);
			ClickGenerate();
			Comm_QBC_VerifyHyperlinks();
			Comm_QBC_SelectQueue(queue3);
			ClickGenerate();
			Comm_QBC_VerifyHyperlinks();
			Comm_QBC_SelectQueue(queue4);
			ClickGenerate();
			Comm_QBC_VerifyHyperlinks();
			Reporter.SuccessReport("TC_191", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_191,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_191", "Username"),
	    			xls.getCellValue("TC_191", "Password"),
	    			xls.getCellValue("TC_191", "MainMenu"),
	    			xls.getCellValue("TC_191", "SubMenu"),
	    			xls.getCellValue("TC_191", "Queue"),
	    			xls.getCellValue("TC_191", "DaysOut"),
                    "Time Change Delay Less than 2 hours",
	    			"Time Change Prepone Greater than 1 hours",
	    			"Time Change Prepone Less than 1 hours",
	    			"To verify  Different Queue"
	    		}};
	}

}

