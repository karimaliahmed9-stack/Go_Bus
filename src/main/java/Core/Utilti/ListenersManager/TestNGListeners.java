package Core.Utilti.ListenersManager;

import Core.Utilti.AllureReports.AllureAttachmentManager;
import Core.Utilti.AllureReports.AllureConstants_Paths;
import Core.Utilti.AllureReports.AllureEnviromentManager;
import Core.Utilti.AllureReports.AllureReportGenerator;
import Core.Utilti.Assertions.SoftAssert;
import Core.Utilti.AttachementsManager.ScreenRecordManager;
import Core.Utilti.AttachementsManager.ScreenShootsManager;
import Core.Utilti.DataReaderManager.PropertyReader;
import Core.Utilti.DriverManager.DriverReader;
import Core.Utilti.FileUtilsManager.FileUtil;
import Core.Utilti.LogManager.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;

public class TestNGListeners implements IExecutionListener, IInvokedMethodListener, ITestListener {


    public void onExecutionStart() {

        CleaningTestOutputDirectory();
        LogManager.Info("Test Execution Started");
        LogManager.Info("Cleaning directors: ");
        CreatingDirectory();
        LogManager.Info("Creating directors: ...");
        //كدا نا بنادي علي الفايلات من الريسورسز
        PropertyReader.loadproperties();
        LogManager.Info("Properties loaded");
        AllureEnviromentManager.setAllureEnvironment();
        LogManager.Info("Allure Environment Set");
    }

    public void onExecutionFinish() {
        LogManager.Info("Starting Test Execution Finished: ... ");
        AllureReportGenerator.generateReports(false);
        AllureReportGenerator.Copy_history();
        AllureReportGenerator.generateReports(true);
        AllureReportGenerator.openReport(AllureReportGenerator.renaming());
        LogManager.Info("Test Execution Finished: ... ");
    }

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            ScreenRecordManager.StartRecord();
            LogManager.Info("Starting Test Case : " + testResult.getName() + "Started");
        }

    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        WebDriver driver = null;
        if (method.isTestMethod()) {
            ScreenRecordManager.StopRecord(testResult.getName());
            SoftAssert.AssertAll();
            if (testResult.getInstance() instanceof DriverReader provider)
                driver = provider.getDriver();
            switch (testResult.getStatus()) {
                case ITestResult.SUCCESS ->
                        ScreenShootsManager.TakeFullScreenShots(driver, "Passed-" + testResult.getName());
                case ITestResult.FAILURE ->
                        ScreenShootsManager.TakeFullScreenShots(driver, "Failed-" + testResult.getName());
                case ITestResult.SKIP ->
                        ScreenShootsManager.TakeFullScreenShots(driver, "Skipped-" + testResult.getName());
            }
            AllureAttachmentManager.AttachmentLogs();
            AllureAttachmentManager.AttachmentScreenRecord(testResult.getName());
        }
    }

    public void onTestSuccess(ITestResult result) {
        LogManager.Info("Test Case Passed: " + result.getName() + "Passed");
    }

    public void onTestFailure(ITestResult result) {
        LogManager.Info("Test Case Failed: " + result.getName() + "Failed");
    }

    public void onTestSkipped(ITestResult result) {
        LogManager.Info("Test Case Skipped: " + result.getName() + "Skipped");
    }


    public static void CleaningTestOutputDirectory() {
        //FileUtil.cleaningDirectory(AllureConstants_Paths.RESULTS_FOLDER.toFile());
        FileUtil.cleaningDirectory(AllureConstants_Paths.REPORT_PATH.toFile());
        FileUtil.cleaningDirectory(AllureConstants_Paths.FULL_REPORT_PATH.toFile());
        FileUtil.cleaningDirectory(new File(ScreenShootsManager.screenshoot_path));
        FileUtil.cleaningDirectory(new File(ScreenRecordManager.RECORDINGS_PATHE));
        FileUtil.CleaningWithForce(new File(LogManager.LOG_PATH));
    }

    public void CreatingDirectory() {
        FileUtil.CreatingDirectory(ScreenShootsManager.screenshoot_path);
        FileUtil.CreatingDirectory(ScreenRecordManager.RECORDINGS_PATHE);
    }
}
