package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ApplicationObjects;
import pageObjects.LoginPageObjects;
import pageObjects.UpdateScreenObjects;

public class TC_0003UpdateTestclass extends BaseClass {

    @Test
    public void updateTest() {
        LoginPageObjects lg = new LoginPageObjects(driver);
        lg.sendUsernameAndPassword(prop.getProperty("username"), prop.getProperty("password"));
        log.info("entered username and password...");

        ApplicationObjects ap = new ApplicationObjects(driver);
        ap.applicationClk();
        log.info("clicked on application model....");
        ap.clkDistribute();
        log.info("clicked on distributed tab....");

        UpdateScreenObjects up = new UpdateScreenObjects(driver);
        up.clkUpdateBtn();
        log.info("clicked on update button...");

        boolean isClickable = up.applicatinFeefield();

        if (isClickable) {
            log.info("Application fee field is clickable.");
            Assert.fail("Test failed: application field SHOULD NOT be clickable");
        } else {
            log.info("Application fee field is NOT clickable.");
            Assert.assertTrue(true, "Test passed: application field is not clickable");
        }


    }


}
