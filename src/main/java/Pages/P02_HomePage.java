package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class P02_HomePage {
    public WebDriver driver;

    ////////Constructor
    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement dateInstructionsText() {
        return driver.findElement(By.xpath("//h1[@class=\"agegate_instructionsText__2x1XA-\"] [contains(.,'To access our Jägermeister websites you must be of legal drinking age in your country of access or older. ')]"));
    }

    private WebElement pageTitle() {
        return driver.findElement(By.xpath("//h1[@class=\"fullbleed_pageTitle__3BSXP-\"] [contains(.,'The Best Nights Of Your Life')]"));
    }

    private WebElement lessThan18ErrorMsg() {
        return driver.findElement(By.xpath("//div[@class=\"verificationError_headline__h-42s-\"] [contains(.,'nein')]"));
    }

    private WebElement invalidDayErrorMsg() {
        return driver.findElement(By.xpath("//div[@class=\"input_errorMessage__2BX8K-\"] [contains(.,'Invalid day input')]"));
    }

    private WebElement invalidMonthErrorMsg() {
        return driver.findElement(By.xpath("//div[@class=\"input_errorMessage__2BX8K-\"] [contains(.,'Invalid month input')]"));
    }

    private WebElement lessThan1900ErrorMsg() {
        return driver.findElement(By.xpath("//div[@class=\"verificationError_message__12kUk-\"]/div [contains(.,'Just a minute, old timer')]"));
    }

    public void verifyUserRedirectedSuccessfully() throws InterruptedException {
        Thread.sleep(1500);
        SoftAssert soft = new SoftAssert();
        Assert.assertTrue(driver.getTitle().contains("Be The Meister"));
        Assert.assertTrue(pageTitle().isDisplayed());
        soft.assertAll();
    }

    public void verifyLessThan18YearsErrorMsg() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(lessThan18ErrorMsg().isDisplayed(), "Less than 18 years old Error Msg not Displayed");
    }

    public void verifyHomePage() {
        SoftAssert soft = new SoftAssert();
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Jägermeister"));
        Assert.assertTrue(dateInstructionsText().isDisplayed());
        soft.assertAll();
    }

    public void verifyInvalidDayErrorMsg() {
        Assert.assertEquals(invalidDayErrorMsg().getText(), "Invalid day input");
    }

    public void verifyInvalidMonthErrorMsg() {
        Assert.assertEquals(invalidMonthErrorMsg().getText(), "Invalid month input");
    }

    public void verifyUnrealDateErrorMsg() {
        Assert.assertEquals(lessThan1900ErrorMsg().getText(), "JUST A MINUTE, OLD TIMER");
    }

    public static String getCurrentDateMinus(int years, int days) {
        LocalDateTime myDateObj = LocalDateTime.now().minusYears(years).minusDays(days);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate.replace("-", "");
    }

    public static String getCurrentDate_MinusYearsPlusDays(int years, int days) {
        LocalDateTime myDateObj = LocalDateTime.now().minusYears(years).plusDays(days);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate.replace("-", "");
    }

}
