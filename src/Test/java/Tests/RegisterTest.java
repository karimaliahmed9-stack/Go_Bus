package Tests;

import ConfigureTest.BaseTest;
import Core.Pages.HomePage;
import Core.Utilti.DataReaderManager.JsonReader;
import Core.Utilti.DriverManager.GUIDriver;
import Core.Utilti.TimeManager.TimeManager;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    //Tests

    @Test
    @Description("Validate Register With The Same Email.")
    public void Register_TC_001() {
        new HomePage(driver)
                .NavigateToUrl()
                .ValidateBookingLableIsDisplayed()
                .ClickLoginandRegisterButton()
                .ValidateLableAPPEAR()
                .ClickRegisterButton()
                .EnterFullName(jsonReader.getJsonData("Tc_001.fullname") + TimeManager.GetSimpleTimeForData())
                .EnterPhoneNumber(jsonReader.getJsonData("Tc_001.phone"))
                .EnterEmail(jsonReader.getJsonData("Tc_001.Email") )
                .EnterPassword(jsonReader.getJsonData("Tc_001.Pass"))
                .EnterConfirmPassword(jsonReader.getJsonData("Tc_001.ConfirmPass"))
                .ClickRegisterSubmitButton()
                .ValidateRegisterErrorMessageIsDisplayed();
    }


    @Test
    @Description("Validate Register With The Same Full Name.")
    public void Register_TC_002() {
        new HomePage(driver)
                .NavigateToUrl()
                .ValidateBookingLableIsDisplayed()
                .ClickLoginandRegisterButton()
                .ValidateLableAPPEAR()
                .ClickRegisterButton()
                .EnterFullName(jsonReader.getJsonData("Tc_002.fullname"))
                .EnterPhoneNumber(jsonReader.getJsonData("Tc_002.phone"))
                .EnterEmail(jsonReader.getJsonData("Tc_002.Email") + TimeManager.GetSimpleTimeForData()) //change email every run to pass tc
                .EnterPassword(jsonReader.getJsonData("Tc_002.Pass"))
                .EnterConfirmPassword(jsonReader.getJsonData("Tc_002.ConfirmPass"))
                .ClickRegisterSubmitButton()
                .ValidateRegisterErrorMessageIsDisplayed();

    }

    @Test
    @Description("Validate Register With The Same Phone Number.")
    public void Register_TC_003() {
        new HomePage(driver)
                .NavigateToUrl()
                .ValidateBookingLableIsDisplayed()
                .ClickLoginandRegisterButton()
                .ValidateLableAPPEAR()
                .ClickRegisterButton()
                .EnterFullName(jsonReader.getJsonData("Tc_003.fullname"))
                .EnterPhoneNumber(jsonReader.getJsonData("Tc_003.phone"))
                .EnterEmail(jsonReader.getJsonData("Tc_003.Email")) //change email every run to pass tc
                .EnterPassword(jsonReader.getJsonData("Tc_003.Pass"))
                .EnterConfirmPassword(jsonReader.getJsonData("Tc_003.ConfirmPass"))
                .ClickRegisterSubmitButton()
                .ValidateRegisterErrorMessageIsDisplayed();

    }


    //Configurations

    @BeforeMethod
    public void Setup() {
        driver = new GUIDriver();
    }

    @AfterMethod
    public void TearDown() {
        driver.quitDriver();
    }

    @BeforeClass
    public void BeforeClass() {
        jsonReader = new JsonReader("Register");
    }
}
