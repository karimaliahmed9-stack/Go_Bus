package Core.Pages;

import Core.Utilti.DataReaderManager.PropertyReader;
import Core.Utilti.DriverManager.GUIDriver;
import Core.Utilti.LogManager.LogManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RegisterPage {
    protected GUIDriver driver;
    public RegisterPage(GUIDriver driver) {
        this.driver = driver;
    }
    //variables
    private final String EndPoint = "signup";
    //locator
    private final By FullName = By.cssSelector("[name=\"userName\"]");
    private final By PhoneNamber = By.cssSelector("[type=\"tel\"]");
    private final By Email = By.name("userEmail");
    private final By Password = By.name("userPassword");
    private final By ConfirmPassword = By.name("confirmPassword");
    private final By RegisterSubmitButton = By.cssSelector("[type=\"submit\"]");
    private final By RegisterSuccessMessage = By.cssSelector("[class=\"text-xs text-white  px-1 rounded\"]");
    private final By RegisterErrorMessage = By.cssSelector("[class=\"alert text-red-500\"]");

    //Actions
    @Step("Navigate to Register Page")
    public RegisterPage NavigateToRegisterPage()
    {
        driver.browsersActions().Navigation(PropertyReader.getProperty("BaseUrl") + EndPoint);
        return this;
    }
    @Step("Enter Full Name: {0}")
    public RegisterPage EnterFullName(String fullName)
    {
        driver.elementActions().SendKey(FullName,fullName);
        return this;
    }
    @Step("Enter Phone Number: {0}")
    public RegisterPage EnterPhoneNumber(String phoneNumber)
    {

        driver.elementActions().SendKey(PhoneNamber,phoneNumber);
        return this;
    }
    @Step("Enter Email: {0}")
    public RegisterPage EnterEmail(String email)
    {
        driver.elementActions().SendKey(Email,email);
        return this;
    }
    @Step("Enter Password: {0}")
    public RegisterPage EnterPassword(String password)
    {
        driver.elementActions().SendKey(Password,password);
        return this;
    }
    @Step("Enter Confirm Password: {0}")
    public RegisterPage EnterConfirmPassword(String confirmPassword)
    {
        driver.elementActions().SendKey(ConfirmPassword,confirmPassword);
        return this;
    }
    @Step("Click on Register Submit Button")
    public RegisterPage ClickRegisterSubmitButton()
    {
        driver.elementActions().Click(RegisterSubmitButton);
        return this;
    }
    //Vlidation
    @Step("Validate the current url")
    public RegisterPage ValidateCurrentUrl(String expectedUrl)
    {
        String currentUrl = driver.browsersActions().GetUrl();
        driver.hardAssert().assertEquals(currentUrl,expectedUrl,"Url Not Matched");
        return this;
    }
    @Step("Validate the Register Success Message is displayed")
    public RegisterPage ValidateRegisterSuccessMessageIsDisplayed()
    {
        driver.hardAssert().isElementVisible(RegisterSuccessMessage);
        LogManager.Info("Register Success Message is displayed");
        return this;
    }
    @Step("Validate the Register Error Message is displayed")
    public RegisterPage ValidateRegisterErrorMessageIsDisplayed()
    {
        driver.hardAssert().isElementVisible(RegisterErrorMessage);
        LogManager.Info("Register Error Message is displayed");
        return this;
    }








}
