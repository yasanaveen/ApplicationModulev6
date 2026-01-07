package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ApplicationObjects;
import pageObjects.LoginPageObjects;

public class TC_002ApplcationTestclass extends BaseClass {


    @Test
    public void applicationTestclass() throws InterruptedException {

        LoginPageObjects lg = new LoginPageObjects(driver);
        lg.sendUsernameAndPassword(prop.getProperty("username"), prop.getProperty("password"));


        ApplicationObjects ap = new ApplicationObjects(driver);
        ap.applicationClk();
        log.info("clicked on application module");
        Thread.sleep(1000);
        String actualapplicaionUrl = ap.validateApplicationURL();
        String expectedApplcationurl = "http://192.168.20.19:8081/scopes/application/analytics";
        Assert.assertEquals(actualapplicaionUrl, expectedApplcationurl, "applicationURL missmatched");
        ap.clkDistribute();


        log.info("clicked on distributed tab...");
        boolean text = ap.textIsdisplayed();
        System.out.println("The text is displayed:-" + text);
        ap.cityNamedpdown("HYDERABAD");
        ap.selectZoneName("MADHAPUR");
        ap.selectBranchName();
        ap.issuedToDpdown();
        ap.applicationFeedpdown();
        ap.applicationSeriesdpdown();
        String expectedApcount = "10";
        String actualappCount = ap.applicationCount();
        Assert.assertEquals(actualappCount, expectedApcount, "application count not matched...");
        //ap.enterRangeField("2");

        boolean isValid = ap.validateRangeNotExceedApplicationCount("15");
        Assert.assertTrue(
                isValid,
                "Range field not accepts more than application count..."
        );

        ap.getDateFieldValue();
        log.info("entered all the fields...");
        ap.clkInsertBtn();
        log.info("clicked on insert button");
        log.info("**************** completed  Tc_002 application module************");

    }

}
