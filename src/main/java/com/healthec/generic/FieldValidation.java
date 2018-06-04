package com.healthec.generic;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class FieldValidation {

    public static WebDriverWait wait;
    public static ExcelData testcase;

    public FieldValidation() {
        TestBaseClass.testcaseInit();
        //System.out.println("testcase: "+testcase);

    }


    public static WebElement textFieldValidation(RemoteWebDriver driver, WebElement element, String testClassName, String testcaseName) {
        int success = 0;
        testcase = TestBaseClass.testcaseExcel;
        //System.out.println("testcase: "+testcase);
        wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        /***************************************Presence*************************************************************/
        int height_val = 0, width_val = 0, x_val = 0, y_val = 0;
        Boolean obj_exist = false;
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Dimension dimesions = element.getSize();
            height_val = dimesions.height;
            width_val = dimesions.width;

            Point point = element.getLocation();
            x_val = point.x;
            y_val = point.y;

            if (height_val != 0 && width_val != 0) {
                obj_exist = true;
                success = 1;
            }
            if (x_val != 0 && y_val != 0) {
                obj_exist = true;
                success = 1;
            }

        } catch (Exception e) {
            System.out.println("Element not present: " + e.getMessage());
            ExcelUtility.writeStatus(testcase, testClassName, testcaseName, "Actual_Output", "Element not present ");
            ExcelUtility.writeStatus(testcase, testClassName, testcaseName, "Console_Output", e.getMessage());

        }
        /***************************************Visibility*************************************************************/
        if (success == 1) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                //ExcelUtility.writeStatus(testcase, testClassName, testcaseName, "Actual_Output", "HII Checking");

            } catch (Exception e) {
                System.out.println("Element not displaying: " + e.getMessage());
                ExcelUtility.writeStatus(testcase, testClassName, testcaseName, "Actual_Output", "Unable to click on element");
                ExcelUtility.writeStatus(testcase, testClassName, testcaseName, "Console_Output", e.getMessage());

            }
        }
        /***************************************Clickable*************************************************************/
        if (success == 1) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));

            } catch (Exception e) {
                System.out.println("Unable to click: " + e.getMessage());
                ExcelUtility.writeStatus(testcase, testClassName, testcaseName, "Actual_Output", e.getMessage());
                ExcelUtility.writeStatus(testcase, testClassName, testcaseName, "Console_Output", e.getMessage());

            }
        }
        if (success == 1)
            return element;
        else
          Assert.fail();
          return null;

    }











    public static WebElement contentValidation(RemoteWebDriver driver, WebElement element, String testClassName, String testcaseName) {

        int success = 0;
        testcase = TestBaseClass.testcaseExcel;
        //System.out.println("testcase: "+testcase);
        wait = new WebDriverWait(driver, 30);

        /***************************************Presence*************************************************************/
        int height_val = 0, width_val = 0, x_val = 0, y_val = 0;
        Boolean obj_exist = false;
        try {
            Dimension dimesions = element.getSize();
            height_val = dimesions.height;
            width_val = dimesions.width;

            Point point = element.getLocation();
            x_val = point.x;
            y_val = point.y;

            if (height_val != 0 && width_val != 0 && x_val != 0 && y_val != 0) {
                obj_exist = true;
                success = 1;
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not present: " + e.getMessage());
            ExcelUtility.writeStatus(testcase, testClassName, testcaseName, "Actual_Output", "Element not present ");
            ExcelUtility.writeStatus(testcase, testClassName, testcaseName, "Console_Output", "Element not present :"+e.getMessage());

        } catch (NullPointerException e) {
            System.out.println("Element not present: " + e.getMessage());
            ExcelUtility.writeStatus(testcase, testClassName, testcaseName, "Actual_Output", e.getMessage());

        }
        /***************************************Visibility*************************************************************/
        if (success == 1) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                //ExcelUtility.writeStatus(testcase, testClassName, testcaseName, "Actual_Output", "HII Checking");

            } catch (Exception e) {
                System.out.println("Element not displaying: " + e.getMessage());
                ExcelUtility.writeStatus(testcase, testClassName, testcaseName, "Actual_Output", "Unable to click on element");
                ExcelUtility.writeStatus(testcase, testClassName, testcaseName, "Actual_Output", e.getMessage());

            }
        }

        if (success == 1)
            return element;
        else
            Assert.fail();
        return null;

    }
}
