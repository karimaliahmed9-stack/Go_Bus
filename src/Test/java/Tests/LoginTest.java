package Tests;

import ConfigureTest.BaseTest;
import Core.Utilti.DataReaderManager.JsonReader;
import Core.Utilti.DriverManager.GUIDriver;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Description("")
    @Test


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
        jsonReader = new JsonReader("Login");
    }




}
