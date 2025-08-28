package pages;

import dto.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.DropDown;
import wrappers.Input;

public class NewContactModal extends BasePage {
    private final By SAVE_BUTTON = By.xpath("//button[@name='SaveEdit']");
    private final By NEW_BUTTON = By.xpath("//*[@title='New']/div");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    public NewContactModal open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Contact/list?filterName=__Recent");
        driver.findElement(NEW_BUTTON).click();
        return this;
    }


    public NewContactModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
        return this;
    }

    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
    }


    public NewContactModal createContact(Contact contact) {
        new DropDown(driver, "Salutation").select(contact.getSalutation());
        new Input(driver, "First Name").write(contact.getFirstName());
        new Input(driver, "Last Name").write(contact.getLastName());
        new Input(driver, "Phone").write(contact.getPhone());
        new Input(driver, "Home Phone").write(contact.getHomePhone());
        new Input(driver, "Title").write(contact.getTitle());
        new Input(driver, "Department").write(contact.getDepartment());
        new Input(driver, "Mobile").write(contact.getDepartment());
        new Input(driver, "Fax").write(contact.getFax());
        new Input(driver, "Email").write(contact.getEmail());
        return this;
    }
}
