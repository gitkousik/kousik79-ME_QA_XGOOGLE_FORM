package demo.wrappers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class Wrappers {

    // Wrapper for navigating to a URL
    public static void navigateTo(ChromeDriver driver, String url) {
        driver.get(url);
    }

    // Wrapper for getting text from an element
    public static String getText(ChromeDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(locator)
        );
        return element.getText();
    }

    //Wrapper for wating for an element before interacting with it
    public static void waitForElement(ChromeDriver driver, By locator) 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Wrapper for entering text in text box element
    public static void enterText(ChromeDriver driver, By locator, String text) 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        element.sendKeys(text);
    }

    //Wrapper for clicking on an element
    public static void clickElement(ChromeDriver driver, By locator) 
    {
        waitForElement(driver, locator);
        WebElement element = driver.findElement(locator);
        element.click();
    }

    //Wrapper for dropdown selection
    public static void selectFromDropdown(ChromeDriver driver, By dropdownLocator,By optionLocator) 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        option.click();
    }

    //Wrapper for entering date
    public static void enterDate(ChromeDriver driver,By locator,String dateValue) 
    {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
            "arguments[0].value = arguments[1];" +
            "arguments[0].dispatchEvent(new Event('input', {bubbles:true}));" +
            "arguments[0].dispatchEvent(new Event('change', {bubbles:true}));",
            element,
            dateValue
        );
    }

     //Wrapper for checking elemnet displyed or not
    public static boolean isElementDisplayed(ChromeDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
            ).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}