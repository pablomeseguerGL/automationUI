package Base;

import com.saucelabs.common.SauceOnDemandAuthentication;

import framework.common.Utilities;
import framework.config.DriverWeb;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.saucelabs.junit.ConcurrentParameterized;
import com.saucelabs.junit.SauceOnDemandTestWatcher;
import java.net.URL;
import java.util.LinkedList;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;

import javax.rmi.CORBA.Util;


/**
 * Demonstrates how to write a JUnit test that runs tests against Sauce Labs using multiple browsers in parallel.
 * <p/>
 * The test also includes the {@link SauceOnDemandTestWatcher} which will invoke the Sauce REST API to mark
 * the test as passed or failed.
 *
 * @author Neil Manvar
 */
@Ignore
@RunWith(ConcurrentParameterized.class)
public class WebBaseTest implements SauceOnDemandSessionIdProvider {

    public static Utilities util = new Utilities();
    public static boolean isRemote;
    public static String username;
    public static String password;
    public static String accessKey;
    public static String port;
    public static String localBrowser;
    public static String buildTag;
    /**
     * Constructs a {@link SauceOnDemandAuthentication} instance using the supplied user name/access key.  To use the authentication
     * supplied by environment variables or from an external file, use the no-arg {@link SauceOnDemandAuthentication} constructor.
     */
    public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(username, accessKey);

    /**
     * JUnit Rule which will mark the Sauce Job as passed/failed when the test succeeds or fails.
     */
    @Rule
    public SauceOnDemandTestWatcher resultReportingTestWatcher = new SauceOnDemandTestWatcher(this, authentication);

    @Rule
    public TestName name = new TestName() {
        public String getMethodName() {
            return String.format("%s", super.getMethodName());
        }
    };

    protected String browser;
    protected String os;
    protected String version;
    protected String deviceName;
    protected String deviceOrientation;
    protected String sessionId;
    protected WebDriver driver;

    /**
     * Constructs a new instance of the test.  The constructor requires three string parameters, which represent the operating
     * system, version and browser to be used when launching a Sauce VM.  The order of the parameters should be the same
     * as that of the elements within the {@link #()} method.
     * @param os
     * @param version
     * @param browser
     * @param deviceName
     * @param deviceOrientation
     */

    public WebBaseTest(String os, String version, String browser, String deviceName, String deviceOrientation) {
        super();
        this.os = os;
        this.version = version;
        this.browser = browser;
        this.deviceName = deviceName;
        this.deviceOrientation = deviceOrientation;
    }

    /**
     * @return a LinkedList containing String arrays representing the browser combinations the test should be run against. The values
     * in the String array are used as part of the invocation of the test constructor
     */
    @ConcurrentParameterized.Parameters
    public static LinkedList browsersStrings() throws Exception {
        LinkedList browsers;
        browsers = getCapabilities();

        return browsers;
    }

    /**
     * Constructs a new {@link RemoteWebDriver} instance which is configured to use the capabilities defined by the {@link #browser},
     * {@link #version} and {@link #os} instance variables, and which is configured to run against ondemand.saucelabs.com, using
     * the username and access key populated by the {@link #authentication} instance.
     *
     * @throws Exception if an error occurs during the creation of the {@link RemoteWebDriver} instance.
     */
    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
        capabilities.setCapability(CapabilityType.VERSION, version);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("device-orientation", deviceOrientation);
        capabilities.setCapability(CapabilityType.PLATFORM, os);

        String methodName = name.getMethodName();
        capabilities.setCapability("name", methodName);

        //Getting the build name.
        //Using the Jenkins ENV var. You can use your own. If it is not set test will run without a build id.
        if (buildTag != null) {
            capabilities.setCapability("build", buildTag);
        }

        if(isRemote){
            this.driver = new RemoteWebDriver(
                    new URL("http://" + username + ":" + accessKey + "@ondemand.saucelabs.com:"+
                            port + "/wd/hub"), capabilities);
            this.sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
        }else{
            this.driver = DriverWeb.getWebDriver(localBrowser);
        }

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    /**
     * @return the value of the Sauce Job id.
     */
    @Override
    public String getSessionId() {
        return sessionId;
    }

    @BeforeClass
    public static void setupClass() {
        //get the uri to send the commands to.
       // seleniumURI = "@ondemand.saucelabs.com:443";
        //If available add build tag. When running under Jenkins BUILD_TAG is automatically set.
        //You can set this manually on manual runs.
        buildTag = System.getenv("BUILD_TAG");
        if (buildTag == null) {
            buildTag = System.getenv("SAUCE_BUILD_NAME");
        }
    }
    private static LinkedList getCapabilities() throws Exception {
        LinkedList browsers = new LinkedList();
        String jsonString = util.getCapabilities("WebDriverConfig.properties",false);
        JSONObject mainJsonObject = new JSONObject(jsonString);
        JSONArray dataArray = mainJsonObject.getJSONArray("capabilities");
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject jsonObject = dataArray.getJSONObject(i);
            if(i==0){
                isRemote=Boolean.parseBoolean(jsonObject.get("isRemote").toString());
                username=jsonObject.get("username").toString();
                password=jsonObject.get("password").toString();
                accessKey=jsonObject.get("key").toString();
                port=jsonObject.get("port").toString();
                localBrowser=jsonObject.get("localBrowser").toString();

            }else{
                if(isRemote){
                    browsers.add(new String[]{jsonObject.get("platform").toString(),
                            jsonObject.get("browserVersion").toString(),
                            jsonObject.get("browser").toString(), null, null});
                }else{
                    browsers.add(new String[]{null,
                            null,
                            null, null, null});
                    break;
                }

            }

        }
        return browsers;

    }
}
