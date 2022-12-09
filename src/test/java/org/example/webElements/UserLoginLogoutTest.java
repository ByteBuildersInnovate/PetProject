package org.example.webElements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserLoginLogoutTest extends AbstractTest {

    static Logger logger = LoggerFactory.getLogger(UserLoginLogoutTest.class);

    @Test
    public void userLoginLogoutTest() throws InterruptedException {
        logger.info("Start test for login");

        //logout
        Actions builder = new Actions(getDriver());
        WebElement dropDownList = getDriver().findElement(By.xpath("//*[@id='main_header']/ul/li[4]"));
        builder.moveToElement(dropDownList).moveToElement(getDriver().findElement(By.xpath("//*[@id='main_header']/ul/li[4]/div/div/ul/li[5]/a"))).click().build().perform();

        Thread.sleep(3000);

        String newUser = getDriver().findElement(By.xpath("//*[@id='new_user']/a/img[1]")).getText();
        Assertions.assertEquals(true, newUser.contains(getDriver().findElement(By.xpath("//*[@id='new_user']/a/img[1]")).getText()));

        logger.info("Test completed");

    }
}
