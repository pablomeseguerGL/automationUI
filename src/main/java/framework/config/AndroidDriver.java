package framework.config;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pablomeseguer on 1/30/18.
 */
public class AndroidDriver extends MobileCapabilities implements Runnable {

    AppiumDriver<WebElement> driver;
    Capabilities capabilities;
    public AndroidDriver(Capabilities capabilities) {
     this.capabilities=capabilities;

    }

    public AppiumDriver executeAndroidDriver() {

            final String URL_STRING = "";
        String typeExecution="";
            String urltemp = capabilities.getCapability("url").toString();
           String[] urlSplit= urltemp.split("/");

        try {
            if(!typeExecution.trim().equals("remote")){
                driver = (AppiumDriver<WebElement>) new RemoteWebDriver(new URL(urltemp), capabilities);

}
else {
                driver = new io.appium.java_client.android.AndroidDriver<WebElement>(new URL(urltemp), capabilities);
}

            Thread.sleep(0);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
return driver;

        }

    @Override
    public void run() {
       executeAndroidDriver();
    }


}
