package org.example.webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainMenuPage extends AbstractPage{

    @FindBy(xpath = "//*[@id='sidenav']/ul")
    private WebElement leftMenu;

    @FindBy(xpath = "//*[@id='sidenav']/ul/li[3]/a/div[2]/div[1]")
    private WebElement practice;

    @FindBy(xpath = "//*[@id='sidenav']/ul/li[4]/a/div[2]/div[1]")
    private WebElement freestyleSparing;

    @FindBy(xpath = "//*[@id='sidenav']/ul/li[10]/a/div[2]/div[1]")
    private WebElement docs;

    public MainMenuPage(WebDriver driver) {
        super(driver);
    }

    //переход на веб-страницу с документацией
    public MainMenuPage viewDocs() {
        Actions builder = new Actions(getDriver());
        builder
                .moveToElement(leftMenu)
                .moveToElement(docs)
                .click().build().perform();
        return new MainMenuPage(getDriver());
    }

    //выбор пукта меню practice
    public MainMenuPage practiceMenu() {
        Actions builder = new Actions(getDriver());
        builder
                .moveToElement(leftMenu)
                .moveToElement(practice)
                .click().build().perform();
        return new MainMenuPage(getDriver());
    }

    //выбор пукта меню freestyleSparing
    public MainMenuPage freestyleSparingMenu() {
        Actions builder = new Actions(getDriver());
        builder
                .moveToElement(leftMenu)
                .moveToElement(freestyleSparing)
                .click().build().perform();
        return new MainMenuPage(getDriver());
    }
}
