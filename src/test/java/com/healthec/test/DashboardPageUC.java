package com.healthec.test;

import com.healthec.UI.BackButton;
import com.healthec.UI.SwitchView;
import com.healthec.generic.*;
import com.healthec.objectRepo.DashboardPageObjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DashboardPageUC extends TestBaseClass {
	
	public static RemoteWebDriver driver;
	public static WebDriverWait wait;
	public static DashboardPageObjects dps;
	public static ExcelData testcaseSheet = null;
	public static ExcelData testdataSheet = null;
	public static String testClassName=null;
	public static String testMethodName=null;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	@BeforeClass(alwaysRun = true)
	public static void beforeDashboardPageClass()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait=(WebDriverWait)new WebDriverWait(driver, 30);
	}
	
	
	@BeforeTest(alwaysRun = true)
	public static void beforeDashboardPageTest()
	{
        System.out.println("test");
        driver = LoginPageUC.driver;
        dps = new DashboardPageObjects(driver);
        testDataInit();
        testdataSheet=testdataExcel;
	}
	//mood validation
	@Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_001() throws Exception
	{
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on moods button");
		FieldValidation.textFieldValidation(driver,dps.moods,testClassName,testMethodName).click();
        log.info("Clicking on 1st mood button");
		FieldValidation.textFieldValidation(driver,dps.mood1,testClassName,testMethodName).click();
		//Assert.assert

	}
		 
    @Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_002() throws Exception
	{
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on moods button");
        FieldValidation.textFieldValidation(driver,dps.moods,testClassName,testMethodName).click();
        log.info("Clicking on 2nd mood button");
        FieldValidation.textFieldValidation(driver,dps.mood2,testClassName,testMethodName).click();

	}
	@Test(enabled=true,groups = {"smoke","functional"})
	public static void dashBoardPageTC_003() throws Exception
	{
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on moods button");
        FieldValidation.textFieldValidation(driver,dps.moods,testClassName,testMethodName).click();
        log.info("Clicking on 3rd mood button");
        FieldValidation.textFieldValidation(driver,dps.mood3,testClassName,testMethodName).click();

	}
	@Test(enabled=true)
	public static void dashBoardPageTC_004() throws Exception
	{
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on moods button");
        FieldValidation.textFieldValidation(driver,dps.moods,testClassName,testMethodName).click();
        log.info("Clicking on 4th mood button");
        FieldValidation.textFieldValidation(driver,dps.mood4,testClassName,testMethodName).click();

	}
	@Test(enabled=true)
	public static void dashBoardPageTC_005() throws Exception
	{
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on moods button");
        FieldValidation.textFieldValidation(driver,dps.moods,testClassName,testMethodName).click();
        log.info("Clicking on 5th mood button");
        FieldValidation.textFieldValidation(driver,dps.mood5,testClassName,testMethodName).click();

	}
	//dasboard box validation
	  //calorie-box validation
	@Test(enabled=true)
	public static void dashBoardPageTC_006()
	{
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on calorie box button");
        FieldValidation.textFieldValidation(driver,dps.calorie_box,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.textFieldValidation(driver,dps.back_btn,testClassName,testMethodName).click();
        log.info("Clicking on bmi box button");
        FieldValidation.textFieldValidation(driver,dps.bmi_box,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.textFieldValidation(driver,dps.back_btn,testClassName,testMethodName).click();
        log.info("Clicking on bp box button");
        FieldValidation.textFieldValidation(driver,dps.bp_box,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.textFieldValidation(driver,dps.back_btn,testClassName,testMethodName).click();
	}
	@Test(enabled=true)
	public static void dashBoardPageTC_007()
	{
        testClassName = className;
        testMethodName =  methodName;
        log.info("Validating week range");
		String start_date =null;
		String end_date =null;
		try {
            for (int i = 0; i < dps.displaying_week_list.size(); i++) {
                start_date = dps.displaying_week_list.get(0).getText();
                end_date = dps.displaying_week_list.get(dps.displaying_week_list.size() - 1).getText();
            }
            System.out.println("Week range displaying is: " + (start_date.trim()) + " and " + end_date.trim());
        }catch(Exception e)
        {
            ExcelUtility.writeStatus(testcaseSheet, testClassName, testMethodName, "Actual_Output", "Element not present ");
        }
	
	}
	@Test(enabled=true)
	public static void dashBoardPageTC_008()
	{
		try{
            log.info("Checking records present");
            wait.until(ExpectedConditions.visibilityOf(dps.no_record_text));

		}catch(Exception e)
		{
            log.info("Alerts are present");
		    System.out.println("alert(s) displaying");
		}
	}
	@Test(enabled=true)
	public static void dashBoardPageTC_009()
	{
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on menu button");
        FieldValidation.textFieldValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on home tab button");
        FieldValidation.textFieldValidation(driver,dps.home_tab,testClassName,testMethodName).click();
	}
	@Test(enabled=true)
	public static void dashBoardPageTC_010()
	{
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on menu button");
        FieldValidation.textFieldValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on profile tab");
        FieldValidation.textFieldValidation(driver,dps.profile_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.textFieldValidation(driver,dps.back_btn,testClassName,testMethodName).click();

	}
	@Test(enabled=true)
	public static void dashBoardPageTC_011()
	{
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on menu button");
        FieldValidation.textFieldValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on health tracker tab");
        FieldValidation.textFieldValidation(driver,dps.healthTracker_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.textFieldValidation(driver,dps.back_btn,testClassName,testMethodName).click();

	}
	@Test(enabled=true,groups ={"smokeTest","functionality"})
	public static void dashBoardPageTC_012()
	{
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on menu button");
        FieldValidation.textFieldValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on medical care tab");
        FieldValidation.textFieldValidation(driver,dps.medicalCare_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.textFieldValidation(driver,dps.back_btn,testClassName,testMethodName).click();

	}
	@Test(enabled=true)
	public static void dashBoardPageTC_013()
	{
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on menu button");
        FieldValidation.textFieldValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on alerts tab");
        FieldValidation.textFieldValidation(driver,dps.alerts_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.textFieldValidation(driver,dps.back_btn,testClassName,testMethodName).click();

	}
	@Test(enabled=true)
	public static void dashBoardPageTC_014()
	{
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on menu button");
        FieldValidation.textFieldValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on health topic tab");
        FieldValidation.textFieldValidation(driver,dps.healthTopic_tab,testClassName,testMethodName).click();
        SwitchView.changeContext(driver,"NATIVE_APP");
		try{
            wait.until(ExpectedConditions.invisibilityOf(dps.healthTopic_spinner));
        }catch(Exception e){
            System.out.println("Exception in getting spinner: "+e.getMessage());
            ExcelUtility.writeStatus(testcaseSheet, testClassName, testMethodName, "Actual_Output", "Element not present ");
        }
        SwitchView.changeContext(driver,"WEBVIEW");
		//wait.until(ExpectedConditions.visibilityOf(dps.healthTopic_page)).isDisplayed();
        HealthTopicBackButton.backBtn(driver);

	}
	@Test(enabled=true)
	public static void dashBoardPageTC_015()
	{
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on menu button");
        FieldValidation.textFieldValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on my document button");
        FieldValidation.textFieldValidation(driver,dps.myDocument_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.textFieldValidation(driver,dps.back_btn,testClassName,testMethodName).click();

	}
	@Test(enabled=true)
	public static void dashBoardPageTC_016()
	{
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on menu button");
        FieldValidation.textFieldValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on settings tab");
        FieldValidation.textFieldValidation(driver,dps.settings_tab,testClassName,testMethodName).click();

		
	}
	@Test(enabled=true)
	public static void dashBoardPageTC_017()
	{
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on menu button");
        FieldValidation.textFieldValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on help tab");
        FieldValidation.textFieldValidation(driver,dps.help_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.textFieldValidation(driver,dps.back_btn,testClassName,testMethodName).click();

	}
	@Test(enabled=true)
    public static void dashBoardPageTC_018()
    {
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on menu button");
        FieldValidation.textFieldValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on contact us tab");
        FieldValidation.textFieldValidation(driver,dps.contact_us_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        BackButton.backButon(driver);
    }
    @Test(enabled=true)
    public static void dashBoardPageTC_019()
    {
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on privacy policy");
        FieldValidation.textFieldValidation(driver,dps.privacy_policy_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
    	BackButton.backButon(driver);
    }
    @Test(enabled=true)
    public static void dashBoardPageTC_020()
    {
        testClassName = className;
        testMethodName =  methodName;
        log.info("Clicking on terms of use");
        FieldValidation.textFieldValidation(driver,dps.terms_of_use_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        BackButton.backButon(driver);
    }
}
