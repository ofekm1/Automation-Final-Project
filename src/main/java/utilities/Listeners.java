package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {
    public void onStart(ITestContext execution) {
        System.out.println("-------------- Starting execution --------------");
    }

    public void onFinish(ITestContext execution) {
        System.out.println("-------------- Execution ended --------------");
    }

    public void onTestStart(ITestResult test) {
        System.out.println("-------------- Starting test " + test.getName() + " --------------");

    }

    public void onTestSuccess(ITestResult test) {
        if (!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if (file.delete())
                System.out.println("File deleted successfully");
            else
                System.out.println("Unable to delete file");
        }
        System.out.println("-------------- Test " + test.getName() + " passed --------------");
    }

    public void onTestFailure(ITestResult test) {
        saveScreenshot();
        if (!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("-------------- Test " + test.getName() + " failed --------------");
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
        System.out.println("-------------- Test " + test.getName() + " failed but --------------");
    }

    public void onTestSkipped(ITestResult test) {
        System.out.println("-------------- Starting test " + test.getName() + " --------------");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        if (platform.equalsIgnoreCase("mobile")) {
            return ((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.BYTES);
        } else {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
    }
}

