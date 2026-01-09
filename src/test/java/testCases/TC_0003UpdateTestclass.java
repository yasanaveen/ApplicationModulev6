package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.ApplicationObjects;
import pageObjects.LoginPageObjects;
import pageObjects.UpdateScreenObjects;

public class TC_0003UpdateTestclass extends BaseClass {

    @Test
    public void updateTest() throws InterruptedException {

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

        String expectedText = "Update Distribution To DGM";
        String actualText = up.validateText();
        Assert.assertEquals(actualText, expectedText, "text missMatched...");
        log.info("text is matched...");

        boolean isclickable = up.acadamicYeardown();
        if (isclickable) {
            log.error("academic year field is clickable ");
            Assert.fail("Academic year field should not be clickable at update page..");
        } else {
            log.info("Academic year field is not clickable");
            Assert.assertTrue(true, "Application field not clickable...");
        }

        up.cityDpDown("HYDERABAD");
        Thread.sleep(1000);
        up.zoneDpdown("NALLAKUNTA");
        up.selectBranch();

        up.issuedTodpDown();

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


        log.info("*************TC_003 completed***************");


    }


}
