package org.example.webElements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrainingMenuTest extends AbstractTest {

    static Logger logger = LoggerFactory.getLogger(UserLoginLogoutTest.class);

    @Test
    public void trainingMenuPracticeTest() throws InterruptedException {

        logger.info("Start test for login");

        //practice
        Actions builder = new Actions(getDriver());
        WebElement leftMenu = getDriver().findElement(By.xpath("//*[@id='sidenav']/ul"));
        builder.moveToElement(leftMenu).moveToElement(getDriver().findElement(By.xpath("//*[@id='sidenav']/ul/li[3]/a/div[2]/div[1]"))).click().build().perform();

        Thread.sleep(300);

        //ожидаемый результ - url страницы меню practice
        Assertions.assertEquals(getDriver().getCurrentUrl(),"https://www.codewars.com/kata/latest/my-languages?beta=false");

        Thread.sleep(300);

        Actions builderSecond = new Actions(getDriver());
        WebElement leftMenuSecond = getDriver().findElement(By.xpath("//*[@id='sidenav']/ul"));
        builderSecond.moveToElement(leftMenuSecond).moveToElement(getDriver().findElement(By.xpath("//*[@id='sidenav']/ul/li[4]/a/div[2]/div[1]"))).click().build().perform();

        Thread.sleep(300);

        //ожидаемый результ - url страницы меню freestyle sparring
        Assertions.assertEquals(getDriver().getCurrentUrl(),"https://www.codewars.com/kumite");

        Thread.sleep(300);

        logger.info("Test completed");
    }

}
