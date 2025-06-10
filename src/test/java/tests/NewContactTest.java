package tests;

import dto.Contact;
import org.testng.annotations.Test;

public class NewContactTest extends BaseTest {

    Contact contact = Contact.builder()
            .salutation("Mr.")
            .firstName("John")
            .lastName("Wick")
            .phone("+375295642323")
            .homePhone("3456789")
            .title("Boba")
            .department("Boba")
            .mobile("+48987654345")
            .fax("3456789")
            .email("johnwick@gmail.com")
            .build();

    @Test
    public void checkCreateContact() throws InterruptedException {
        loginPage.open()
                .isPageOpened()
                .login("tborodich@tms.sandbox", "Password002!");
        Thread.sleep(1000);
        newContactModal.open()
                .isPageOpened()
                .createContact(contact)
                .clickSaveButton();
    }
}