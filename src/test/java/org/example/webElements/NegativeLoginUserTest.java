package org.example.webElements;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NegativeLoginUserTest extends AbstractTest {

    static Logger logger = LoggerFactory.getLogger(UserLoginLogoutTest.class);

    @Test
    @DisplayName("Аторизация - негативный тест")
    @Description("Тест на попытку аторизации с неверными учетными данными")
    @Link("http://yandex.ru")
    @Issue("https://www.codewars.com/")
    @Severity(SeverityLevel.CRITICAL)
    public void negativeLoginUserTest() throws InterruptedException {

        logger.info("Start test for login");

        //logout
        AccountMenuPage userLogoutForNegativeTest = new AccountMenuPage(getDriver());
        userLogoutForNegativeTest.userLogout();

        Thread.sleep(3000);

        //login
        LoginFormsPage userLogin = new LoginFormsPage(getDriver());
        userLogin.userLoginPassword("rogaAndKopeta@gmail.com", "0Yfacspwkparq7897a");

        String invalid = getDriver().findElement(By.xpath("//*[@id='flash']/div/div/div")).getText();
        Assertions.assertEquals(true, invalid.contains(getDriver().findElement(By.xpath("//*[@id='flash']/div/div/div")).getText()));

        Thread.sleep(3000);
    }
}
