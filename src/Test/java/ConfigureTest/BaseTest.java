package ConfigureTest;

import Core.DataReaderManager.JsonReader;
import Core.DriverManager.DriverReader;
import Core.DriverManager.GUIDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest implements DriverReader {
    protected GUIDriver driver;
    protected JsonReader jsonReader;
    @Override
    public WebDriver getDriver() {
        return driver.getDriver();
    }







}
