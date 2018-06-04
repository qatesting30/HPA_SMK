package com.healthec.objectRepo;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HealthTrackerPageObjects {

 public RemoteWebDriver driver;

 public HealthTrackerPageObjects(RemoteWebDriver driver)
 {
  this.driver = driver;
  PageFactory.initElements(new AppiumFieldDecorator(driver), this);
 }


    @FindBy(xpath = "//i[@class='material-icons header_menu_icn']")
    public WebElement menu_btn;
    @FindBy(xpath = "//span[contains(text(),'Health Tracker')]")
    public WebElement healthTracker_tab;
    @FindBy(xpath = "//strong[contains(text(),'Health Tracker')]")
    public WebElement healthTracker_page;

   //weight
    @FindBy(xpath = "//div[contains(text(),'Weight')]")
    public WebElement weight_tab;
    @FindBy(xpath = "//div[@class='no-records-msg']")
    public WebElement no_record_text;
    @FindBy(id = "idAddWeight")
    public WebElement add_weight_btn;
    @FindBy(id = "idGraph")
    public WebElement weight_graph_btn;
    @FindBy(id = "healthTrackerDate")
    public WebElement date_field;
    @FindBy(className = "ui-datepicker-year")
    public WebElement date_datePicker_year_dropdown;
    @FindBy(className = "ui-datepicker-month")
    public WebElement date_datePicker_month_dropdown;
    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")
    public List<WebElement> date_datePicker_day;
    @FindBy(id = "weight")
    public WebElement weight_field;
    @FindBy(id = "feet")
    public WebElement feet_field;
    @FindBy(id = "inches")
    public WebElement inches_field;
    @FindBy(id = "clearWeight")
    public WebElement clear_btn;
    @FindBy(id = "addWeight")
    public WebElement add_btn;
    @FindBy(id = "idMsg")
    public WebElement added_successfully_msg;
    @FindBy(id = "idAddMore")
    public WebElement add_more_btn;
    @FindBy(id = "idViewInfo")
    public WebElement view_info_btn;
    //blood pressure
    @FindBy(xpath = "//div[contains(text(),'Blood Pressure')]")
    public WebElement blood_pressure_tab;
    @FindBy(xpath = "//div[contains(text(),'Blood Glucose')]")
    public WebElement blood_glucose_tab;
    @FindBy(xpath = "//div[contains(text(),'Cholesterol')]")
    public WebElement cholesterol_tab;
    @FindBy(xpath = "//div[contains(text(),'Pulse Ox')]")
    public WebElement pulse_ox_tab;
    @FindBy(xpath = "//div[contains(text(),'Calorie Burned')]")
    public WebElement calorie_burned_tab;
    @FindBy(xpath = "//div[contains(text(),'Hours of Sleep')]")
    public WebElement hours_of_sleep_tab;
    @FindBy(xpath = "//div[contains(text(),'Temperature')]")
    public WebElement temperature_tab;


}
