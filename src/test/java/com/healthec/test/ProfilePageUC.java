package com.healthec.test;


import com.healthec.UI.*;
import com.healthec.generic.*;
import com.healthec.objectRepo.HealthTrackerPageObjects;
import com.healthec.objectRepo.LoginPageObjects;
import com.healthec.objectRepo.ProfilePageObjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProfilePageUC extends TestBaseClass {

    public static RemoteWebDriver driver;
    public static WebDriverWait wait;
    public static ProfilePageObjects pgs;
    public static ExcelData testcaseSheet = null;
    public static ExcelData testdataSheet = null;
    public static String testClassName = null;
    public static String testMethodName=null;
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static String instance;
    public static LoginPageObjects lps;
    public static HealthTrackerPageObjects hps;

    @BeforeClass(alwaysRun = true)
    public void beforeProfilePageClass() {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = (WebDriverWait) new WebDriverWait(driver, 30);
    }

    @BeforeTest(alwaysRun = true)
    public static void beforeProfilePageTest() {

        driver = LoginPageUC.driver;
        //System.out.println("driver value: "+driver);
        pgs = new ProfilePageObjects(driver);
        lps = new LoginPageObjects(driver);
        hps = new HealthTrackerPageObjects(driver);
        testDataInit();
        testdataSheet = testdataExcel;
        SwitchView.changeContext(driver, "WEBVIEW");
    }
    //profile-tab

    @Test(enabled = true,groups = {"test1","test2","smoke","functional"})
    public static void profilePageTC_001() {
        log.info("Clicking on menu button");
        FieldValidation.textFieldValidation(driver,pgs.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on profile tab");
        FieldValidation.textFieldValidation(driver,pgs.profile_tab,testClassName,testMethodName).click();
        log.info("Validating profile submenus");
        Assert.assertTrue(pgs.profile_sub_menus.isDisplayed());

    }

    @Test( enabled = true)
    public static void profilePageTC_002() {
        log.info("Validating profile submenus");
        Assert.assertTrue(pgs.profile_sub_menus.isDisplayed());
    }

    //personal
    @Test(enabled = true)
    public static void profilePageTC_003() {
        log.info("Clicking on contacts menu");
        FieldValidation.textFieldValidation(driver,pgs.contacts_menu,testClassName,testMethodName).click();
        log.info("Validating personal contacts");
        Assert.assertTrue(pgs.personal_contacts.isDisplayed());

    }

    @Test(enabled = true)
    public static void profilePageTC_004() {

        Assert.assertTrue(pgs.personal_contacts_total_fields.isDisplayed());
    }

    @Test(enabled = true)
    public static void profilePageTC_005() {

        Swipe.swipeVerticalDown(driver, 5);
        FieldValidation.textFieldValidation(driver,pgs.personal_editAndUpdate_btn,testClassName,testMethodName).click();
        Swipe.swipeVerticalUp(driver, 5);
    }

    @Test( enabled = true)
    public static void profilePageTC_006() {

        Swipe.swipeVerticalUp(driver, 5);
        FieldValidation.textFieldValidation(driver,pgs.personal_phone_number,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.personal_phone_number,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 1));
    }

    @Test(enabled = true)
    public static void profilePageTC_007() {
        System.out.println("email: " + pgs.personal_email.getAttribute("value"));
        Assert.assertTrue(pgs.personal_email.getAttribute("value").length() > 0);

    }

    @Test(enabled = true)
    public static void profilePageTC_008() {
        Swipe.swipeVerticalUp(driver, 2);
        FieldValidation.textFieldValidation(driver,pgs.personal_email,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.personal_email,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 2));
    }

    @Test( enabled = true)
    public static void profilePageTC_009() {
        FieldValidation.textFieldValidation(driver,pgs.personal_address,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.personal_address,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 3));
    }

    @Test(priority = 10, enabled = true)
    public static void profilePageTC_010() {
        FieldValidation.textFieldValidation(driver,pgs.personal_city,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.personal_city,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 4));
    }

    @Test(priority = 11, enabled = true)
    public static void profilePageTC_011() {
        FieldValidation.textFieldValidation(driver,pgs.personal_zip_code,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.personal_zip_code,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 6));
    }

    @Test(priority = 12, enabled = true)
    public static void profilePageTC_012() {
        FieldValidation.textFieldValidation(driver,pgs.personal_state,testClassName,testMethodName).click();
    }

    @Test(priority = 13, enabled = true)
    public static void profilePageTC_013() {

        instance = driver.getClass().getName();

        if (instance.contains("AndroidDriver")) {
            Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 5));
        } else if (instance.contains("IOSDriver")) {
            Select dropdown = new Select(driver.findElement(By.id("state")));
            dropdown.selectByVisibleText(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 5));

        } else {
            System.out.println("Unable to find dropdown data");
        }
    }

    @Test(priority = 14, enabled = true)
    public static void profilePageTC_014() {
        FieldValidation.textFieldValidation(driver,pgs.personal_cancel_btn,testClassName,testMethodName).click();
    }

    @Test(priority = 15, enabled = true)
    public static void profilePageTC_015() {
        FieldValidation.textFieldValidation(driver,pgs.personal_editAndUpdate_btn,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.personal_editAndUpdate_btn,testClassName,testMethodName).click();
    }

    @Test(priority = 16, enabled = true)
    public static void profilePageTC_016() {
        FieldValidation.textFieldValidation(driver,pgs.personal_added_successfully_btn_ok,testClassName,testMethodName).click();
    }

    //Emergency
    @Test(priority = 17, enabled = true)
    public static void profilePageTC_017() {
        FieldValidation.textFieldValidation(driver,pgs.emergency_tab,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.emergency_field_total_contents.isDisplayed());
    }

    @Test(priority = 18, enabled = true)
    public static void profilePageTC_018() {
        Swipe.swipeVerticalDown(driver, 5);
        FieldValidation.textFieldValidation(driver,pgs.emergency_editAndUpdate_btn,testClassName,testMethodName).click();
    }

    @Test(priority = 19, enabled = true)
    public static void profilePageTC_019() {

        Swipe.swipeVerticalUp(driver, 5);
        FieldValidation.textFieldValidation(driver,pgs.emergency_firstname,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.emergency_firstname,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 7));
    }

    @Test(priority = 20, enabled = true)
    public static void profilePageTC_020() {

        FieldValidation.textFieldValidation(driver,pgs.emergency_lastname,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.emergency_lastname,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 8));
    }

    @Test(priority = 21, enabled = true)
    public static void profilePageTC_021() {
        FieldValidation.textFieldValidation(driver,pgs.emergency_phone_number,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.emergency_phone_number,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 9));
    }

    @Test(priority = 22, enabled = true)
    public static void profilePageTC_022() {
        FieldValidation.textFieldValidation(driver,pgs.emergency_email,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.emergency_email,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 10));
    }

    @Test(priority = 23, enabled = true)
    public static void profilePageTC_023() {
        FieldValidation.textFieldValidation(driver,pgs.emergency_street,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.emergency_street,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 11));
    }

    @Test(priority = 24, enabled = true)
    public static void profilePageTC_024() {
        FieldValidation.textFieldValidation(driver,pgs.emergency_city,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.emergency_city,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 12));
    }

    @Test(priority = 25, enabled = true)
    public static void profilePageTC_025() {
        FieldValidation.textFieldValidation(driver,pgs.emergency_state,testClassName,testMethodName).click();
        instance = driver.getClass().getName();

        if (instance.contains("AndroidDriver")) {
            Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 13));
        } else if (instance.contains("IOSDriver")) {
            Select dropdown = new Select(driver.findElement(By.id("state")));
            dropdown.selectByVisibleText(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 13));

        } else {
            System.out.println("Unable to find dropdown data");
        }

    }

    @Test(priority = 26, enabled = true)
    public static void profilePageTC_026() {
        FieldValidation.textFieldValidation(driver,pgs.emergency_zip_code,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.emergency_zip_code,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 14));
    }

    @Test(priority = 27, enabled = true)
    public static void profilePageTC_027() {

        HideKeyBoard.hideKeyBoard(driver);
        FieldValidation.textFieldValidation(driver,pgs.emergency_cancel_btn,testClassName,testMethodName).click();
    }

    @Test(priority = 28, enabled = true)
    public static void profilePageTC_028() {
        FieldValidation.textFieldValidation(driver,pgs.emergency_editAndUpdate_btn,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.emergency_update_btn,testClassName,testMethodName).click();
    }

    @Test(priority = 29, enabled = true)
    public static void profilePageTC_029() {
        FieldValidation.textFieldValidation(driver,pgs.emergency_updated_sucessfully_popup_btn,testClassName,testMethodName).click();
    }

    //physicians
    @Test(priority = 30, enabled = true)
    public static void profilePageTC_030() throws Exception {

        FieldValidation.textFieldValidation(driver,pgs.menu_btn,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.profile_tab,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.physicians_tab,testClassName,testMethodName).click();

        WebElement noRecordFoundElement = null;

        try {

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            if (NoRecordsFound.noRecordsFoundMsg(driver).isDisplayed()) {
                System.out.println("No Records Present");
            }
        } catch (Exception e) {
            System.out.println("Exception in finding element: " + e.getMessage());
        }
    }

    @Test(priority = 31, enabled = true)
    public static void profilePageTC_031() {

        try {
            Assert.assertTrue(pgs.physicians_records_grid_contents.isDisplayed());
        } catch (Exception e) {
            System.out.println("Exception in finding element: " + e.getMessage());
        }
    }

    @Test(priority = 32, enabled = true)
    public static void profilePageTC_032() {
        FieldValidation.textFieldValidation(driver,pgs.add_physicians_icon,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.physicians_page_contents.isDisplayed());
    }

    @Test(priority = 33, enabled = true)
    public static void profilePageTC_033() {

        Swipe.swipeVerticalDown(driver, 3);
        FieldValidation.textFieldValidation(driver,pgs.physician_type_dropdown,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.physician_type_dropdown_values.isDisplayed());
    }

    @Test(priority = 34, enabled = true)
    public static void profilePageTC_034() {

        instance = driver.getClass().getName();
        if (instance.contains("AndroidDriver")) {
            Scroll.scrollToText(driver, "Specialist");
        } else if (instance.contains("IOSDriver")) {
            Select dropdown = new Select(pgs.physician_type_dropdown);
            dropdown.selectByVisibleText("Specialist");

        } else {
            System.out.println("Unable to find dropdown data");
        }
        Swipe.swipeVerticalDown(driver, 3);
        Assert.assertTrue(pgs.select_speciality_field.isDisplayed());
    }

    @Test(priority = 35, enabled = true)
    public static void profilePageTC_035() {
        FieldValidation.textFieldValidation(driver,pgs.add_physician_btn,testClassName,testMethodName).click();
        Swipe.swipeVerticalUp(driver, 4);
        Assert.assertTrue(pgs.add_physicians_warning_msg.isDisplayed());
    }

    @Test(priority = 36, enabled = true)
    public static void profilePageTC_036() {
        FieldValidation.textFieldValidation(driver,pgs.lastname_txt_field,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.lastname_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 0));
        FieldValidation.textFieldValidation(driver,pgs.firstname_txt_field,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.firstname_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 1));
        FieldValidation.textFieldValidation(driver,pgs.phoneNumber_txt_field,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.phoneNumber_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 2));
        FieldValidation.textFieldValidation(driver,pgs.email_txt_field,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.email_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 3));
        Swipe.swipeVerticalUp(driver, 3);
        HideKeyBoard.hideKeyBoard(driver);
        FieldValidation.textFieldValidation(driver,pgs.physician_type_dropdown,testClassName,testMethodName).click();

        instance = driver.getClass().getName();
        if (instance.contains("AndroidDriver")) {
            Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 4));
        } else if (instance.contains("IOSDriver")) {
            Select dropdown = new Select(pgs.physician_type_dropdown);
            dropdown.selectByVisibleText(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 4));

        } else {
            System.out.println("Unable to find dropdown data");
        }
        try {
            if (ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 4).equalsIgnoreCase("Specialist")) {
                System.out.println("Extracted physician type is specialist");
                wait.until(ExpectedConditions.elementToBeClickable(pgs.select_speciality_field)).click();
                instance = driver.getClass().getName();
                if (instance.contains("AndroidDriver")) {
                    Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 5));
                } else if (instance.contains("IOSDriver")) {
                    Select dropdown = new Select(pgs.select_speciality_field);
                    dropdown.selectByVisibleText(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 5));

                } else {
                    System.out.println("Unable to find dropdown data");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getting data or the physican type is not specialist: " + e.getMessage());
        }
        FieldValidation.textFieldValidation(driver,pgs.add_physician_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.physician_added_sucessfully_msg_pop_up.isDisplayed());
    }

    @Test(priority = 37, enabled = true)
    public static void profilePageTC_037() {
        FieldValidation.textFieldValidation(driver,pgs.physician_addMore_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.physician_add_page.isDisplayed());
    }

    @Test(priority = 38, enabled = true)
    public static void profilePageTC_038() {
        FieldValidation.textFieldValidation(driver,pgs.lastname_txt_field,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.lastname_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 0));
        FieldValidation.textFieldValidation(driver,pgs.firstname_txt_field,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.firstname_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 1));
        FieldValidation.textFieldValidation(driver,pgs.phoneNumber_txt_field,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.phoneNumber_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 2));
        FieldValidation.textFieldValidation(driver,pgs.email_txt_field,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.email_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 3));
        Swipe.swipeVerticalUp(driver, 3);
        HideKeyBoard.hideKeyBoard(driver);
        FieldValidation.textFieldValidation(driver,pgs.physician_type_dropdown,testClassName,testMethodName).clear();
        instance = driver.getClass().getName();
        if (instance.contains("AndroidDriver")) {
            Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 4));
        } else if (instance.contains("IOSDriver")) {
            Select dropdown = new Select(pgs.physician_type_dropdown);
            dropdown.selectByVisibleText(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 4));

        } else {
            System.out.println("Unable to find dropdown data");
        }
        try {
            if (ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 4).equalsIgnoreCase("Specialist")) {
                System.out.println("Extracted physician type is specialist");
                wait.until(ExpectedConditions.elementToBeClickable(pgs.select_speciality_field)).click();
                instance = driver.getClass().getName();
                if (instance.contains("AndroidDriver")) {
                    Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 5));
                } else if (instance.contains("IOSDriver")) {
                    Select dropdown = new Select(pgs.select_speciality_field);
                    dropdown.selectByVisibleText(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 5));

                } else {
                    System.out.println("Unable to find dropdown data");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getting data or the physican type is not specialist: " + e.getMessage());
        }
        FieldValidation.textFieldValidation(driver,pgs.add_physician_btn,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.physician_updatedSuccessfully_viewInfo_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.physician_results_page.isDisplayed());
    }

    @Test(priority = 39, enabled = true)
    public static void profilePageTC_039() {

        FieldValidation.textFieldValidation(driver,pgs.physician_call_btn,testClassName,testMethodName).click();
        System.out.println("Hii");
        PhoneNumber.phoneNumberValidation(driver);
    }

    @Test(priority = 40, enabled = true)
    public static void profilePageTC_040() {

        System.out.println("Unable to automate");
    }

    @Test(priority = 41, enabled = true)
    public static void profilePageTC_041() {

        System.out.println("Unable to automate");
    }

    @Test(priority = 42, enabled = true)
    public static void profilePageTC_042() {

        FieldValidation.textFieldValidation(driver,pgs.physician_edit_record_btn,testClassName,testMethodName).click();
        Swipe.swipeVerticalDown(driver, 3);
        FieldValidation.textFieldValidation(driver,pgs.physician_update_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.physician_update_successfully_btn.isDisplayed());
    }

    @Test(priority = 43, enabled = true)
    public static void profilePageTC_043() {
        FieldValidation.textFieldValidation(driver,pgs.physician_update_successfully_btn,testClassName,testMethodName).click();
    }

    @Test(priority = 44, enabled = true)
    public static void profilePageTC_044() {
        FieldValidation.textFieldValidation(driver,pgs.menu_btn,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.profile_tab,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_tab,testClassName,testMethodName).click();

        try {

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            if (NoRecordsFound.noRecordsFoundMsg(driver).isDisplayed()) {
                System.out.println("No Records Present");
            }
        } catch (Exception e) {
            System.out.println("Exception in finding element: " + e.getMessage());
        }

    }

    @Test(priority = 45, enabled = true)
    public static void profilePageTC_045() {

        try {
            Assert.assertTrue(NoRecordsFound.RecordsAvailableMsg(driver).isDisplayed());
            Assert.assertTrue(pgs.pharmacy_recordsPage_contents.isDisplayed());
            // System.out.println("checking pharmacy records");

        } catch (Exception e) {
            System.out.println("Exception in finding element: " + e.getMessage());
        }

    }

    @Test(priority = 46, enabled = true)
    public static void profilePageTC_046() {
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_add_icon,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.add_pharmacy_page_contents.isDisplayed());

    }

    @Test(priority = 47, enabled = true)
    public static void profilePageTC_047() {
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_add_pharmacy_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.pharmacy_provideAlldetains_warning_msg.isDisplayed());
    }

    @Test(priority = 48, enabled = true)
    public static void profilePageTC_048() {
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_pharmacy_name_txt_field,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_pharmacy_name_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Pharmacy", 1, 0));
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_contact_person_text_field,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_contact_person_text_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Pharmacy", 1, 1));
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_phone_number_txt_field,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_phone_number_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Pharmacy", 1, 2));
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_add_pharmacy_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.pharmacy_add_successfully_msg_popUp.isDisplayed());
    }

    @Test(priority = 49, enabled = true)
    public static void profilePageTC_049() {
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_addMore_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.add_pharmacy_page_contents.isDisplayed());
    }

    @Test(priority = 50, enabled = true)
    public static void profilePageTC_050() {

        FieldValidation.textFieldValidation(driver,pgs.pharmacy_pharmacy_name_txt_field,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_pharmacy_name_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Pharmacy", 1, 0));
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_contact_person_text_field,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_contact_person_text_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Pharmacy", 1, 1));
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_phone_number_txt_field,testClassName,testMethodName).clear();
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_phone_number_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Pharmacy", 1, 2));
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_add_pharmacy_btn,testClassName,testMethodName).click();

        wait.until(ExpectedConditions.visibilityOf(pgs.pharmacy_add_successfully_msg_popUp)).isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.pharmacy_viewInfo_btn)).click();
        Assert.assertTrue(pgs.pharmacy_recordsPage_contents.isDisplayed());
    }

    @Test(priority = 51, enabled = true)
    public static void profilePageTC_051() {
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_edit_record,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_update_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.pharmacy_updatedSuccessfully_popUp.isDisplayed());
    }

    @Test(priority = 52, enabled = true)
    public static void profilePageTC_052() {
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_updatedSuccessfully_viewInfo_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.pharmacy_recordsPage_contents.isDisplayed());
    }

    @Test(priority = 53, enabled = true)
    public static void profilePageTC_053() {
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_delete_record,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.pharmacy_deleteConfirmation_popup.isDisplayed());
    }

    @Test(priority = 54, enabled = true)
    public static void profilePageTC_054() {
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_deleteConfirmation_popup_No_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.pharmacy_recordsPage_contents.isDisplayed());
    }

    @Test(priority = 55, enabled = true)
    public static void profilePageTC_055() {
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_delete_record,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_deleteConfirmation_popup_Yes_btn,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.pharmacy_deleteSuccessfull_ok_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.pharmacy_recordsPage_contents.isDisplayed());
    }

    @Test(priority = 56, enabled = true)
    public static void profilePageTC_056() {
        FieldValidation.textFieldValidation(driver,pgs.menu_btn,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.profile_tab,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.insurance_tab,testClassName,testMethodName).click();

        try {

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            if (NoRecordsFound.noRecordsFoundMsg(driver).isDisplayed()) {
                System.out.println("No Records Present");
            }
        } catch (Exception e) {
            System.out.println("Exception in finding element: " + e.getMessage());
        }
    }

    @Test(priority = 57, enabled = true)
    public static void profilePageTC_057() {

        try {
            Assert.assertTrue(NoRecordsFound.RecordsAvailableMsg(driver).isDisplayed());
            Assert.assertTrue(pgs.insurance_records_page_contents.isDisplayed());
            // System.out.println("checking pharmacy records");

        } catch (Exception e) {
            System.out.println("Exception in finding element: " + e.getMessage());
        }

    }

    @Test(priority = 58, enabled = true)
    public static void profilePageTC_058() {
        FieldValidation.textFieldValidation(driver,pgs.insurarce_add_icon,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurance_add_page_contents.isDisplayed());
    }

    @Test(priority = 59, enabled = true)
    public static void profilePageTC_059() {

        String selectedElement = pgs.selected_insuranceType_value.getAttribute("value");
        System.out.println("Selected value is: " + selectedElement);
        FieldValidation.textFieldValidation(driver,pgs.insurarce_insurance_type,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurance_insurance_type_contents.isDisplayed());
        Scroll.scrollToText(driver, selectedElement);
    }

    @Test(priority = 60, enabled = true)
    public static void profilePageTC_060() {

        String selectedElement = pgs.selected_planType_value.getText();
        System.out.println("Selected value is: " + selectedElement);
        FieldValidation.textFieldValidation(driver,pgs.insurarce_plan_type,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurance_plan_type_contents.isDisplayed());
        Scroll.scrollToText(driver, selectedElement);
    }

    @Test(priority = 61, enabled = true)
    public static void profilePageTC_061() {
        FieldValidation.textFieldValidation(driver,pgs.insurarce_addInsurance_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurarce_warning_msg.isDisplayed());
    }

    @Test(priority = 62, enabled = true)
    public static void profilePageTC_062() {
        FieldValidation.textFieldValidation(driver,pgs.insurarce_insurance_type,testClassName,testMethodName).click();
        Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Insurance", 1, 0));
        FieldValidation.textFieldValidation(driver,pgs.insurarce_plan_type,testClassName,testMethodName).click();
        Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Insurance", 1, 1));
        FieldValidation.textFieldValidation(driver,pgs.insurarce_plan_name_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Insurance", 1, 2));
        HideKeyBoard.hideKeyBoard(driver);
        FieldValidation.textFieldValidation(driver,pgs.insurarce_group_name_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Insurance", 1, 3));
        FieldValidation.textFieldValidation(driver,pgs.insurarce_addInsurance_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurarce_updatedSuccessfully_popUp.isDisplayed());
    }

    @Test(priority = 63, enabled = true)
    public static void profilePageTC_063() {
        FieldValidation.textFieldValidation(driver,pgs.insurarce_updatedSuccessfully_popUp_addMore,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurance_add_page_contents.isDisplayed());
    }

    @Test(priority = 64, enabled = true)
    public static void profilePageTC_064() {
        FieldValidation.textFieldValidation(driver,pgs.insurarce_insurance_type,testClassName,testMethodName).click();
        Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Insurance", 1, 0));
        FieldValidation.textFieldValidation(driver,pgs.insurarce_plan_type,testClassName,testMethodName).click();
        Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Insurance", 1, 1));
        FieldValidation.textFieldValidation(driver,pgs.insurarce_plan_name_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Insurance", 1, 2));
        FieldValidation.textFieldValidation(driver,pgs.insurarce_plan_name_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Insurance", 1, 3));
        HideKeyBoard.hideKeyBoard(driver);
        FieldValidation.textFieldValidation(driver,pgs.insurarce_addInsurance_btn,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.insurarce_updatedSuccessfully_popUp_viewInfo,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurance_records_page_contents.isDisplayed());
    }

    @Test(priority = 65, enabled = true)
    public static void profilePageTC_065() {
        FieldValidation.textFieldValidation(driver,pgs.insurance_editRecord,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.insurance_update_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurance_updated_sucessfully_popUp.isDisplayed());
    }

    @Test(priority = 66, enabled = true)
    public static void profilePageTC_066() {
        FieldValidation.textFieldValidation(driver,pgs.insurance_view_info_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurance_records_page_contents.isDisplayed());
    }

    @Test(priority = 67, enabled = true)
    public static void profilePageTC_067() {
        FieldValidation.textFieldValidation(driver,pgs.insurance_delete_reocrd,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.insurance_deleteRecord_confirmation_popUp_Yes_btn,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.insurance_deletedSucessfully_Ok_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurance_records_page_contents.isDisplayed());
    }

    @Test(priority = 68, enabled = true)
    public static void profilePageTC_068() {


        Assert.assertTrue(pgs.insurance_records_page_contents.isDisplayed());
    }

    @Test(priority = 69, enabled = true)
    public static void profilePageTC_069() {
        FieldValidation.textFieldValidation(driver,pgs.menu_btn,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.profile_tab,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.social_history_tab,testClassName,testMethodName).click();
        System.out.println("social_his: " + pgs.socialHistory_contents.size());
        Assert.assertTrue(pgs.socialHistory_contents.size() == 3);
    }

    @Test(priority = 70, enabled = true)
    public static void profilePageTC_070() {

        FieldValidation.textFieldValidation(driver,pgs.socialHistory_edit_btn,testClassName,testMethodName).click();
    }

    @Test(priority = 71, enabled = true)
    public static void profilePageTC_071() {

        FieldValidation.textFieldValidation(driver,pgs.socialHistory_drinkAlcohol_checkBox_No,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.socialHistory_smoke_checkBox_No,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.socialHistory_Exercise_checkBox_No,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.socialHistory_drinkAlcohol_checkBox_No.isSelected());
        Assert.assertTrue(pgs.socialHistory_smoke_checkBox_No.isSelected());
        Assert.assertTrue(pgs.socialHistory_Exercise_checkBox_No.isSelected());
    }

    @Test(priority = 72, enabled = true)
    public static void profilePageTC_072() {

        FieldValidation.textFieldValidation(driver,pgs.socialHistory_drinkAlcohol_checkBox_Yes,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.socialHistory_smoke_checkBox_yes,testClassName,testMethodName).click();
        FieldValidation.textFieldValidation(driver,pgs.socialHistory_Exercise_checkBox_Yes,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.socialHistory_drinkAlcohol_checkBox_Yes.isSelected());
        Assert.assertTrue(pgs.socialHistory_smoke_checkBox_yes.isSelected());
        Assert.assertTrue(pgs.socialHistory_Exercise_checkBox_Yes.isSelected());
    }


    @Test(priority = 73, enabled = true)
    public static void profilePageTC_073() {

        FieldValidation.textFieldValidation(driver,pgs.socialHistory_drinkPerWeek_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        FieldValidation.textFieldValidation(driver,pgs.socialHistory_drinkNoOfyears_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        FieldValidation.textFieldValidation(driver,pgs.socialHistory_smoke_packsPerWeek_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        FieldValidation.textFieldValidation(driver,pgs.socialHistory_smokeNoOfyears_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        FieldValidation.textFieldValidation(driver,pgs.socialHistory_ExercisedayPerWeek_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        FieldValidation.textFieldValidation(driver,pgs.socialHistory_ExerciseType_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        FieldValidation.textFieldValidation(driver,pgs.socialHistory_update_btn,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        Assert.assertTrue(pgs.socialHistory_updated_successfully_popUp.isDisplayed());
    }

    @Test(priority = 74, enabled = true)
    public static void profilePageTC_074() {

        FieldValidation.textFieldValidation(driver,pgs.socialHistory_updated_successfully_popUp_ok_btn,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        Assert.assertTrue(pgs.socialHistory_contents.size() == 3);
    }

    @Test(priority = 75, enabled = true)
    public static void profilePageTC_075() {

        FieldValidation.textFieldValidation(driver,pgs.menu_btn,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        FieldValidation.textFieldValidation(driver,pgs.profile_tab,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        FieldValidation.textFieldValidation(driver,pgs.access_sharing_tab,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        try {

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            if (NoRecordsFound.noRecordsFoundMsg(driver).isDisplayed()) {
                System.out.println("No Records Present");
            }
        } catch (Exception e) {
            System.out.println("Exception in finding element: " + e.getMessage());
        }

    }

    @Test(priority = 76, enabled = true)
    public static void profilePageTC_076() {

        try {
            Assert.assertTrue(pgs.access_sharing_record_present_list.isDisplayed());
            Assert.assertTrue(pgs.access_sharing_recordsPage_contents.isDisplayed());
            // System.out.println("checking pharmacy records");

        } catch (Exception e) {
            System.out.println("Exception in finding element: " + e.getMessage());
        }

    }

    @Test(priority = 77, enabled = true)
    public static void profilePageTC_077() {

        FieldValidation.textFieldValidation(driver,pgs.access_sharing_add_icon,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.access_sharing_add_page_contents.isDisplayed());
    }

    @Test(priority = 78, enabled = true)
    public static void profilePageTC_078() {

        Assert.assertTrue(pgs.access_sharing_add_page_contents.isDisplayed());
    }

    @Test(priority = 79, enabled = true)
    public static void profilePageTC_079() {

        FieldValidation.textFieldValidation(driver,pgs.access_sharing_search_txt_field_by_lastname,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 0));


        try {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            if (pgs.search_no_user_results_found.isDisplayed()) {
                System.out.println("User not present");

            }
        } catch (Exception e) {

            System.out.println(("Entered lastname of user available"));
            wait.until(ExpectedConditions.elementToBeClickable(pgs.search_autopopulate_user)).isDisplayed();
        }

        List<WebElement> fname = pgs.search_firstName;
        List<WebElement> email_id = pgs.search_email;

        try {

            for (WebElement ele : fname) {
                for (WebElement ele2 : email_id) {
                    if (ele.getText().equalsIgnoreCase(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 1)) && ele2.getText().equalsIgnoreCase(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 2))) {
                        System.out.println("user found");
                        ele.click();
                        break;
                    }
                    System.out.println("user not found");
                    throw new AssertionError("User not present");
                }
            }

        } catch (Exception e) {

            System.out.println("Exception in getting user name: " + e.getMessage());
        }

        Assert.assertTrue(pgs.access_sharing_lastname_txt_field.getAttribute("value").equalsIgnoreCase(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 0)));
    }

    @Test(priority = 80, enabled = true)
    public static void profilePageTC_080() {

        Assert.assertTrue(pgs.access_sharing_firstbname_txt_field.getAttribute("value").equalsIgnoreCase(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 1)));
    }

    @Test(priority = 81, enabled = true)
    public static void profilePageTC_081() {

        Assert.assertTrue(pgs.access_sharing_Email_txt_field.getAttribute("value").equalsIgnoreCase(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 2)));
    }

    @Test(priority = 82, enabled = true)
    public static void profilePageTC_082() {

        Assert.assertTrue(pgs.access_sharing_lastname_txt_field.getAttribute("value").equalsIgnoreCase(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 0)));
    }

    @Test(priority = 83, enabled = true)
    public static void profilePageTC_083() {

        Assert.assertTrue(pgs.access_sharing_firstbname_txt_field.getAttribute("value").equalsIgnoreCase(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 1)));
    }

    @Test(priority = 84, enabled = true)
    public static void profilePageTC_084() {

        Assert.assertTrue(pgs.access_sharing_Email_txt_field.getAttribute("value").equalsIgnoreCase(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 2)));
    }

    @Test(priority = 85, enabled = true)
    public static void profilePageTC_085() {

        HideKeyBoard.hideKeyBoard(driver);

        FieldValidation.textFieldValidation(driver,pgs.access_sharing_relation_dropDown,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.access_sharing_relation_dropDown.isDisplayed());
    }

    @Test(priority = 86, enabled = true)
    public static void profilePageTC_086() {

        instance = driver.getClass().getName();

        if (instance.contains("AndroidDriver")) {
            Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 3));
        } else if (instance.contains("IOSDriver")) {
            Select dropdown = new Select(driver.findElement(By.id("RelationOption")));
            dropdown.selectByVisibleText(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 3));

        } else {
            System.out.println("Unable to find dropdown data");
        }

    }

    @Test(priority = 87, enabled = true)
    public static void profilePageTC_087() throws InterruptedException {

        FieldValidation.textFieldValidation(driver,pgs.access_sharing_relation_dropDown,testClassName,testMethodName).click();
        Thread.sleep(3000);

        instance = driver.getClass().getName();

        if (instance.contains("AndroidDriver")) {
            Scroll.scrollToText(driver, "Other");
        } else if (instance.contains("IOSDriver")) {
            Select dropdown = new Select(driver.findElement(By.id("RelationOption")));
            dropdown.selectByVisibleText("Other");

        } else {
            System.out.println("Unable to find dropdown data");
        }
        Assert.assertTrue(pgs.Access_sharing_relation_dropDown_other_txtField.isDisplayed());
        FieldValidation.textFieldValidation(driver,pgs.access_sharing_relation_dropDown,testClassName,testMethodName).click();
        Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 3));

    }

    @Test(priority = 88, enabled = true)
    public static void profilePageTC_088() {

        FieldValidation.textFieldValidation(driver,pgs.Access_sharing_access_level_dropDown,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.Access_sharing_access_level_dropDown_options.isDisplayed());
        //driver.getPageSource();
        // System.out.println("Page source: "+driver.getPageSource());
    }

    @Test(priority = 89, enabled = true)
    public static void profilePageTC_089() throws InterruptedException {

        instance = driver.getClass().getName();

        if (instance.contains("AndroidDriver")) {
            Scroll.scrollToText(driver, "View");
        } else if (instance.contains("IOSDriver")) {
            Select dropdown = new Select(driver.findElement(By.id("RelationOption")));
            dropdown.selectByVisibleText("View");

        } else {
            System.out.println("Unable to find dropdown data");
        }
        System.out.println("Extracted value from access sharing: " + pgs.Access_sharing_access_level_dropDown.getAttribute("value"));
        Assert.assertTrue(pgs.Access_sharing_access_level_dropDown.getAttribute("value").equalsIgnoreCase("V"));
    }

    @Test(priority = 90, enabled = true)
    public static void profilePageTC_090() throws InterruptedException {

        FieldValidation.textFieldValidation(driver,pgs.Access_sharing_access_level_dropDown,testClassName,testMethodName).click();


        instance = driver.getClass().getName();

        if (instance.contains("AndroidDriver")) {
            Scroll.scrollToText(driver, "View & Modify");
        } else if (instance.contains("IOSDriver")) {
            Select dropdown = new Select(driver.findElement(By.id("RelationOption")));
            dropdown.selectByVisibleText("View & Modify");

        } else {
            System.out.println("Unable to find dropdown data");
        }
        System.out.println("Extracted value from access sharing: " + pgs.Access_sharing_access_level_dropDown.getAttribute("value"));
        Assert.assertTrue(pgs.Access_sharing_access_level_dropDown.getAttribute("value").equalsIgnoreCase("E"));
    }

    @Test(priority = 91, enabled = true)
    public static void profilePageTC_091() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_fromDate_datePicker_field)).click();
        Assert.assertTrue(pgs.access_sharing_fromDate_datePicker.isDisplayed());
    }

    @Test(priority = 92, enabled = true)
    public static void profilePageTC_092() throws Exception {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_from_month_dropdown)).click();
        System.out.println("Total months: " + pgs.access_duration_from_month_select_month.size());
        String from_date_received = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 6);
        System.out.println(from_date_received);
        DateCheck from_dt = new DateCheck(from_date_received);
        String from_month = from_dt.getMonth();
        int from_year = from_dt.getYear();
        String from_day = Integer.toString(from_dt.getDay());
        System.out.println("Month :" + from_month + ", Year: " + from_year + ", Day: " + from_day);

        Scroll.scrollToText(driver, from_month);

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_from_year_dropdown)).click();
        //System.out.println("Total years: "+pgs.access_duration_from_month_select_year.size());
        Scroll.scrollToText(driver, from_year);


        //System.out.println("Totals dates: "+pgs.access_duration_from_select_days.size());
        for (WebElement days : pgs.access_duration_from_select_days) {
            if (days.getText().equals(from_day)) {
                //System.out.println(days.getText());
                days.click();
                break;
            } else {
                //System.out.println(days.getText());
                System.out.println("Not able to find dates in from date picker");
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_fromDate_datePicker_ok_btn)).click();
    }

    @Test(priority = 93, enabled = true)
    public static void profilePageTC_093() throws Exception {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_toDate_datePicker_field)).click();
        Assert.assertTrue(pgs.access_sharing_toDate_datePicker.isDisplayed());
    }

    @Test(priority = 94, enabled = true)
    public static void profilePageTC_094() throws Exception {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_to_month_dropdown)).click();
        System.out.println("Total months: " + pgs.access_duration_to_month_select_month.size());
        String to_date_received = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 7);
        System.out.println(to_date_received);
        DateCheck to_dt = new DateCheck(to_date_received);
        String to_month = to_dt.getMonth();
        int to_year = to_dt.getYear();
        String to_day = Integer.toString(to_dt.getDay());
        System.out.println("Month :" + to_month + ", Year: " + to_year + ", Day: " + to_day);

        Scroll.scrollToText(driver, to_month);

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_to_year_dropdown)).click();
        //System.out.println("Total years: "+pgs.access_duration_to_month_select_year.size());
        Scroll.scrollToText(driver, to_year);


        //System.out.println("Totals dates: "+pgs.access_duration_to_select_days.size());
        for (WebElement days : pgs.access_duration_to_select_days) {
            if (days.getText().equals(to_day)) {
                //System.out.println(days.getText());
                days.click();
                break;
            } else {
                //System.out.println(days.getText());
                System.out.println("Not able to find dates in from date picker");
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_toDate_datePicker_ok_btn)).click();
    }

    @Test(priority = 95, enabled = true)
    public static void profilePageTC_095() {

        Swipe.swipeVerticalDown(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_profile_feature_expand_btn)).click();
        Swipe.swipeVerticalDown(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_healthTracker_feature_expand_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_medicalCare_feature_expand_btn)).click();
        Assert.assertTrue(pgs.access_duration_profile_feature_collapse_btn.isDisplayed());
        Assert.assertTrue(pgs.access_duration_healthTracker_feature_collapse_btn.isDisplayed());
        Swipe.swipeVerticalDown(driver, 3);
        Assert.assertTrue(pgs.access_duration_medicalCare_feature_collapse_btn.isDisplayed());
    }

    @Test(priority = 96, enabled = true)
    public static void profilePageTC_096() {

        Swipe.swipeVerticalUp(driver, 3);
        Assert.assertTrue(pgs.features_profile_submodules.isDisplayed());
    }

    @Test(priority = 97, enabled = true)
    public static void profilePageTC_097() {

        Assert.assertTrue(pgs.features_healthTracker_submodules.isDisplayed());
    }

    @Test(priority = 98, enabled = true)
    public static void profilePageTC_098() {

        Swipe.swipeVerticalDown(driver, 3);
        Assert.assertTrue(pgs.features_medicalCare_submodules.isDisplayed());
    }

    @Test(priority = 99, enabled = true)
    public static void profilePageTC_099() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_medicalCare_feature_collapse_btn)).click();
        Swipe.swipeVerticalUp(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_healthTracker_feature_collapse_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_profile_feature_collapse_btn)).click();
        Assert.assertTrue(pgs.access_duration_profile_feature_expand_btn.isDisplayed());
        Assert.assertTrue(pgs.access_duration_healthTracker_feature_expand_btn.isDisplayed());
        Swipe.swipeVerticalDown(driver, 3);
        Assert.assertTrue(pgs.access_duration_medicalCare_feature_expand_btn.isDisplayed());
    }

    @Test(priority = 100, enabled = true)
    public static void profilePageTC_100() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_profile_feature_expand_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_profile)).click();
        Assert.assertTrue(pgs.features_profile_allSubModule_checkbox.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_profile)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_profile_feature_collapse_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_healthTracker_feature_expand_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_healthTracker)).click();
        Assert.assertTrue(pgs.features_healthTracker_allSubModule_checkbox.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_healthTracker)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_healthTracker_feature_collapse_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_medicalCare_feature_expand_btn)).click();
        Swipe.swipeVerticalDown(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_medicalCare)).click();
        Assert.assertTrue(pgs.features_medicalcare_allSubModule_checkbox.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_medicalCare)).click();
    }

    @Test(priority = 101, enabled = true)
    public static void profilePageTC_101() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_medicalCare_alergies)).click();
        Assert.assertTrue(pgs.features_allergies_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_conditions_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_proceduresAndSurgeries_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_immunizations_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_labTest_checkbox.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_medicalCare_alergies)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_medicalCare_feature_collapse_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_healthTracker_feature_expand_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_healthTracker_bloodPressure)).click();
        Assert.assertTrue(pgs.features_bloodPressure_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_Weight_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_bloodGlucose_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_cholesterol_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_pulseOx_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_calorie_burned_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_hours_of_sleep_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_temperature_checkbox.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_healthTracker_bloodPressure)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_healthTracker_feature_collapse_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_profile_feature_expand_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_profile_insurance)).click();
        Assert.assertTrue(pgs.features_insurance_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_contacts_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_physicians_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_pharmacy_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_socialHistory_checkbox.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_profile_insurance)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_profile_feature_collapse_btn)).click();
    }

    @Test(priority = 102, enabled = true)
    public static void profilePageTC_102() {

        String checkboxes_profile = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 8);
        System.out.println("Data from excel: " + checkboxes_profile);
        if (checkboxes_profile.length() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_profile_feature_expand_btn)).click();
            List<String> checkbox_list_profile = new ArrayList<String>(Arrays.asList(checkboxes_profile.split(",")));
            System.out.println("List_value_profile: " + checkbox_list_profile);
            List<WebElement> profile_subMenues_list = pgs.profile_subMenus;
            System.out.println("profile size: " + profile_subMenues_list.size());


            for (String cb_profile : checkbox_list_profile) {
                System.out.println("check_value_profile: " + checkbox_list_profile);
                for (WebElement chk_profile : profile_subMenues_list) {
                    System.out.println("chk_value_profile: " + chk_profile);
                    if (chk_profile.getText().equalsIgnoreCase(cb_profile))
                        System.out.println("chk_text_Profile: " + chk_profile.getText()); //'"+eventName+"
                    chk_profile.findElement(By.xpath("//label[contains(text(),'" + cb_profile + "')]")).click();
                    break;
                }
            }
            wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_profile_feature_collapse_btn)).click();
        }
        String checkboxes_healthTracker = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 9);
        System.out.println("Data from excel: " + checkboxes_healthTracker);
        if (checkboxes_healthTracker.length() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_healthTracker_feature_expand_btn)).click();
            List<String> checkbox_list_healthTracker = new ArrayList<String>(Arrays.asList(checkboxes_healthTracker.split(",")));
            System.out.println("List_value_ht: " + checkbox_list_healthTracker);
            List<WebElement> healthTracker_subMenues_list = pgs.healthTracker_subMenus;
            System.out.println("healthTracker size: " + healthTracker_subMenues_list.size());

            for (String cb_healthTracker : checkbox_list_healthTracker) {
                System.out.println("check_value_ht: " + checkbox_list_healthTracker);
                for (WebElement chk_healthTracker : healthTracker_subMenues_list) {
                    System.out.println("chk_value_ht: " + chk_healthTracker.getText());
                    if (chk_healthTracker.getText().equalsIgnoreCase(cb_healthTracker))
                        System.out.println("chk_text_ht: " + chk_healthTracker.getText()); //'"+eventName+"
                    chk_healthTracker.findElement(By.xpath("//label[contains(text(),'" + cb_healthTracker + "')]")).click();
                    break;
                }
            }
            wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_healthTracker_feature_collapse_btn)).click();
        }
        String checkboxes_medicalCare = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 10);
        System.out.println("Data from excel: " + checkboxes_medicalCare);
        if (checkboxes_medicalCare.length() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_medicalCare_feature_expand_btn)).click();
            List<String> checkbox_list_medicalCare = new ArrayList<String>(Arrays.asList(checkboxes_medicalCare.split(",")));
            System.out.println("List_value_medicalCare: " + checkbox_list_medicalCare);
            List<WebElement> medicalCare_subMenues_list = pgs.medicalCare_subMenus;
            System.out.println("Medical Care size: " + medicalCare_subMenues_list.size());

            for (String cb_medicalCare : checkbox_list_medicalCare) {
                System.out.println("check value: " + checkbox_list_medicalCare);
                for (WebElement chk_medicalCare : medicalCare_subMenues_list) {
                    System.out.println("chk value: " + chk_medicalCare);
                    if (chk_medicalCare.getText().equalsIgnoreCase(cb_medicalCare))
                        System.out.println("chk text: " + chk_medicalCare.getText()); //'"+eventName+"
                    chk_medicalCare.findElement(By.xpath("//label[contains(text(),'" + cb_medicalCare + "')]")).click();
                    break;
                }
            }
            wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_medicalCare_feature_collapse_btn)).click();
        }
        String checkbox_Alerts = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 11);
        if (checkbox_Alerts.equalsIgnoreCase("Y")) {
            pgs.features_alerts_checkbox.click();
        }
        String checkbox_healthTopic = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 12);
        if (checkbox_healthTopic.equalsIgnoreCase("Y")) {
            pgs.features_healthTopic_checkbox.click();
        }
        String checkbox_myDocument = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 13);
        if (checkbox_myDocument.equalsIgnoreCase("Y")) {
            pgs.features_myDocument_checkbox.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(pgs.add_access_sharing_btn)).click();
        Assert.assertTrue(pgs.access_sharing_added_successfully_popUp.isDisplayed());
    }

    @Test(priority = 103, enabled = true)
    public static void profilePageTC_103() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_added_successfully_popUp_viewInfo)).click();
        Assert.assertTrue(pgs.access_sharing_recordsPage_contents.isDisplayed());
    }

    @Test(priority = 104, enabled = true)
    public static void profilePageTC_104() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_recordspage_editBtn)).click();
        Swipe.swipeVerticalDown(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(pgs.add_access_sharing_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_added_successfully_popUp_addMore)).click();
        Assert.assertTrue(pgs.access_sharing_add_page_contents.isDisplayed());
    }

    @Test(priority = 105, enabled = true)
    public static void profilePageTC_105() {

        Swipe.swipeVerticalDown(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(pgs.add_access_sharing_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_added_successfully_popUp_viewInfo)).click();
        String lastName = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 0);
        String firstName = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 1);
        String cname = lastName + "," + firstName;
        System.out.println("cname: " + cname);
        System.out.println("name present in records: " + pgs.access_sharing_recordspage_userName.getText());
        Assert.assertEquals(pgs.access_sharing_recordspage_userName.getText(), cname);

    }

    @Test(priority = 106, enabled = true)
    public static void profilePageTC_106() {

        String lastName = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 0);
        String firstName = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 1);
        String cname = lastName + "," + firstName;
        System.out.println("cname: " + cname);
        System.out.println("name present in records: " + pgs.access_sharing_recordspage_userName.getText());
        Assert.assertEquals(pgs.access_sharing_recordspage_userName.getText(), cname);
    }

    @Test(priority = 107, enabled = true)
    public static void profilePageTC_107() {

        Assert.assertTrue(pgs.access_sharing_recordspage_userName.isDisplayed());
    }

    @Test(priority = 108, enabled = true)
    public static void profilePageTC_108() {

        Assert.assertTrue(pgs.access_sharing_recordspage_email.isDisplayed());
    }

    @Test(priority = 109, enabled = true)
    public static void profilePageTC_109() {

        Assert.assertTrue(pgs.access_sharing_recordspage_email.isDisplayed());
    }

    @Test(priority = 110, enabled = true)
    public static void profilePageTC_110() {

        Assert.assertTrue(pgs.access_sharing_recordspage_relationShip.isDisplayed());
    }

    @Test(priority = 111, enabled = true)
    public static void profilePageTC_111() {

        Assert.assertTrue(pgs.access_sharing_recordspage_relationShip.isDisplayed());
    }

    @Test(priority = 112, enabled = true)
    public static void profilePageTC_112() {

        if (ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 5).equals(" ")) {
            System.out.println("Other relationship is blank");
        } else {
            String other = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 5);
            Assert.assertEquals(pgs.access_sharing_recordspage_relationShip.getText(), ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 5));
        }
    }

    @Test(priority = 113, enabled = true)
    public static void profilePageTC_113() {

        Assert.assertEquals(pgs.access_sharing_recordspage_expiryDate.getText(), ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 7));
    }

    @Test(priority = 114, enabled = true)
    public static void profilePageTC_114() {

        Assert.assertEquals(pgs.access_sharing_recordspage_expiryDate.getText(), ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 7));
    }

    @Test(priority = 115, enabled = true)
    public static void profilePageTC_115() {

        Assert.assertEquals(pgs.access_sharing_recordspage_createdDate.getText(), ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 6));
    }

    @Test(priority = 116, enabled = true)
    public static void profilePageTC_116() {

        Assert.assertEquals(pgs.access_sharing_recordspage_createdDate.getText(), ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 6));
    }

    @Test(priority = 117, enabled = true)
    public static void profilePageTC_117() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_recordspage_deleteBtn)).click();
        Assert.assertTrue(pgs.access_sharing_deleteConfirmation_popUp.isDisplayed());
    }

    @Test(priority = 118, enabled = true)
    public static void profilePageTC_118() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_deleteConfirmation_popUp_No_btn)).click();
        Assert.assertTrue(pgs.access_sharing_recordsPage_contents.isDisplayed());
    }

    @Test(priority = 119, enabled = true)
    public static void profilePageTC_119() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_recordspage_deleteBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_deleteConfirmation_popUp_Yes_btn)).click();
        Assert.assertTrue(pgs.access_sharing_deletedSuccessfully_ok_btn.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_deletedSuccessfully_ok_btn)).click();
    }

    @Test(priority = 120, enabled = true)
    public static void profilePageTC_120() {

        String delete_record_last_name = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 0);
        String delete_record_first_name = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 1);
        String name = delete_record_last_name + "," + delete_record_first_name;
        System.out.println("deleted record user name: " + name);


        for (int i = 0; i < pgs.access_sharing_deletedRecord_Validation.size(); i++) {
            System.out.println("ele: " + pgs.access_sharing_deletedRecord_Validation.get(i).getText());
            Assert.assertNotEquals(pgs.access_sharing_deletedRecord_Validation.get(i).getText(), name);
        }
    }

    @Test(priority = 121, enabled = true)
    public static void profilePageTC_121() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_editBtn)).click();
        Assert.assertTrue(pgs.access_sharing_add_page_contents.isDisplayed());
    }

    @Test(priority = 122, enabled = true)
    public static void profilePageTC_122() {

        Swipe.swipeVerticalDown(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_update_btn)).click();
        Assert.assertTrue(pgs.access_sharing_recordsPage_contents.isDisplayed());
        System.out.println("Hii");
    }

    @Test(priority = 123, enabled = true)
    public static void profilePageTC_123() throws Exception {
        log.info("Getting user lastname from excel");
        String lastName = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 0);
        log.info("Getting user firstname from excel");
        String firstName = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 1);
        log.info("Appending firstname with lastname");
        String cname = lastName + "," + firstName;
        System.out.println("cname: " + cname);
        //System.out.println("name present in records: " + pgs.access_sharing_recordspage_userName.getText());
        log.info("Printing total access sharing user records");
        System.out.println("Records present in access sharing: "+pgs.access_sharing_recordspage_userName_list.size());
        log.info("Finding required user and clicking his/her edit button");
        for(WebElement wl :pgs.access_sharing_recordspage_userName_list) {

           try {
               if (wl.getText().equalsIgnoreCase(cname)) {
                   System.out.println(wl.getText());
                   //System.out.println("Hii");
                   driver.findElement(By.xpath("//b[text()='"+cname+"']/parent::*/following-sibling::*//div[@class='as-edit']")).click();
               }
           } catch (Exception e) {
               System.out.println("Exception in finding element: " + e.getMessage());
            }
        }
        log.info("Clicking on access level dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(pgs.Access_sharing_access_level_dropDown)).click();
        instance = driver.getClass().getName();
        log.info("Scrolling and selecting the access level value");
        if (instance.contains("AndroidDriver")) {
            Scroll.scrollToText(driver, "View");
        } else if (instance.contains("IOSDriver")) {
            Select dropdown = new Select(pgs.Access_sharing_access_level_dropDown);
            dropdown.selectByVisibleText("View");

        } else {
            System.out.println("Unable to find dropdown data");
            log.info("Unable to find  access level dropdown data");
        }
        log.info("Swiping vertiacally up");
        Swipe.swipeVerticalDown(driver,3);
        log.info("Clicking on access sharing add button");
        wait.until(ExpectedConditions.elementToBeClickable(pgs.add_access_sharing_btn)).click();
        log.info("Clicking on view info button in added successfully pop up");
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_added_successfully_popUp_viewInfo)).click();
        log.info("Clicking on menu button");
        wait.until(ExpectedConditions.elementToBeClickable(pgs.menu_btn)).click();
        log.info("Clicking on log out button");
        wait.until(ExpectedConditions.elementToBeClickable(pgs.user_logOut_btn)).click();
        log.info("Clearing username text field");
        wait.until(ExpectedConditions.elementToBeClickable(lps.username_txt_field)).clear();
        log.info("Entering username data");
        wait.until(ExpectedConditions.elementToBeClickable(lps.username_txt_field)).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 14));
        log.info("Clearing password text field");
        wait.until(ExpectedConditions.elementToBeClickable(lps.password_txt_field)).clear();
        log.info("Entering password data");
        wait.until(ExpectedConditions.elementToBeClickable(lps.password_txt_field)).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 15));
        log.info("Hiding device keypad");
        HideKeyBoard.hideKeyBoard(driver);
        log.info("Clicking on login button");
        wait.until(ExpectedConditions.elementToBeClickable(lps.login_btn)).click();
        log.info("Validating dashboard page");
        if(wait.until(ExpectedConditions.visibilityOf(lps.login_In_Check)).isDisplayed()){
            System.out.println("Sucessfully logged in");
            log.info("Dashboard displayed");
        }
        else {
            log.info("login Unsuccessful");

        }
         log.info("Retrieving shared user firstname");
         String shared_user_firstname = ExcelUtility.readTestdata(testdataSheet, "LoginPageUC", 1, 2);
         log.info("Retrieving shared user lastname");
         String shared_user_lastname = ExcelUtility.readTestdata(testdataSheet, "LoginPageUC", 1, 3);
        log.info("Appending shared user lastname with firstname");
         String shared_user_name = shared_user_lastname+ " "+shared_user_firstname;
         System.out.println("shared user name: "+shared_user_name);
        log.info("Checking if multiple shared access sharing users present");
        try
        {
            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
            if(pgs.manage_btn_drop_down.isDisplayed())
            {
                pgs.manage_btn_drop_down.click();
            }
        }catch(Exception e)
        {
            System.out.println("Exception in getting element: "+e.getMessage());
            log.info("Exception in getting element: "+e.getMessage());
        }
        log.info("Printing total access sharing users");
        System.out.println("total access sharing users: "+pgs.access_sharing_users.size());
        log.info("Checking for the required shared access sharing user and cliking manage button for the user ");
        for(WebElement a :pgs.access_sharing_users)
        {
            System.out.println(a.getText());
            System.out.println(shared_user_name);
            if(a.getText().contains(shared_user_name))
            {
              a.findElement(By.xpath("//li[@class='access_name' and contains(text(),'"+shared_user_name+"')]/following-sibling::*/input[@class='access_button']")).click();
            }
        }
        log.info("Clicking on shared profile tab");
        wait.until(ExpectedConditions.elementToBeClickable(pgs.shared_profile_tab)).click();
        log.info("Retrieving profile total sub-menus from excel ");
        String checkboxes_profile = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 8);
        System.out.println("Checkboxes_profile: "+checkboxes_profile);
        log.info("Checking if profile submenus containing physicians");
        if(checkboxes_profile.contains("Physicians")) {
            log.info("Clicking on shared physicians tab");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.physicians_tab)).click();
            log.info("Swiping down");
            Swipe.swipeVerticalDown(driver,3);
            log.info("Validating if add physicians button displaying");
            Assert.assertFalse(pgs.add_physicians_icon.isDisplayed());
            log.info("Swiping Up");
            Swipe.swipeVerticalUp(driver,3);
            log.info("Clicking on back button");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
        }
        log.info("Checking if profile submenus containing pharmacy");
        if(checkboxes_profile.contains("Pharmacy")) {
            log.info("Clicking on pharmacy tab");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.pharmacy_tab)).click();
            log.info("Swiping down");
            Swipe.swipeVerticalDown(driver,3);
            log.info("Validating if pharmacy add button displaying");
            Assert.assertFalse(pgs.pharmacy_add_icon.isDisplayed());
            log.info("Swiping up");
            Swipe.swipeVerticalUp(driver,3);
            log.info("Clicking on back button");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
        }
        log.info("Checking if profile submenus containing Insurance");
        if(checkboxes_profile.contains("Insurance")) {
            log.info("Clicking on insurance tab");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.insurance_tab)).click();
            log.info("Swiping down");
            Swipe.swipeVerticalDown(driver,3);
            log.info("Validating if insurance add button displaying");
            Assert.assertFalse(pgs.insurarce_add_icon.isDisplayed());
            log.info("Swiping up");
            Swipe.swipeVerticalUp(driver,3);
            log.info("Clicking on back button");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
        }
        log.info("Checking if profile submenus containing Social History");
        if(checkboxes_profile.contains("Social History")) {
            log.info("Clicking on social history tab");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.social_history_tab)).click();
            log.info("Swiping down");
            Swipe.swipeVerticalDown(driver,3);
            log.info("Validating if edit button is displaying");
            Assert.assertFalse(pgs.socialHistory_edit_btn.isDisplayed());
            log.info("Swiping up");
            Swipe.swipeVerticalUp(driver,3);
            log.info("Clicking on back button");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
        }
        log.info("Clicking on back button");
        wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
        log.info("Clicking on shared health tracker tab");
        wait.until(ExpectedConditions.elementToBeClickable(pgs.shared_Health_Tracker_tab)).click();
        log.info("retrieving healthracker sub menus from excel");
        String checkboxes_health_tracker = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 9);
        log.info("Checking if health tracker submenus containing Weight");
        if(checkboxes_health_tracker.contains("Weight")) {
            log.info("Clicking on weight tab");
            wait.until(ExpectedConditions.elementToBeClickable(hps.weight_tab)).click();
            log.info("Swiping down");
            Swipe.swipeVerticalDown(driver,3);
            log.info("Validating if add weight button displaying");
            Assert.assertFalse(hps.add_weight_btn.isDisplayed());
            log.info("Swiping up");
            Swipe.swipeVerticalUp(driver,3);
            log.info("Clicking on back button");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
        }
        log.info("Checking if health tracker submenus containing blood pressure");
        if(checkboxes_health_tracker.contains("Blood Pressure")) {
            log.info("Clicking on blood pressure tab");
            wait.until(ExpectedConditions.elementToBeClickable(hps.blood_pressure_tab)).click();
            log.info("Swiping down");
            Swipe.swipeVerticalDown(driver,3);
            log.info("Validating if add blood pressure button displaying");
            Assert.assertFalse(hps.add_weight_btn.isDisplayed());
            log.info("Swiping up");
            Swipe.swipeVerticalUp(driver,3);
            log.info("Clicking on back button");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
        }



    }
}























