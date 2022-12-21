package org.example.webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountMenuPage extends AbstractPage {

    @FindBy(xpath ="//*[@id='main_header']/ul/li[4]")
    private WebElement dropDownList;

    @FindBy (xpath = "//*[@id='main_header']/ul/li[4]/div/div/ul/li[3]/a")
    private WebElement trainingSetup;

    @FindBy (xpath = "//*[@id='user_career_paths_mobile']")
    private WebElement chooseMobile;

    @FindBy (xpath = "//*[@id='setup']/div[10]/a")
    private WebElement setupButton;

    @FindBy (xpath = "//*[@id='main_header']/ul/li[4]/div/div/ul/li[5]/a")
    private WebElement singOut;

    @FindBy(xpath = "//*[@id='main_header']/ul/li[4]/div/div/ul/li[2]/a")
    private WebElement accountSettings;

    @FindBy(xpath = "//*[@id='user_name']")
    private WebElement writeUserName;

    @FindBy(xpath = "//*[@id='edit_user']/input[3]")
    private WebElement buttonUpdate;


    public AccountMenuPage(WebDriver driver) {
        super(driver);
    }

    //Выход из учетки (logout)
    public AccountMenuPage userLogout () {
        Actions builder = new Actions(getDriver());
        builder
                .moveToElement(dropDownList)
                .moveToElement(singOut)
                .click().build().perform();
        return new AccountMenuPage(getDriver());
    }

    //Конфигурация параметров тренировки changeTraining
    public AccountMenuPage trainingSetup () {
        Actions builder = new Actions(getDriver());
        builder
                .moveToElement(dropDownList)
                .moveToElement(trainingSetup)
                .click().build().perform();
        chooseMobile.click();
        setupButton.click();
        return new AccountMenuPage(getDriver());
    }

    //Настройки профиля пользователя
    public AccountMenuPage userProfile() {
        Actions builder = new Actions(getDriver());
        builder
                .moveToElement(dropDownList)
                .moveToElement(accountSettings)
                .click().build().perform();
        return new AccountMenuPage(getDriver());
    }

    //Смена имени юзера в настройках профиля
    public AccountMenuPage changeUserName(String name) {
        writeUserName.click();
        writeUserName.sendKeys(name);
        buttonUpdate.click();
        return new AccountMenuPage(getDriver());
    }

}
