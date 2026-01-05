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

    @FindBy(xpath = "(//*[contains(@class,'button__BMIDC ')])[6]")
    WebElement applicationFeefield;


    public void clkUpdateBtn() {
        updateBtn.click();
    }

    public boolean applicatinFeefield() {
        try {
            waitutil.waitForClickable(applicationFeefield).click();
            return true;
        } catch (TimeoutException e) {
            return false;
        }

    }


}
