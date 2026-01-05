package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtill;

public class LoginPageObjects {

    public WebDriver driver;
    private WaitUtill waitUtil;

    public LoginPageObjects(WebDriver driver) {
        this.driver = driver;
        waitUtil = new WaitUtill(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "emailId")
    WebElement inputEmail;

    @FindBy(id = "password")
    WebElement inputPassword;

    @FindBy(xpath = "//*[text()='Login']")
    WebElement lgnBtn;

    public void sendUsernameAndPassword(String uName, String password) {
        inputEmail.sendKeys(uName);
        inputPassword.sendKeys(password);
        lgnBtn.click();
    }

    public String validateUrl() {
        return driver.getCurrentUrl();
    }


}
