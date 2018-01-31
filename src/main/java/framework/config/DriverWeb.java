package framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverWeb {

    public static WebDriver myDriver=null;

    public static WebDriver getWebDriver() {

        boolean isRemote = false;//TODO get this value from a config file
        String browser = "Chrome"; //TODO get this value from a config file
        String OS = "Mac"; //TODO get this value from a config file

        if (isRemote) {

            getRemoteWebDriver();

        } else {
            switch (browser.toLowerCase()) {
                case "firefox":
                    System.setProperty("webdriver.gecko.appiumDriver", "./Resources/geckodriver");
                    myDriver = new FirefoxDriver();
                    break;

                case "chrome":
                    System.setProperty("webdriver.chrome.appiumDriver", "./Resources/chromedriver");
                    myDriver = new ChromeDriver();
                    break;

                case "safari":
                    myDriver = new SafariDriver();
                    break;

                case "internetexplorer":
                    if (OS.toLowerCase().equals("mac")) {
                        throw new RuntimeException("Internet Explorer not supported on MAC platform");
                    }
                    System.setProperty("webdriver.ie.appiumDriver", "./Resources/MicrosoftWebDriver.exe");
                    myDriver = new InternetExplorerDriver();
                    break;

                default:
                    throw new RuntimeException("Browser Type not supported. " +
                            "Only Firefox, Chrome, Safari, HtmlUnitDriver and InternetExplorer(Only Windows) browsers are supported");
            }

        }
        return myDriver;

    }

    private static void getRemoteWebDriver(){

        String username="a"; //TODO get this value from a config file
        String key="";//TODO get this value from a config file
        String browser = "Chrome"; //TODO get this value from a config file
        String OS = "Mac"; //TODO get this value from a config file
        String browserVersion = "7.5"; //TODO get this value from a config file


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setCapability("version", browserVersion);
        capabilities.setCapability("platform", OS);
        // Create the connection  to run the tests
        try {
            myDriver =  new RemoteWebDriver(
                    new URL("http://" + username + ":" + key + "@ondemand.saucelabs.com:80/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

}
