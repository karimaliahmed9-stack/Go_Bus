package Core.Pages;

import Core.Utilti.DataReaderManager.PropertyReader;
import Core.Utilti.DriverManager.GUIDriver;
import Core.Utilti.LogManager.LogManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage {
    protected GUIDriver driver;

    public LoginPage(GUIDriver driver) {
        this.driver = driver;
    }
    //Variables
    private final String EndPoint = "login";
    //locator
    private final By RegisterButton = By.cssSelector("[href=\"/signup\"]");
    private final By LableLOgin = By.cssSelector("[class=\"custom-switch bg-orange\"]");


    //Actions
    @Step("Navigate to Login Page")
    public LoginPage NavigateToLoginPage()
    {
        driver.browsersActions().Navigation(PropertyReader.getProperty("BaseUrl") + EndPoint);
        return this;
    }
    @Step("Click on Register button")
    public RegisterPage ClickRegisterButton()
    {
        driver.elementActions().Click(RegisterButton);
        return new RegisterPage(driver);
    }
    //validation
    //Validate the current url
    @Step("Validate the Lable login appear ")
    public LoginPage ValidateLableAPPEAR()
    {
        driver.hardAssert().isElementVisible(LableLOgin);
        LogManager.Info("Lable login is displayed");
        return this;
    }




}
