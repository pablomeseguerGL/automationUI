package framework;

import framework.config.DriverMobile;


import static framework.config.MobileCapabilities.getCapabiltiiesJson;

/**
 * Created by pablomeseguer on 1/29/18.
 */
public class test {



        public static void main(String[] args) throws Exception {

           // Strin`g capabilities="{\"capabilities\":[{\"run\":\"no\",\"url\":\"http://127.0.0.1:4723/wd/hub\",\"platformName\":\"iOS\",\"autoAcceptAlerts\":\"true\",\"autoDismissAlerts\":\"true\",\"deviceName\":\"iPhone 6\",\"automationName\":\"XCUITest\",\"platformVersion\":\"10.3\",\"app\":\"/Users/pablomeseguer/Library/Developer/Xcode/DerivedData/PatientEngagement-bykbkgtwcohyuicjjmesihkdnaye/Build/Products/DaVitaHome_Debug-iphonesimulator/DaVitaHome.app\"},{\"run\":\"yes\",\"url\":\"http://127.0.0.1:4723/wd/hub\",\"platformName\":\"Android\",\"autoDismissAlerts\":\"true\",\"deviceName\":\"mydevice\",\"automationName\":\"Appium\",\"platformVersion\":\"7.1.1\",\"appActivity\":\"com.pe.login.LoginActivity\",\"appPackage\":\"com.pe.davita.debug\",\"app\":\"/Users/pablomeseguer/Desktop/Demogloo/PatientEngagement-Apperian.apk\"}]}";
            //String capabilities="{\"capabilities\":[{\"run\":\"no\",\"url\":\"http://127.0.0.1:4723/wd/hub\",\"platformName\":\"iOS\",\"autoAcceptAlerts\":\"true\",\"autoDismissAlerts\":\"true\",\"deviceName\":\"iPhone 6\",\"automationName\":\"XCUITest\",\"platformVersion\":\"10.3\",\"app\":\"/Users/pablomeseguer/Library/Developer/Xcode/DerivedData/PatientEngagement-bykbkgtwcohyuicjjmesihkdnaye/Build/Products/DaVitaHome_Debug-iphonesimulator/DaVitaHome.app\"},{\"run\":\"yes\",\"url\":\"http://127.0.0.1:4723/wd/hub\",\"platformName\":\"Android\",\"autoDismissAlerts\":\"true\",\"deviceName\":\"newEulator\",\"automationName\":\"Appium\",\"platformVersion\":\"5.1\",\"appActivity\":\"com.pe.login.LoginActivity\",\"appPackage\":\"com.pe.davita.debug\",\"app\":\"/Users/pablomeseguer/Desktop/Demogloo/PatientEngagement-Apperian.apk\"}]}";
            String Capabilities=  getCapabiltiiesJson();
            DriverMobile driver=new DriverMobile();

            try {
             //   driver.androidDriverRun("Android");
                driver.getDriver("iOS");
            } catch (Exception e) {
                e.printStackTrace();
            }

      //    Login login=new Login("Android");
        //  login.AbstractScreen();
                  //login.AbstractScreen();

        }

}
