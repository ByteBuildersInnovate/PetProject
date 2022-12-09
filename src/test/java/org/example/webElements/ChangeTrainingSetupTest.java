package org.example.webElements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChangeTrainingSetupTest extends AbstractTest{

    static Logger logger = LoggerFactory.getLogger(UserProfileChangeNameTest.class);

    @Test
    public void changeTrainingSetupTest() throws InterruptedException {

        logger.info("Start test for login");

        Actions builder = new Actions(getDriver());
        WebElement dropDownList = getDriver().findElement(By.xpath("//*[@id='main_header']/ul/li[4]"));
        builder.moveToElement(dropDownList).moveToElement(getDriver().findElement(By.xpath("//*[@id='main_header']/ul/li[4]/div/div/ul/li[3]/a"))).click().build().perform();

        Thread.sleep(3000);

        WebElement chooseMobile = getDriver().findElement(By.xpath("//*[@id='user_career_paths_mobile']"));
        chooseMobile.click();

        WebElement setupButton = getDriver().findElement(By.xpath("//*[@id='setup']/div[10]/a"));
        setupButton.click();

        Thread.sleep(3000);

        String trainerBanner = getDriver().findElement(By.xpath("//*[@id='trainer']")).getText();
        Assertions.assertEquals(true, trainerBanner.contains(getDriver().findElement(By.xpath("//*[@id='trainer']")).getText()));

        logger.info("Test completed");

    }
}
