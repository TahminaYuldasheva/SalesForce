package tests;

import dto.Contact;
import org.testng.annotations.Test;

public class NewContactTest extends BaseTest {
    Contact contact = new Contact("Mr.", "Jordani", "Jovanovich", "+37564345678",
            "62762538", "Biba", "Boba", "+48564345678", "+48564345678",
            "johnwick@gmail.com");


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