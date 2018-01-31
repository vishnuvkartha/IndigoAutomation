package com.Indigo.Commercial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_185_QBC_VerifySendAndSendAllButton extends HelperClass {
	//185,186,190
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Commercial");
	
	@Test(dataProvider = "testData")
	public void TC_185_QBC_VerifySendandSendAllButton(String Username,String Password,String Mainmenu,String Submenu,String queue,String DaysOut,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			Comm_QBC_SelectQueue(queue);
			Comm_QBC_SelectDaysOut(DaysOut);
			ClickGenerate();
			UncheckAllFlights();
			AU_SelectFirstFlight();
			//verify send button
			ClickSendButton();
			VerifyConfirmation();
			ClickOKButton();
			//verify send all button
			ClickSendAllButton();
			ClickconfirmationSend();
			VerifyConfirmation();
			ClickOKButton();
			//verify export to excel
			Comm_QBC_VerifyExportToExcel();
			Reporter.SuccessReport("TC_185", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_185,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_185", "Username"),
	    			xls.getCellValue("TC_185", "Password"),
	    			xls.getCellValue("TC_185", "MainMenu"),
	    			xls.getCellValue("TC_185", "SubMenu"),
	    			xls.getCellValue("TC_185", "Queue"),
	    			xls.getCellValue("TC_185", "DaysOut"),
	    			
	    			
	    			"To verify PAX Adhoc in Commercial Module"
	    		}};
	}

}

