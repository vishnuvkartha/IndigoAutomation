package com.Indigo.Commercial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_142_BM_VerifyUploadWithOtherFormat extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Commercial");
	//142,144
	@Test(dataProvider = "testData")
	public void TC_142_VerifyUploadWithOtherformat(String Username,String Password,String Mainmenu,String Submenu,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			CommBM_VerifyUploadfileInOtherFormat("other.txt");
			VerifyConfirmation();
			ClickOKButton();
			CommBM_VerifyUploadfileInOtherFormat("UploadFile_seema.xlt");
			VerifyConfirmation();
			ClickOKButton();
			Reporter.SuccessReport("TC_142", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_142,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_142", "Username"),
	    			xls.getCellValue("TC_142", "Password"),
	    			xls.getCellValue("TC_142", "MainMenu"),
	    			xls.getCellValue("TC_142", "SubMenu"),
	    			
	    		
	    			
	    			"To verifY Upload Sample File with other format"
	    		}};
	}

}

