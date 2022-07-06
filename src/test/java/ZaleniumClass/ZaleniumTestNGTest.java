package ZaleniumClass;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.sql.Time;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ZaleniumTestNGTest {

    public static WebDriver driver;
    //public static JavascriptExecutor jse;


    @BeforeMethod(alwaysRun = true)
    @org.testng.annotations.Parameters(value = { "config"})
    @SuppressWarnings("unchecked")
    public void setUp(String config_file, Method m) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/" + config_file));

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
        desiredCapabilities.setCapability("zal:name", m.getName());
        desiredCapabilities.setCapability("zal:build", "myTestBuild");
        desiredCapabilities.setCapability("zal:idleTimeout", 150);
        desiredCapabilities.setCapability("zal:screenResolution", "1280x720");
        desiredCapabilities.setCapability("zal:recordVideo", false);
        //desiredCapabilities.setCapability("zal:tz", "IN");

        /*ChromeOptions capabilities = new ChromeOptions();
        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        Iterator it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (capabilities.getCapability(pair.getKey().toString()) == null) {
                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
            }
        }*/

        driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        driver.quit();
    }



}
