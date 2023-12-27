package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_AgeGatewayPage {
    public WebDriver driver;

    //////////Constructor
    public P01_AgeGatewayPage(WebDriver driver) {
        this.driver = driver;
    }

    ////////Locators
    public WebElement getDayInput() {
        return driver.findElement(By.id("DD"));
    }

    public WebElement getMonthInput() {
        return driver.findElement(By.id("MM"));
    }

    public WebElement getYearBtn() {
        return driver.findElement(By.id("YYYY"));
    }


    public void enterValidInputs(String day, String month, String year) {
        getDayInput().clear();
        getDayInput().sendKeys(day);
        getMonthInput().clear();
        getMonthInput().sendKeys(month);
        getYearBtn().clear();
        getYearBtn().sendKeys(year);
    }

    public void enterValidInputs(String date) {
        getDayInput().clear();
        getDayInput().sendKeys(date);
    }


}
