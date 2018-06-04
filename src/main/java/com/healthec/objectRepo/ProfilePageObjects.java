package com.healthec.objectRepo;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePageObjects {

public RemoteWebDriver driver;

public ProfilePageObjects(RemoteWebDriver driver)
{
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}


    //contacts
    @FindBy(xpath="//i[@class='material-icons header_menu_icn']")
    public static WebElement menu_btn;
    @FindBy(xpath="//i[@class='material-icons panel_lft_arrw_icn']")
    public static WebElement menu_back_btn;
    @FindBy(xpath="//a[@id='backButton']/i")
    public static WebElement back_btn;
    @FindBy(xpath="//strong[contains(text(),'Profile')]")
    public static WebElement profile_page;
    @FindBys({@FindBy(xpath="//div[contains(text(),'Contacts')]"),@FindBy(xpath="//div[contains(text(),'Physicians')]"),@FindBy(xpath="//div[contains(text(),'Pharmacy')]"),
              @FindBy(xpath="//div[contains(text(),'Insurance')]"),@FindBy(xpath="//div[contains(text(),'Social History')]"),@FindBy(xpath="//div[contains(text(),'Access Sharing')]")})
    public static WebElement profile_sub_menus;
    @FindBy(id="idContactsPersonal")
    public static WebElement personal_contacts;
    @FindBys({@FindBy(xpath="//div[contains(text(),'Phone No')]"),@FindBy(xpath="//div[contains(text(),'Email')]"),
              @FindBy(xpath="//div[contains(text(),'Address')]"),@FindBy(xpath="//div[contains(text(),'City')]"),@FindBy(xpath="//div[contains(text(),'State')]"),
              @FindBy(xpath="//div[contains(text(),'Zipcode')]")})
    public static WebElement personal_contacts_total_fields;
    @FindBy(id="idHome")
    public static WebElement home_tab;
    @FindBy(xpath="//div[contains(text(),'Contacts')]")
    public static WebElement contacts_menu;
    @FindBy(xpath="//span[contains(text(),'Profile')]")
    public static WebElement profile_tab;
    @FindBy(id="editAndAdd")
    public static WebElement personal_editAndUpdate_btn;
    @FindBy(id="cancel")
    public static WebElement personal_cancel_btn;
    @FindBy(id="phoneNumber")
    public static WebElement personal_phone_number;
    @FindBy(id="emailID")
    public static WebElement personal_email;
    @FindBy(id="city")
    public static WebElement personal_city;
    @FindBy(id="address")
    public static WebElement personal_address;
    @FindBy(id="pinCode")
    public static WebElement personal_zip_code;
    @FindBy(id="state")
    public static WebElement personal_state;
    @FindBy(id="idOk1")
    public static WebElement personal_added_successfully_btn_ok;
   //Emergency
    @FindBy(id="idContactsEmergency")
    public static WebElement emergency_tab;
    @FindBys({@FindBy(xpath="//div[contains(text(),'First Name')]"),@FindBy(xpath="//div[contains(text(),'Last Name')]"),@FindBy(xpath="//div[contains(text(),'Phone No')]"),
              @FindBy(xpath="//div[contains(text(),'Email')]"),@FindBy(xpath="//div[contains(text(),'Street')]"),@FindBy(xpath="//div[contains(text(),'City')]"),
              @FindBy(xpath="//div[contains(text(),'State')]"),@FindBy(xpath="//div[contains(text(),'Zipcode')]")})
    public static WebElement emergency_field_total_contents;
    @FindBy(id="editAndAdd")
    public static WebElement emergency_editAndUpdate_btn;
    @FindBy(id="firstName")
    public static WebElement emergency_firstname;
    @FindBy(id="lastName")
    public static WebElement emergency_lastname;
    @FindBy(id="phoneNumber")
    public static WebElement emergency_phone_number;
    @FindBy(id="emailID")
    public static WebElement emergency_email;
    @FindBy(id="street")
    public static WebElement emergency_street;
    @FindBy(id="city")
    public static WebElement emergency_city;
    @FindBy(id="pinCode")
    public static WebElement emergency_zip_code;
    @FindBy(id="state")
    public static WebElement emergency_state;
    @FindBy(xpath="//input[@value='Cancel']")
    public static WebElement emergency_cancel_btn;
    @FindBy(xpath="//input[@value='Update']")
    public static WebElement emergency_update_btn;
    @FindBy(id="idOk1")
    public static WebElement emergency_updated_sucessfully_popup_btn;
    //physicians
    @FindBy(xpath="//div[contains(text(),'Physicians')]")
    public static WebElement physicians_tab;

    @FindBy(id="divphysicians")
    public static WebElement physician_results_page;

   /* @FindBys({@FindBy (xpath="//span[contains(text(),'Physician Type')]"),@FindBy (xpath="//span[contains(text(),'Physician Name')]"),
             @FindBy (xpath="//span[contains(text(),'Phone Number')]"),@FindBy (xpath="//span[contains(text(),'Physician Email')]")})
    public static WebElement physicians_records_grid_contents;*/

    @FindBys({@FindBy(xpath="//div[@id='divphysicians']/div[1]/div[1]/div[1]/div[2]/span[contains(text(),'Physician Type')]"),@FindBy(xpath="//div[@id='divphysicians']/div[1]/div[1]/div[2]/div[2]/span[contains(text(),'Physician Name')]"),
         @FindBy(xpath="//div[@id='divphysicians']/div[1]/div[2]/div[1]/div[2]/span[contains(text(),'Phone Number')]"),@FindBy(xpath="//div[@id='divphysicians']/div[1]/div[2]/div[2]/div[2]/span[contains(text(),'Physician Email')]"),
            @FindBy(xpath="//div[@id='divphysicians']/div[1]/div[3]/a/img[@class='Edit_Record']")})
    public static WebElement physicians_records_grid_contents;

    @FindBy(id="idViewAdd")
    public static WebElement add_physicians_icon;

    @FindBy(className="signUpTextBoxContainer")
    public static WebElement physician_add_page;

    @FindBys({@FindBy(xpath="//div[contains(text(),'Last Name')]"),@FindBy(xpath="//div[contains(text(),'First Name')]"),
            @FindBy(xpath="//div[contains(text(),'Phone Number')]"),@FindBy(xpath="//div[contains(text(),'Email')]"),
            @FindBy(xpath="//div[contains(text(),'Select Physician')]")})
    public static WebElement physicians_page_contents;

    @FindBy(id="idSelectPhyType")
    public static WebElement physician_type_dropdown;

    @FindBys({@FindBy(xpath="//option[contains(text(),'Dentist')]"),@FindBy(xpath="//option[contains(text(),'Facility (Hospital)')]"),
            @FindBy(xpath="//option[contains(text(),'Lab')]"),@FindBy(xpath="//option[contains(text(),'Primary Care Physician (PCP)')]"),
            @FindBy(xpath="//option[contains(text(),'Specialist')]")})
    public static WebElement physician_type_dropdown_values;

    @FindBy(id="idSelectSpeciality")
    public static WebElement select_speciality_field;

    @FindBy(id="idAddPhysician")
    public static WebElement add_physician_btn;

    @FindBy(xpath="//div[contains(text(),'Provide All Details')]")
    public static WebElement add_physicians_warning_msg;

    @FindBy(id="idLastName")
    public static WebElement lastname_txt_field;
    @FindBy(id="idFirstName")
    public static WebElement firstname_txt_field;
    @FindBy(id="idNumber")
    public static WebElement phoneNumber_txt_field;
    @FindBy(id="idEmail")
    public static WebElement email_txt_field;
    @FindBy(id="idMsg")
    public static WebElement physician_added_sucessfully_msg_pop_up;
    @FindBy(id="idAddMore")
    public static WebElement physician_addMore_btn;
    @FindBy(id="idViewInfo")
    public static WebElement physician_updatedSuccessfully_viewInfo_btn;
    @FindBy(xpath="//img[@src='assets/images/profile/physician/phoneView.png']")
    public static WebElement physician_call_btn;
    @FindBy(xpath="//img[@onclick='getVal(0);']")
    public static WebElement physician_edit_record_btn;
    @FindBy(id="idAddPhysician")
    public static WebElement physician_update_btn;
    @FindBy(id="idViewInfo")
    public static WebElement physician_update_successfully_btn;
    //pharmacy
    @FindBy(xpath="//div[contains(text(),'Pharmacy')]")
    public static WebElement pharmacy_tab;
    /*@FindBys({@FindBy (xpath="//span[contains(text(),'Pharmacy Name')]"),@FindBy (xpath="//span[contains(text(),'Contact Person')]"),
            @FindBy (xpath="//span[contains(text(),'Phone Number')]")})//@FindBy (xpath="//img[@class='Close_Record']"),@FindBy (xpath="//div[@class='Record_Footer']/img[@class='Edit_Record']"
    public static WebElement pharmacy_recordsPage_contents;*/

    @FindBys({@FindBy(xpath="//*[@id='idPharmacyRecord']/div[1]/div[1]/div[1]/div[2]/span[contains(text(),'Pharmacy Name')]"),@FindBy(xpath="//*[@id='idPharmacyRecord']/div[1]/div[1]/div[2]/div[2]/span[contains(text(),'Contact Person')]"),
            @FindBy(xpath="//*[@id='idPharmacyRecord']/div[1]/div[2]/div[1]/div[2]/span[contains(text(),'Phone Number')]"),@FindBy(xpath="//*[@id='idPharmacyRecord']/div[1]/div[3]/a/img[@class='Close_Record']"),@FindBy(xpath="//*[@id='idPharmacyRecord']/div[1]/div[3]/a/img[@class='Edit_Record']")})
    public static WebElement pharmacy_recordsPage_contents;

    @FindBy(id="idViewAdd")
    public static WebElement pharmacy_add_icon;
    @FindBys({@FindBy(xpath="//div[contains(text(),'Pharmacy Name')]"),@FindBy(xpath="//div[contains(text(),'Contact Person')]"),
            @FindBy(xpath="//div[contains(text(),'Phone Number')]")}) //@FindBy(id="idAddPharmacy")
    public static WebElement add_pharmacy_page_contents;
    @FindBy(id="loginErr")
    public static WebElement pharmacy_provideAlldetains_warning_msg;
    @FindBy(id="idPharmacyName")
    public static WebElement pharmacy_pharmacy_name_txt_field;
    @FindBy(id="idContactPerson")
    public static WebElement pharmacy_contact_person_text_field;
    @FindBy(id="idPhoneNumber")
    public static WebElement pharmacy_phone_number_txt_field;
    @FindBy(id="idAddPharmacy")
    public static WebElement pharmacy_add_pharmacy_btn;
    @FindBy(id="idMsg")
    public static WebElement pharmacy_add_successfully_msg_popUp;
    @FindBy(id="idAddMore")
    public static WebElement pharmacy_addMore_btn;
    @FindBy(id="idViewInfo")
    public static WebElement pharmacy_viewInfo_btn;
    @FindBy(xpath="//div[@id='idPharmacyRecord']/div[1]/div[3]/a/img[@class='Edit_Record']")
    public static WebElement pharmacy_edit_record;
    @FindBy(id="idAddPharmacy")
    public static WebElement pharmacy_update_btn;
    @FindBy(id="idMsg")
    public static WebElement pharmacy_updatedSuccessfully_popUp;
    @FindBy(id="idViewInfo")
    public static WebElement pharmacy_updatedSuccessfully_viewInfo_btn;
    @FindBy(xpath="//div[@id='idPharmacyRecord']/div[1]/div[3]/a/img[@class='Close_Record']")
    public static WebElement pharmacy_delete_record;
    @FindBy(id="idMsg1")
    public static WebElement pharmacy_deleteConfirmation_popup;
    @FindBy(id="idNo")
    public static WebElement pharmacy_deleteConfirmation_popup_No_btn;
    @FindBy(id="idYes")
    public static WebElement pharmacy_deleteConfirmation_popup_Yes_btn;
    @FindBy(id="idOk")
    public static WebElement pharmacy_deleteSuccessfull_ok_btn;
    //Insurance
    @FindBy(xpath="//div[contains(text(),'Insurance')]")
    public static WebElement insurance_tab;
    @FindBys({@FindBy(xpath="//div[@id='idInsuranceRecord']/div[1]/div[1]/div[1]/div[2]/span[contains(text(),'Insurance Type')]"),@FindBy(xpath="//div[@id='idInsuranceRecord']/div[1]/div[1]/div[2]/div[2]/span[contains(text(),'Plan Name')]"),
              @FindBy(xpath="//div[@id='idInsuranceRecord']/div[1]/div[2]/div[1]/div[2]/span[contains(text(),'Group Number')]"),@FindBy(xpath="//div[@id='idInsuranceRecord']/div[1]/div[2]/div[2]/div[2]/span[contains(text(),'Plan Type')]"),
              @FindBy(xpath="//div[@id='idInsuranceRecord']/div[1]/div[3]/a/img[@class='Close_Record']"),@FindBy(xpath="//div[@id='idInsuranceRecord']/div[1]/div[3]/a/img[@class='Edit_Record']")})
    public static WebElement insurance_records_page_contents;
    @FindBy(id="idViewAdd")
    public static WebElement insurarce_add_icon;
    @FindBys({@FindBy(xpath="//div[contains(text(),'Insurance Type')]"),@FindBy(xpath="//div[contains(text(),'Plan Type')]"),
            @FindBy(xpath="//div[contains(text(),'Plan Name')]"),@FindBy(xpath="//div[contains(text(),'Group Number')]")})
    public static WebElement insurance_add_page_contents;
    @FindBy(id="idInsuranceType")
    public static WebElement insurarce_insurance_type;
    @FindBy(id="idInsuranceType")
    public static WebElement selected_insuranceType_value;
    @FindBys({@FindBy(xpath="//option[contains(text(),'Compensation')]"),@FindBy(xpath="//option[contains(text(),'Managed Care')]"),
            @FindBy(xpath="//option[contains(text(),'Medicaid Managed Care')]"),@FindBy(xpath="//option[contains(text(),'Medicare Advantage')]"),
    @FindBy(xpath="//option[contains(text(),'No-Fault')]"),@FindBy(xpath="//option[contains(text(),'Primary')]"),
    @FindBy(xpath="//option[contains(text(),'Secondary')]"),@FindBy(xpath="//option[contains(text(),'Tertiary')]")})
    public static WebElement insurance_insurance_type_contents;
    @FindBy(id="idPlanType")
    public static WebElement insurarce_plan_type;
    @FindBy(xpath="//option[contains(text(),'Vision')]")
    public static WebElement selected_planType_value;
    @FindBys({@FindBy(xpath="//option[contains(text(),'Accident')]"),@FindBy(xpath="//option[contains(text(),'Accidental Death and Dismemberment')]"),
            @FindBy(xpath="//option[contains(text(),'Cancer')]"),@FindBy(xpath="//option[contains(text(),'Dental')]"),
            @FindBy(xpath="//option[contains(text(),'Disability')]"),@FindBy(xpath="//option[contains(text(),'Group accidental death')]"),
            @FindBy(xpath="//option[contains(text(),'Group dental')]"),@FindBy(xpath="//option[contains(text(),'Group disability')]"),
            @FindBy(xpath="//option[contains(text(),'Group life')]"),@FindBy(xpath="//option[contains(text(),'Group medical')]"),
            @FindBy(xpath="//option[contains(text(),'Group prescription')]"),@FindBy(xpath="//option[contains(text(),'Life')]"),
            @FindBy(xpath="//option[contains(text(),'Long Term Care')]"),@FindBy(xpath="//option[contains(text(),'Medical')]"),
            @FindBy(xpath="//option[contains(text(),'Medical (supplemental)')]"),@FindBy(xpath="//option[contains(text(),'Prescription drug')]"),
            @FindBy(xpath="//option[contains(text(),'Prescription drug (supplemental)')]"),@FindBy(xpath="//option[contains(text(),'Vision')]")})
    public static WebElement insurance_plan_type_contents;
    @FindBy(id="idPlanName")
    public static WebElement insurarce_plan_name_txt_field;
    @FindBy(id="idGroupNumber")
    public static WebElement insurarce_group_name_txt_field;
    @FindBy(id="loginErr")
    public static WebElement insurarce_warning_msg;
    @FindBy(id="idAddInsurance")
    public static WebElement insurarce_addInsurance_btn;
    @FindBy(id="idMsg")
    public static WebElement insurarce_updatedSuccessfully_popUp;
    @FindBy(id="idAddMore")
    public static WebElement insurarce_updatedSuccessfully_popUp_addMore;
    @FindBy(id="idViewInfo")
    public static WebElement insurarce_updatedSuccessfully_popUp_viewInfo;
    @FindBy(xpath="//div[@id='idInsuranceRecord']/div/div[3]/a/img[@class='Edit_Record']")
    public static WebElement insurance_editRecord;
    @FindBy(id="idAddInsurance")
    public static WebElement insurance_update_btn;
    @FindBy(id="idMsg")
    public static WebElement insurance_updated_sucessfully_popUp;
    @FindBy(id="idViewInfo")
    public static WebElement insurance_view_info_btn;
    @FindBy(xpath="//div[@id='idInsuranceRecord']/div/div[3]/a/img[@class='Close_Record']")
    public static WebElement insurance_delete_reocrd;
    @FindBy(id="idMsg3")
    public static WebElement insurance_deleteRecord_confirmation_popUp;
    @FindBy(id="idNo")
    public static WebElement insurance_deleteRecord_confirmation_popUp_No_btn;
    @FindBy(id="idYes")
    public static WebElement insurance_deleteRecord_confirmation_popUp_Yes_btn;
    @FindBy(id="idOk2")
    public static WebElement insurance_deletedSucessfully_Ok_btn;
    //social History
    @FindBy(xpath="//div[contains(text(),'Social History')]")
    public static WebElement social_history_tab;
    @FindBy(className="addPageLabel")
    public static List<WebElement> socialHistory_contents;
    @FindBy(id="idAddSocialHistory")
    public static WebElement socialHistory_edit_btn;
    @FindBy(id="idRadioAlcohalNo")
    public static WebElement socialHistory_drinkAlcohol_checkBox_No;
    @FindBy(id="idRadioAlcohalYes")
    public static WebElement socialHistory_drinkAlcohol_checkBox_Yes;
    @FindBy(id="idDrinkPerWeek")
    public static WebElement socialHistory_drinkPerWeek_txt_field;
    @FindBy(id="idDrinkNumberYear")
    public static WebElement socialHistory_drinkNoOfyears_txt_field;
    @FindBy(id="idRadioSmokeNo")
    public static WebElement socialHistory_smoke_checkBox_No;
    @FindBy(id="idRadioSmokeYes")
    public static WebElement socialHistory_smoke_checkBox_yes;
    @FindBy(id="idSmokePackPerWeek")
    public static WebElement socialHistory_smoke_packsPerWeek_txt_field;
    @FindBy(id="idSmokeNumberYear")
    public static WebElement socialHistory_smokeNoOfyears_txt_field;
    @FindBy(id="idRadioExerciseNo")
    public static WebElement socialHistory_Exercise_checkBox_No;
    @FindBy(id="idRadioExerciseYes")
    public static WebElement socialHistory_Exercise_checkBox_Yes;
    @FindBy(id="idExcerciseDayPerWeek")
    public static WebElement socialHistory_ExercisedayPerWeek_txt_field;
    @FindBy(id="idExerciseType")
    public static WebElement socialHistory_ExerciseType_txt_field;
    @FindBy(id="idUpdateSocialHistory")
    public static WebElement socialHistory_update_btn;
    @FindBy(id="idMsg")
    public static WebElement socialHistory_updated_successfully_popUp;
    @FindBy(id="idOk")
    public static WebElement socialHistory_updated_successfully_popUp_ok_btn;
    //Access-Sharing
    @FindBy(xpath="//div[contains(text(),'Access Sharing')]")
    public static WebElement access_sharing_tab;
    @FindBy(id="idAddAS")
    public static WebElement access_sharing_add_icon;
    @FindBys({@FindBy(xpath="//b[@class='as-name']"),@FindBy(xpath="//div[@class='as-email']"),@FindBy(xpath="//div[@class='as-neighbor']"),
            @FindBy(xpath="//div[@class='as-delete']"),@FindBy(xpath="//div[@class='as-edit']"),@FindBy(xpath="//div[@class='as-labsed']"),
            @FindBy(xpath="//div[@class='as-created-date']")})
    public static WebElement access_sharing_recordsPage_contents;
    @FindBy(xpath="//i[@class='material-icons sub_head_lft_arrw_icn']")
    public static WebElement access_sharing_back_btn;
    @FindBys({@FindBy(id="assignAccess"),@FindBy(xpath="//div[contains(text(),'Search')]"),@FindBy(xpath="//div[contains(text(),'Add Person')]"),@FindBy(xpath="//div[contains(text(),'Relationship')]"),
            @FindBy(xpath="//div[contains(text(),'Access Level')]"),@FindBy(xpath="//span[contains(text(),'Access Duration')]"),@FindBy(xpath="//span[contains(text(),'Select Features')]"),
            @FindBy(xpath="//label[contains(text(),'Notes')]")})
    public static WebElement access_sharing_add_page_contents;
    @FindBy(xpath="//div[@class='list-panel not-lapsed']")
    public static WebElement access_sharing_record_present_list;
    @FindBy(xpath="//li[@class='item no-results']")
    public static WebElement search_no_user_results_found;
    @FindBy(className="flexdatalist-results")
    public static WebElement search_autopopulate_user;
    @FindBy(xpath="//ul[@class='flexdatalist-results']/li/span[@class='item item-firstName']")
    public static List<WebElement> search_firstName;
    @FindBy(xpath="//ul[@class='flexdatalist-results']/li/span[@class='item item-email']")
    public static List<WebElement> search_email;
    @FindBy(id="chained_relative-flexdatalist")
    public static WebElement access_sharing_search_txt_field_by_lastname;
    @FindBy(id="LastName")
    public static WebElement access_sharing_lastname_txt_field;
    @FindBy(id="FirstName")
    public static WebElement access_sharing_firstbname_txt_field;
    @FindBy(id="Email")
    public static WebElement access_sharing_Email_txt_field;
    @FindBy(xpath="//select[@id='RelationOption']")
    public static WebElement access_sharing_relation_dropDown;
    @FindBy(id="Specify")
    public static WebElement Access_sharing_relation_dropDown_other_txtField;
    @FindBy(id="AccessOption")
    public static WebElement Access_sharing_access_level_dropDown;
    @FindBys({@FindBy(xpath="//select[@id='AccessOption']/option[contains(text(),'Select')]"),
            @FindBy(xpath="//select[@id='AccessOption']/option[contains(text(),'View')]"),
            @FindBy(xpath="//select[@id='AccessOption']/option[contains(text(),'View & Modify')]")})
    public static WebElement Access_sharing_access_level_dropDown_options;
    @FindBy(id="myDocFromDate")
    public static WebElement access_sharing_fromDate_datePicker_field;
    @FindBy(id="dobDatePicker")
    public static WebElement access_sharing_fromDate_datePicker;
    @FindBy(xpath="//select[@class='ui-datepicker-month']")
    public static WebElement access_duration_from_month_dropdown;
    @FindBy(xpath="//select[@class='ui-datepicker-month']/option")
    public static List<WebElement> access_duration_from_month_select_month;
    @FindBy(className="ui-datepicker-year")
    public static WebElement access_duration_from_year_dropdown;
    @FindBy(xpath="//select[@class='ui-datepicker-year']/option")
    public static List<WebElement> access_duration_from_month_select_year;
    @FindBy(xpath="//table[@class='ui-datepicker-calendar']//td")
    public static List<WebElement> access_duration_from_select_days;
    @FindBy(id="datePickerOk")
    public static WebElement access_duration_fromDate_datePicker_ok_btn;
    @FindBy(id="myDocToDate")
    public static WebElement access_sharing_toDate_datePicker_field;
    @FindBy(id="dobDatePicker1")
    public static WebElement access_sharing_toDate_datePicker;
    @FindBy(xpath="//div[@id='dobDatePicker1']//select[@class='ui-datepicker-month']")
    public static WebElement access_duration_to_month_dropdown;
    @FindBy(xpath="//select[@class='ui-datepicker-month']/option")
    public static List<WebElement> access_duration_to_month_select_month;
    @FindBy(xpath="//div[@id='dobDatePicker1']//select[@class='ui-datepicker-year']")
    public static WebElement access_duration_to_year_dropdown;
    @FindBy(xpath="//select[@class='ui-datepicker-year']/option")
    public static List<WebElement> access_duration_to_month_select_year;
    @FindBy(xpath="//table[@class='ui-datepicker-calendar']//td")
    public static List<WebElement> access_duration_to_select_days;
    @FindBy(id="datePickerOk1")
    public static WebElement access_duration_toDate_datePicker_ok_btn;
    @FindBy(xpath="//label[contains(text(),'Profile')]/parent::*//div[@class='arrow collapsed']")
    public static WebElement access_duration_profile_feature_expand_btn;
    @FindBy(xpath="//label[contains(text(),'Health Tracker')]/parent::*//div[@class='arrow collapsed']")
    public static WebElement access_duration_healthTracker_feature_expand_btn;
    @FindBy(xpath="//label[contains(text(),'Medical Care')]/parent::*//div[@class='arrow collapsed']")
    public static WebElement access_duration_medicalCare_feature_expand_btn;
    @FindBy(xpath="//label[contains(text(),'Profile')]/parent::*//div[@class='arrow expanded']")
    public static WebElement access_duration_profile_feature_collapse_btn;
    @FindBy(xpath="//label[contains(text(),'Health Tracker')]/parent::*//div[@class='arrow expanded']")
    public static WebElement access_duration_healthTracker_feature_collapse_btn;
    @FindBy(xpath="//label[contains(text(),'Medical Care')]/parent::*//div[@class='arrow expanded']")
    public static WebElement access_duration_medicalCare_feature_collapse_btn;
    @FindBys({@FindBy(xpath="//label[contains(text(),'Profile')]/parent::*//li/label[contains(text(),'Contacts')]"),@FindBy(xpath="//label[contains(text(),'Profile')]/parent::*//li/label[contains(text(),'Physicians')]"),
            @FindBy(xpath="//label[contains(text(),'Profile')]/parent::*//li/label[contains(text(),'Insurance')]"),@FindBy(xpath="//label[contains(text(),'Profile')]/parent::*//li/label[contains(text(),'Social History')]"),
            @FindBy(xpath="//label[contains(text(),'Profile')]/parent::*//li/label[contains(text(),'Contacts')]")})
    public static WebElement features_profile_submodules;
    @FindBys({@FindBy(xpath="//label[contains(text(),'Health Tracker')]/parent::*//li/label[contains(text(),'Weight')]"),@FindBy(xpath="//label[contains(text(),'Health Tracker')]/parent::*//li/label[contains(text(),'Blood Pressure')]"),
            @FindBy(xpath="//label[contains(text(),'Health Tracker')]/parent::*//li/label[contains(text(),'Blood Glucose')]"),@FindBy(xpath="//label[contains(text(),'Health Tracker')]/parent::*//li/label[contains(text(),'Pulse Ox')]"),
            @FindBy(xpath="//label[contains(text(),'Health Tracker')]/parent::*//li/label[contains(text(),'Calorie Burned')]"),@FindBy(xpath="//label[contains(text(),'Health Tracker')]/parent::*//li/label[contains(text(),'Hours of Sleep')]"),
            @FindBy(xpath="//label[contains(text(),'Health Tracker')]/parent::*//li/label[contains(text(),'Temperature')]")})
    public static WebElement features_healthTracker_submodules;
    @FindBys({@FindBy(xpath="//label[contains(text(),'Medical Care')]/parent::*//li/label[contains(text(),'Procedures and Surgeries')]"),@FindBy(xpath="//label[contains(text(),'Medical Care')]/parent::*//li/label[contains(text(),'Allergies')]"),
            @FindBy(xpath="//label[contains(text(),'Medical Care')]/parent::*//li/label[contains(text(),'Immunizations')]"),@FindBy(xpath="//label[contains(text(),'Medical Care')]/parent::*//li/label[contains(text(),'Lab Tests')]")})
    public static WebElement features_medicalCare_submodules;
    @FindBy(xpath="//label[contains(text(),'Profile')]")
    public static WebElement features_profile;
    @FindBy(xpath="//label[contains(text(),'Health Tracker')]")
    public static WebElement features_healthTracker;
    @FindBy(xpath="//label[contains(text(),'Medical Care')]")
    public static WebElement features_medicalCare;
    @FindBy(xpath="//label[contains(text(),'Alerts')]")
    public static WebElement features_alerts;
    @FindBy(xpath="//label[contains(text(),'Health Topic')]")
    public static WebElement features_healthTopic;
    @FindBy(xpath="//label[contains(text(),'My Document')]")
    public static WebElement features_myDocument;
    @FindBy(xpath="//label[contains(text(),'Allergies')]")
    public static WebElement features_medicalCare_alergies;
    @FindBy(xpath="//label[contains(text(),'Blood Pressure')]")
    public static WebElement features_healthTracker_bloodPressure;
    @FindBy(xpath="//label[contains(text(),'Insurance')]")
    public static WebElement features_profile_insurance;
    @FindBy(xpath="//label[contains(text(),'Profile')]/parent::*//li/div[@class='checkbox checked']")
    public static WebElement features_profile_allSubModule_checkbox;
    @FindBy(xpath="//label[contains(text(),'Health Tracker')]/parent::*//li/div[@class='checkbox checked']")
    public static WebElement features_healthTracker_allSubModule_checkbox;
    @FindBy(xpath="//label[contains(text(),'Medical Care')]/parent::*//li/div[@class='checkbox checked']")
    public static WebElement features_medicalcare_allSubModule_checkbox;
    @FindBy(xpath="//label[contains(text(),'Blood Pressure')]/parent::*//div[@class='checkbox checked']")
    public static WebElement features_bloodPressure_checkbox;
    @FindBy(xpath="//label[contains(text(),'Weight')]/parent::*//div[@class='checkbox']")
    public static WebElement features_Weight_checkbox;
    @FindBy(xpath="//label[contains(text(),'Cholesterol')]/parent::*//div[@class='checkbox']")
    public static WebElement features_cholesterol_checkbox;
    @FindBy(xpath="//label[contains(text(),'Blood Glucose')]/parent::*//div[@class='checkbox']")
    public static WebElement features_bloodGlucose_checkbox;
    @FindBy(xpath="//label[contains(text(),'Pulse Ox')]/parent::*//div[@class='checkbox']")
    public static WebElement features_pulseOx_checkbox;
    @FindBy(xpath="//label[contains(text(),'Calorie Burned')]/parent::*//div[@class='checkbox']")
    public static WebElement features_calorie_burned_checkbox;
    @FindBy(xpath="//label[contains(text(),'Temperature')]/parent::*//div[@class='checkbox']")
    public static WebElement features_temperature_checkbox;
    @FindBy(xpath="//label[contains(text(),'Hours of Sleep')]/parent::*//div[@class='checkbox']")
    public static WebElement features_hours_of_sleep_checkbox;
    @FindBy(xpath="//label[contains(text(),'Allergies')]/parent::*//div[@class='checkbox checked']")
    public static WebElement features_allergies_checkbox;
    @FindBy(xpath="//label[contains(text(),'Conditions')]/parent::*//div[@class='checkbox']")
    public static WebElement features_conditions_checkbox;
    @FindBy(xpath="//label[contains(text(),'Procedures and Surgeries')]/parent::*//div[@class='checkbox']")
    public static WebElement features_proceduresAndSurgeries_checkbox;
    @FindBy(xpath="//label[contains(text(),'Immunizations')]/parent::*//div[@class='checkbox']")
    public static WebElement features_immunizations_checkbox;
    @FindBy(xpath="//label[contains(text(),'Lab Tests')]/parent::*//div[@class='checkbox']")
    public static WebElement features_labTest_checkbox;
    @FindBy(xpath="//label[contains(text(),'Insurance')]/parent::*//div[@class='checkbox checked']")
    public static WebElement features_insurance_checkbox;
    @FindBy(xpath="//label[contains(text(),'Contacts')]/parent::*//div[@class='checkbox']")
    public static WebElement features_contacts_checkbox;
    @FindBy(xpath="//label[contains(text(),'Physicians')]/parent::*//div[@class='checkbox']")
    public static WebElement features_physicians_checkbox;
    @FindBy(xpath="//label[contains(text(),'Pharmacy')]/parent::*//div[@class='checkbox']")
    public static WebElement features_pharmacy_checkbox;
    @FindBy(xpath="//label[contains(text(),'Social History')]/parent::*//div[@class='checkbox']")
    public static WebElement features_socialHistory_checkbox;
    @FindBy(xpath="//label[contains(text(),'Profile')]/parent::*//li")
    public static List<WebElement> profile_subMenus;
    @FindBy(xpath="//label[contains(text(),'Health Tracker')]/parent::*//li")
    public static List<WebElement> healthTracker_subMenus;
    @FindBy(xpath="//label[contains(text(),'Medical Care')]/parent::*//li")
    public static List<WebElement> medicalCare_subMenus;

    @FindBy(xpath="//label[contains(text(),'Alerts')]")
    public static WebElement features_alerts_checkbox;
    @FindBy(xpath="//label[contains(text(),'Health Topic')]")
    public static WebElement features_healthTopic_checkbox;
    @FindBy(xpath="//label[contains(text(),'My Document')]")
    public static WebElement features_myDocument_checkbox;
    @FindBy(id="assignAccess")
    public static WebElement add_access_sharing_btn;
    @FindBy(id="idMsg")
    public static WebElement access_sharing_added_successfully_popUp;
    @FindBy(id="idAddMore")
    public static WebElement access_sharing_added_successfully_popUp_addMore;
    @FindBy(id="idViewInfo")
    public static WebElement access_sharing_added_successfully_popUp_viewInfo;
    @FindBy(xpath="//div[@class='as-edit']")
    public static WebElement access_sharing_recordspage_editBtn;
    @FindBy(xpath="//b[@class='as-name']")
    public static WebElement access_sharing_recordspage_userName;
    @FindBy(xpath="//b[@class='as-name']")
    public static List<WebElement> access_sharing_recordspage_userName_list;
    @FindBy(xpath="//div[@class='as-email']")
    public static WebElement access_sharing_recordspage_email;
    @FindBy(xpath="//div[@class='as-neighbor']")
    public static WebElement access_sharing_recordspage_relationShip;
    @FindBy(xpath="//div[@class='as-labsed']")
    public static WebElement access_sharing_recordspage_expiryDate;
    @FindBy(xpath="//div[@class='as-created-date']")
    public static WebElement access_sharing_recordspage_createdDate;
    @FindBy(xpath="//div[@class='as-delete']")
    public static WebElement access_sharing_recordspage_deleteBtn;
    @FindBy(id="idMsg3")
    public static WebElement access_sharing_deleteConfirmation_popUp;
    @FindBy(id="idNo")
    public static WebElement access_sharing_deleteConfirmation_popUp_No_btn;
    @FindBy(id="idYes")
    public static WebElement access_sharing_deleteConfirmation_popUp_Yes_btn;
    @FindBy(id="idOk")
    public static WebElement access_sharing_deletedSuccessfully_ok_btn;
    @FindBy(xpath="//*[@id='poxList']//b[@class='as-name']")
    public static List<WebElement> access_sharing_deletedRecord_Validation;
    @FindBy(xpath="div[@class='as-edit']")
    public static WebElement access_sharing_editBtn;
    @FindBy(id="assignAccess")
    public static WebElement access_sharing_update_btn;
    @FindBy(id="idLogout")
    public static WebElement user_logOut_btn;
    @FindBy(xpath = "//i[@class='material-icons notification_down_arrow']")
    public WebElement manage_btn_drop_down;
    @FindBy(xpath = "//li[@class='access_name']")
    public List<WebElement> access_sharing_users;
    @FindBy(xpath = "//div[contains(text(),'Profile')]")
    public WebElement shared_profile_tab;
    @FindBy(xpath = "//div[contains(text(),'Health Tracker')]")
    public WebElement shared_Health_Tracker_tab;
    @FindBy(xpath = "//div[contains(text(),'Medical Care')]")
    public WebElement shared_Medical_Care_tab;
    @FindBy(xpath = "//div[contains(text(),'Alerts')]")
    public WebElement shared_Alerts_tab;
    @FindBy(xpath = "//div[contains(text(),'My Document')]")
    public WebElement shared_My_Document_tab;



























//    //Acess sharing
//    public By access_sharing_tab=By.xpath("//div[contains(text(),'Access Sharing')]");
//    public By add_access_sharing_icon=By.id("idAddAS");
//    // public By search_txt_field=By.xpath("//label[contains(text(),'Search by Last Name, First Name, Email')]");
//    public By search_txt_field=By.id("chained_relative-flexdatalist");
//    public By search_autopopulate_user=By.className("flexdatalist-results");
//    // public By serach_no_user_results_found=By.xpath("//li[contains(text(),'No results found for')]");
//    public By serach_no_user_results_found=By.xpath("//li[@class='item no-results']");
//    public By search_autopopulate_user_first_name=By.xpath("//span[@class='item item-firstName']");
//    public By user_lastname_txt_field=By.id("LastName");
//    public By user_firstname_txt_field=By.id("FirstName");
//    public By user_email_txt_field=By.id("Email");
//    public By user_relationship_dropdown=By.id("RelationOption");
//    public By user_acess_level_dropdown=By.id("AccessOption");
//    public By access_duration_from=By.id("myDocFromDate");
//    // public By access_duration_from_month_dropdown = By.className("ui-datepicker-month");
//    public By access_duration_from_month_dropdown = By.xpath("//select[@class='ui-datepicker-month']");
//    public By access_duration_from_month_select_month = By.xpath("//select[@class='ui-datepicker-month']/option");
//    public By access_duration_from_year_dropdown = By.className("ui-datepicker-year");
//    public By access_duration_from_month_select_year = By.xpath("//select[@class='ui-datepicker-year']/option");
//    public By access_duration_from_select_dates = By.xpath("//table[@class='ui-datepicker-calendar']//td");
//    public By access_duration_from_cancel_btn=By.id("datePickerCancel");
//    public By access_duration_from_ok_btn=By.id("datePickerOk");
//    public By access_duration_to=By.id("myDocToDate");
//    public By access_duration_to_month_dropdown=By.xpath("//div[@id='dobDatePicker1']//select[@class='ui-datepicker-month']");
//    public By access_duration_to_year_dropdown=By.xpath("//div[@id='dobDatePicker1']//select[@class='ui-datepicker-year']");
//    public By access_duration_toDate_cancel_btn=By.id("datePickerCancel1");
//    public By access_duration_toDate_ok_btn=By.id("datePickerOk1");
//    public By features_profile=By.xpath("//label[contains(text(),'Profile')]");
//    public By features_healthTracker=By.xpath("//label[contains(text(),'Health Tracker')]");
//    public By features_medicalCare=By.xpath("//label[contains(text(),'Medical Care')]");
//    public By features_alerts=By.xpath("//label[contains(text(),'Alerts')]");
//    public By features_healthtopic=By.xpath("//label[contains(text(),'Health Topic')]");
//    public By features_myDocument=By.xpath("//label[contains(text(),'My Document')]");
//    public By notes=By.id("message");
//    public By profile_Contacts=By.xpath("//label[contains(text(),'Contacts')]");
//    public By profile_expand_btn_open=By.xpath("//label[contains(text(),'Profile')]/parent::*//div[@class='arrow collapsed']");
//    public By profile_expand_btn_close=By.xpath("//label[contains(text(),'Profile')]/parent::*//div[@class='arrow expanded']");
//    public By profile_subMenus=By.xpath("//label[contains(text(),'Profile')]/parent::*//li");
//    public By healthTracker_subMenus=By.xpath("//label[contains(text(),'Health Tracker')]/parent::*//li");
//    public By healthTracker_expand_btn_open=By.xpath("//label[contains(text(),'Health Tracker')]/parent::*//div[@class='arrow collapsed']");
//    public By healthTracker_expand_btn_close=By.xpath("//label[contains(text(),'Health Tracker')]/parent::*//div[@class='arrow expanded']");
//    public By medicalCare_subMenus=By.xpath("//label[contains(text(),'Medical Care')]/parent::*//li");
//    public By medicalCare_expand_btn_open=By.xpath("//label[contains(text(),'Medical Care')]/parent::*//div[@class='arrow collapsed']");
//    public By medicalCare_expand_btn_close=By.xpath("//label[contains(text(),'Medical Care')]/parent::*//div[@class='arrow expanded']");
//    public By alerts_checkbox=By.xpath("//label[contains(text(),'Alerts')]");
//    public By healthTopic_checkbox=By.xpath("//label[contains(text(),'Health Topic')]");
//    public By myDocument_checkbox=By.xpath("//label[contains(text(),'My Document')]");
//    public By add_access_sharing_btn=By.id("assignAccess");
//    public By view_Info_access_sharing = By.id("idViewInfo");
//    public By add_more_access_sharing = By.id("idAddMore");

}
