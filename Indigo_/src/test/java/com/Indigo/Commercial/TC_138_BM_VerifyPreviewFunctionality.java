package com.Indigo.Commercial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_138_BM_VerifyPreviewFunctionality extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Commercial");
	//137,138,139,140,148,149
	@Test(dataProvider = "testData")
	public void TC_138_BM_VerifyPreviewfunctionality(String Username,String Password,String Mainmenu,String Submenu,String sms,String email,String testdescription) throws Throwable {
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
			BM_ClickEmailIcon();
			BM_VerifyEmailPopup();
			VerifyMessageEmailPreview("email");
			driver.navigate().refresh();
			Comm_BM_SMSTemplate(sms);
			CommBM_VerifyUploadfile("UploadFile_seema.xls");
			ClickOKButton();
			BM_ClickPreview();
			BM_ClickSMSIcon();
			BM_VerifySMSPopup();
			VerifyMessageEmailPreview("SMS");
			driver.navigate().refresh();
			Comm_BM_EmailTemplate(email);
			CommBM_VerifyUploadfile("UploadFile_seema1.xls");
			ClickOKButton();
			BM_ClickPreview();
			BM_ClickEmailIcon();
			VerifyMessageEmailPreview("email");
			driver.navigate().refresh();
			Comm_BM_SMSTemplate(sms);
			CommBM_VerifyUploadfile("UploadFile_seema1.xls");
			ClickOKButton();
			BM_ClickPreview();
			BM_ClickSMSIcon();
			VerifyMessageEmailPreview("SMS");
			
			Reporter.SuccessReport("TC_138", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_138,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
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

