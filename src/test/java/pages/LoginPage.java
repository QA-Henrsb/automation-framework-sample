package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Locators
    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By submit = By.id("submit");
    private final By error = By.id("error");
    private final By logoutBtn = By.linkText("Log out");

    // Actions

    public void open() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submit).click();
    }

    public boolean isLoginSuccessful() {
        wait.until(ExpectedConditions.urlContains("logged-in-successfully"));
        return driver.findElement(logoutBtn).isDisplayed();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(error)).getText();
    }
}

