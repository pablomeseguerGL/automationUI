$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/mobile/Space.feature");
formatter.feature({
  "line": 2,
  "name": "space",
  "description": "",
  "id": "space",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@regression"
    }
  ]
});
formatter.before({
  "duration": 981014756,
  "status": "passed"
});
formatter.before({
  "duration": 614498532,
  "status": "passed"
});
formatter.before({
  "duration": 84388,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Login",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Open Android platform",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I click the \"alreadyHaveAccountButton~Login\" element",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I enter \"glooaccount2017\" in the \"loginUserNameTextBox~Login\" field",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I enter \"gorilla\" in the \"loginPassWordTextBox~Login\" field",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I click the \"loginButton~Login\" element",
  "keyword": "And "
});
formatter.match({
  "location": "mobileSteps.openAndroidPlatform()"
});
formatter.result({
  "duration": 15085643049,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "alreadyHaveAccountButton~Login",
      "offset": 13
    }
  ],
  "location": "mobileSteps.iClickTheElement(String)"
});
formatter.result({
  "duration": 38433372604,
  "error_message": "org.openqa.selenium.WebDriverException: An unknown server-side error occurred while processing the command. Original error: Cannot read property \u0027sendAction\u0027 of null (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nBuild info: version: \u00273.8.1\u0027, revision: \u00276e95a6684b\u0027, time: \u00272017-12-01T18:33:54.468Z\u0027\nSystem info: host: \u0027Pablos-MacBook-Pro.local\u0027, ip: \u0027fdd5:cbaa:aa01:0:f5e3:1732:384f:ab1a\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.13.3\u0027, java.version: \u00271.8.0_144\u0027\nDriver info: io.appium.java_client.android.AndroidDriver\nCapabilities {app: /Users/pablomeseguer/Deskto..., appActivity: com.gloo.polymerandroid.act..., appPackage: com.gloo.polymerandroid, appWaitActivity: com.gloo.polymerandroid.act..., appWaitPackage: com.gloo.polymerandroid, automationName: Appium, databaseEnabled: false, desired: {app: /Users/pablomeseguer/Deskto..., automationName: Appium, deviceName: realdevice, platformName: android, platformVersion: 7.1.1, url: http://127.0.0.1:4723/wd/hub}, deviceManufacturer: Google, deviceModel: Android SDK built for x86, deviceName: emulator-5554, deviceScreenSize: 1080x1920, deviceUDID: emulator-5554, javascriptEnabled: true, locationContextEnabled: false, networkConnectionEnabled: true, platform: LINUX, platformName: LINUX, platformVersion: 7.1.1, takesScreenshot: true, url: http://127.0.0.1:4723/wd/hub, warnings: {}, webStorageEnabled: false}\nSession ID: ae6234e3-9eb9-44ab-97eb-c68818fbdd6c\n*** Element info: {Using\u003dxpath, value\u003d(//*[contains(concat(\u0027 \u0027, normalize-space(com.gloo.polymerandroid:id/@resource-id), \u0027 \u0027), \u0027 landing_already_have_account_button \u0027)])}\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:164)\n\tat io.appium.java_client.remote.AppiumCommandExecutor.execute(AppiumCommandExecutor.java:89)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:601)\n\tat io.appium.java_client.DefaultGenericMobileDriver.execute(DefaultGenericMobileDriver.java:42)\n\tat io.appium.java_client.AppiumDriver.execute(AppiumDriver.java:1)\n\tat io.appium.java_client.android.AndroidDriver.execute(AndroidDriver.java:1)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElements(RemoteWebDriver.java:398)\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElements(DefaultGenericMobileDriver.java:54)\n\tat io.appium.java_client.AppiumDriver.findElements(AppiumDriver.java:149)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementsByXPath(RemoteWebDriver.java:477)\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElementsByXPath(DefaultGenericMobileDriver.java:144)\n\tat io.appium.java_client.AppiumDriver.findElementsByXPath(AppiumDriver.java:181)\n\tat org.openqa.selenium.By$ByXPath.findElements(By.java:356)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElements(RemoteWebDriver.java:359)\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElements(DefaultGenericMobileDriver.java:50)\n\tat io.appium.java_client.AppiumDriver.findElements(AppiumDriver.java:145)\n\tat org.openqa.selenium.support.ui.ExpectedConditions.findElement(ExpectedConditions.java:881)\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:205)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:201)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$22.apply(ExpectedConditions.java:643)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$22.apply(ExpectedConditions.java:640)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:208)\n\tat framework.config.Element.click(Element.java:40)\n\tat cucumber.steps.mobileSteps.iClickTheElement(mobileSteps.java:61)\n\tat ✽.And I click the \"alreadyHaveAccountButton~Login\" element(src/test/resources/features/mobile/Space.feature:5)\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "glooaccount2017",
      "offset": 9
    },
    {
      "val": "loginUserNameTextBox~Login",
      "offset": 34
    }
  ],
  "location": "mobileSteps.iEnterInTheField(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "gorilla",
      "offset": 9
    },
    {
      "val": "loginPassWordTextBox~Login",
      "offset": 26
    }
  ],
  "location": "mobileSteps.iEnterInTheField(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "loginButton~Login",
      "offset": 13
    }
  ],
  "location": "mobileSteps.iClickTheElement(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 12,
  "name": "New",
  "description": "",
  "id": "space;new",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "I click the \"createSpace\" element",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I click the \"createSpace\" element",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 15,
      "value": "#And I \"will\" see the \"messages\" element"
    }
  ],
  "line": 16,
  "name": "I \"will\" see the \"actionCreateSpace\" element",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I click the \"actionCreateSpace\" element",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I click the \"actionCreateSpace\" element",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I click the \"newSpaceOption\" element",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I enter \"gorillaSpace\" in the \"newSpaceName\" field",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I close the keyboard",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I click the \"createButton\" element",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "createSpace",
      "offset": 13
    }
  ],
  "location": "mobileSteps.iClickTheElement(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "createSpace",
      "offset": 13
    }
  ],
  "location": "mobileSteps.iClickTheElement(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "will",
      "offset": 3
    },
    {
      "val": "actionCreateSpace",
      "offset": 18
    }
  ],
  "location": "mobileSteps.iSeeTheElement(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "actionCreateSpace",
      "offset": 13
    }
  ],
  "location": "mobileSteps.iClickTheElement(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "actionCreateSpace",
      "offset": 13
    }
  ],
  "location": "mobileSteps.iClickTheElement(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "newSpaceOption",
      "offset": 13
    }
  ],
  "location": "mobileSteps.iClickTheElement(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "gorillaSpace",
      "offset": 9
    },
    {
      "val": "newSpaceName",
      "offset": 31
    }
  ],
  "location": "mobileSteps.iEnterInTheField(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "mobileSteps.iCloseTheKeyboard()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "createButton",
      "offset": 13
    }
  ],
  "location": "mobileSteps.iClickTheElement(String)"
});
formatter.result({
  "status": "skipped"
});
});