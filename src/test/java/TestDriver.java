import org.junit.Test;
import framework.config.DriverWeb;
import org.openqa.selenium.WebDriver;

public class TestDriver extends TestBase{

    public TestDriver(String os,
                         String version, String browser, String deviceName, String deviceOrientation) {
        super(os, version, browser, deviceName, deviceOrientation);
    }

    @Test
    public void getWebDriver(){


        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.quit();

    }
}
