package pages;

import dto.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.Checkbox;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

public class NewAccountModal extends BasePage {

    private static final By SAVE_BUTTON = By.xpath("//*[@name='SaveEdit']");
    public final String NEW_BUTTON_URL = "https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new";
    private final String INPUT_FIELD = "//input[@name='%s']";

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public NewAccountModal open() {
        driver.get(NEW_BUTTON_URL);
        return this;
    }

    public NewAccountModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
        return this;
    }

    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
    }

    private void setInputValue(String fieldName, String value) {
        String locator = String.format(INPUT_FIELD, fieldName);
        WebElement input = driver.findElement(By.xpath(locator));
        input.clear();
        input.sendKeys(value);
    }

    public NewAccountModal setName(String name) {
        setInputValue("Name", name);
        return this;
    }

    public NewAccountModal setWebsite(String website) {
        setInputValue("Website", website);
        return this;
    }

    public NewAccountModal createAccount(Account account) {
        new Input(driver, "Account Name").write(account.getName());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Website").write(account.getWebsite());
        new DropDown(driver, "Rating").select(account.getRating());
        new Input(driver, "Account Number").write(account.getAccountNumber());
        new Input(driver, "Account Site").write(account.getAccountSite());
        new Input(driver, "Ticker Symbol").write(account.getTickerSymbol());
        new DropDown(driver, "Type").select(account.getType());
        new DropDown(driver, "Ownership").select(account.getOwnerShip());
        new DropDown(driver, "Industry").select(account.getIndustry());
        new Input(driver, "Employees").write(account.getEmployees());
        new Input(driver, "Annual Revenue").write(account.getAnnualRevenue());
        new Input(driver, "SIC Code").write(account.getSicCode());
        new Checkbox(driver, "VIP Client").select();
        new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        new Input(driver, "Billing City").write(account.getBillingCity());
        new Input(driver, "Billing State/Province").write(account.getState());
        new Input(driver, "Billing Zip/Postal Code").write(account.getBillingZip());
        new Input(driver, "Billing Country").write(account.getBillingCountry());
        new Input(driver, "Shipping City").write(account.getShippingCity());
        new Input(driver, "Shipping State/Province").write(account.getStateProvince());
        new Input(driver, "Shipping Zip/Postal Code").write(account.getShippingZip());
        new Input(driver, "Shipping Country").write(account.getShippingCountry());
        new DropDown(driver, "Customer Priority").select(account.getCustomerPriority());
        new DropDown(driver, "SLA").select(account.getSLA());
        new Input(driver, "Number of Locations").write(account.getNumberOfLocations());
        new DropDown(driver, "Active").select(account.getActive());
        new Input(driver, "SLA Serial Number").write(account.getSLASerialNumber());
        new DropDown(driver, "Upsell Opportunity").select(account.getUpsellOpportunity());
        new TextArea(driver, "Description").write(account.getDescription());
        return this;
    }


}
