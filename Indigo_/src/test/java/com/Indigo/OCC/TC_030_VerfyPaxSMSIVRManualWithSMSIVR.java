package com.Indigo.OCC;





import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_030_VerfyPaxSMSIVRManualWithSMSIVR extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_030_VerfyPaxSMSIVRManualWithSMSIVR(String Username,String Password,String Mainmenu,String Submenu,String From,String To,String Origin,
			String Destination,	String reason,String station,String communication,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			SelectFromDate(From);
			SelectToDate(To);
			PAX_SelectOrigin(Origin);
			PAX_SelectFlightNo();
			ClickGenerate();
			AU_SelectFirstFlight();
			getFlightInfo();
			GetTailNo();
			getETD();
			SelectReason(reason);
			SelectAffectedStation(station);
			ClickSendButton();
			VerifyConfirmation();
			Reporter.SuccessReport("TC_030", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_030,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_030", "Username"),
	    			xls.getCellValue("TC_030", "Password"),
	    			xls.getCellValue("TC_030", "MainMenu"),
	    			xls.getCellValue("TC_030", "SubMenu"),
	    			xls.getCellValue("TC_030", "From"),
	    			xls.getCellValue("TC_030", "To"),
	    			xls.getCellValue("TC_030", "Origin"),
	    			xls.getCellValue("TC_030", "Destination"),
	    			xls.getCellValue("TC_030", "Reason"),
	    			xls.getCellValue("TC_030", "AffectedStation"),
	    			xls.getCellValue("TC_030", "Communication"),
	    		
	    			
	    			"To verify PAX SMS/IVR Manual by selecting IVR Option"
	    		}};
	}

}

