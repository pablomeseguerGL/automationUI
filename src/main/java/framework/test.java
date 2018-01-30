package framework;

import framework.common.Utilities;
import framework.config.Driver;

import java.io.IOException;

/**
 * Created by pablomeseguer on 1/29/18.
 */
public class test {



        public static void main(String[] args) throws IOException {

            String s;
         //String capabilities="{\"capabilities\":[{\"run\":\"no\",\"url\":\"http://127.0.0.1:4723/wd/hub\",\"platformName\":\"iOS\",\"autoAcceptAlerts\":\"true\",\"autoDismissAlerts\":\"true\",\"deviceName\":\"iPhone 6\",\"automationName\":\"XCUITest\",\"platformVersion\":\"10.3\",\"app\":\"/Users/pablomeseguer/Library/Developer/Xcode/DerivedData/PatientEngagement-bykbkgtwcohyuicjjmesihkdnaye/Build/Products/DaVitaHome_Debug-iphonesimulator/DaVitaHome.app\"},{\"run\":\"yes\",\"url\":\"http://127.0.0.1:4723/wd/hub\",\"platformName\":\"Android\",\"autoDismissAlerts\":\"true\",\"deviceName\":\"newEulator\",\"automationName\":\"Appium\",\"platformVersion\":\"5.1\",\"appActivity\":\"com.pe.login.LoginActivity\",\"appPackage\":\"com.pe.davita.debug\",\"app\":\"/Users/pablomeseguer/Desktop/Demogloo/PatientEngagement-Apperian.apk\"}]}";  String capabilities="{\"capabilities\":[{\"run\":\"no\",\"url\":\"http://127.0.0.1:4723/wd/hub\",\"platformName\":\"iOS\",\"autoAcceptAlerts\":\"true\",\"autoDismissAlerts\":\"true\",\"deviceName\":\"iPhone 6\",\"automationName\":\"XCUITest\",\"platformVersion\":\"10.3\",\"app\":\"/Users/pablomeseguer/Library/Developer/Xcode/DerivedData/PatientEngagement-bykbkgtwcohyuicjjmesihkdnaye/Build/Products/DaVitaHome_Debug-iphonesimulator/DaVitaHome.app\"},{\"run\":\"yes\",\"url\":\"http://127.0.0.1:4723/wd/hub\",\"platformName\":\"Android\",\"autoDismissAlerts\":\"true\",\"deviceName\":\"newEulator\",\"automationName\":\"Appium\",\"platformVersion\":\"5.1\",\"appActivity\":\"com.pe.login.LoginActivity\",\"appPackage\":\"com.pe.davita.debug\",\"app\":\"/Users/pablomeseguer/Desktop/Demogloo/PatientEngagement-Apperian.apk\"}]}";
            //Driver driver=new Driver(capabilities);
            try {
           //     driver.androidDriverRun();
            } catch (Exception e) {
             //   e.printStackTrace();
            }

            Utilities u = new Utilities();
            s = u.getCapabilities("config.properties");
            System.out.println(s);
        }

}
