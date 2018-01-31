/*package com.Indigo.Commercial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_129_PaxAdhoc_VerifyDataForSelectedFlight extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Commercial");
	//129
	@Test(dataProvider = "testData")
	public void TC_129_PaxAdhoc_VerifyDataForSelectedFligh(String Username,String Password,String Mainmenu,String Submenu,String From,String To,String FlightType,String LegType,String Origin,
			String Destination,String email,String ivr,String sms,	String reason,String station,String communication,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu1(Submenu);
			SelectFromDate(From);
			SelectToDate(To);
			Comm_PAD_SelectFlightType(FlightType);
			Comm_PAD_SelectLegType(LegType);
			CommPAD_SelectOrigin(Origin);
			CommPAD_SelectDestination(Destination);	
			//SelectFirstFlight();
			CommPAD_EmailTemplate(email);
			CommPAD_IVRTemplate(ivr);
			CommPAD_SMSTemplate(sms);
			PAD_ClickGenerate();
			CommPAD_ProvideEmailBody();
			CommPAD_ProvideIVRBody();
			CommPAD_ProvideSMSBody();
			UncheckAllFlights();
			AU_SelectFirstFlight();
			ClickSendButton();
			VerifyConfirmation();
			Reporter.SuccessReport("TC_129", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_129,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_129", "Username"),
	    			xls.getCellValue("TC_129", "Password"),
	    			xls.getCellValue("TC_129", "MainMenu"),
	    			xls.getCellValue("TC_129", "SubMenu"),
	    			xls.getCellValue("TC_129", "From"),
	    			xls.getCellValue("TC_129", "To"),
	    			xls.getCellValue("TC_129", "FlightType"),
	    			xls.getCellValue("TC_129", "LegType"),
	    			xls.getCellValue("TC_129", "Origin"),
	    			xls.getCellValue("TC_129", "Destination"),
	    			xls.getCellValue("TC_129", "EmailTemplate"),
	    			xls.getCellValue("TC_129", "IVRTemplate"),
	    			xls.getCellValue("TC_129", "SMSTemplate"),	    			
	    			xls.getCellValue("TC_129", "Reason"),
	    			xls.getCellValue("TC_129", "AffectedStation"),
	    			xls.getCellValue("TC_129", "Communication"),
	    		
	    			
	    			"To verify PAX Adhoc in Commercial Module"
	    		}};
	}

}

*/