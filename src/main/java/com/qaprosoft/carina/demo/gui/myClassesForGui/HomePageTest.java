package com.qaprosoft.carina.demo.gui.myClassesForGui;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

import java.lang.invoke.MethodHandles;

public class HomePageTest extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(className = "login_logo")
    private ExtendedWebElement title;

    @FindBy(id = "user-name")
    private ExtendedWebElement userNameField;

    @FindBy(id = "password")
    private ExtendedWebElement userPasswordField;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    private ExtendedWebElement errorMessage;

    @FindBy(xpath = "//*[@id='login_button_container']/div/form/div[3]/h3")
    private ExtendedWebElement errorMessageLogin;

    @FindBy(className = "error_icon")
    private ExtendedWebElement errorIcon;

    @FindBy(className = "error-button")
    private ExtendedWebElement errorButton;

    public HomePageTest(WebDriver driver) {
        super(driver);
    }

    public boolean isTitlePresent() {
        return title.isElementPresent(5);
    }

    public HomePageTest typeUserName(String userName) {
        this.userNameField.type(userName);
        LOGGER.info("Written username: " + userName);
        return this;
    }

    public HomePageTest typePassword(String password) {
        userPasswordField.type(password);
        LOGGER.info("Written password: " + password);
        return this;
    }

    public InventoryPage clickLoginButton() {
        loginButton.click();
        LOGGER.info("The Login button is clicked");
        return new InventoryPage(driver);
    }

    public InventoryPage loginToAccount(String username, String password) {
        typeUserName(username);
        typePassword(password);
        clickLoginButton();
        return new InventoryPage(driver);
    }

    public boolean isErrorMessagePresent() {
        return errorMessage.isElementPresent();
    }

    public String getErrorMessage() {
        return errorMessageLogin.getText();
    }

    public boolean isErrorIconPresent() {
        return errorIcon.isElementPresent();
    }

    public boolean isErrorButtonPresent() {
        return errorButton.isElementPresent();
    }

    public String checkUsernameTextField() {
        return userNameField.getElement().getAttribute("value");
    }

    public String checkPasswordTextField() {
        return userPasswordField.getElement().getAttribute("value");
    }

    public boolean checkLocationUsername() {

        LOGGER.info("Password location: " + userPasswordField.getLocation().toString());
        LOGGER.info("Username location: " + userNameField.getLocation().toString());
        return userPasswordField.getLocation().y > userNameField.getLocation().y;
/*        if (userPasswordField.getLocation().y > userNameField.getLocation().y) {
            return true;
        } else {
            return false;
        }*/
    }

    public boolean checkLocationLoginBtn() {

        LOGGER.info("Password location: " + userPasswordField.getLocation().toString());
        LOGGER.info("Login button location: " + loginButton.getLocation().toString());
        return userPasswordField.getLocation().y < loginButton.getLocation().y;
/*        if (userPasswordField.getLocation().y < loginButton.getLocation().y) {
            return true;
        } else {
            return false;
        }*/
    }


}