//	@Test(priority=9,enabled=true) //access-sharing
//	public static void profilePageTC_009() throws Exception
//	{
//
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.access_sharing_tab())).click();
//		try{
//			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//			if(pgss.No_record_message().isDisplayed())
//			{
//				System.out.println("Records are not present");
//			}
//
//		}catch(Exception e)
//		{
//			System.out.println("records are present");
//		}
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.add_access_sharing_add_icon())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.search_user_by_lastName())).sendKeys("miller");
//
//		try
//        {
//            driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
//            if(pgss.search_check_user_available().isDisplayed())
//            {
//                System.out.println("User11 not present");
//
//            }
//        }
//        catch(Exception e)
//        {
//            System.out.println(("Entered lastname of user available"));
//            wait.until(ExpectedConditions.elementToBeClickable(pgss.search_user_autopopulate_field())).isDisplayed();
//        }
//        List<WebElement> fname = driver.findElements(By.xpath("//ul[@class='flexdatalist-results']/li/span[@class='item item-firstName']"));
//		List<WebElement> email = driver.findElements(By.xpath("//ul[@class='flexdatalist-results']/li/span[@class='item item-email']"));
//		try{
//
//			for(WebElement ele :fname )
//			{
//				for(WebElement ele2 : email)
//				{
//					if(ele.getText().equalsIgnoreCase("john") && ele2.getText().equalsIgnoreCase("akash.mahato@healthec.com")){
//						System.out.println("user found");
//						ele.click();
//						break;
//					}
//					System.out.println("user not found");
//                    throw new AssertionError("User11 not present");
//				}
//			}
//
//			*//*for(WebElement ele :fname )
//		    {
//			if(ele.getText().equalsIgnoreCase("test1122")){
//				for(WebElement ele2 : email)
//				{
//					if(ele2.getText().equalsIgnoreCase("prasanna.kumar@healthec.com")){
//						System.out.println("element found");
//						ele.click();
//						break;
//					}
//				}
//
//			}
//		}*//*
//		}catch(Exception e)
//	  {
//			System.out.println("Exception in getting user name: "+e.getMessage());
//		}
//	//	WebElement wb = driver.findElement(By.xpath("//ul[@class='flexdatalist-results']"));
//		//Swipe.swipeVerticalUpWithDimensions(driver, 3000,wb );
//		//SwitchView.changeContext(driver, "NATIVE_APP");
//		/*WebElement el1 = driver.findElement(By.xpath("//*[@class='android.widget.ListView']"));
//		Swipe.swipeVerticalUpWithDimensions(driver, 3000,el1 );
//		*//*
//		*//*try{
//
//			Point p = pgss.search_user().getLocation();
//			int searc_user_x = p.getX();
//			int searc_user_y = p.getY();
//
//			int search_ht = wb.getSize().getHeight();
//			int search_wd = wb.getSize().getWidth();
//		//	System.out.println("X-axis: "+searc_user_x+","+"Y-axis: "+searc_user_y+"ht: "+search_ht+","+"wdth: "+search_wd);
//
//			Swipe.swipeVerticalUpWithDimensions(driver, 3000,wb );
//		}catch(Exception e)
//		{
//			System.out.println("Exception in swipe for user_search box: "+e.getMessage() );
//		}*//*
//		*//*String lname = wait.until(ExpectedConditions.elementToBeClickable(pgss.search_user_lastname_txt_field())).getAttribute("value");
//		System.out.println("lastname displaying: "+lname);
//		Assert.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(pgss.search_user_lastname_txt_field())).getAttribute("value"), "test");
//		Assert.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(pgss.search_user_firstname_txt_field())).getAttribute("value"), "test1122");
//		Assert.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(pgss.search_user_email_txt_field())).getAttribute("value"), "prasanna.kumar@healthec.com");
//	    HideKeyBoard.hideKeyBoard(driver);*//*
//
//
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_relationship_dropdown())).click();
//		Scroll.scrollToText(driver, "Brother");
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_level_dropdown())).click();
//		Scroll.scrollToText(driver, "View & Modify");
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_duration_dromDate_datePicker())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_duration_from_month())).click();
//		System.out.println("Total months: "+pgss.user_access_duration_from_select_month().size());
//		String from_date_received = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 5);
//		System.out.println(from_date_received);
//		DateCheck from_dt = new DateCheck(from_date_received);
//		String from_month = from_dt.getMonth();
//		int from_year = from_dt.getYear();
//		String from_day = Integer.toString(from_dt.getDay());
//		System.out.println(from_month);
//		System.out.println(from_year);
//		System.out.println(from_day);
//
//		Scroll.scrollToText(driver,from_month);
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_duration_from_year())).click();
//		System.out.println("Total years: "+pgss.user_access_duration_from_select_year().size());
//		Scroll.scrollToText(driver, from_year);
//
//
//		System.out.println("Totals dates: "+pgss.user_access_duration_from_select_dates().size());
//		for(WebElement days : pgss.user_access_duration_from_select_dates())
//		{
//			if(days.getText().equals(from_day))
//			{
//				//System.out.println(days.getText());
//				days.click();
//				break;
//			}
//			else{
//				//System.out.println(days.getText());
//				System.out.println("Not able to find dates in from date picker");
//			}
//		}
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_duration_fromdate_Ok_btn())).click();
//		Thread.sleep(4000);
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_duration_todate_datePicker())).click();
//
//		System.out.println("Clicked on to date datepicker");
//
//
//
//		//driver.findElement(By.xpath("//div[@id='dobDatePicker1']//select[@class='ui-datepicker-month']")).click();
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_duration_todate_month_dropdown())).click();
//		System.out.println("Total months: "+pgss.user_access_duration_from_select_month().size());
//		String to_date_received = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 6);
//		DateCheck to_dt = new DateCheck(to_date_received);
//		String to_month = to_dt.getMonth();
//		int to_year = to_dt.getYear();
//		String to_day = Integer.toString(to_dt.getDay());
//		System.out.println(to_month);
//		System.out.println(from_year);
//		System.out.println(from_day);
//		Scroll.scrollToText(driver, to_month);
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_duration_todate_year_dropdown())).click();
//		System.out.println("Total months: "+pgss.user_access_duration_from_select_year().size());
//		Scroll.scrollToText(driver, to_year);
//		System.out.println("Totals dates: "+pgss.user_access_duration_from_select_dates().size());
//		for(WebElement days : pgss.user_access_duration_from_select_dates())
//		{
//			if(days.getText().equals(to_day))
//			{
//				days.click();
//				break;
//			}
//			else{
//				System.out.println("Not able to find dates in to date picker");
//			}
//		}
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_duration_toDate_ok_btn())).click();
//		Swipe.swipeVerticalDown(driver, 5);
//		String checkboxes_profile = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 7);
//		System.out.println("Data from excel: "+checkboxes_profile);
//		if(checkboxes_profile.length()>0)
//		{
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.profile_expand_btn_open())).click();
//		List<String> checkbox_list_profile = new ArrayList<String>(Arrays.asList(checkboxes_profile.split(",")));
//		System.out.println("List value: "+checkbox_list_profile);
//		List<WebElement>profile_subMenues_list = pgss.profile_subMenus();
//		System.out.println("profile size: "+profile_subMenues_list.size());
//
//
//		for(String cb_profile : checkbox_list_profile){
//			System.out.println("check value: "+checkbox_list_profile);
//		 for (WebElement chk_profile : profile_subMenues_list){
//			 System.out.println("chk value: "+chk_profile);
//			if(chk_profile.getText().equalsIgnoreCase(cb_profile))
//				System.out.println("chk text: "+chk_profile.getText()); //'"+eventName+"
//			chk_profile.findElement(By.xpath("//label[contains(text(),'"+cb_profile+"')]")).click();
//			   break;
//			 }
//		 }
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.profile_expand_btn_close())).click();
//		}
//		String checkboxes_healthTracker = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 8);
//		System.out.println("Data from excel: "+checkboxes_healthTracker);
//		if(checkboxes_healthTracker.length()>0)
//		{
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.healthTracker_expand_btn_open())).click();
//		List<String> checkbox_list_healthTracker = new ArrayList<String>(Arrays.asList(checkboxes_healthTracker.split(",")));
//		System.out.println("List value: "+checkbox_list_healthTracker);
//		List<WebElement>healthTracker_subMenues_list = pgss.healthTracker_subMenus();
//		System.out.println("profile size: "+healthTracker_subMenues_list.size());
//
//		for(String cb_healthTracker : checkbox_list_healthTracker){
//			System.out.println("check value: "+checkbox_list_healthTracker);
//		 for (WebElement chk_healthTracker : healthTracker_subMenues_list){
//			 System.out.println("chk value: "+chk_healthTracker);
//			if(chk_healthTracker.getText().equalsIgnoreCase(cb_healthTracker))
//				System.out.println("chk text: "+chk_healthTracker.getText()); //'"+eventName+"
//			chk_healthTracker.findElement(By.xpath("//label[contains(text(),'"+cb_healthTracker+"')]")).click();
//			   break;
//			 }
//		 }
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.healthTracker_expand_btn_close())).click();
//		}
//		String checkboxes_medicalCare = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 9);
//		System.out.println("Data from excel: "+checkboxes_medicalCare);
//		if(checkboxes_medicalCare.length()>0)
//		{
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.medicalCare_expand_btn_open())).click();
//		List<String> checkbox_list_medicalCare = new ArrayList<String>(Arrays.asList(checkboxes_medicalCare.split(",")));
//		System.out.println("List value: "+checkbox_list_medicalCare);
//		List<WebElement>medicalCare_subMenues_list = pgss.medicalCare_subMenus();
//		System.out.println("profile size: "+medicalCare_subMenues_list.size());
//
//		for(String cb_medicalCare : checkbox_list_medicalCare){
//			System.out.println("check value: "+checkbox_list_medicalCare);
//		 for (WebElement chk_medicalCare : medicalCare_subMenues_list){
//			 System.out.println("chk value: "+chk_medicalCare);
//			if(chk_medicalCare.getText().equalsIgnoreCase(cb_medicalCare))
//				System.out.println("chk text: "+chk_medicalCare.getText()); //'"+eventName+"
//			chk_medicalCare.findElement(By.xpath("//label[contains(text(),'"+cb_medicalCare+"')]")).click();
//			   break;
//			 }
//		 }
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.medicalCare_expand_btn_close())).click();
//		}
//		String checkbox_Alerts = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing",1,10);
//		if(checkbox_Alerts.equalsIgnoreCase("Y"))
//		{
//			pgss.alerts_checkBox().click();
//		}
//		String checkbox_healthTopic = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing",1,11);
//		if(checkbox_healthTopic.equalsIgnoreCase("Y"))
//		{
//			pgss.healthTopic_checkBox().click();
//		}
//		String checkbox_myDocument = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing",1,12);
//		if(checkbox_myDocument.equalsIgnoreCase("Y"))
//		{
//			pgss.myDocument_checkBox().click();
//		}
//
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.add_access_sharing_btn())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.access_sharing_view_info_btn())).click();


		

	
	


