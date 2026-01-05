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

    @FindBy(xpath = "//*[text()='Select Issued To']")
    WebElement issuedToDropdown;
    @FindBy(xpath = "//*[text()='Sandhya Rani']")
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
