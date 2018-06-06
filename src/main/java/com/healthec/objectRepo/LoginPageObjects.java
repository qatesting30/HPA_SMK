package com.healthec.objectRepo;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

    public RemoteWebDriver driver;
    public LoginPageObjects(RemoteWebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public String login_error_message = "User Name and Password are required";
    public String username_required_error_msg = "User Name Required";
    public String password_required_error_msg = "Password Required";








    //SignUp
    @FindBy(id= "backButton")
    public WebElement signUp_bck_btn;

    //ForgotPassword
    @FindBy(id= "idforgotpwd")
    public WebElement forgotPassword_link;

    @FindBy(id= "backButton")
    public WebElement forgotPassword_bck_btn;

    //login Page
    @FindBy(id= "userNameTxt")
    public WebElement username_txt_field;

    @FindBy(id= "passwordTxt")
    public WebElement password_txt_field;

    @FindBy(id= "loginBtn")
    public WebElement login_btn;

    @FindBy(id="demo-page")
    public WebElement login_In_Check;

    @FindBy(id="loginErr")
    public WebElement login_error_msg;

    @FindBy(id="passErr")
    public WebElement password_error_msg;

    @FindBy(id="idMsg")
    public WebElement invalid_credentials_popup;

    @FindBy(id = "idOk")
    public WebElement invalid_credentials_popup_Ok;

    @FindBy(id = "idRemberme")
    public WebElement rememnber_me_checkbox;


    @FindBy(xpath = "//a[@href='ContactUs.html']")
    public WebElement contact_us_link;

    @FindBy(xpath="//h1[contains(text(),'Contact Us')]")      ////android.view.View[contains(text(),'Contact Us')]
    public MobileElement contact_us_link_page_validation;

    @FindBy(xpath = "//a[@href='TermsofUse.html']")
    public WebElement terms_of_use_link;

    @FindBy(xpath="//h1[@class='head_title' and contains(text(),'TERMS OF USE')]")
    public WebElement terms_of_use_link_page_validation;


    @FindBy(xpath = "//a[@href='PrivacyPolicy.html']")
    public WebElement privacy_policy_link;

    @FindBy(xpath="//h1[@class='head_title' and contains(text(),'PRIVACY POLICY')]")
    public WebElement privacu_policy_link_page_validation;

    @FindBy(id = "idSignUp")
    public WebElement signUp_link;

    @FindBy(xpath = "//span[@id='userInfo']")
    public WebElement user_logged_in;




}
