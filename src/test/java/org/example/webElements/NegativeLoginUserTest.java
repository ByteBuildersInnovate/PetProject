package org.example.webElements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NegativeLoginUserTest extends AbstractTest {

    static Logger logger = LoggerFactory.getLogger(UserLoginLogoutTest.class);

    @Test
    public void negativeLoginUserTest() throws InterruptedException {

        logger.info("Start test for login");

        //logout
        Actions builder = new Actions(getDriver());
        WebElement dropDownList = getDriver().findElement(By.xpath("//*[@id='main_header']/ul/li[4]"));
        builder.moveToElement(dropDownList).moveToElement(getDriver().findElement(By.xpath("//*[@id='main_header']/ul/li[4]/div/div/ul/li[5]/a"))).click().build().perform();

        Thread.sleep(3000);

        WebElement writeLogin = getDriver().findElement(By.xpath("//*[@id='user_email']"));
        writeLogin.click();
        writeLogin.sendKeys("rogaAndKopeta@gmail.com");

        WebElement writePassword = getDriver().findElement(By.xpath("//*[@id='user_password']"));
        writePassword.click();
        writePassword.sendKeys("0Yfacspwkparq7897a");

        WebElement singIn = getDriver().findElement(By.xpath("//*[@id='new_user']/button[2]"));
        singIn.click();

        String invalid = getDriver().findElement(By.xpath("//*[@id='flash']/div/div/div")).getText();
        Assertions.assertEquals(true, invalid.contains(getDriver().findElement(By.xpath("//*[@id='flash']/div/div/div")).getText()));

        Thread.sleep(3000);
    }
}
