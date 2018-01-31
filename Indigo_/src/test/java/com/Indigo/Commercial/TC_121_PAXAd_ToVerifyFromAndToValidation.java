

package com.Indigo.Commercial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_121_PAXAd_ToVerifyFromAndToValidation extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Commercial");
	//Covers 120,121,124,125,126,127,128
	@Test(dataProvider = "testData")
	public void TC_121_PAXAd_ToVerifyFromAndToValidation(String Username,String Password,String Mainmenu,String Submenu,String From,String To,String FlightType,String LegType,String Origin,
			String Destination,String email,String ivr,String sms,	String reason,String station,String communication,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu1(Submenu);
			//verify features of pax adhoc page
			CommPAD_VerifyPaxAdhocPage();
			PAD_ClickGenerate();
		    //verify email,sms,ivr hyperlinks and icons		
			CommPAD_VerifySMSIVREmail();
			//verify confirmation without selecting any flights
			UncheckAllFlights();
			ClickSendButton();
			VerifyConfirmation();
			ClickOKButton();		
	    	//check to date less than from validation
			SelectFromDate(From);
			SelectToDate(To);
			PAD_ClickGenerate();
			VerifyConfirmation();
			ClickOKButton();
			//verify reset button
			ClickResetButton();
			driver.navigate().refresh();
			//verify communication is being sent.
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
			VerifyAdhocConfirmation();
			
			Reporter.SuccessReport("TC_121", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_121,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_121", "Username"),
	    			xls.getCellValue("TC_121", "Password"),
	    			xls.getCellValue("TC_121", "MainMenu"),
	    			xls.getCellValue("TC_121", "SubMenu"),
	    			xls.getCellValue("TC_121", "From"),
	    			xls.getCellValue("TC_121", "To"),
	    			xls.getCellValue("TC_121", "FlightType"),
	    			xls.getCellValue("TC_121", "LegType"),
	    			xls.getCellValue("TC_121", "Origin"),
	    			xls.getCellValue("TC_121", "Destination"),
	    			xls.getCellValue("TC_121", "EmailTemplate"),
	    			xls.getCellValue("TC_121", "IVRTemplate"),
	    			xls.getCellValue("TC_121", "SMSTemplate"),	    			
	    			xls.getCellValue("TC_121", "Reason"),
	    			xls.getCellValue("TC_121", "AffectedStation"),
	    			xls.getCellValue("TC_121", "Communication"),
	    		
	    			
	    			"To verify PAX Adhoc in Commercial Module"
	    		}};
	}

}


