package org.example.webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFormsPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='login-btn']")
    private WebElement buttonWithLogin;

    @FindBy(xpath = "//*[@id='user_email']")
    private WebElement writeLogin;

    @FindBy(xpath = "//*[@id='user_password']")
    private WebElement writePassword;

    @FindBy(xpath = "//*[@id='new_user']/button[2]")
    private WebElement singIn;

    public LoginFormsPage(WebDriver driver) {
        super(driver);
    }

    //Базовая авторизаци пользователя - ввод логина и пароля
    public LoginFormsPage userLoginPassword (String login, String password) {
        writeLogin.click();
        writeLogin.sendKeys(login);
        writePassword.click();
        writePassword.sendKeys(password);
        singIn.click();
        return new LoginFormsPage(getDriver());
    }
}
