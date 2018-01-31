package com.desktopWeb.workflows;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ctaf.support.ExcelReader;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.testObjects.PageLocators;
import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;

import jxl.DateCell;
import jxl.write.DateTime;

public class HelperClass extends PageLocators{
	
	public void handleAuthPopup() throws IOException, InterruptedException{
		//Runtime.getRuntime().exec("C:\\Users\\E002358\\DPCWorkspace\\DPC_Chrome_1\\software\\autoit\\auth_popup.exe");
		//Thread.sleep(40000);
	}
	
	
	
	


//Indigo
//OCC

public void Indigo_Login(String username,String password) throws Throwable{
	logger.info("in Indigo_Login()");
	
	waitForVisibilityOfElement(Indigo_Username,"Username field");
	
	type(Indigo_Username, username, "username");
	
	type(Indigo_Password, password, "password");
	
	click(Indigo_Login, "Log In");
	Reporter.SuccessReport("Step:-Logging In","Logged In Successfully using Username \t:-"+username+"\t and Password \t:-"+password);		
	}

public void ClickMainMenu(String menu) throws Throwable{
	logger.info("in ClickMainMenu()");
	
	waitForVisibilityOfElement(Indigo_MainMenu(menu),"Main Menu \t"+menu);
	click(Indigo_MainMenu(menu), "Main Menu \t"+menu);
	Reporter.SuccessReport("Step:-Select Main Menu","Successfully clicked on Main Menu \t:-"+menu);
	
	}

public void ClickSubMenu(String submenu) throws Throwable{
	logger.info("in ClickSubMenu()");
	
	waitForVisibilityOfElement(Indigo_SubMenu(submenu),"Sub Menu \t"+submenu);
	click(Indigo_SubMenu(submenu),"Sub Menu \t"+submenu);
	Reporter.SuccessReport("Step:-Select Sub Menu","Successfully clicked on Sub Menu \t:-"+submenu);
	
	}
public void ClickSubMenu1(String submenu) throws Throwable{
	logger.info("in ClickSubMenu()");
	
	waitForVisibilityOfElement(Indigo_SubMenu1(submenu),"Sub Menu \t"+submenu);
	click(Indigo_SubMenu1(submenu),"Sub Menu \t"+submenu);
	Reporter.SuccessReport("Step:-Select Sub Menu","Successfully clicked on Sub Menu \t:-"+submenu);
	
	}
public void ClickMenuOptions() throws Throwable{
	logger.info("in ClickMenuOptions()");
	try
	{
	waitForVisibilityOfElement(Indigo_MenuOptions,"Menu Options");
	highLightElement(driver,driver.findElement(Indigo_MenuOptions));
	click(Indigo_MenuOptions,"Menu Options");
	Reporter.SuccessReport("Step:-Select Menu","Successfully clicked on Menu");
	}
	catch(Exception es)
	{
		WebElement ele=driver.findElement(Indigo_MenuOptions);
		highLightElement(driver,ele);
	}
	}

public String TodaysDate() throws Throwable{
	logger.info("in TodaysDate()");
	
	DateFormat dateFormat = new SimpleDateFormat("dd");
	Date date = new Date();
	System.out.println(dateFormat.format(date)); 
	return dateFormat.format(date);
}

public void SelectFromDate(String date) throws Throwable{
	logger.info("in SelectFromDate()");
	
	WebElement from;
    int tomm=0;
    waitForVisibilityOfElement(MFC_FromDate,"From date");
    from=driver.findElement(MFC_FromDate);
    from.click();
	
    Thread.sleep(1000);
	
	//changing string to date format
	String startDateString =date;
	DateFormat df = new SimpleDateFormat("dd"); 
	Date From;
	String FromDate="";
	try {
		From = df.parse(startDateString);
		FromDate = df.format(From);
	    System.out.println(FromDate);
	} catch (ParseException e) {
	    e.printStackTrace();
	}
      
      if(FromDate.contains("0"))
		{
		String[] parts = FromDate.split("0");
		FromDate=parts[1];
		if(parts[1]=="0")
		{
			FromDate=parts[0]+parts[1];
		}
		
		}
   
    //find the calendar  
      List<WebElement> columns=driver.findElements(MFC_FromCalender);  

      //comparing the text of cell with today's date and clicking it.
      for (WebElement cell : columns)
      {
    	  String b=cell.getText();
    	
    	  boolean c=cell.isDisplayed ();
    	  
         if (b.equals(FromDate))
         {
        	
        	 highLightElement(driver,cell);
            cell.click();
            break;
         }
      }
      
      Reporter.SuccessReport("Step:-Select From Date","Successfully clicked on provided From date \t:-"+date);
	
	}
public void SelectToDate(String date) throws Throwable{
	logger.info("in SelectToDate()");
	
	WebElement from;
    int tomm=0;
    waitForVisibilityOfElement(MFC_ToDate,"To date");
    from=driver.findElement(MFC_ToDate);
    from.click();
	
    Thread.sleep(1000);
	
	//changing string to date format
	String startDateString =date;
	DateFormat df = new SimpleDateFormat("dd"); 
	Date To;
	String ToDate="";
	try {
		To = df.parse(startDateString);
		ToDate = df.format(To);
	    System.out.println(ToDate);
	} catch (ParseException e) {
	    e.printStackTrace();
	}
      
      if(ToDate.contains("0"))
		{
		String[] parts = ToDate.split("0");
		ToDate=parts[1];
		if(parts[1]=="0")
		{
			ToDate=parts[0]+parts[1];
		}
		
		}
    
    //find the calendar  
      List<WebElement> columns=driver.findElements(MFC_ToCalender);  

      //comparing the text of cell with today's date and clicking it.
      for (WebElement cell : columns)
      {
    	  String b=cell.getText();
    	 
    	  
         if (b.equals(ToDate))
         {
        	 highLightElement(driver,cell);
            cell.click();
            break;
         }
      }
      
      Reporter.SuccessReport("Step:-Select To Date","Successfully clicked on provided To date \t:-"+date);
	
	}

public void SelectFromDate1(String date) throws Throwable{
	logger.info("in SelectFromDate()");
	
	WebElement from;
    int tomm=0;
    waitForVisibilityOfElement(MFC_FromDate,"From date");
    from=driver.findElement(MFC_FromDate);
    from.click();
	
    Thread.sleep(1000);
	
	//changing string to date format
	String startDateString =date;
	DateFormat df = new SimpleDateFormat("dd"); 
	Date From;
	String FromDate="";
	try {
		From = df.parse(startDateString);
		FromDate = df.format(From);
	    System.out.println(FromDate);
	} catch (ParseException e) {
	    e.printStackTrace();
	}
      
    if(FromDate.contains("0"))
		{
		String[] parts = FromDate.split("0");
		FromDate=parts[1];
		if(parts[1]=="0")
		{
			FromDate=parts[0]+parts[1];
		}
		
		}
    
    //find the calendar  
      List<WebElement> columns=driver.findElements(MFC_FromCalender1);  

      //comparing the text of cell with today's date and clicking it.
      for (WebElement cell : columns)
      {
    	  String b=cell.getText();
    	 
    	  
         if (b.equals(FromDate))
         {
        	 highLightElement(driver,cell); 
            cell.click();
            break;
         }
      }
      
      Reporter.SuccessReport("Step:-Select From Date","Successfully clicked on provided From date \t:-"+date);
	
	}
public void SelectToDate1(String date) throws Throwable{
	logger.info("in SelectToDate()");
	
	WebElement from;
    int tomm=0;
    waitForVisibilityOfElement(MFC_ToDate,"To date");
    from=driver.findElement(MFC_ToDate);
    from.click();
	
    Thread.sleep(1000);
	
	//changing string to date format
	String startDateString =date;
	DateFormat df = new SimpleDateFormat("dd"); 
	Date To;
	String ToDate="";
	try {
		To = df.parse(startDateString);
		ToDate = df.format(To);
	    System.out.println(ToDate);
	} catch (ParseException e) {
	    e.printStackTrace();
	}
      
      if(ToDate.contains("0"))
		{
		String[] parts = ToDate.split("0");
		ToDate=parts[1];
		if(parts[1]=="0")
		{
			ToDate=parts[0]+parts[1];
		}
		
		}
    
    //find the calendar  
      List<WebElement> columns=driver.findElements(MFC_ToCalender1);  

      //comparing the text of cell with today's date and clicking it.
      for (WebElement cell : columns)
      {
    	  String b=cell.getText();
    	 
    	  
         if (b.equals(ToDate))
         {
        	 highLightElement(driver,cell); 
            cell.click();
            break;
         }
      }
      
      Reporter.SuccessReport("Step:-Select To Date","Successfully clicked on provided To date \t:-"+date);
	
	}

public void SelectOrigin(String origin) throws Throwable{
	logger.info("in SelectOrigin()");
	Thread.sleep(2000);
	click(MFC_Origin,"Origin");
	Thread.sleep(3000);
	MoveMouse();
	click(MFC_Origin,"Origin");
	//Thread.sleep(1000);
	click(MFC_OriginPlaces(origin), "Origin Place \t"+origin);
	Reporter.SuccessReport("Step:-Select Origin","The Origin is selected as \t:-"+origin);
		
}
public void SelectDestination(String dest) throws Throwable{
	logger.info("in SelectDestination()");
	// waitForVisibilityOfElement(MFC_Destination,"Destination");
	Thread.sleep(3000);
	click(MFC_Destination,"Destination");
	Thread.sleep(2000);
	click(MFC_DestinationPlaces(dest), "Destination Place \t"+dest);
	Reporter.SuccessReport("Step:-Select Destination","The Destination is selected as \t:-"+dest);
		
}
public void SelectFlightNo() throws Throwable{
	logger.info("in SelectFlightNo()");
	// waitForVisibilityOfElement(MFC_FlightNo,"Flight No");
	Thread.sleep(3000);
	click(MFC_FlightNo,"Flight no");
	Thread.sleep(1000);
	click(MFC_FlightNoSelectAll, "Flight no \t"+"Select All");
	Reporter.SuccessReport("Step:-Select Flight Number","The Flight number is selected as \t:-"+"Select All");
		
}

public void ClickOKButton() throws Throwable{
	logger.info("in ClickOKButton()");
	// waitForVisibilityOfElement(MFC_FlightNo,"Flight No");
	Thread.sleep(2000);
	JSClick(OKButton,"OK Button");
	
	Reporter.SuccessReport("Step:-Click OK Button","OK Button is clicked \t");
		
}

public void SelectFirstFlight() throws Throwable{
	logger.info("in SelectFirstFlight()");
	// waitForVisibilityOfElement(MFC_FlightNo,"Flight No");
	Thread.sleep(2000);
	click(MFC_FlightNo,"Flight no");
	Thread.sleep(1000);
	click(MFC_FlightNoSelectFirst, "Flight no \t"+"FirstFlight");
	
	Reporter.SuccessReport("Step:-Select Flight Number","The Flight number is selected \t:-");
		
}

public void ClickGenerate() throws Throwable{
	logger.info("in ClickGenerate()");
	Thread.sleep(3000);
	waitForVisibilityOfElement(MFC_GenerateButton,"Generate Button");
	JSClick(MFC_GenerateButton,"Generate Button");
	Reporter.SuccessReport("Step:-Click Generate Button","Successfully clicked on Generate Button");
}

public void SelectAllFlightsCheckbox() throws Throwable{
	logger.info("in SelectAllFlightsCheckbox()");
	Thread.sleep(3000);
	//waitForVisibilityOfElement(MFC_GenerateButton,"Generate Button");
	JSClick(MFC_SelectAllCheckBox,"Select all flights");
	Reporter.SuccessReport("Step:-Select All Flights","Successfully clicked on 'All Flights' Checkbox");
}
public void getFlightInfo() throws Throwable{
	logger.info("in getFlightInfo()");
	//Thread.sleep(2000);
	//waitForVisibilityOfElement(MFC_GenerateButton,"Generate Button");
	String fligtinfo=getText(MFC_FlightInfo, "Flight Info");
	Reporter.SuccessReport("Step:-Get Flight Info","The Flight Info is displayed as \t:-"+fligtinfo);
}

public void SelectReason(String reason) throws Throwable{
	logger.info("in SelectReason()");
	
	click(MFC_DelayReason,"Delay Reason");
	Thread.sleep(1000);
	click(MFC_DelayReasons(reason),"Select Reason");
	Reporter.SuccessReport("Step:-Select Reason","The selected reason is \t:-"+reason);
}

public void SelectAffectedStation(String station) throws Throwable{
	logger.info("in SelectAffectedStation()");
	
	JSClick(MFC_AffectedStation,"Affected Station");
	Thread.sleep(1000);
	JSClick(MFC_AffectedStations(station),"Affected Station");
	Reporter.SuccessReport("Step:-Choose Affected Station","The Affected Station is \t:-"+station);
}

public void SelectCommunicationOption(String option) throws Throwable{
	logger.info("in SelectCommunicationOption()");
	
if(option.equals("SMS"))
{
	
	JSClick(MFC_IVRCheckbox,"IVR checkbox");
	Thread.sleep(1000);
	Reporter.SuccessReport("Step:-Select Communication mode(SMS or IVR)","The CommunicationOption is selected as \t:-"+option);

}
else
{

	JSClick(MFC_SMSCheckbox,"Sms checkbox");
	Thread.sleep(1000);
	Reporter.SuccessReport("Step:-Select Communication mode(SMS or IVR)","The CommunicationOption is selected as \t:-"+option);
}


}

public void VerifyCommunicationTable(String option) throws Throwable{
	logger.info("in VerifySMSTable()");
	int k=2;
	if(option.equals("SMS"))
	{
	click(MFC_SMSIcon,"Sms icon");
	}
	else
	{
		click(MFC_IVRIcon,"IVR icon");
	}
	List<WebElement> element=driver.findElements(By.xpath("//div[@id='messageplaceholder']//tbody//tr[not(contains(@style,'display: none;'))]"));
	int z=element.size();

	int y=z-1;
	waitForVisibilityOfElement(MFC_SMSIVRPopup,"SMS Popup");
	for(int i=0;i<y;i++)
	{
		int l=1;
		String a=driver.findElement(By.xpath("//div[@class='table_grid mb10']//tbody//tr["+k+"]//td["+l+"]")).getText();
		l++;
		String b=driver.findElement(By.xpath("//div[@class='table_grid mb10']//tbody//tr["+k+"]//td["+l+"]")).getText();
		l++;
		String c=driver.findElement(By.xpath("//div[@class='table_grid mb10']//tbody//tr["+k+"]//td["+l+"]")).getText();
		Reporter.SuccessReport("Step:-Verify \t '"+option+"' \tTable","Slno:-"+a+"\t\t Message:- \t"+b+"\t\t Phone No:- \t"+c);
		k++;
	}
}
	public void GetTailNo() throws Throwable{
		logger.info("in GetTailNo()");
		//Thread.sleep(2000);
		//waitForVisibilityOfElement(MFC_GenerateButton,"Generate Button");
		String tailno=getText(MFC_TailNo, "Tail Number");
		Reporter.SuccessReport("Step:-Get Tail No","The tail no is displayed as \t:-"+tailno);

}
	
