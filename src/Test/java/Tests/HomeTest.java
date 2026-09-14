package Tests;

import ConfigureTest.BaseTest;
import Core.DataReaderManager.JsonReader;
import Core.DataReaderManager.PropertyReader;
import Core.DriverManager.GUIDriver;
import Core.Pages.HomePage;
import Core.Pages.LoginPage;
import Core.TimeManager.TimeManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    //Tests

    @Test
    public void TC_001() {
        new HomePage(driver)
                .NavigateToUrl()
                .ValidateBookingLableIsDisplayed()
                .ClickLoginandRegisterButton()
                .ValidateLableAPPEAR()
                .ClickRegisterButton()
                .EnterFullName(jsonReader.getJsonData("fullname") + TimeManager.GetSimpleTimeForData())
                .EnterPhoneNumber(jsonReader.getJsonData("phone") +TimeManager.GetSimpleTimeForData())
                .EnterEmail(jsonReader.getJsonData("البريدالإلكتروني")+TimeManager.GetSimpleTimeForData())
                .EnterPassword(jsonReader.getJsonData("كلمةالمرور"))
                .EnterConfirmPassword(jsonReader.getJsonData("تأكيدكلمةالمرور")+TimeManager.GetSimpleTimeForData())
                .ClickRegisterSubmitButton();
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
    public void BeforeClass()
    {
        jsonReader = new JsonReader("gobus");
    }
}
