package pages;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import stepdefinition.SharedSD;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class BasePage {

	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(java.util.NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementNotFoundException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return element;
	}

	public void clickOn(By locator) {
		try {
			SharedSD.getDriver().findElement(locator).click();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}
	public void sendText(By locator, String text) {
		try {
			SharedSD.getDriver().findElement(locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}
	public String getTextFromElement(By locator) {
		String text = null;
		try {
			text = SharedSD.getDriver().findElement(locator).getText();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
		return text;
	}

	public void selectAutoComplete(By autoCompleteTextField, String partialText, By suggestedList, String valueToBeSelected) {
		try {
			SharedSD.getDriver().findElement(autoCompleteTextField).sendKeys(partialText);
		} catch (NoSuchElementException e){
			Assert.fail("Elelment is not found with this locator : " + autoCompleteTextField.toString());
		}
		List<WebElement> list = SharedSD.getDriver().findElements(suggestedList);
		for (WebElement ele : list){
			if (ele.getText().contains(valueToBeSelected)){
				ele.click();
				break;
			}
		}
	}

	public void selectFromDropDown(By dropdownField, String visibleText) {
		// Select value from drop
		Select dropdown = new Select(webAction(dropdownField));
		// Select element by visible text
		dropdown.selectByVisibleText(visibleText);
	}

	public void mouseOver(By hoverOverElement) {
		WebElement element = webAction(hoverOverElement);
		Actions action = new Actions(SharedSD.getDriver());
		action.moveToElement(element).build().perform();
	}

}
