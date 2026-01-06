package pageObjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtill;

public class UpdateScreenObjects {

    private WebDriver driver;
    private WaitUtill waitutil;

    public UpdateScreenObjects(WebDriver driver) {
        this.driver = driver;
        waitutil = new WaitUtill(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//*[text()='Update'])[1]")
    WebElement updateBtn;

    @FindBy(xpath = "//*[text()='Update Distribution to DGM']")
    WebElement updateDistributionToDGMText;

    @FindBy(xpath = "(//*[contains(@class,'button__BMIDC ')])[9]")
    WebElement cityNamedpDown;

    @FindBy(xpath = "//*[contains(@class,'Searchbox_rectangle__A1jP6')]")
    WebElement searchCityNameInputField;

    @FindBy(xpath = "//*[text()='HYDERABAD']")
    WebElement selectCityNameOption;

    @FindBy(xpath = "(//*[contains(@class,'button__BMIDC ')])[10]")
    WebElement zoneNamedpdown;
    @FindBy(xpath = "//*[contains(@placeholder,'Search Zone Name')]")
    WebElement zoneSearchInput;
    @FindBy(xpath = "//*[text()='NALLAKUNTA']")
    WebElement selectZoneOption;

    @FindBy(xpath = "(//*[contains(@class,'button__BMIDC ')])[11]")
    WebElement branchDpdown;

    @FindBy(xpath = "//*[text()='NALLAKUNTA IPL']")
    WebElement selectBranch;

    @FindBy(xpath = "(//*[contains(@class,'button__BMIDC ')])[12]")
    WebElement issuedToDropdown;

    @FindBy(xpath = "//*[text()='Harika Narsaraopet']")
    WebElement selectIssuedToOption;

    @FindBy(xpath = "(//*[contains(@class,'button__BMIDC ')])[6]")
    WebElement applicationFeefield;

    @FindBy(xpath = "//*[text()='Update']")
    WebElement clkUpdateBtn;

    @FindBy(xpath = "(//*[@id='mobileNumber'])[2]")
    WebElement mobileNumber;


    public void clkUpdateBtn() {
        updateBtn.click();
    }

    public String validateText() {
        return updateDistributionToDGMText.getText();
    }

    public void cityDpDown(String city) {
        cityNamedpDown.click();
        searchCityNameInputField.sendKeys(city);
        selectCityNameOption.click();
    }

    public void zoneDpdown(String zoneName) {
        zoneNamedpdown.click();
        zoneSearchInput.sendKeys(zoneName);
        selectZoneOption.click();

    }

    public void selectBranch()
    {
        branchDpdown.click();
        selectBranch.click();
    }

    public void issuedTodpDown() {
        //issuedToDropdown.click();
        waitutil.waitForClickable(issuedToDropdown).click();
        selectIssuedToOption.click();
    }

    public boolean applicatinFeefield() {
        try {
            waitutil.waitForClickable(applicationFeefield);
            // waitutil.waitForElementToBeInvisible(applicationFeefield).
            return true;
        } catch (TimeoutException e) {
            return false;
        }

    }

    public String validateMobileNumber() {
        // return mobileNumber.getText().trim();
        return mobileNumber.getAttribute("value");
    }

    public void clkUpdateBtnn() {
        clkUpdateBtn.click();
    }


}
