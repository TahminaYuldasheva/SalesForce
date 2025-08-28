package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage {

    private static final By USERNAME_FIELD = By.id("username");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("Login");
    public final String BASE_URL = "https://tms9-dev-ed.develop.my.salesforce.com";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        log.info("Opening Login Page");
        driver.get(BASE_URL);
        return this;
    }

    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        } catch (TimeoutException e) {
            log.error("Login Page is not opened!");
        }
        return this;
    }

    public LoginPage login(String user, String password) {
        log.info("Log in with username: {} and password: {}", user, password);
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new LoginPage(driver);
    }
}