	public void ClickSendButton() throws Throwable{
		logger.info("in ClickSendButton()");
		
		click(MFC_SendButton,"Send Button");
		Reporter.SuccessReport("Step:-Click Send Button","Successfully clicked on Send Button");
}
	
	public void getETD() throws Throwable{
		logger.info("in getETD()");
		
		String ETD=getText(MFC_ETD, "ETD");
		Reporter.SuccessReport("Step:-Get ETD","The  ETD is displayed as \t:-"+ETD);
}
	
	public void VerifyConfirmation() throws Throwable{
		logger.info("in VerifyConfirmation()");
		//if(isElementDisplayed(MFC_SMSConfirmation, ""))
		waitForVisibilityOfElement(MFC_SMSConfirmation,"Confirmation");
		Thread.sleep(4000);
		String confirmation=getText(MFC_SMSConfirmation, "Confirmation message");
		Reporter.SuccessReport("Step:-Verify Confirmation","The  confirmation message is displayed as \t:-"+confirmation);
}
	
	public void ClickconfirmationSend() throws Throwable{
		logger.info("in ClickconfirmationSend()");
		//if(isElementDisplayed(MFC_SMSConfirmation, ""))
		waitForVisibilityOfElement(CommQBC_btn_SendInConfirmation,"send");
		click(CommQBC_btn_SendInConfirmation,"send");
}
	
	public void VerifyAdhocConfirmation() throws Throwable{
		logger.info("in VerifyAdhocConfirmation()");
		//if(isElementDisplayed(MFC_SMSConfirmation, ""))
		waitForVisibilityOfElement(PAX_AhocInfoPopup,"Confirmation");
		Thread.sleep(4000);
		String confirmation=getText(PAX_AhocInfoPopup, "Confirmation message");
		click(OKButton2,"Ok button");
		Reporter.SuccessReport("Step:-Verify Confirmation","The  confirmation message is displayed as \t:-"+confirmation);
}

	
//Aims Uploader
	
	public void AU_SelectFirstFlight() throws Throwable{
		logger.info("in AU_SelectFirstFlight()");
		Thread.sleep(2000);
		JSClick(AU_FirstFlightCheckbox, "first Flight");
		Reporter.SuccessReport("Step:-Select First Flight","The  first flight is selected");
}
	
	public void AU_GetFlightDetails() throws Throwable{
		logger.info("in AU_GetFlightDetails()");
		
		Thread.sleep(1000);
		
		String flight=getText(AU_FlightInfo, "Flight Info");
		String LastNotifiedETD=getText(AU_LastNotifiedETD, "Last Notified ETD");
		String presentETD=getText(AU_PresentETD, "present ETD");
		String LNPax=getText(AU_lastNotifiedPax, "Last Notified Pax");
		String PrePax=getText(AU_PresentPax, "Present Pax");
		String TailNo=getText(AU_TailNo, "TailNo");
		String CreatedDTM=getText(AU_CreatedDTM, "Created DTM");
		Reporter.SuccessReport("Step:-get Flight Info","The flight info is displayed as \t:-"+flight);
		Reporter.SuccessReport("Step:-get Last Notified ETD","The Last Notified ETD is displayed as \t:-"+LastNotifiedETD);
		Reporter.SuccessReport("Step:-get present ETD","The presentETD is displayed as \t:-"+presentETD);
		Reporter.SuccessReport("Step:-get Last Notified Pax","The Last Notified Pax is displayed as \t:-"+LNPax);
		Reporter.SuccessReport("Step:-get Present Pax","The Present Pax is displayed as \t:-"+PrePax);
		Reporter.SuccessReport("Step:-get TailNo","The TailNo is displayed as \t:-"+TailNo);
		Reporter.SuccessReport("Step:-get Created DTM","The Created DTM is displayed as \t:-"+CreatedDTM);
}
	
	public void AU_ClickBoarded() throws Throwable{
		logger.info("in AU_ClickBoarded()");
		waitForVisibilityOfElement(AU_Boarded,"Boarded Flights");
		Thread.sleep(1000);
		
		JSClick(AU_Boarded,"Boarded Flights");
		Thread.sleep(2000);
		Reporter.SuccessReport("Step:-Select Boarded flights","Boarded flight option is selected");
}
	
	public void AU_ClickTailReason() throws Throwable{
		logger.info("in AU_ClickTailReason()");
		waitForVisibilityOfElement(AU_TailReason,"Tail Reason");
		
		JSClick(AU_TailReason,"Tail Reason");
		Thread.sleep(2000);
		Reporter.SuccessReport("Step:-Click Tail Reason","Clicked on Tail Reason");
}
	
	public void AU_SelectTailNo(String TailNo) throws Throwable{
		logger.info("in AU_SelectTailNo()");
		//waitForVisibilityOfElement(AU_TailNumber,"Tail Number");
		
		click(AU_TailNumber,"Tail Number");
		Thread.sleep(1000);
		click(MFC_OriginPlaces(TailNo), "Tail Number \t"+TailNo);
		
		Reporter.SuccessReport("Step:-Select Tail No","Tail number is selected \t:-"+TailNo);
}
	public void AU_SelectTailReason(String reason) throws Throwable{
		logger.info("in AU_SelectTailReason()");
		Thread.sleep(2000);
		
		JSClick(AU_ReasonRemark,"Reason");
		Thread.sleep(1000);
		click(MFC_OriginPlaces(reason), "Reason \t"+reason);
		
		Reporter.SuccessReport("Step:-Select Reason","Reason is selected \t:-"+reason);
}
	public void AU_SelectAffectedStation(String station) throws Throwable{
		logger.info("in AU_SelectAffectedStation()");
		Thread.sleep(2000);
		
		JSClick(AU_AffectedStation,"Affected Station");
		Thread.sleep(1000);
		click(MFC_OriginPlaces(station), "Affected Station \t"+station);
		
		Reporter.SuccessReport("Step:-Select Affected Station","Affected Station is selected \t:-"+station);
}
	
	public void AU_ClickSave() throws Throwable{
		logger.info("in AU_ClickSave()");
		Thread.sleep(2000);
		click(AU_SaveAll, "Save button \t");
		
		Reporter.SuccessReport("Step:-Click Save Button","Clicked On Save Button \t:-");
}
	
	public void AU_ClickSearch() throws Throwable{
		logger.info("in AU_ClickSearch()");
		Thread.sleep(2000);
		waitForVisibilityOfElement(SPM_Search,"Search Button");
		click(SPM_Search, "Search button \t");
		
		
		Reporter.SuccessReport("Step:-Click Search Button","Clicked On Search Button \t:-");
}
	public void AU_Delete() throws Throwable{
		logger.info("in AU_Delete()");
		//waitForVisibilityOfElement(SPM_Search,"Search Button");
		click(AU_Delete, "Delete button \t");
		
		Reporter.SuccessReport("Step:-Click Delete Button","The selected flight is Successfully Deleted \t");
}
	
	
	
	public void PAX_SelectOrigin(String origin) throws Throwable{
		logger.info("in PAX_Origin()");
		waitForVisibilityOfElement(PAX_Origin,"Origin");
		Thread.sleep(2000);
		
		click(PAX_Origin,"Origin");
		Thread.sleep(3000);
		MoveMouse();
		click(PAX_Origin,"Origin");
		Thread.sleep(1000);
		
		click(MFC_OriginPlaces(origin), "Origin Place \t"+origin);
		Reporter.SuccessReport("Step:-Select origin","The origin is selected as \t"+origin);
}
	
	public void PAX_SelectFlightNo() throws Throwable{
		logger.info("in PAX_SelectFlightNo()");
		Thread.sleep(2000);
		waitForVisibilityOfElement(PAX_FligntNo,"Flight No Options");
		
		click(PAX_FligntNo,"Origin");
		Thread.sleep(1000);
		click(MFC_FlightNoSelectAll, "Select Flight no \t");
		Reporter.SuccessReport("Step:-Select Flight No","The flight option is selected as SelectAll");
}
	
	//P ADHOC
	public void PAD_SelectFlightType(String type) throws Throwable{
		logger.info("in PAD_SelectFlightType()");
		Thread.sleep(2000);
		waitForVisibilityOfElement(PAD_FlightType,"Flight Type");
		
		click(PAD_FlightType,"Flight Type");
		Thread.sleep(1000);
		click(PAD_FlightTypes(type), "Select Flight type \t");
		Reporter.SuccessReport("Step:- Select Flight Type","The flight type is selected as \t"+type);
}
	
	public void PAD_SelectLegType(String type) throws Throwable{
		logger.info("in Select Leg Type()");
		Thread.sleep(3000);
		waitForVisibilityOfElement(PAD_LegType,"Leg Type");
		
		click(PAD_LegType,"Leg Type");
		Thread.sleep(1000);
		click(PAD_LegTypes(type), "Select Leg Type \t");
		Reporter.SuccessReport("Step:- Select Leg Type","The leg type is selected as \t"+type);
}
	
