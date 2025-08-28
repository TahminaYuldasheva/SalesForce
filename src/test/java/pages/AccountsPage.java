package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsPage extends BasePage {
    private static final By NEW_NOTE_BUTTON = By.xpath("//button[text()='New Note']");
    public final By DROPDOWN_MENU = By.xpath
            ("//lightning-button-menu[@class=" +
                    "'menu-button-item slds-dropdown_actions slds-dropdown-trigger slds-dropdown-trigger_click']");
    private final String ACCOUNTS_PAGE_URL =
            "https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/list?filterName=__Recent";
    private final By SEARCH_FIELD = By.xpath("//div[@type='search']/input");
    private final By MENU_OPTION = By.xpath("//lightning-menu-item//span[normalize-space()='Edit']");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public AccountsPage isPageOpened() {
        driver.get(ACCOUNTS_PAGE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_FIELD));
        return new AccountsPage(driver);
    }

    public AccountsPage isAccountCreated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_NOTE_BUTTON));
        return new AccountsPage(driver);
    }

    public AccountsPage clickDropdownMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(DROPDOWN_MENU));
        WebElement webElement = driver.findElement(DROPDOWN_MENU);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
        return this;
    }

    public AccountsPage selectOptionFromDropdown() {
        WebElement editElement = wait.until(ExpectedConditions.elementToBeClickable(MENU_OPTION));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editElement);
        return this;
    }


}





