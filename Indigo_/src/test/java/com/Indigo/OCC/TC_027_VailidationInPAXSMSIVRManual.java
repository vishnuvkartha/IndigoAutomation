package com.Indigo.OCC;





import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_027_VailidationInPAXSMSIVRManual extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_027_VailidationInPAXSMSIVRManual(String Username,String Password,String Mainmenu,String Submenu,String From,String To,String Origin,
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
			ClickSendButton();
			VerifyConfirmation();
			ClickOKButton();
			SelectReason(reason);
			ClickSendButton();
			VerifyConfirmation();
			ClickOKButton();
			SelectAffectedStation(station);
			SelectCommunicationOption(communication);
			ClickSendButton();
			VerifyConfirmation();
			Reporter.SuccessReport("TC_027", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_027,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_027", "Username"),
	    			xls.getCellValue("TC_027", "Password"),
	    			xls.getCellValue("TC_027", "MainMenu"),
	    			xls.getCellValue("TC_027", "SubMenu"),
	    			xls.getCellValue("TC_027", "From"),
	    			xls.getCellValue("TC_027", "To"),
	    			xls.getCellValue("TC_027", "Origin"),
	    			xls.getCellValue("TC_027", "Destination"),
	    			xls.getCellValue("TC_027", "Reason"),
	    			xls.getCellValue("TC_027", "AffectedStation"),
	    			xls.getCellValue("TC_027", "Communication"),
	    		
	    			
	    			"To verify validation in PAX SMS/IVR Manual"
	    		}};
	}

}