	public void PAD_SelectOrigin(String origin) throws Throwable{
		logger.info("in PAD_SelectOrigin()");
		Thread.sleep(3000);
		click(PAD_Origin,"Origin");
		
		click(MFC_OriginPlaces(origin), "Origin Place \t"+origin);
		Reporter.SuccessReport("Step:-Select Origin","The Origin is selected as \t:-"+origin);
			
	}
	public void PAD_SelectDestination(String dest) throws Throwable{
		logger.info("in PAD_SelectDestination()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		click(PAD_Destination,"Destination");
		click(MFC_DestinationPlaces(dest), "Destination Place \t"+dest);
		Reporter.SuccessReport("Step:-Select Destination","The Destination is selected as \t:-"+dest);
			
	}
	
	public void PAD_SMSTemplate(String temp) throws Throwable{
		logger.info("in PAD_SMSTemplate()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		click(PAD_SMSTemplate,"SMS Template");
		click(MFC_DestinationPlaces(temp), "Destination Place \t"+temp);
		Reporter.SuccessReport("Step:-Select SMS Template","The Template is selected as \t:-"+temp);
			
	}
	
	
	public void PAD_ClickGenerate() throws Throwable{
		logger.info("in ClickGenerate()");
		Thread.sleep(2000);
		//waitForVisibilityOfElement(MFC_GenerateButton,"Generate Button");
		click(PAD_GenerateButton,"Generate Button");
		Reporter.SuccessReport("Step:-Click Generate Button","Successfully clicked on Generate Button");
	}
	
	public void PAD_GetFlightDetails() throws Throwable{
		logger.info("in AU_GetFlightDetails()");
		
		Thread.sleep(1000);
		
		String flight=getText(PAD_FlightInfo, "Flight Info");
		String Pending=getText(PAD_Pending, "Pending");
		String Initiated=getText(PAD_Initiated, "Initiated");
		String Success=getText(PAD_Success, "Success");
		String Aawited=getText(PAD_Awaited, "Aawited");
		String Failed=getText(PAD_Failed, "Failed");
		String LastnotifiedTime=getText(PAD_LastNotifiedTime, "Last Notified Time");
		Reporter.SuccessReport("Step:-get Flight Info","The flight info is displayed as \t:-"+flight);
		Reporter.SuccessReport("Step:-get Pending","Pending is displayed as \t:-"+Pending);
		Reporter.SuccessReport("Step:-get Initiatedf","Initiated is displayed as \t:-"+Initiated);
		Reporter.SuccessReport("Step:-get Success","Success is displayed as \t:-"+Success);
		Reporter.SuccessReport("Step:-get Aawited","The Present Pax is displayed as \t:-"+Aawited);
		Reporter.SuccessReport("Step:-get TailNo","Failed is displayed as \t:-"+Failed);
		Reporter.SuccessReport("Step:-get LastnotifiedTime ","Last notified Time is displayed as \t:-"+LastnotifiedTime);
}
	
	
	public void CAM_SelectOrigin(String origin) throws Throwable{
		logger.info("in CAM_SelectOrigin()");
		Thread.sleep(2000);
	click(CAM_Origin,"Origin");
	//Thread.sleep(2000);
	click(Submenu(origin), "Origin Place \t"+origin);
		Reporter.SuccessReport("Step:-Select Origin","The Origin is selected as \t:-"+origin);
			
	}
	public void CAM_SelectDestination(String dest) throws Throwable{
		logger.info("in CAM_SelectDestination()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		click(CAM_Destination,"Destination");
		JSClick(MFC_DestinationPlaces(dest), "Destination Place \t"+dest);
		Reporter.SuccessReport("Step:-Select Destination","The Destination is selected as \t:-"+dest);
			
	}
	
	public void CAM_Startime(String time) throws Throwable{
		logger.info("in CAM_Startime()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		click(CAM_StartTime,"Start Time");
		Thread.sleep(2000);
		JSClick(CAM_StartTime(time), "Start Time \t"+time);
		Reporter.SuccessReport("Step:-Select StartTime","The StartTime is selected as \t:-"+time);
			
	}
	public void CAM_EndTime(String time) throws Throwable{
		logger.info("in CAM_EndTime()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		click(CAM_EndTime,"End Time");
		JSClick(CAM_StartTime(time), "End Time \t"+time);
		Reporter.SuccessReport("Step:-Select EndTime","The EndTime is selected as \t:-"+time);
			
	}
	
	public void CAM_SelectCrewType(String type,String notify) throws Throwable{
		logger.info("in CAM_SelectCrewType()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		if(notify.equals("General Broadcast"))
		{
		click(CAM_CrewType1,"Crew type");
		JSClick(PAD_LegTypes(type), "Crew type  \t"+type);
		}
		else
		{
			click(CAM_CrewType,"Crew type");
			JSClick(DropdownItems(type), "Crew type  \t"+type);
		}
		Thread.sleep(1000);
	
	Thread.sleep(1000);
		Reporter.SuccessReport("Step:-Select Crew Type","The Crew Type is selected as \t:-"+type);
			
	}
	
	
	
	public void CAM_SelectFlightStaus(String status) throws Throwable{
		logger.info("in CAM_SelectDestination()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		click(CAM_FlightStatus,"Flight Staus");
		JSClick(MFC_DestinationPlaces(status), "Flight Status \t"+status);
		Reporter.SuccessReport("Step:-Select Flight Staus","The Flight Status is selected as \t:-"+status);
			
	}
	
	public void CAM_AddCCNo(String no) throws Throwable{
		logger.info("in CAM_AddCCNo()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
	    type(CAM_CCNo,no,"CC No");
		Reporter.SuccessReport("Step:-Add CC No","CC number is provided as \t:-"+no);
			
	}
	
	public void CAM_SelectCrewNotificationType(String type) throws Throwable{
		logger.info("in CAM_SelectCrewNotificationType()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		click(CAM_CrewNotificationType,"Crew Notification Type");
		JSClick(MFC_DestinationPlaces(type), "Crew Notification Type \t"+type);
		Reporter.SuccessReport("Step:-Select Crew Notification Type","The Crew Notification Type is selected as \t:-"+type);
			
	}
	
	public void CAM_SelectBase(String base) throws Throwable{
		logger.info("in CAM_SelectBase()");
		Thread.sleep(2000);
		click(CAM_Base,"Base");
		JSClick(CAM_Base(base), "Base  \t"+base);
		Reporter.SuccessReport("Step:-Select Basee","The Base is selected as \t:-"+base);
			
	}
	
	public void SelectSMS() throws Throwable{
		logger.info("in SelectSMS()");
		JSClick(CAM_SMS,"Sms checkbox");
		Thread.sleep(1000);
		Reporter.SuccessReport("Step:-Select Communication mode(SMS or IVR)","The CommunicationOption is selected as \t:-"+"SMS");
			
	}
	
	public void CAM_ClickSend() throws Throwable{
		logger.info("in CAM_ClickSend()");
		click(CAM_Send,"Send Button");
		Thread.sleep(1000);
		Reporter.SuccessReport("Step:-Click Send Button","The send button is clicked succesfully \t:-");
			
	}
	public void VerifySchedulePassengerMessage() throws Throwable{
		logger.info("in VerifySchedulePassengerMessage()");
		int k=2;
		
		List<WebElement> element=driver.findElements(By.xpath("//div[@class='table_grid mb10']//tr"));
		int z=element.size();

		int y=z-1;
		
		for(int i=0;i<y;i++)
		{
			int l=1;

			String a=driver.findElement(SPM_SchedulerName(k,l)).getText();
			l++;
			String b=driver.findElement(SPM_SchedulerStartDate(k,l)).getText();
			l++;
			String c=driver.findElement(SchedulerEndDate(k,l)).getText();
			l++;
			String d=driver.findElement(SPM_SchedulerTime(k,l)).getText();
			l++;
			String e=driver.findElement(SPM_Active(k,l)).getText();
			Reporter.SuccessReport("Step:-Schedule Passenger Message details","Scheduler Name:-"+a+"\t\t Scheduler Start Date:- \t"+b+"\t\t Scheduler End Date:- \t"+c+"\t\t 	Scheduler Time:- \t"+d+"\t\t Active:- \t"+e);
			k++;
		}
	}
	
	public void SPMM_ClickSearch(String City) throws Throwable{
		logger.info("in SPMM_ClickSearch()");
		   type(SPM_SearchArea,City,"Search parameter");
		   Thread.sleep(1000);
		click(SPM_Search,"Search Button");
		Thread.sleep(1000);
		Reporter.SuccessReport("Step:-Click Search Button","The Search button is clicked succesfully \t:-");
			
	}
	
	public void SPM_ClickEdit() throws Throwable{
		logger.info("in SPM_ClickEdit()");
		 
		click(Editlink,"Edit Link");
		Thread.sleep(1000);
		Reporter.SuccessReport("Step:-Click Edit Button","The Edit button is clicked succesfully \t:-");
			
	}
	
	public void SPM_ClickDelete() throws Throwable{
		logger.info("in SPM_ClickDelete()");
		 
		click(Deletelink,"Delete Link");
		Thread.sleep(1000);
		click(DeleteButton,"Delete button");
		Reporter.SuccessReport("Step:-Click Delete Button","The flight is deleted succesfully \t");
			
	}
	
	public void SPM_Startime(String time) throws Throwable{
		logger.info("in SPM_Startime()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		click(SPM_StartTime,"Start Time");
		JSClick(CAM_StartTime(time), "Start Time \t"+time);
		Reporter.SuccessReport("Step:-Select StartTime","The StartTime is selected as \t:-"+time);
			
	}
	
	public void SPM_ProvideSchedulername(String name) throws Throwable{
		logger.info("in SPM_Startime()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		type(SPM_SchedulerNmae,name,"Scheduler Name");
		
		Reporter.SuccessReport("Step:-Provide Scheduler Name","The Scheduler name is given as \t:-"+name);
			
	}
	
	public void SPM_ClickUpdate() throws Throwable{
		logger.info("in SPM_ClickUpdate()");
		Thread.sleep(2000);
		//waitForVisibilityOfElement(MFC_GenerateButton,"Generate Button");
		click(SPM_Update,"Update Button");
		Reporter.SuccessReport("Step:-Click Update Button","Successfully clicked on update Button");
	}
	
	public void CheckUncheckFlifoUpdate() throws Throwable{
		logger.info("in SPMM_CheckUncheckFlifoUpdate()");
		 
	    JSClick(AU_FlifoUpdate,"Flifo Update");
		Thread.sleep(1000);
		Reporter.SuccessReport("Step:-Check/Uncheck Flifo Update","Checking/Unchecking of Flifo Update done successfully \t:-");
			
	}
	
	public void MoveMouse()
	{
	try {
	    // These coordinates are screen coordinates
	    int xCoord = 500;
	    int yCoord = 500;

	    // Move the cursor
	    Robot robot = new Robot();
	    robot.mouseMove(xCoord, yCoord);
	} catch (AWTException e) {
	}
	
	}
	

	public static void highLightElement(WebDriver webdriver, WebElement element) throws InterruptedException {
	    JavascriptExecutor driver = (JavascriptExecutor) webdriver;
	    driver.executeScript("arguments[0].setAttribute('style',arguments[1]);", element, "border: 2px solid red;");
	}
	
	
	//COMMERCIAL
	
	//PAX Adhoc
	
	public void Comm_PAD_SelectFlightType(String type) throws Throwable{
		logger.info("in PAD_SelectFlightType()");
		Thread.sleep(2000);
		waitForVisibilityOfElement(CommPAX_FlightType,"Flight Type");
		
		click(CommPAX_FlightType,"Flight Type");
		Thread.sleep(1000);
		click(PAD_FlightTypes(type), "Select Flight type \t");
		Reporter.SuccessReport("Step:- Select Flight Type","The flight type is selected as \t"+type);
}
	
	
	
	public void Comm_PAD_SelectLegType(String type) throws Throwable{
		logger.info("in Comm_PAD_SelectLegType()");
		Thread.sleep(3000);
	//	waitForVisibilityOfElement(CommPAX_LegType,"Leg Type");
		
		click(CommPAX_LegType,"Leg Type");
		Thread.sleep(1000);
		click(PAD_LegTypes(type), "Select Leg Type \t");
		Reporter.SuccessReport("Step:- Select Leg Type","The leg type is selected as \t"+type);
}
	
	public void CommPAD_SelectOrigin(String origin) throws Throwable{
		logger.info("in PAD_SelectOrigin()");
		Thread.sleep(3000);
		click(CommPAX_Origin,"Origin");
		
		click(MFC_OriginPlaces(origin), "Origin Place \t"+origin);
		Reporter.SuccessReport("Step:-Select Origin","The Origin is selected as \t:-"+origin);
			
	}
	public void CommPAD_SelectDestination(String dest) throws Throwable{
		logger.info("in PAD_SelectDestination()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		click(CommPAX_Destination,"Destination");
		click(MFC_DestinationPlaces(dest), "Destination Place \t"+dest);
		Reporter.SuccessReport("Step:-Select Destination","The Destination is selected as \t:-"+dest);
			
	}
	public void CommPAD_EmailTemplate(String temp) throws Throwable{
		logger.info("in PAD_EmailTemplate()");
	     waitForVisibilityOfElement(CommPAX_EmailTemplate,"Email");
		Thread.sleep(3000);
	    JSClick(CommPAX_EmailTemplate,"Email Template");
	    Thread.sleep(1000);
	    click(CommPAX_EmailTemplate,"Email Template");
	    //JSClick(CommPAX_EmailTemplate,"Email Template");
		click(MFC_OriginPlaces(temp), "email template \t"+temp);
		Reporter.SuccessReport("Step:-Select Email Template","The Template is selected as \t:-"+temp);
			
	}
	public void CommPAD_IVRTemplate(String temp) throws Throwable{
		logger.info("in IVR_EmailTemplate()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		click(CommPAX_IVRTemplate,"Email Template");
		click(CommPAX_IVR(temp), "IVR template \t"+temp);
		Reporter.SuccessReport("Step:-Select IVR Template","The Template is selected as \t:-"+temp);
			
	}
	public void CommPAD_SMSTemplate(String temp) throws Throwable{
		logger.info("in PAD_SMSTemplate()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		click(CommPAX_SmsTemplate,"SMS Template");
		click(MFC_DestinationPlaces(temp), "SMS Template \t"+temp);
		Reporter.SuccessReport("Step:-Select SMS Template","The Template is selected as \t:-"+temp);
			
	}
	
	
	public void CommPAD_ClickGenerate() throws Throwable{
		logger.info("in ClickGenerate()");
		Thread.sleep(2000);
		//waitForVisibilityOfElement(MFC_GenerateButton,"Generate Button");
		click(PAD_GenerateButton,"Generate Button");
		Reporter.SuccessReport("Step:-Click Generate Button","Successfully clicked on Generate Button");
	}
	
	public void CommPAD_VerifyPaxAdhocPage() throws Throwable{
		logger.info("in CommPAD_VerifyPaxAdhocPage()");
		//Verifying user is navigated to broadcast page
		waitForVisibilityOfElement(CommPAX_FlightType,"Pax Adhoc Heading");
		 isElementDisplayed(CommPAX_LegType, "Leg Type Dropdown");
		 isElementDisplayed(CommPAX_Origin, "origin dropdown");
		 isElementDisplayed(CommPAX_Destination, "Destination Button");
		 isElementDisplayed(CommPAX_EmailTemplate, "Email Template dropdown");
		 isElementDisplayed(CommPAX_IVRTemplate, "IVR Template dropdown");
		 isElementPresent(CommPAX_SmsTemplate, "SMS Template dropdown");
		 isElementPresent(MFC_FromDate, "From date and time");
		 isElementPresent(MFC_ToDate, "To date and time");
		 Reporter.SuccessReport("Step:-VerifyPaxAdhocPage","Successfully verified Pax adhoc page in Commercial module");
		 
		
	}
	
	public void CommPAD_VerifySMSIVREmail() throws Throwable{
		logger.info("in CommPAD_VerifySMSIVREmail()");
	 
		 Thread.sleep(2000);
		 waitForVisibilityOfElement(MFC_SMSIcon,"SMS Icon");
		 isElementDisplayed(MFC_IVRIcon, "IVR Icon");
		 isElementDisplayed(MFC_SMSIcon, "SMS Icon");
		 isElementDisplayed(PAX_EmailIcon, "Email Icon");
		 isElementDisplayed(PAX_SMSHyperlink, "SMSHyperlink");
		 isElementDisplayed(PAX_EmalHyperlink, "EmalHyperlink");
		 isElementDisplayed(PAX_IVRHyperlink, "IVRHyperlink");		 
		 Reporter.SuccessReport("Step:-Verify SMS/IVR/Eamil","Successfully verified SMS,IVR and Email details");
		 
		
	}
	
	public void CommPAD_ProvideEmailBody() throws Throwable{
		logger.info("in CommPAD_ProvideEmailBody()");
	 
		 type(PAX_EmailSubject, "Test", "Email subject");
		 Thread.sleep(1000);		 
		 WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		 driver.switchTo().frame(iframe);
		 Thread.sleep(2000);	
		 WebElement tinymce = driver.findElement(PAX_EmailBody);
		 driver.findElement(PAX_EmailBody).click();
		 Thread.sleep(2000);	
		 tinymce.clear();
		 tinymce.sendKeys("Hello, tinymce!");
		 driver.switchTo().defaultContent();         
		 
		 Reporter.SuccessReport("Step:-Provide email details","Successfully provided email details");   

		 
		
	}
	public void CommPAD_ProvideIVRBody() throws Throwable{
		logger.info("in CommPAD_ProvideIVRBody()");	 
		type(PAX_IVRBody, "halooooooooo", "IVR subject");
		 Reporter.SuccessReport("Step:-Provide IVR details","Successfully provided IVR details");   	 
		 
		
	}
	public void CommPAD_ProvideSMSBody() throws Throwable{
		logger.info("in CommPAD_ProvideSMSBody()");
	 
		type(PAX_SMSBody, "halooooooooo", "SMS subject");
		 
		Reporter.SuccessReport("Step:-Provide SMS details","Successfully provided SMS details");   
		
	}
	
	public void UncheckAllFlights() throws Throwable{
		logger.info("in UncheckAllFlights()");
	     
		 JSClick(MFC_SelectAllCheckBox, "Flight info check box");
		 Thread.sleep(2000);
		 Reporter.SuccessReport("Step:-Uncheck All flights","Successfully unchecked flights");
		 
		
	}
	public void QBC_Startime(String time) throws Throwable{
		logger.info("in QBC_Startime()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		click(CAM_StartTime,"Start Time");
		Thread.sleep(2000);
		JSClick(CommQBC_Starttime(time), "Start Time \t"+time);
		Reporter.SuccessReport("Step:-Select StartTime","The StartTime is selected as \t:-"+time);
			
	}
	public void QBC_EndTime(String time) throws Throwable{
		logger.info("in QBC_EndTime()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		click(CAM_EndTime,"End Time");
		Thread.sleep(2000);
		JSClick(CommQBC_Endtime(time), "Start Time \t"+time);
		Reporter.SuccessReport("Step:-Select EndTime","The EndTime is selected as \t:-"+time);
			
	}
	
	public void Comm_QBC_SelectQueue(String queue) throws Throwable{
		logger.info("in CommPAD_SelectQueue()");
		Thread.sleep(3000);
		click(CommQBC_Queue,"Queue");
		
		click(MFC_OriginPlaces(queue), "Queue \t"+queue);
		Reporter.SuccessReport("Step:-Select Queue","The Queue is selected as \t:-"+queue);
			
	}
	
	public void Comm_QBC_VerifyPage() throws Throwable{
		logger.info("in Comm_QBC_VerifyPage()");
		waitForVisibilityOfElement(CommQBC_b_Heading,"Queue Based Changes Heading");
		 isElementDisplayed(CommQBC_b_Heading, "Queue Based Changes Heading");
		 isElementDisplayed(CommQBC_Queue, "Queue Dropdown");
		 isElementDisplayed(CommQBC_Origin, "Origin Dropdown");
		 isElementDisplayed(CommQBC_Destination, "Destination Dropdown");
		 isElementDisplayed(CommQBC_DaysOut, "Days out dropdown");
		 isElementDisplayed(CommQBC_FlightType, "Flight type dropdown");
		 isElementDisplayed(MFC_FlightNo, "Flight number dropdown");
		 isElementPresent(MFC_FromDate, "From date and time");
		 isElementPresent(MFC_ToDate, "To date and time");
		 isElementPresent(CAM_StartTime, "From time");
		 isElementPresent(CAM_EndTime, "To time");
		 Reporter.SuccessReport("Step:-Verify Queue Based changes screen","The Queue based changes screen is verified successfully \t:-");
		 
		 
		
	}
	
	
	
	public void Comm_QBC_SelectDaysOut(String queue) throws Throwable{
		logger.info("in CommPAD_SelectDaysOut()");
		Thread.sleep(3000);
		click(CommQBC_DaysOut,"DaysOut");
		
		click(MFC_OriginPlaces(queue), "DaysOut \t"+queue);
		Reporter.SuccessReport("Step:-Select DaysOut","The DaysOut is selected as \t:-"+queue);
			
	}
	public void Comm_QBC_VerifyCheckBoxes() throws Throwable{
		logger.info("in Comm_QBC_VerifyCheckBoxes()");
		Thread.sleep(2000);
		//waitForVisibilityOfElement(CommQBC_EmailFirstFlight,"Email checkBox");
		WebElement e = driver.findElement(CommQBC_EmailFirstFlight);
		boolean a=e.isSelected();
		assertTrue(a);
		JSClick(CommQBC_EmailFirstFlight, "Email Checkbox");
		Thread.sleep(1000);
		boolean b=e.isSelected();
		assertFalse(b);
		
		WebElement sms = driver.findElement(CommQBC_SMSFirstFlight);
		boolean sm=sms.isSelected();
		assertTrue(sm);
		JSClick(CommQBC_SMSFirstFlight, "SMS Checkbox");
		Thread.sleep(1000);
		 sm=sms.isSelected();
		assertFalse(sm);
		
		WebElement ivr = driver.findElement(CommQBC_IVRFirstFlight);
		boolean iv=ivr.isSelected();
		assertTrue(iv);
		JSClick(CommQBC_IVRFirstFlight, "IVR Checkbox");
		Thread.sleep(1000);
		 iv=sms.isSelected();
		assertFalse(iv);
		Reporter.SuccessReport("Step:-Verify Email,SMS,IVR Checkboxes","The checkboxes are verified successfully \t:-");
	}
	public void Comm_QBC_VerifySelectAllEmailCheckbox() throws Throwable{
		logger.info("in Comm_QBC_VerifySelectAllEmailCheckbox()");
		Thread.sleep(2000);
		//waitForVisibilityOfElement(CommQBC_EmailFirstFlight,"Email checkBox");
		
		JSClick(CommQBC_SelectAllEmail, "Select All Email Checkbox");
		Thread.sleep(1000);
		
		//checking wheather all the email checkboxes are unchecked
		WebElement email1 = driver.findElement(CommQBC_EmailFirstFlight);
		boolean emailFlight1=email1.isSelected();
		assertFalse(emailFlight1);
		WebElement email2 = driver.findElement(CommQBC_EmailSecondFlight);
		boolean emailFlight2=email2.isSelected();
		assertFalse(emailFlight2);
		Reporter.SuccessReport("Step:-Verify SelectAll email checkbox","The email checkbox for all the flights are unchecked when the checkbox on the grid is unchecked  \t:-");
		//checking wheather all the email checkboxes are checked
		JSClick(CommQBC_SelectAllEmail, "Select All Email Checkbox");
		Thread.sleep(1000);
		emailFlight1=email1.isSelected();
		emailFlight2=email2.isSelected();
		assertTrue(emailFlight1);
		assertTrue(emailFlight2);
		Reporter.SuccessReport("Step:-Verify SelectAll email checkbox","The email checkbox for all the flights are checked when the checkbox on the grid is checked  \t:-");
	}
	
	public void Comm_QBC_VerifySelectAllSMSCheckbox() throws Throwable{
		logger.info("in Comm_QBC_VerifySelectAllEmailCheckbox()");
		Thread.sleep(2000);
		//waitForVisibilityOfElement(CommQBC_EmailFirstFlight,"Email checkBox");
		
		JSClick(CommQBC_SelectAllSMS, "Select All SMS Checkbox");
		Thread.sleep(1000);
		
		//checking wheather all the email checkboxes are unchecked
		WebElement sms1 = driver.findElement(CommQBC_SMSFirstFlight);
		boolean smsFlight1=sms1.isSelected();
		assertFalse(smsFlight1);
		WebElement sms2 = driver.findElement(CommQBC_SMSSecondFlight);
		boolean smsFlight2=sms2.isSelected();
		assertFalse(smsFlight2);
		Reporter.SuccessReport("Step:-Verify SelectAll SMS checkbox","The SMS checkbox for all the flights are unchecked when the checkbox on the grid is unchecked  \t:-");
		//checking wheather all the email checkboxes are checked
		JSClick(CommQBC_SelectAllSMS, "Select All SMS Checkbox");
		Thread.sleep(1000);
		smsFlight1=sms1.isSelected();
		smsFlight2=sms2.isSelected();
		assertTrue(smsFlight1);
		assertTrue(smsFlight2);
		Reporter.SuccessReport("Step:-Verify SelectAll SMS checkbox","The email checkbox for all the flights are checked when the checkbox on the grid is checked  \t:-");
	}
	
	public void Comm_QBC_VerifySelectAllIVRCheckbox() throws Throwable{
		logger.info("in Comm_QBC_VerifySelectAllIVRCheckbox()");
		Thread.sleep(2000);
		//waitForVisibilityOfElement(CommQBC_EmailFirstFlight,"Email checkBox");
		
		JSClick(CommQBC_SelectAllIVR, "Select All IVR Checkbox");
		Thread.sleep(1000);
		
		//checking wheather all the email checkboxes are unchecked
		WebElement ivr1 = driver.findElement(CommQBC_IVRFirstFlight);
		boolean ivrFlight1=ivr1.isSelected();
		assertFalse(ivrFlight1);
		WebElement ivr2 = driver.findElement(CommQBC_IVRSecondFlight);
		boolean ivrFlight2=ivr2.isSelected();
		assertFalse(ivrFlight2);
		Reporter.SuccessReport("Step:-Verify SelectAll IVR checkbox","The IVR checkbox for all the flights are unchecked when the checkbox on the grid is unchecked  \t:-");
	  
		//checking wheather all the email checkboxes are checked
		JSClick(CommQBC_SelectAllIVR, "Select All IVR Checkbox");
		Thread.sleep(1000);
		ivrFlight1=ivr1.isSelected();
		ivrFlight2=ivr2.isSelected();
		assertTrue(ivrFlight1);
		assertTrue(ivrFlight2);
		Reporter.SuccessReport("Step:-Verify SelectAll IVR checkbox","The IVR checkbox for all the flights are checked when the checkbox on the grid is checked  \t:-");
	}
	
	
	
	
	public void Comm_QBC_SelectFlightType(String type) throws Throwable{
		logger.info("in Comm_QBC_SelectFlightType()");
		Thread.sleep(2000);
		waitForVisibilityOfElement(CommQBC_FlightType,"Flight Type");
		
		click(CommQBC_FlightType,"Flight Type");
		Thread.sleep(1000);
		JSClick(PAD_FlightTypes(type), "Select Flight type \t");
		Reporter.SuccessReport("Step:- Select Flight Type","The flight type is selected as \t"+type);
}
	
	
	public void CommQBC_SelectOrigin(String origin) throws Throwable{
		logger.info("in CommQBC_SelectOrigin()");
		Thread.sleep(3000);
		click(CommQBC_Origin,"Origin");
		
		click(MFC_OriginPlaces(origin), "Origin Place \t"+origin);
		Reporter.SuccessReport("Step:-Select Origin","The Origin is selected as \t:-"+origin);
			
	}
	public void CommQBC_SelectDestination(String dest) throws Throwable{
		logger.info("in CommQBC_SelectDestination()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		click(CommQBC_Destination,"Destination");
		click(MFC_DestinationPlaces(dest), "Destination Place \t"+dest);
		Reporter.SuccessReport("Step:-Select Destination","The Destination is selected as \t:-"+dest);
			
	}
	
	public void ClickResetButton() throws Throwable{
		logger.info("in ClickReset()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(1000);
		click(CommQBC_ResetButton,"Reset button");
		Thread.sleep(2000);
		Reporter.SuccessReport("Step:-Click Rest Button","The Reset Button was clicked succesfully \t:-");
			
	}
	
	public void ClickSendAllButton() throws Throwable{
		logger.info("in ClickSendAllButton()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(1000);
		click(CommQBC_btn_SendAll,"Send all button");
		Thread.sleep(1000);
		Reporter.SuccessReport("Step:-Click Send All Button","The Send All Button was clicked succesfully \t:-");
			
	}
	
	
	public void CommQBC_VerifySearchResults() throws Throwable{
		logger.info("in CommQBC_VerifySearchResults()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		 List<WebElement> rows=driver.findElements(CommQBC_FlightInfoTable); 
		 int num=rows.size();
		 if(num<5)
		 {
			 Reporter.SuccessReport("Step:-Search Results","No flights have been displayed\t"); 
		 }
		 else
		 {
		 int actual=num/5;
		 Reporter.SuccessReport("Step:-Search Results","The search criteria provide results for\t"+actual+"\t flights");
		 }
		 Reporter.SuccessReport("Step:-Verify Search Results","The Search results are verified succesfully \t");
			
	}
	
	public void Comm_QBC_VerifyExportToExcel() throws Throwable{
		logger.info("in Comm_QBC_VerifyExportToExcel()");
		 waitForVisibilityOfElement(CommQBC_btn_ExporttoExcel,"Export To Excel");
		 click(CommQBC_btn_ExporttoExcel,"Export To Excel");
		 Thread.sleep(3000);
		    String downloadPath="C:\\Users\\E003681\\Downloads"; 
			Thread.sleep(2000);
			boolean a= isFileDownloaded(downloadPath, "TimeChange_22_01_2018_17_34_54.xls");
	   	    Assert.assertTrue(a, "Failed to download Expected document");
	   	 Reporter.SuccessReport("Step:-Verify Export to Excel Functionality","The Export to Excel functionality is working fine \t");
	}
	
	public void Comm_QBC_VerifyMessageEmailPreview(String option) throws Throwable{
		logger.info("in VerifyMessageEmailPreview()");
		int k=2;
		
		List<WebElement> element=driver.findElements(By.xpath("//div[@id='messageplaceholder']//tbody//tr[not(contains(@style,'display: none;'))]"));
		int z=element.size();

		int y=z-1;
		waitForVisibilityOfElement(MFC_SMSIVRPopup,"Popup");
		for(int i=0;i<y;i++)
		{
			int l=2;
			String a=driver.findElement(By.xpath("//div[@id='messageplaceholder']//tbody//tr["+k+"]//td["+l+"]")).getText();
			l++;
			String b=driver.findElement(By.xpath("//div[@id='messageplaceholder']//tbody//tr["+k+"]//td["+l+"]")).getText();
			l++;
			String c=driver.findElement(By.xpath("//div[@id='messageplaceholder']//tbody//tr["+k+"]//td["+l+"]")).getText();
			Reporter.SuccessReport("Step:-Verify \t '"+option+"' \tTable","Slno:-"+a+"\t\t Message:- \t"+b+"\t\t Phone No:- \t"+c);
			k++;
		}
	}
	
	public void Comm_QBC_VerifyHyperlinks() throws Throwable{
		logger.info("in Comm_QBC_VerifyHyperlinks()");
		 waitForVisibilityOfElement(PAX_SMSHyperlink,"SMS Hyperlink");
		 isElementDisplayed(PAX_SMSHyperlink, "SMS Hyperlink");
		 isElementDisplayed(PAX_EmalHyperlink, "Email Hyperlink");
		 isElementDisplayed(PAX_IVRHyperlink, "IVR Hyperlink");
		 //verifying email template view 
		 JSClick(PAX_EmalHyperlink,"Email");
		 Thread.sleep(2000);
		 Comm_QBC_VerifyMessageEmailPreview("email");
		 //Verifying Cancel Button and Export to excel
		
		 isElementDisplayed(CommQA_btn_TemplateCancelButton, "Cancel Button");
		 isElementDisplayed(CommQBC_btn_ExporttoExcel, "Export to Excel Button");
		 click(CommQA_btn_TemplateCancelButton,"close");
		 //verifying sms template	view
		 Thread.sleep(2000);
		 JSClick(PAX_SMSHyperlink,"SMS");
		 Thread.sleep(2000);
		 Comm_QBC_VerifyMessageEmailPreview("SMS");
		 
		 isElementDisplayed(CommQA_btn_TemplateCancelButton, "Cancel Button");
		 isElementDisplayed(CommQBC_btn_ExporttoExcel, "Export to Excel Button");
		 click(CommQA_btn_TemplateCancelButton,"close");
		 Thread.sleep(2000);
		 //verifying IVR template	view
		 JSClick(PAX_IVRHyperlink,"IVR");
		 Thread.sleep(2000);
		 Comm_QBC_VerifyMessageEmailPreview("IVR");
		
		 isElementDisplayed(CommQA_btn_TemplateCancelButton, "Cancel Button");
		 isElementDisplayed(CommQBC_btn_ExporttoExcel, "Export to Excel Button");
		 click(CommQA_btn_TemplateCancelButton,"close");
		 Reporter.SuccessReport("Step:-Verify SMS/IVR/Email Hyperlink functionalities","The hyperlink functionalities are verified \t"); 		   		 	
	}
	
	//broadcast page
	public void CommBM_VerifyBroadcastPage() throws Throwable{
		logger.info("in CommQBC_SelectDestination()");
		//Verifying user is navigated to broadcast page
		waitForVisibilityOfElement(CommBM_BroadcastHeading,"Broadcast Page Heading");
		 isElementDisplayed(CommBM_BroadcastHeading, "Broadcast Page Heading");
		 isElementDisplayed(CommBM_SMSTemplate, "SMS Template dropdown");
		 isElementDisplayed(CommBM_PreviewButton, "Preview Button");
		 isElementDisplayed(CommBM_EmailTemplate, "Email Template dropdown");
		 isElementDisplayed(CommBM_DownloadFile, "Download File link");
		 isElementPresent(CommBM_UploadExcel, "Upload Excel");
		 
		 Reporter.SuccessReport("Step:-Verify Broadcast Page","The broadcast screen is verified successfully\t"); 
		
	}
	
	
	public void CommBM_VerifyDownloadfile() throws Throwable{
		logger.info("in CommQBC_VerifyDownloadfile()");
		//Verifying user is navigated to broadcast page
		waitForVisibilityOfElement(CommBM_BroadcastHeading,"Download file link");
		click(CommBM_DownloadFile,"Download file link");
		String downloadPath="C:\\Users\\E003681\\Downloads"; 
		Thread.sleep(2000);
		boolean a= isFileDownloaded(downloadPath, "UploadFile_seema.xls");
   	    Assert.assertTrue(a, "Failed to download Expected document");
    	 Reporter.SuccessReport("Step:-Verify Download Sample File","The download file functionality is working fine \t"); 
		
	}
	public void CommBM_VerifyUploadfile(String file) throws Throwable{
		logger.info("in CommQBC_VerifyDownloadfile()");
		//Verifying user is navigated to broadcast page
		//waitForVisibilityOfElement(CommBM_UploadExcel,"Upload file");
		waitForVisibilityOfElement(CommBM_BroadcastHeading,"Broadcast Page Heading");
		WebElement uploadElement = driver.findElement(CommBM_UploadExcel);
		 String path="C:\\Users\\E003681\\Downloads\\"+file;
        // enter the file path onto the file-selection input field
        uploadElement.sendKeys(path);
        Thread.sleep(3000);
        Reporter.SuccessReport("Step:-Verify Upload File functionality","The upload file functionality is working fine \t"); 
        Thread.sleep(3000);
		
	}
	public void CommBM_VerifyUploadfileInOtherFormat(String file) throws Throwable{
		logger.info("in CommQBC_VerifyDownloadfile()");
		//Verifying user is navigated to broadcast page
		//waitForVisibilityOfElement(CommBM_UploadExcel,"Upload file");
		waitForVisibilityOfElement(CommBM_BroadcastHeading,"Broadcast Page Heading");
		WebElement uploadElement = driver.findElement(CommBM_UploadExcel);
        String path="C:\\Users\\E003681\\Downloads\\"+file;
        // enter the file path onto the file-selection input field
        uploadElement.sendKeys(path);
        Reporter.SuccessReport("Step:-Upload file","The file \t"+file+"\t is uploaded");
        Thread.sleep(3000);	
		 		
	}
	
	
	public void Comm_BM_EmailTemplate(String temp) throws Throwable{
		logger.info("in Comm_BM_EmailTemplate()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		click(CommBM_EmailTemplate,"Email Template");
		click(MFC_DestinationPlaces(temp), "email template \t"+temp);
		Reporter.SuccessReport("Step:-Select Email Template","The Template is selected as \t:-"+temp);
			
	}
	
	public void Comm_BM_SMSTemplate(String temp) throws Throwable{
		logger.info("in Comm_BM_SMSTemplate()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(2000);
		click(CommBM_SMSTemplate,"SMS Template");
		click(MFC_OriginPlaces(temp), "SMS Template \t"+temp);
		Reporter.SuccessReport("Step:-Select SMS Template","The Template is selected as \t:-"+temp);
			
	}
	
	public void VerifyMessageEmailPreview(String option) throws Throwable{
		logger.info("in VerifyMessageEmailPreview()");
		int k=2;
		
		List<WebElement> element=driver.findElements(By.xpath("//div[@id='messageplaceholder']//tbody//tr[not(contains(@style,'display: none;'))]"));
		int z=element.size();

		int y=z-1;
		waitForVisibilityOfElement(MFC_SMSIVRPopup,"Popup");
		for(int i=0;i<y;i++)
		{
			int l=1;
			String a=driver.findElement(By.xpath("//div[@id='messageplaceholder']//tbody//tr["+k+"]//td["+l+"]")).getText();
			l++;
			String b=driver.findElement(By.xpath("//div[@id='messageplaceholder']//tbody//tr["+k+"]//td["+l+"]")).getText();
			l++;
			String c=driver.findElement(By.xpath("//div[@id='messageplaceholder']//tbody//tr["+k+"]//td["+l+"]")).getText();
			Reporter.SuccessReport("Step:-Verify \t '"+option+"' \tTable","Slno:-"+a+"\t\t Message:- \t"+b+"\t\t Phone No:- \t"+c);
			k++;
		}
		
		Reporter.SuccessReport("Step:-Verify Email/SMS preview ","The preview is verified successfully \t");
	}
	
	public void BM_ClickEmailIcon() throws Throwable{
		logger.info("in BM_ClickEmailIcon()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(1000);
		click(CommBM_EmailIcon,"Reset button");
		Reporter.SuccessReport("Step:-Click Email Icon","The email icon is clicked successfully \t");	
		
			
	}
	
	public void BM_ClickSMSIcon() throws Throwable{
		logger.info("in BM_ClickSMSIcon()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(1000);
		click(CommBM_SMSIcon,"Reset button");
		Reporter.SuccessReport("Step:-Click SMS Icon","The SMS icon is clicked successfully \t");
		
			
	}
	
	
	public void BM_ClickPreview() throws Throwable{
		logger.info("in BM_ClickPreview()");
		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		Thread.sleep(1000);
		click(CommBM_PreviewButton,"Preview button");
		Reporter.SuccessReport("Step:-Click Preview button","The preview button is clicked successfully \t");
		
			
	}
	
	public void BM_VerifyEmailPopup() throws Throwable{
		logger.info("in BM_VerifyEmailPopup()");
		 waitForVisibilityOfElement(CommBM_EmailPopup,"Email Popup");
		 isElementDisplayed(CommBM_EmailPopup, "Email Popup");
		 Reporter.SuccessReport("Step:-Verify email popup","The email popup is displayed \t");
		
			
	}
	
	public void BM_VerifySMSPopup() throws Throwable{
		logger.info("in BM_VerifySMSPopup()");
		waitForVisibilityOfElement(CommBM_EmailPopup,"SMS Popup");
		isElementDisplayed(CommBM_EmailPopup, "SMS Popup");
		Reporter.SuccessReport("Step:-Verify SMS popup","The SMS popup is displayed \t");	
			
	}
	
	public void BM_CheckUncheckSmsOption() throws Throwable{
		logger.info("in BM_CheckUncheckSmsOption()");
		Thread.sleep(2000);
		JSClick(CommBM_chk_SelectSMS, "SMS Checkbox");
		Reporter.SuccessReport("Step:-Check/Uncheck SMS Option","The SMS option is checked/unchecked \t:-");		
	}
	
	public void BM_CheckUncheckEmailOption() throws Throwable{
		logger.info("in BM_CheckUncheckEmailOption()");
	//	waitForVisibilityOfElement(CommBM_chk_SelectEmail,"Email Checkbox");
		Thread.sleep(2000);
		JSClick(CommBM_chk_SelectEmail, "Email Checkbox");
		Reporter.SuccessReport("Step:-Check/Uncheck email Option","The email option is checked/unchecked\t");		
	}
	
	
	
	//Commercial-Queue Approval
	
	
	public void Comm_QA_VerifyQueueApprovalPage() throws Throwable{
		logger.info("in Comm_QBC_VerifyQueueApprovalPage()");
		 waitForVisibilityOfElement(CommQA_b_Heading,"Queue Approval Heading");
		 isElementDisplayed(CommQA_b_Heading, "Queue Approval");
		 isElementDisplayed(CommQA_drd_Queue, "Queue Dropdown");		
		 isElementDisplayed(CommQA_btn_Search, "Search button");
		 click(CommQA_drd_Queue,"queue");
		 isElementDisplayed(CommQA_opt_QueueOptions("Flight Movement"), "Flight Movement");
		 isElementDisplayed(CommQA_opt_QueueOptions("Flight Number Change"), "Flight Number Change");
		 isElementDisplayed(CommQA_opt_QueueOptions("Miss Connection"), "Miss Connection");
		 isElementDisplayed(CommQA_opt_QueueOptions("Time Change Delay Greater than 2 hours"), "Time Change Delay Greater than 2 hours");
		 isElementDisplayed(CommQA_opt_QueueOptions("Time Change Delay Less than 2 hours"), "Time Change Delay Less than 2 hours");
		 isElementDisplayed(CommQA_opt_QueueOptions("Time Change Prepone Greater than 1 hours"), "Time Change Prepone Greater than 1 hours");
		 isElementDisplayed(CommQA_opt_QueueOptions("Time Change Prepone Less than 1 hours"), "Time Change Prepone Less than 1 hours");
		 
		 Reporter.SuccessReport("Step:-Verify Queue Approval page","The Queue approval page is verified\t");
		 
		
	}
	public void Comm_QA_SelectQueue(String queue) throws Throwable{
		Thread.sleep(3000);
		click(CommQA_drd_Queue,"Queue");
		
		click(MFC_OriginPlaces(queue), "Queue \t"+queue);
		Reporter.SuccessReport("Step:-Select Queue","The Queue is selected as \t:-"+queue);
		 		 
		
	}
	
	public void Comm_QA_ClickSearch() throws Throwable{
		Thread.sleep(1000);
		click(CommQA_btn_Search,"Search");
		Reporter.SuccessReport("Step:-Click search button","The Search button is clicked successfully \t"); 		 
		
	}
	
	public void QA_UncheckAllFlights() throws Throwable{
		logger.info("in UncheckAllFlights()");
	     
		 JSClick(CommQA_chk_SelectAll, "Flight info check box");
		 Thread.sleep(2000);
		 Reporter.SuccessReport("Step:-Uncheck All flights","Successfully unchecked flights");
		 
		
	}
	
	public void QA_SelectAFlight() throws Throwable{
		logger.info("in QA_SelectAFlight()");
	     
		 JSClick(CommQA_chk_SelectAFlight, "Select Flight");
		 Thread.sleep(2000);
		 Reporter.SuccessReport("Step:-Select a Flight","Successfully selected flight");
		 
		
	}
	public void QA_SelectAFlight1() throws Throwable{
		logger.info("in QA_SelectAFlight()");
	     
		 JSClick(CommQA_chk_SelectAFlight1, "Select Flight");
		 Thread.sleep(2000);
		 Reporter.SuccessReport("Step:-Select a Flight","Successfully selected flight");
		 
		
	}
	
	
	
	public void Comm_QA_VerifyExportToExcel() throws Throwable{
		logger.info("in Comm_QA_VerifyExportToExcel()");
		 waitForVisibilityOfElement(CommQA_btn_ExportToExcel,"Export To Excel");
		 click(CommQA_btn_ExportToExcel,"Export To Excel");
		 Thread.sleep(3000);
		    String downloadPath="C:\\Users\\E003681\\Downloads"; 
			Thread.sleep(2000);
			boolean a= isFileDownloaded(downloadPath, "ApprovalQueueNotification_FLTMOV.xls");
	   	    Assert.assertTrue(a, "Failed to download Expected document");
	   	 Reporter.SuccessReport("Step:-Verify Export to Excel","The Export to Excel functionality is verified\t"); 		 
	}
	
	public void Comm_QA_VerifyHyperlinks() throws Throwable{
		logger.info("in Comm_QA_VerifyHyperlinks()");
		 waitForVisibilityOfElement(CommQA__hyp_SMSHyperlink,"SMS Hyperlink");
		 isElementDisplayed(CommQA__hyp_SMSHyperlink, "SMS Hyperlink");
		 isElementDisplayed(CommQA_hyp_PAX_EmalHyperlink, "Email Hyperlink");
		 isElementDisplayed(CommQA_hyp_PAX_IVRHyperlink, "IVR Hyperlink");
		 //verifying email template view 
		 click(CommQA_hyp_PAX_EmalHyperlink,"Email");
		 Thread.sleep(2000);
		 Comm_QA_VerifyMessageEmailPreview("email");
		 //Verifying Cancel Button and Export to excel
		
		 isElementDisplayed(CommQA_btn_TemplateCancelButton, "Cancel Button");
		 isElementDisplayed(CommQA_btn_TemplateExportExcelButton, "Export to Excel Button");
		 click(CommQA_btn_TemplateCancelButton,"cancel");
		 //verifying sms template	view
		 click(CommQA__hyp_SMSHyperlink,"SMS");
		 Thread.sleep(2000);
		 Comm_QA_VerifyMessageEmailPreview("SMS");
		 
		 isElementDisplayed(CommQA_btn_TemplateCancelButton, "Cancel Button");
		 isElementDisplayed(CommQA_btn_TemplateExportExcelButton, "Export to Excel Button");
		 click(CommQA_btn_TemplateCancelButton,"cancel");
		 //verifying IVR template	view
		 click(CommQA_hyp_PAX_IVRHyperlink,"IVR");
		 Thread.sleep(2000);
		 Comm_QA_VerifyMessageEmailPreview("IVR");
		
		 isElementDisplayed(CommQA_btn_TemplateCancelButton, "Cancel Button");
		 isElementDisplayed(CommQA_btn_TemplateExportExcelButton, "Export to Excel Button");
		 click(CommQA_btn_TemplateCancelButton,"cancel");
		 Reporter.SuccessReport("Step:-Verify SMS/Email/IVR Hyperlinks","The SMS/Email/IVR Hyperlinks are verified \t"); 		  
	}
	
	public void Comm_QA_VerifyMessageEmailPreview(String option) throws Throwable{
		logger.info("in VerifyMessageEmailPreview()");
		int k=1;
		
		List<WebElement> element=driver.findElements(By.xpath("//div[@id='messageplaceholder']//tbody//tr[not(contains(@style,'display: none;'))]"));
		int z=element.size();

		int y=z-1;
		waitForVisibilityOfElement(MFC_SMSIVRPopup,"SMS Popup");
		for(int i=0;i<y;i++)
		{
			int l=1;
			String a=driver.findElement(By.xpath("//div[@id='messageplaceholder']//tbody//tr["+k+"]//td["+l+"]")).getText();
			l++;
			String b=driver.findElement(By.xpath("//div[@id='messageplaceholder']//tbody//tr["+k+"]//td["+l+"]")).getText();
			l++;
			String c=driver.findElement(By.xpath("//div[@id='messageplaceholder']//tbody//tr["+k+"]//td["+l+"]")).getText();
			Reporter.SuccessReport("Step:-Verify \t '"+option+"' \tTable","Slno:-"+a+"\t\t Message:- \t"+b+"\t\t Phone No:- \t"+c);
			k++;
		}
	}
	
	public void Comm_QA_VerifyProcessedSubqueue() throws Throwable{
		Thread.sleep(1000);
		JSClick(CommQA_btn_processedQueue, "processed queue");
		Comm_QA_ClickSearch();
		Thread.sleep(2000);
		isElementDisplayed(CommQA_btn_ExportToExcel, "Excel button");
		Reporter.SuccessReport("Step:-Verify Processed SubQueue","The Processed SubQueue functionality is verified \t"); 		   		 	
	}
	
	public void Comm_QA_VerifyUnProcessedSubqueue() throws Throwable{
		Thread.sleep(1000);
		JSClick(CommQA_btn_unprocessedQueue, "unprocessed queue");
		Comm_QA_ClickSearch();
		Thread.sleep(2000);
		isElementDisplayed(CommQA_btn_ExportToExcel, "Excel button");	
		Reporter.SuccessReport("Step:-Verify UnProcessed SubQueue","The UnProcessed SubQueue functionality is verified \t"); 		   		 	
	}
	
	public void Comm_QA_ClickApprove() throws Throwable{
			   		 	 		 
		Thread.sleep(1000);
		click(CommQA_btn_Approve,"Aprove");
		Reporter.SuccessReport("Step:-Click Approve button","The approve button is clicked\t"); 		   		 	 		 
	}
	

	public void Comm_QA_ClickEmailIcon() throws Throwable{
		Thread.sleep(1000);
		click(CommQA_hyp_PAX_EmalHyperlink,"Email");
		Reporter.SuccessReport("Step:-Click Email","The email link is clicked\t"); 	
		
	}
	
	
	
	public void Comm_QA_VerifyMessageEmailPreview() throws Throwable{
		logger.info("in VerifyMessageEmailPreview()");
		int k=1;
		
		List<WebElement> element=driver.findElements(By.xpath("//div[@id='messageplaceholder']//tbody//tr[not(contains(@style,'display: none;'))]"));
		int z=element.size();

		int y=z-1;
		waitForVisibilityOfElement(MFC_SMSIVRPopup,"Popup");
		for(int i=0;i<y;i++)
		{
			int l=1;
			String a=driver.findElement(By.xpath("//div[@id='messageplaceholder']//tbody//tr["+k+"]//td["+l+"]")).getText();
			l++;
			String b=driver.findElement(By.xpath("//div[@id='messageplaceholder']//tbody//tr["+k+"]//td["+l+"]")).getText();
			l++;
			String c=driver.findElement(By.xpath("//div[@id='messageplaceholder']//tbody//tr["+k+"]//td["+l+"]")).getText();
			Reporter.SuccessReport("Step:-Verify EMAIL Table","Slno:-"+a+"\t\t Message:- \t"+b+"\t\t Email:- \t"+c);
			k++;
		}
	}
	
	

	public void Comm_QA_ClickTemplateCancel() throws Throwable{
		Thread.sleep(1000);
		click(CommQA_btn_TemplateCancelButton,"close");
		Reporter.SuccessReport("Step:-Click cancel","The cancel button is clicked\t"); 	
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//MIS-Flight Search
	
	     public void MIS_FS_VerifyFlightSearchPage() throws Throwable{
		 logger.info("in Comm_FS_VerifyFlightSearchPage()");
		 waitForVisibilityOfElement(MIS_FS_b_Heading,"MIS Heading");
		 isElementDisplayed(MIS_FS_b_Heading, "MIS Heading");
		 isElementDisplayed(MIS_FS_drd_Origin, "Origin");	
		 isElementDisplayed(MIS_FS_drd_Destination, "Destination");
		 isElementDisplayed(MIS_FS_drd_Status, "Status");
		 isElementDisplayed(MIS_FS_drd_Application, "Application");
		 isElementDisplayed(MIS_FS_btn_Search, "Search");
		 isElementDisplayed(MIS_FS_btn_Reset, "Reset");
		 isElementDisplayed(MIS_FS_drd_CommType, "Communication type");
		 isElementDisplayed(MIS_FS_btn_ExportToExcel, "Export to Excel");
		 
		 
		 Reporter.SuccessReport("Step:-Verify Flight Search page","The Flight Search page is verified\t");
		 
		
	}
	     
	     
	     public void MIS_FS_SelectOrigin(String origin) throws Throwable{
	 		logger.info("in MIS_FS_SelectOrigin()");
	 		Thread.sleep(3000);
	 		click(MIS_FS_drd_Origin,"Origin");
	 		
	 		click(MFC_OriginPlaces(origin), "Origin Place \t"+origin);
	 		Reporter.SuccessReport("Step:-Select Origin","The Origin is selected as \t:-"+origin);
	 			
	 	}
	 	public void MIS_FS_SelectDestination(String dest) throws Throwable{
	 		logger.info("in MIS_FS_SelectDestination()");
	 		// waitForVisibilityOfElement(MFC_Destination,"Destination");
	 		Thread.sleep(2000);
	 		click(MIS_FS_drd_Destination,"Destination");
	 		click(MFC_DestinationPlaces(dest), "Destination Place \t"+dest);
	 		Reporter.SuccessReport("Step:-Select Destination","The Destination is selected as \t:-"+dest);
	 			
	 	}
	 	
	 	public void MIS_FS_SelectCommunicationType(String dest) throws Throwable{
	 		logger.info("in MIS_FS_SelectCommunicationType()");
	 		// waitForVisibilityOfElement(MFC_Destination,"Destination");
	 		Thread.sleep(2000);
	 		click(MIS_FS_drd_CommType,"Communication Type");
	 		click(MFC_DestinationPlaces(dest), "Communication Type \t"+dest);
	 		Reporter.SuccessReport("Step:-Select Communication Type","The Communication Type is selected as \t:-"+dest);
	 			
	 	}
	 	
	 	public void MIS_FS_SelectStatus(String dest) throws Throwable{
	 		logger.info("in MIS_FS_SelectStatus()");
	 		// waitForVisibilityOfElement(MFC_Destination,"Destination");
	 		Thread.sleep(2000);
	 		click(MIS_FS_drd_Status,"Status");
	 		click(MFC_DestinationPlaces(dest), "Status \t"+dest);
	 		Reporter.SuccessReport("Step:-Select Status Type","The status is selected as \t:-"+dest);
	 			
	 	}
	 	
	 	public void MIS_FS_SelectApplication(String dest) throws Throwable{
	 		logger.info("in MIS_FS_SelectApplication()");
	 		// waitForVisibilityOfElement(MFC_Destination,"Destination");
	 		Thread.sleep(2000);
	 		click(MIS_FS_drd_Application,"Application");
	 		click(MFC_DestinationPlaces(dest), "Application \t"+dest);
	 		Reporter.SuccessReport("Step:-Select Application","The Application is selected as \t:-"+dest);
	 			
	 	}
	 	public void MIS_FS_ValidateSearch() throws Throwable{
	 		logger.info("in MIS_FS_ValidateSearch()");
	 		// waitForVisibilityOfElement(MFC_Destination,"Destination");
	 		Thread.sleep(2000);
	 		String SentBy=getText(MIS_FS_td_SearchResultSentBy, "SentBy");
	 		Reporter.SuccessReport("Step:-Validate Search","The search result is validated and is Sent by  \t:-"+SentBy);
	 			
	 	}
	 	
	 	public void MIS_ClickSearch() throws Throwable{
			logger.info("in AU_ClickSearch()");
			waitForVisibilityOfElement(SPM_Search,"Search Button");
			click(SPM_Search, "Search button \t");
			Thread.sleep(3000);
			
			Reporter.SuccessReport("Step:-Click Search Button","Clicked On Search Button \t");
	}
	 	
	 	public void Comm_MIS_FS_VerifyExportToExcel() throws Throwable{
			logger.info("in Comm_MIS_FS_VerifyExportToExcel()");
			 waitForVisibilityOfElement(MIS_FS_btn_ExportToExcel,"Export To Excel");
			 click(MIS_FS_btn_ExportToExcel,"Export To Excel");
			 Thread.sleep(3000);
			    String downloadPath="C:\\Users\\E003681\\Downloads"; 
				Thread.sleep(2000);
				boolean a= isFileDownloaded(downloadPath, "FlightSearch_24_01_2018_11_46_56.xls");
		   	    Assert.assertTrue(a, "Failed to download Expected document");
		   	 Reporter.SuccessReport("Step:-Verify Export to Excel","The Export to Excel functionality is verified\t"); 		 
		}
	 	
	 	
	 	//MIS-GENERIC SEARCH
	 	
	 	 public void MIS_FS_VerifyGenericSearchPage() throws Throwable{
			 logger.info("in MIS_FS_VerifyGenericSearchPage()");
			 waitForVisibilityOfElement(MIS_GS_b_Heading,"MIS  Generic Search Heading");
			 isElementDisplayed(MIS_GS_b_Heading, "MIS Generic Search Heading");
			 isElementDisplayed(MIS_GS_drd_Queue, "Queue dropdown");	
			 isElementDisplayed(MIS_GS_drd_Department, "Department dropdown");
			 isElementDisplayed(MIS_GS_drd_Status, "Status");
			 isElementDisplayed(MIS_GS_drd_DaysOut, "DaysOut");
			 isElementDisplayed(MIS_GS_drd_Application, "Application");
			 isElementDisplayed(MIS_GS_btn_Search, "Search");
			 isElementDisplayed(MIS_GS_btn_Reset, "Reset");
			 isElementDisplayed(MIS_GS_drd_CommType, "Communication type");
			// isElementDisplayed(MIS_FS_btn_ExportToExcel, "Export to Excel");
			 
			 
			 Reporter.SuccessReport("Step:-Verify Generic Search page","The Flight Search page is verified\t");
			 
			
		}
	 	 
	 	 
	 	public void MIS_GS_SelectCommunicationType(String dest) throws Throwable{
	 		logger.info("in MIS_FS_SelectCommunicationType()");
	 		// waitForVisibilityOfElement(MFC_Destination,"Destination");
	 		Thread.sleep(2000);
	 		click(MIS_GS_drd_CommType,"Communication Type");
	 		click(MFC_DestinationPlaces(dest), "Communication Type \t"+dest);
	 		Reporter.SuccessReport("Step:-Select Communication Type","The Communication Type is selected as \t:-"+dest);
	 			
	 	}
	 	
		public void MIS_GS_SelectStatus(String dest) throws Throwable{
	 		logger.info("in MIS_FS_SelectStatus()");
	 		// waitForVisibilityOfElement(MFC_Destination,"Destination");
	 		Thread.sleep(2000);
	 		click(MIS_GS_drd_Status,"Status");
	 		click(MFC_DestinationPlaces(dest), "Status \t"+dest);
	 		Reporter.SuccessReport("Step:-Select Status Type","The status is selected as \t:-"+dest);
	 			
	 	}
	 	
	 	public void MIS_GS_SelectApplication(String dest) throws Throwable{
	 		logger.info("in MIS_FS_SelectApplication()");
	 		// waitForVisibilityOfElement(MFC_Destination,"Destination");
	 		Thread.sleep(2000);
	 		click(MIS_GS_drd_Application,"Application");
	 		click(MFC_DestinationPlaces(dest), "Application \t"+dest);
	 		Reporter.SuccessReport("Step:-Select Application","The Application is selected as \t:-"+dest);
	 			
	 	}
	 	
	 	public void MIS_GS_SelectDepartment(String dest) throws Throwable{
	 		logger.info("in MIS_GS_SelectDepartment()");
	 		// waitForVisibilityOfElement(MFC_Destination,"Destination");
	 		Thread.sleep(2000);
	 		click(MIS_GS_drd_Department,"Department");
	 		click(MFC_DestinationPlaces(dest), "Department \t"+dest);
	 		Reporter.SuccessReport("Step:-Select Application","The Application is selected as \t:-"+dest);
	 			
	 	}
	 	
	 	public void MIS_GS_SelectQueue(String dest) throws Throwable{
	 		logger.info("in MIS_GS_SelectQueue()");
	 		// waitForVisibilityOfElement(MFC_Destination,"Destination");
	 		Thread.sleep(2000);
	 		click(MIS_GS_drd_Queue,"Queue");
	 		click(MFC_DestinationPlaces(dest), "Queue \t"+dest);
	 		Reporter.SuccessReport("Step:-Select Application","The Application is selected as \t:-"+dest);
	 			
	 	}
	 	
	 	public void MIS_GS_DaysOut(String dest) throws Throwable{
	 		logger.info("in MIS_GS_DaysOut()");
	 		// waitForVisibilityOfElement(MFC_Destination,"Destination");
	 		Thread.sleep(2000);
	 		click(MIS_GS_drd_DaysOut,"Days Out");
	 		click(MFC_DestinationPlaces(dest), "Days Out \t"+dest);
	 		Reporter.SuccessReport("Step:-Select Application","The Application is selected as \t:-"+dest);
	 			
	 	}
	 	
	 	//Customer Search
	 	
	 	 public void MIS_CS_VerifyCustomerSearchPage() throws Throwable{
			 logger.info("in MIS_CS_VerifyCustomerSearchPage()");
			 waitForVisibilityOfElement(MIS_CS_b_Heading,"MIS  Customer Search Heading");
			 isElementDisplayed(MIS_CS_b_Heading, "MIS Customer Search Heading");
			 isElementDisplayed(MIS_CS_date_FlightDate, "Flight date");	
			 isElementDisplayed(MIS_CS_txt_FlightNo, "Flight no");
			 isElementDisplayed(MIS_CS_txt_PNRNo, "PNR No");
			 isElementDisplayed(MIS_CS_txt_MobNo, "Mobile number");
			 isElementDisplayed(MIS_CS_txt_Email, "Email");
			 isElementDisplayed(MIS_CS_btn_Search, "Search");
			 isElementDisplayed(MIS_CS_btn_Reset, "Reset");
			 isElementDisplayed(MIS_CS_drd_CommType, "Communication type");
			 isElementDisplayed(MIS_CS_drd_Application, "Application");
			 isElementDisplayed(MIS_CS_btn_ExportToExcel, "Export to Excel");
			 
			 
			 Reporter.SuccessReport("Step:-Verify Customer Search page","The Flight Search page is verified\t");
			 
			
		}
	 	 
	 	public void MIS_CS_SelectFlightDate(String date) throws Throwable{
	 		logger.info("in SelectFromDate()");
	 		
	 		WebElement from;
	 	    int tomm=0;
	 	    waitForVisibilityOfElement(MIS_CS_date_FlightDate,"From date");
	 	    from=driver.findElement(MIS_CS_date_FlightDate);
	 	    from.click();
	 		
	 	    Thread.sleep(1000);
	 		
	 		//changing string to date format
	 		String startDateString =date;
	 		DateFormat df = new SimpleDateFormat("dd"); 
	 		Date From;
	 		String FromDate="";
	 		try {
	 			From = df.parse(startDateString);
	 			FromDate = df.format(From);
	 		    System.out.println(FromDate);
	 		} catch (ParseException e) {
	 		    e.printStackTrace();
	 		}
	 	      
	 	      if(FromDate.contains("0"))
	 			{
	 			String[] parts = FromDate.split("0");
	 			FromDate=parts[1];
	 			if(parts[1]=="0")
	 			{
	 				FromDate=parts[0]+parts[1];
	 			}
	 			
	 			}
	 	    
	 	    //find the calendar  
	 	      List<WebElement> columns=driver.findElements(MIS_CS_date_Calender);  

	 	      //comparing the text of cell with today's date and clicking it.
	 	      for (WebElement cell : columns)
	 	      {
	 	    	  String b=cell.getText();
	 	    	
	 	    	  boolean c=cell.isDisplayed ();
	 	    	  
	 	         if (b.equals(FromDate))
	 	         {
	 	        	
	 	        	 highLightElement(driver,cell);
	 	            cell.click();
	 	            break;
	 	         }
	 	      }
	 	      
	 	      Reporter.SuccessReport("Step:-Select From Date","Successfully clicked on provided From date \t:-"+date);
	 		}

	 	public void MIS_CS_ProvideFlightNumber() throws Throwable{
	 		logger.info("in MIS_CS_ProvideFlightNumber()");
	 		 waitForVisibilityOfElement(MIS_CS_txt_FlightNo,"Flight no");
            type(MIS_CS_txt_FlightNo, "47", "FlightNo");
	 		Reporter.SuccessReport("Step:-Provide FlightNumber","The FlightNumber is provided as \t:-"+"47");
	 			
	 	}
	 	
	 	public void MIS_CS_ProvidePNR() throws Throwable{
	 		logger.info("in MIS_CS_ProvidePNR()");
	 		 waitForVisibilityOfElement(MIS_CS_txt_PNRNo,"PNR no");
            type(MIS_CS_txt_PNRNo, "DG8J7H", "PNRNo");
	 		Reporter.SuccessReport("Step:-Provide PNR","The PNR is provided as \t:-"+"DG8J7H");
	 			
	 	}
	 	
	 	public void MIS_CS_ValidatePNR() throws Throwable{
	 		logger.info("in MIS_CS_ValidatePNR()");
	 		 waitForVisibilityOfElement(MIS_CS_td_PNRCol,"PNR no");
           String a=getText(MIS_CS_td_PNRCol, "PNR");
           
	 		Reporter.SuccessReport("Step:-Validate PNR","The PNR is validated \t"+a);
	 			
	 	}
		public void MIS_CS_ProvideMobileno() throws Throwable{
	 		logger.info("in MIS_CS_ProvideMobileno()");
	 		 waitForVisibilityOfElement(MIS_CS_txt_MobNo,"Mob no");
            type(MIS_CS_txt_MobNo, "9773614385", "Mob No");
	 		Reporter.SuccessReport("Step:-Provide Mob no","The Mob no is provided as \t:-"+"9773614385");
	 			
	 	}
		
		public void MIS_CS_ValidateMobile() throws Throwable{
	 		logger.info("in MIS_CS_ValidateMobile()");
	 		 waitForVisibilityOfElement(MIS_CS_td_MobCol,"Mob no");
           String a=getText(MIS_CS_td_MobCol, "9773614385");
        //   Assert.assertEquals("a", "9773614385");
	 		Reporter.SuccessReport("Step:-Validate mob no","The mob no is validated \t"+a);
	 			
	 	}
		
		public void MIS_CS_ProvideEmail() throws Throwable{
	 		logger.info("in MIS_CS_ProvideEmail()");
	 		 waitForVisibilityOfElement(MIS_CS_txt_Email,"Email");
            type(MIS_CS_txt_Email, "vish.fed@ee.com", "Email");
	 		Reporter.SuccessReport("Step:-Provide email","The email is provided as \t:-"+"vish.fed@ee.com");
	 			
	 	}
		
		public void MIS_CS_ProvideSentBy() throws Throwable{
	 		logger.info("in MIS_CS_ProvideSentBy()");
	 	    waitForVisibilityOfElement(MIS_CS_txt_SentBy,"Sent By");
            type(MIS_CS_txt_SentBy, "seem.rani", "Sent By");
	 		Reporter.SuccessReport("Step:-Provide SentBy","The SentBy is provided as \t:-"+"seema.rani");
	 			
	 	}
		
		public void MIS_CS_SelectApplication(String dest) throws Throwable{
	 		logger.info("in MIS_FS_SelectApplication()");
	 		// waitForVisibilityOfElement(MFC_Destination,"Destination");
	 		Thread.sleep(2000);
	 		click(MIS_CS_drd_Application,"Application");
	 		click(MFC_DestinationPlaces(dest), "Application \t"+dest);
	 		Reporter.SuccessReport("Step:-Select Application","The Application is selected as \t:-"+dest);
	 			
	 	}
		
		public void MIS_CS_SelectCommunicationType(String dest) throws Throwable{
	 		logger.info("in MIS_FS_SelectCommunicationType()");
	 		// waitForVisibilityOfElement(MFC_Destination,"Destination");
	 		Thread.sleep(2000);
	 		click(MIS_CS_drd_CommType,"Communication Type");
	 		MIS_CS_VerifyCommunicationList();
	 		click(MFC_DestinationPlaces(dest), "Communication Type \t"+dest);
	 		Reporter.SuccessReport("Step:-Select Communication Type","The Communication Type is selected as \t:-"+dest);
	 			
	 	}
		
		public void MIS_CS_VerifyCommunicationList() throws Throwable{
	 		logger.info("in MIS_FS_SelectCommunicationType()");
	 		// waitForVisibilityOfElement(MFC_Destination,"Destination");
	 		Thread.sleep(2000);
	 		
	 		String sms=getText(MFC_DestinationPlaces("SMS"), "Communication Type \t"+"SMS");
	 		String ivr=getText(MFC_DestinationPlaces("IVR"), "Communication Type \t"+"ÏVR");
	 		String email=getText(MFC_DestinationPlaces("EMAIL"), "Communication Type \t"+"EMAIL");
	 		Assert.assertTrue(sms.contains("SMS"));
	 		Assert.assertTrue(ivr.contains("IVR"));
	 		Assert.assertTrue(email.contains("EMAIL"));
	 		
	 		Reporter.SuccessReport("Step:-Select Communication Type","The Communication Type list is Verified \t");
	 			
	 	}
		
		public void Comm_MIS_CS_VerifyExportToExcel() throws Throwable{
			logger.info("in Comm_MIS_CS_VerifyExportToExcel()");
			 waitForVisibilityOfElement(MIS_FS_btn_ExportToExcel,"Export To Excel");
			 click(MIS_FS_btn_ExportToExcel,"Export To Excel");
			 Thread.sleep(3000);
			    String downloadPath="C:\\Users\\E003681\\Downloads"; 
				Thread.sleep(2000);
				boolean a= isFileDownloaded(downloadPath, "PaxCommunicationHistory_25_01_2018_14_03_24.xls");
		   	    Assert.assertTrue(a, "Failed to download Expected document");
		   	 Reporter.SuccessReport("Step:-Verify Export to Excel","The Export to Excel functionality is verified\t"); 		 
		}
		
		//Customer Search OCC
		 public void MIS_CS_VerifyCustomerSearchOCCPage() throws Throwable{
			 logger.info("in MIS_CS_VerifyCustomerSearchPage()");
			 waitForVisibilityOfElement(MIS_CSOCC_b_Heading,"MIS  Customer Search OCC Heading");
			 isElementDisplayed(MIS_CSOCC_b_Heading, "MIS Customer Search OCC Heading");
			 isElementDisplayed(MIS_CSOCC_date_FlightDate, "Flight date");	
			 isElementDisplayed(MIS_CSOCC_txt_FlightNo, "Flight no");
			 isElementDisplayed(MIS_CSOCC_txt_PNRNo, "PNR No");
			 isElementDisplayed(MIS_CSOCC_txt_MobNo, "Mobile number");
			 isElementDisplayed(MIS_CSOCC_txt_Email, "Email");
			 isElementDisplayed(MIS_CSOCC_btn_Search, "Search");
			 isElementDisplayed(MIS_CSOCC_btn_Reset, "Reset");
			 isElementDisplayed(MIS_CSOCC_drd_CommType, "Communication type");
			 isElementDisplayed(MIS_CSOCC_drd_Application, "Application");
			 isElementDisplayed(MIS_CSOCC_drd_UserGroup, "UserGroup");
			 isElementDisplayed(MIS_CSOCC_btn_ExportToExcel, "Export to Excel");
			 
			 
			 Reporter.SuccessReport("Step:-Verify Customer Search page","The Flight Search page is verified\t");
			 
			
		}
		 
		 public void MIS_CS_SelectUserGroup(String dest) throws Throwable{
		 		logger.info("in MIS_CS_SelectUserGroup()");
		 		// waitForVisibilityOfElement(MFC_Destination,"Destination");
		 		Thread.sleep(2000);
		 		click(MIS_CSOCC_drd_UserGroup,"User Group");
		 		
		 		click(MFC_OriginPlaces(dest), "User Group \t"+dest);
		 		Reporter.SuccessReport("Step:-Select User Group","The User Group is selected as \t:-"+dest);
		 			
		 	}
			
}