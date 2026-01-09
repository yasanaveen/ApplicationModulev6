package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    Properties prop;
    FileInputStream file;

    public static Logger log;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) throws IOException {
        prop = new Properties();
        file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/application.properties");
        prop.load(file);

        log = LogManager.getLogger(this.getClass());

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser:" + browser);
        }

        log.info("Chrome browser opened...");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
        log.info("applicaton url is opened....");

    }


    @AfterClass
    public void tearDown() {
        //driver.quit();
    }


}
