package com.Indigo.Commercial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_150_BM_VerifyUnselectedCommunicationType extends HelperClass {
	//150,151
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Commercial");
	
	@Test(dataProvider = "testData")
	public void TC_150_BM_VerifyUnselectedcommunicationType(String Username,String Password,String Mainmenu,String Submenu,String sms,String email,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			Comm_BM_EmailTemplate(email);
			CommBM_VerifyUploadfile("UploadFile_seema.xls");
			ClickOKButton();
			BM_ClickPreview();
			//Verify  if communications should not be triggered for unselected communication type
			BM_CheckUncheckEmailOption();
			CAM_ClickSend();
			VerifyConfirmation();
			ClickOKButton();
			//Verify  if communications are triggered as per uploaded data for the selected communication type
			BM_CheckUncheckEmailOption();
			CAM_ClickSend();
			VerifyConfirmation();
			ClickOKButton();
			Reporter.SuccessReport("TC_150", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_150,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_138", "Username"),
	    			xls.getCellValue("TC_138", "Password"),
	    			xls.getCellValue("TC_138", "MainMenu"),
	    			xls.getCellValue("TC_138", "SubMenu"),
	    			xls.getCellValue("TC_138", "SMSTemplate"),
	    			xls.getCellValue("TC_138", "EmailTemplate"),
	    			
	    		
	    			
	    			"To verifY preview functionality"
	    		}};
	}

}

