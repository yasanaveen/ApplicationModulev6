package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtill;

import java.util.List;

public class ApplicationObjects {

    private WebDriver driver;
    private WaitUtill waitUtil;


    public ApplicationObjects(WebDriver driver) {
        this.driver = driver;
        waitUtil = new WaitUtill(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='Application']")
    WebElement applicationModule;

    @FindBy(xpath = "//*[contains(@class,'ApplicationNavLinks')]//a[text()='Distribute']")
    WebElement btnDistribute;

    @FindBy(xpath = "//*[text()='Distribute Applications']")
    WebElement distributeApplicaionstext;

    @FindBy(xpath = "//*[text()='Select City Name']")
    WebElement cityNamedpdown;

    @FindBy(xpath = "//*[text()='Select City Name']")
    WebElement cityNamesearcInput;
    @FindBy(xpath = "//*[text()='NUZVID']")
    WebElement selectCityname;

    @FindBy(xpath = "//*[text()='Select Zone Name']")
    WebElement clkZonedpdown;

//    @FindBy(xpath = "//*[contains(@placeholder,'Search Zone Name')]")
//    WebElement inputZoneName;

//    @FindBy(xpath = "//*[text()='RAMAN BHAVAN']")
//    WebElement selectZoneNameOption;

    @FindBy(xpath = "//*[contains(@class,'panel__LzznH')]//li")
    List<WebElement> allZones;

    @FindBy(xpath = "//*[text()='Select Branch Name']")
    WebElement branchNameDropdown;

    //@FindBy(xpath = "(//*[text()='S AP Nuzvid'])[1]")
    @FindBy(xpath = "//*[text()='Select Branch Name']//following::li")
    List<WebElement> allBranches;

    @FindBy(xpath = "//*[text()='Select Issued To']")
    WebElement issuedToDropdown;
    @FindBy(xpath = "//*[text()='Select Issued To']//following::li")
    List<WebElement> allIssuedNames;

    @FindBy(xpath = "//*[text()='Select Application Fee']")
    WebElement applicationFeeDropdown;
    @FindBy(xpath = "//*[text()='0']")
    WebElement selectApplicationFeeOption;
    @FindBy(xpath = "//*[text()='Select Application Series']")
    WebElement applicationSeriesDropdown;
    @FindBy(xpath = "//*[@id='option-0']")
    WebElement selectApplicationSeriesOption;
    @FindBy(id = "applicationCount")
    WebElement applicationCountField;

    @FindBy(id = "range")
    WebElement rangeField;

    @FindBy(id = "currentDateInput")
    WebElement dateField;

    @FindBy(xpath = "//*[text()='Insert']")
    WebElement insertButton;

    @FindBy(xpath = "//*[text()='Yes']")
    WebElement yesButton;

    public void applicationClk() {
        applicationModule.click();
    }

    public String validateApplicationURL() {
        return driver.getCurrentUrl();
    }


    public void clkDistribute() {
        btnDistribute.click();
    }


    public boolean textIsdisplayed() {
        return distributeApplicaionstext.isDisplayed();
    }

    public void cityNamedpdown(String cityName) {
        cityNamedpdown.click();
        cityNamesearcInput.sendKeys(cityName);
        selectCityname.click();
    }

    public void selectZoneName(String zoneName) {
        clkZonedpdown.click();
        //inputZoneName.clear();
        // selectZoneNameOption.click();
        // inputZoneName.sendKeys(zoneName);

        for (WebElement zone : allZones) {
            if (zone.getText().trim().equalsIgnoreCase(zoneName)) {
                zone.click();
                return;
            }
        }
        throw new RuntimeException("Zone not found: " + zoneName);
    }

    public void selectBranchName(String branchName) {
        branchNameDropdown.click();

        for (WebElement branch : allBranches) {
            if (branch.getText().trim().equalsIgnoreCase(branchName)) {
                branch.click();
                return;
            }
        }
        throw new RuntimeException("Branch not found: " + branchName);

    }

    public void issuedToDpdown(String issuedName) {
        issuedToDropdown.click();
        //selectIssuedToOption.click();

        for (WebElement issued : allIssuedNames) {
            if (issued.getText().trim().equalsIgnoreCase(issuedName)) {
                issued.click();
                return;
            }
        }
        throw new RuntimeException("issued name not found:" + issuedName);
    }

    public void applicationFeedpdown() {
        applicationFeeDropdown.click();
        selectApplicationFeeOption.click();
    }

    public void applicationSeriesdpdown() {
        applicationSeriesDropdown.click();
        selectApplicationSeriesOption.click();

    }

    public String applicationCount() {
        return applicationCountField.getAttribute("value");

    }


    public void enterRangeField(String range) {
        rangeField.sendKeys(range);
    }

    public boolean validateRangeNotExceedApplicationCount(String rangeValue) {

        // Enter range value
        rangeField.clear();
        rangeField.sendKeys(rangeValue);

        // Get application count (auto-filled)
        int applicationCount =
                Integer.parseInt(applicationCountField.getAttribute("value"));

        // Get actual value accepted in range field
        String actualRangeText = rangeField.getAttribute("value");
        int actualRangeValue =
                actualRangeText.isEmpty() ? 0 : Integer.parseInt(actualRangeText);

        // Validation: range must not exceed application count
        return actualRangeValue <= applicationCount;
    }


    public void getDateFieldValue() {
        System.out.println("Date Field Value: " + dateField.getAttribute("value").trim());
    }

    public void clkInsertBtn() {
        insertButton.click();
        yesButton.click();
    }


}
