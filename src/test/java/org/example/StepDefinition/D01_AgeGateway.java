package org.example.StepDefinition;

import Pages.P01_AgeGatewayPage;
import Pages.P02_HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static Pages.P02_HomePage.getCurrentDateMinus;
import static Pages.P02_HomePage.getCurrentDate_MinusYearsPlusDays;

public class D01_AgeGateway {
    public static WebDriver driver;

    ////// Scenario 1: user login with valid data
    @Given("user navigate to jager meister website")
    public void userNavigateTo() {
        driver.get("https://www.jagermeister.com/en-GB/home");
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
    }

    @Then("user enter valid date equals to 18 years old")
    public void enterValidData_equals18() {
        new P01_AgeGatewayPage(driver).enterValidInputs(getCurrentDateMinus(18, 0));
    }

    @Then("user enter valid date bigger than 18 years old")
    public void enterValidData_lessThan18() {
        new P01_AgeGatewayPage(driver).enterValidInputs(getCurrentDateMinus(18, 1));
    }

    @Then("user enter valid date smaller than 18 years old")
    public void enterValidData_biggerThan18() {
        new P01_AgeGatewayPage(driver).enterValidInputs(getCurrentDate_MinusYearsPlusDays(18, 1));
    }

    @Then("user directed to the site page without clicking Enter")
    public void validateLessThan18ErrorMsg() throws InterruptedException {
        new P02_HomePage(driver).verifyUserRedirectedSuccessfully();
    }

    @Then("Error message to appear with date entered is smaller than 18 years old")
    public void validateUserNavigation() throws InterruptedException {
        new P02_HomePage(driver).verifyLessThan18YearsErrorMsg();
    }

    @Then("user should stay in same page")
    public void validateUserNotNavigated() {
        new P02_HomePage(driver).verifyHomePage();
    }


    @When("user enter inValid date {string}, {string} and {string}")
    public void userEnterInValidDate(String DD, String MM, String YYYY) {
        new P01_AgeGatewayPage(driver).enterValidInputs(DD, MM, YYYY);
    }

    @When("user enter inValid Day {string}, {string} and {string}")
    public void userEnter_inValidDay(String DD, String MM, String YYYY) {
        new P01_AgeGatewayPage(driver).enterValidInputs(DD, MM, YYYY);
    }

    @Then("Error message to appear with invalid Day")
    public void validateInvalidDay_ErrorMessage() {
        new P02_HomePage(driver).verifyInvalidDayErrorMsg();
    }

    @When("user enter inValid Month {string}, {string} and {string}")
    public void userEnter_inValidMonth(String DD, String MM, String YYYY) {
        new P01_AgeGatewayPage(driver).enterValidInputs(DD, MM, YYYY);
    }

    @Then("Error message to appear with invalid Month")
    public void validateInvalidMonth_ErrorMessage() {
        new P02_HomePage(driver).verifyInvalidMonthErrorMsg();
    }

    @When("user enter less than 1900 as year {string}, {string} and {string}")
    public void userEnter_lessThan1900(String DD, String MM, String YYYY) {
        new P01_AgeGatewayPage(driver).enterValidInputs(DD, MM, YYYY);
    }

    @Then("Error message to appear with unReal date")
    public void validateUnrealDate_ErrorMessage() throws InterruptedException {
        Thread.sleep(500);
        new P02_HomePage(driver).verifyUnrealDateErrorMsg();
    }

    @When("user navigate to jager meister website in new tab")
    public void openNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.jagermeister.com/en-GB/home");
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
    }
    @Then("user should directed to the site page without completing Age gateway")
    public void userNavigatedWithoutAgeGateway() throws InterruptedException {
        new P02_HomePage(driver).verifyUserRedirectedSuccessfully();
    }

    @Before
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public static void tearDown() {
        driver.quit();
    }

}



