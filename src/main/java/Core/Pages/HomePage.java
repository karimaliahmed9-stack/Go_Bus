package Core.Pages;

import Core.Utilti.DataReaderManager.PropertyReader;
import Core.Utilti.DriverManager.GUIDriver;
import Core.Utilti.LogManager.LogManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage {
    protected GUIDriver driver;

    public HomePage(GUIDriver driver) {
        this.driver = driver;
    }

    //locators
    private final By LoginandRegistebutton = By.partialLinkText("تسجيل الدخول");
    private final By BookingLable = By.cssSelector("[class=\"booking-form\"]");


    //Actions
    @Step("Navigate to Url")
    public HomePage NavigateToUrl() {
        driver.browsersActions().Navigation(PropertyReader.getProperty("BaseUrl"));
        return this;
    }

    @Step("Click on Login and Register button")
    public LoginPage ClickLoginandRegisterButton() {
        driver.elementActions().Click(LoginandRegistebutton);
        return new LoginPage(driver);
    }

    //Validations
    @Step("Validate the Booking Lable is displayed")
    public HomePage ValidateBookingLableIsDisplayed() {
        driver.hardAssert().isElementVisible(BookingLable);
        LogManager.Info("Booking Lable is displayed");
        return this;
    }


}
