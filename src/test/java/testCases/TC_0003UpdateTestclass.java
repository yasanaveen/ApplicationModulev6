package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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

        String expectedText = "Update Distribution to DGM";
        String actualText = up.validateText();
        Assert.assertEquals(actualText, expectedText, "text missMatched...");
        log.info("text is matched...");

        //up.issuedTodpDown();

        //SoftAssert softAssert = new SoftAssert();

        boolean isClickable = up.applicatinFeefield();
        if (isClickable) {
            log.error("Application fee field is clickable.");
            Assert.fail("Application fee field SHOULD NOT be clickable");
        } else {
            log.info("Application fee field is NOT clickable.");
            Assert.assertTrue(true, "Application field is not clickable");
        }

        String expectedMobilenumber = "900000000176";
        String actualMobileNumber = up.validateMobileNumber();
        Assert.assertEquals(actualMobileNumber, expectedMobilenumber, "mobile number missmatched..");
        log.info("mobile number matched...");
        // up.clkUpdateBtnn();


    }


}
