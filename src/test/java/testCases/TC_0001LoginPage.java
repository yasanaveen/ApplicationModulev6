package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPageObjects;

public class TC_0001LoginPage extends BaseClass {

    public LoginPageObjects lg;

    @Test(priority = 1)
    public void loginPagetest() throws InterruptedException {
        lg = new LoginPageObjects(driver);
        lg.sendUsernameAndPassword(prop.getProperty("username"), prop.getProperty("password"));
        log.info("entered username and password...");
        Thread.sleep(1000);
       String actaulUrl= lg.validateUrl();
       String expectedUrl="http://192.168.20.19:8081/scopes";

       Assert.assertEquals(actaulUrl,expectedUrl,"Url missmatched");
        System.out.println(".....url is matched...");

        log.info("**************** completed  Tc_001 Login page************");


    }


//    @Test(priority = 2)
//    public void urlValidation() {
//        lg = new LoginPageObjects(driver);
//        String actualUrl = lg.validateUrl();
//        String expectedUrl = "http://192.168.20.19:8081/scopes";
//        Assert.assertEquals(actualUrl, expectedUrl, "urlmissMatched");
//
//    }


}
