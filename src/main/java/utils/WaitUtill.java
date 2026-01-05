package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtill {

	private WebDriver driver;
	private WebDriverWait wait;

	public WaitUtill(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	// Wait for element to be visible
	public WebElement waitForVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Wait for element to be clickable
	public WebElement waitForClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Wait for element to contain text
	public boolean waitForText(WebElement element, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	// Wait for element attribute to be not empty
	public boolean waitForAttributeNotEmpty(WebElement element, String attribute) {
		return wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
	}

	// Wait for page title
	public boolean waitForTitle(String title) {
		return wait.until(ExpectedConditions.titleContains(title));
	}

	// Wait for URL to contain specific text
	public boolean waitForURL(String urlPart) {
		return wait.until(ExpectedConditions.urlContains(urlPart));
	}
}
