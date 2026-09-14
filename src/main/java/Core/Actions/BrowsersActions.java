package Core.Actions;

import Core.LogManager.LogManager;
import Core.WaitManager.WaitManager;
import org.openqa.selenium.WebDriver;

public class BrowsersActions {
    WebDriver driver;
    private final WaitManager waitManager;

    public BrowsersActions(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
    }

    //Navigation
    public void Navigation(String url) {
        driver.get(url);
    }

    //Get Url
    public String GetUrl() {
        return waitManager.getFluentWait().until(driver1 -> {
            String url = driver1.getCurrentUrl();
            LogManager.Info("Getting Current URL: " + url);
            return url;
        });


    }

    //Get Title
    public String GetTitle() {
        return waitManager.getFluentWait().until(driver1 -> {

            String title = driver1.getTitle();
            LogManager.Info("Getting Current Title: " + title);
            return title;

        });

    }

    //Get Window Handel
    public String GetWindowHandle() {
        LogManager.Info("Getting Current Window Handle: " + driver.getWindowHandle());
        return driver.getWindowHandle();
    }

    //Maximize Browser
    public void MaximizeBrowser() {
        LogManager.Info("Maximizing Browser Window");
        driver.manage().window().maximize();
    }

    //Close Tap
    public void CloseBrowser() {
        LogManager.Info("Closing Tap");
        driver.close();
    }

    //Quit Browser
    public void QuitBrowser() {
        LogManager.Info("Closing Browser");
        driver.quit();
    }

    //Forward
    public void Forward() {
        LogManager.Info("Navigating Forward");
        driver.navigate().forward();
    }

    //Backward
    public void Backward() {
        LogManager.Info("Navigating Backward");
        driver.navigate().back();
    }

    //Refresh
    public void Refresh() {
        LogManager.Info("Refreshing Browser");
        driver.navigate().refresh();
    }

    //Switch
    public void SwitchToWindow(String windowHandle) {
        LogManager.Info("Switching to Window: " + windowHandle);
        driver.switchTo().window(windowHandle);
    }


}
