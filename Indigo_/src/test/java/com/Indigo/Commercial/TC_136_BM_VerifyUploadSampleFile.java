package com.Indigo.Commercial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_136_BM_VerifyUploadSampleFile extends HelperClass {
	//136,141
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Commercial");
	
	@Test(dataProvider = "testData")
	public void TC_136_VerifyDownloadSampleFil(String Username,String Password,String Mainmenu,String Submenu,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			CommBM_VerifyUploadfile("UploadFile_seema.xls");
			VerifyConfirmation();
			ClickOKButton();
			
			Reporter.SuccessReport("TC_136", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_136,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_136", "Username"),
	    			xls.getCellValue("TC_136", "Password"),
	    			xls.getCellValue("TC_136", "MainMenu"),
	    			xls.getCellValue("TC_136", "SubMenu"),
	    			
	    		
	    			
	    			"To verifY Download Sample File"
	    		}};
	}

}

