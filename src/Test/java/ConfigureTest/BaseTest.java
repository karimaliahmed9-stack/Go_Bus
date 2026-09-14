package ConfigureTest;

import Core.Utilti.DataReaderManager.JsonReader;
import Core.Utilti.DriverManager.DriverReader;
import Core.Utilti.DriverManager.GUIDriver;
import org.openqa.selenium.WebDriver;

public class BaseTest implements DriverReader {
    protected GUIDriver driver;
    protected JsonReader jsonReader;
    @Override
    public WebDriver getDriver() {
        return driver.getDriver();
    }







}
