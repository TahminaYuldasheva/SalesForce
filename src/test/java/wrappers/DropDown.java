package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class DropDown {
    WebDriver driver;
    String label;
    String selectPattern = "//label[text()='%s']//ancestor::lightning-picklist";
    WebDriverWait wait;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void select(String option) {
        log.info("Selecting: {} from the dropdown: {}", option, label);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(selectPattern + "//button", label))));
        WebElement dropdown = driver.findElement(By.xpath(String.format(selectPattern + "//button", label)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(selectPattern +
                "//lightning-base-combobox-item//span[text()='%s']", label, option))));

        WebElement optionElement = driver.findElement(By.xpath(String.format(selectPattern +
                "//lightning-base-combobox-item//span[text()='%s']", label, option)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);

    }
}
