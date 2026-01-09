package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPageObjects;

public class TC0001LoginPage extends BaseClass {


    @Test(priority = 1)
    public void loginPageTest() throws InterruptedException {
        LoginPageObjects lg = new LoginPageObjects(driver);
        lg.sendUsernameAndPassword(prop.getProperty("username"), prop.getProperty("password"));
        log.info("entered username and password...");
        Thread.sleep(1000);

        String actaulUrl = lg.validateUrl();
        String expectedUrl = "http://192.168.20.19:8081/scopes";

        Assert.assertEquals(actaulUrl, expectedUrl, "Url missmatched");
        System.out.println(".....url is matched...");

        lg.clickProfile();
        log.info("clicked on profile section and signout....");
        log.info("**************** completed  Tc_001 Login page************");


    }


}
