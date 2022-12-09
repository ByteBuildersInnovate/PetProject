package org.example.webElements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ViewDocsTest extends AbstractTest {

    static Logger logger = LoggerFactory.getLogger(UserLoginLogoutTest.class);

    @Test
    public void viewDocsTest() throws InterruptedException {
        logger.info("Start test for login");

        Actions builder = new Actions(getDriver());
        WebElement leftMenu = getDriver().findElement(By.xpath("//*[@id='sidenav']/ul"));
        builder.moveToElement(leftMenu).moveToElement(getDriver().findElement(By.xpath("//*[@id='sidenav']/ul/li[10]/a/div[2]/div[1]"))).click().build().perform();

        Thread.sleep(300);

        List<String> windowHandles = new ArrayList(getDriver().getWindowHandles());
        String secondTab = windowHandles.get(1);

        getDriver().switchTo().window(secondTab);

        //ожидаемый результ - url страницы с документацией
        Assertions.assertEquals(getDriver().getCurrentUrl(),"https://docs.codewars.com/");

        logger.info("Test completed");
    }
}
