package tests;

import com.github.javafaker.Faker;
import dto.Account;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewAccountTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    Faker faker = new Faker();

    Account account = Account.builder()
            .name(faker.company().name())
            .phone(faker.phoneNumber().phoneNumber())
            .fax(faker.phoneNumber().phoneNumber())
            .website("https://www.apple.com")
            .rating("Hot")
            .accountNumber(faker.number().digit())
            .accountSite(faker.company().url())
            .tickerSymbol("AAPL")
            .type("Other")
            .ownerShip("Public")
            .industry("Technology")
            .employees(faker.number().digits(1))
            .annualRevenue(faker.number().digits(5))
            .sicCode(faker.number().digits(5))
            .billingStreet(faker.address().streetAddress())
            .shippingStreet(faker.address().streetAddress())
            .billingCity(faker.address().city())
            .state(faker.address().state())
            .billingZip(faker.address().zipCode())
            .billingCountry(faker.address().country())
            .shippingCity(faker.address().city())
            .stateProvince(faker.address().state())
            .shippingZip(faker.address().zipCode())
            .shippingCountry(faker.address().country())
            .customerPriority("High")
            .SLA("Gold")
            .numberOfLocations(faker.number().digits(1))
            .active("Yes")
            .SLASerialNumber(faker.number().digits(5))
            .upsellOpportunity("Yes")
            .description(faker.lorem().sentence(15))
            .build();


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
        account.setWebsite("https://www.test.com");
        newAccountModal.setName(account.getName())
                .setWebsite(account.getWebsite())
                .clickSaveButton();

        softAssert.assertEquals(account.getName(),
                "Ku",
                "Некорректный текст!");
        softAssert.assertEquals(account.getWebsite(),
                "https://www.test.com",
                "Некорректный текст!");
        softAssert.assertAll();
    }
}
