package com.healthec.objectRepo;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPageObjects {

    RemoteWebDriver driver;

  public DashboardPageObjects (RemoteWebDriver driver) {
      this.driver = driver;
      PageFactory.initElements(new AppiumFieldDecorator(driver),this);
  }

   //Moods
    @FindBy(className = "menu-open-button")
    public WebElement moods;
    @FindBy(xpath = "//img[@src='assets/images/1.png']")
    public WebElement mood1;
    @FindBy(xpath = "//img[@src='assets/images/2.png' and @id='2']")
    public WebElement mood2;
    @FindBy(xpath = "//img[@src='assets/images/3.png' and @id='3']")
    public WebElement mood3;
    @FindBy(xpath = "//img[@src='assets/images/4.png' and @id='4']")
    public WebElement mood4;
    @FindBy(xpath = "//img[@src='assets/images/5.png']")
    public WebElement mood5;

    //dashboard-box
    @FindBy(className = "calorie-box")
    public WebElement calorie_box;
    @FindBy(className = "bmibox")
    public WebElement bmi_box;
    @FindBy(className = "bp-box")
    public WebElement bp_box;
    @FindBy(xpath = "//i[@class='material-icons sub_head_lft_arrw_icn']")
    public WebElement back_btn;

    //remainder
    @FindBy(xpath = "//ul[@class='week-grid-list']/li[contains(@class,'day-pa')]")
    public List<WebElement> displaying_week_list;
   /* @FindBy(xpath = "//ul[@id='check']/li[contains(@class,'day-pa')]")
    public List<WebElement> displaying_week_list;*/
    @FindBy(xpath = "//div[@class='no-records-msg']")
    public WebElement no_record_text;

    //Menu
    @FindBy(xpath = "//i[@class='material-icons header_menu_icn']")
    public WebElement menu_btn;
    @FindBy(xpath = "//i[@class='material-icons panel_lft_arrw_icn']")
    public WebElement menu_back_btn;
    @FindBy(id = "idHome")
    public WebElement home_tab;
    @FindBy(xpath = "//span[contains(text(),'Profile')]")
    public WebElement profile_tab;
    @FindBy(xpath = "//span[contains(text(),'Health Tracker')]")
    public WebElement healthTracker_tab;
    @FindBy(xpath = "//span[contains(text(),'Medical Care')]")
    public WebElement medicalCare_tab;
    @FindBy(xpath = "//span[contains(text(),'Alerts')]")
    public WebElement alerts_tab;
    @FindBy(xpath = "//span[contains(text(),'Health Topic')]")
    public WebElement healthTopic_tab;
    @FindBy(id = "mplus-logo")
    public WebElement healthTopic_page;
    @FindBy(id = "com.healthec.providereconnect.phrpro:id/progressBar")
    public WebElement healthTopic_spinner;
    @FindBy(xpath = "//span[contains(text(),'My Document')]")
    public WebElement myDocument_tab;
    @FindBy(xpath = "//span[contains(text(),'Settings')]")
    public WebElement settings_tab;
    @FindBy(xpath = "//span[contains(text(),'Help')]")
    public WebElement help_tab;
    @FindBy(xpath = "//small[contains(text(),'Contact Us')]")
    public WebElement contact_us_tab;
    @FindBy(xpath = "//small[contains(text(),'Privacy Policy')]")
    public WebElement privacy_policy_tab;
    @FindBy(xpath = "//small[contains(text(),'Terms of Use')]")
    public WebElement terms_of_use_tab;













}
