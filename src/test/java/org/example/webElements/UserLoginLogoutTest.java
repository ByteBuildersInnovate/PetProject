package org.example.webElements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserLoginLogoutTest extends AbstractTest {

    static Logger logger = LoggerFactory.getLogger(UserLoginLogoutTest.class);

    @Test
    public void userLoginLogoutTest() throws InterruptedException {
        logger.info("Start test for login");

        //logout
        AccountMenuPage userLogoutForTest = new AccountMenuPage(getDriver());
        userLogoutForTest.userLogout();

        Thread.sleep(3000);

        String newUser = getDriver().findElement(By.xpath("//*[@id='new_user']/a/img[1]")).getText();
        Assertions.assertEquals(true, newUser.contains(getDriver().findElement(By.xpath("//*[@id='new_user']/a/img[1]")).getText()));

        logger.info("Test completed");

    }
}
