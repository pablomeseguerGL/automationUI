import org.junit.Test;
import framework.config.DriverWeb;
import org.openqa.selenium.WebDriver;

public class TestDriver {


    @Test
    public void getWebDriver(){

        WebDriver myDriver = DriverWeb.getWebDriver();
        myDriver.get("https://www.google.com");
        myDriver.manage().window().maximize();
        myDriver.close();
    }
}
