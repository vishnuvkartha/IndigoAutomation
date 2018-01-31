package com.Indigo.Commercial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_135_BM_VerifyDownloadSampleFile extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Commercial");
	//135,143,145
	@Test(dataProvider = "testData")
	public void TC_135_VerifyDownloadSampleFil(String Username,String Password,String Mainmenu,String Submenu,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			CommBM_VerifyDownloadfile();
			
			CommBM_VerifyUploadfile("UploadFile_seema.xls");
			VerifyConfirmation();
			ClickOKButton();
			Reporter.SuccessReport("TC_135", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_135,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_135", "Username"),
	    			xls.getCellValue("TC_135", "Password"),
	    			xls.getCellValue("TC_135", "MainMenu"),
	    			xls.getCellValue("TC_135", "SubMenu"),
	    			
	    		
	    			
	    			"To verifY Download Sample File"
	    		}};
	}

}

