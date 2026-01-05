package pageObjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateScreenObjects {

    private WebDriver driver;

    public UpdateScreenObjects(WebDriver driver)
    {
         this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//*[text()='Update'])[1]")
    WebElement updateBtn;

    @FindBy(xpath = "(//*[contains(@class,'button__BMIDC ')])[6]")
    WebElement applicationFeefield;



    public void clkUpdateBtn()
    {
        updateBtn.click();
    }

    public boolean applicatinFeefield()
    {
        try{
            applicationFeefield.click();
            return true;
        }catch (TimeoutException e)
        {
            return false;
        }

    }




}
