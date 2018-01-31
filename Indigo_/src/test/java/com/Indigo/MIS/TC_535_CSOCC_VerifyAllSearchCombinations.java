package com.Indigo.MIS;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_535_CSOCC_VerifyAllSearchCombinations extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"MIS");
	
	@Test(dataProvider = "testData")
	public void TC_535_CSOCC_VerifyAllsearchCombinations(String Username,String Password,String Mainmenu,String Submenu,String date,
			String Commtype,String application,String usergroup,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			MIS_ClickSearch();
			VerifyConfirmation();
			ClickOKButton();
			ClickResetButton();
			
			//Date
			MIS_CS_SelectFlightDate(date);
			MIS_ClickSearch();
			VerifyConfirmation();
			ClickOKButton();
			ClickResetButton();
			
			//Flight no			
			MIS_CS_ProvideFlightNumber();
			MIS_ClickSearch();
			VerifyConfirmation();
			ClickOKButton();
			ClickResetButton();
			
			//pnr
			MIS_CS_ProvidePNR();
			MIS_ClickSearch();
			MIS_CS_ValidatePNR();
			//Export to excel
			Comm_MIS_CS_VerifyExportToExcel();
			ClickResetButton();
			
			//ProvideMobileno			
			MIS_CS_ProvideMobileno();
			MIS_ClickSearch();
			MIS_CS_ValidateMobile();
			ClickResetButton();
			
			//Provide email
			MIS_CS_ProvideEmail();
			MIS_ClickSearch();
			ClickResetButton();
			
			//provide sent by
			MIS_CS_ProvideSentBy();
			MIS_ClickSearch();
			VerifyConfirmation();
			ClickOKButton();
			ClickResetButton();
			
			//CommunicationType
		
			MIS_CS_SelectCommunicationType(Commtype);
			MIS_ClickSearch();
			VerifyConfirmation();
			ClickOKButton();
			ClickResetButton();
			
			//Application
			MIS_CS_SelectApplication(application);
			MIS_ClickSearch();
			VerifyConfirmation();
			ClickOKButton();
			ClickResetButton();
			
			//UserGroup
			MIS_CS_SelectUserGroup(usergroup);
			MIS_ClickSearch();
		
			ClickResetButton();
			
			//all
			MIS_CS_SelectFlightDate(date);
			MIS_CS_ProvideFlightNumber();
			MIS_CS_ProvidePNR();
			MIS_CS_ProvideMobileno();
			
			MIS_CS_ProvideSentBy();
			MIS_CS_SelectCommunicationType(Commtype);
			MIS_CS_SelectApplication(application);
			MIS_CS_SelectUserGroup(usergroup);
			MIS_ClickSearch();
			Reporter.SuccessReport("TC_515", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_515,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_535", "Username"),
	    			xls.getCellValue("TC_535", "Password"),
	    			xls.getCellValue("TC_535", "MainMenu"),
	    			xls.getCellValue("TC_535", "SubMenu"),
	    			xls.getCellValue("TC_535", "From"),
	    			xls.getCellValue("TC_535", "CommType"),
	    			xls.getCellValue("TC_535", "Application"),
	    			xls.getCellValue("TC_535", "UserGroup"),
	    			
	    			"To verify Customer Search OCC Search"
	    		}};
	}

}

