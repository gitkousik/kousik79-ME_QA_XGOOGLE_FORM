package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;
import org.testng.Assert;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    @Test
    public void testCase01(){
        //Navigate to google form
        Wrappers.navigateTo(driver,"https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

        //Fill in Crio Learner in the 1st text box
        By nameField = By.xpath("//div[@role='listitem'][1]//input[@type='text']");
        Wrappers.enterText(driver, nameField, "Crio Learner");

        //Write down "I want to be the best QA Engineer! 1710572021'' where 1710572021 is variable - needs to be the current epoch time.
        By reasonField = By.xpath("//div[@role='listitem'][2]//textarea");
        String epochTime = String.valueOf(
        java.time.Instant.now().getEpochSecond());
        String reason = "I want to be the best QA Engineer! " + epochTime;
        Wrappers.enterText(driver, reasonField, reason);

        //Enter your Automation Testing experience in the next radio button
        By experienceRadio = By.cssSelector("div[role='radio'][data-value='3 - 5']");
        Wrappers.clickElement(driver, experienceRadio);

        //Select Java, Selenium and TestNG from the next check-box
        By javaCheckbox = By.cssSelector("div[role='checkbox'][data-answer-value='Java']");
        By seleniumCheckbox = By.cssSelector("div[role='checkbox'][data-answer-value='Selenium']");
        By testngCheckbox = By.cssSelector("div[role='checkbox'][data-answer-value='TestNG']");
        Wrappers.clickElement(driver, javaCheckbox);
        Wrappers.clickElement(driver, seleniumCheckbox);
        Wrappers.clickElement(driver, testngCheckbox);

        //Provide how you would like to be addressed in the next dropdown
        By addressDropdown = By.cssSelector("div[role='listbox']");
        By mrOption = By.cssSelector("div[role='option'][data-value='Mr']");
        Wrappers.selectFromDropdown(driver, addressDropdown, mrOption);

        //Provided the current date minus 7 days in the next date field, it should be dynamically calculated and not hardcoded.
        By dateField = By.xpath("//div[@role='listitem'][.//div[contains(normalize-space(), 'What was the date 7 days ago?')]]//input[@type='date']");
        String dateSevenDaysAgo = java.time.LocalDate.now()
            .minusDays(7)
            .toString();

        Wrappers.enterDate(driver, dateField, dateSevenDaysAgo);

        //Provide the time 07:30 in the next field (Can also be in 24 hour clock)
        By hourField = By.cssSelector("input[aria-label='Hour']");
        By minuteField = By.cssSelector("input[aria-label='Minute']");

        Wrappers.enterText(driver, hourField, "07");
        Wrappers.enterText(driver, minuteField, "30");

        //Submit the form
        By submitButton = By.cssSelector("div[role='button'][aria-label='Submit']");
        Wrappers.clickElement(driver, submitButton);

        System.out.println("Form submitted successfully.");

        //You will see a success message on the website. Print the same message on the console upon successful completion
        By successMessage = By.xpath("//div[normalize-space()='Thanks for your response, Automation Wizard!']");
        
        if (Wrappers.isElementDisplayed(driver, successMessage)) {
            String message = Wrappers.getText(driver, successMessage);
            System.out.println(message);
        } else {
            System.out.println("ERROR: Form submission was not successful.");
            Assert.fail("Form submission failed - success message was not displayed.");
        }
    }

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}