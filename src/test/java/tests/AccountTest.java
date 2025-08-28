package tests;

import dto.Account;
import dto.AccountFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AccountTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    Account account = AccountFactory.getAccount("Hot", "https://www.apple.com",
            "www.homepageApple", "AAPL", "Other", "Public", "Technology",
            "High",
            "Gold", "Yes", "Yes");

    @Test
    public void checkCreateAccount() throws InterruptedException {
        loginPage.open()
                .isPageOpened()
                .login("tborodich@tms.sandbox", "Password002!");

        Thread.sleep(1000);
        accountsPage.isPageOpened();
        newAccountModal.open()
                .isPageOpened()
                .createAccount(account)
                .clickSaveButton();
        accountsPage.isAccountCreated()
                .clickDropdownMenu()
                .selectOptionFromDropdown();
        account.setName("Ku");
        account.setAccountWebsite("test@gmail.com");
        newAccountModal.setName(account.getName())
                .setWebsite(account.getAccountWebsite())
                .clickSaveButton();

        softAssert.assertEquals(account.getName(),
                "Ku",
                "Некорректный текст!");
        softAssert.assertEquals(account.getAccountWebsite(),
                "test@gmail.com",
                "Некорректный текст!");
        softAssert.assertAll();

    }
}
