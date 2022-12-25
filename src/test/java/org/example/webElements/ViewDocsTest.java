package org.example.webElements;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ViewDocsTest extends AbstractTest {

    static Logger logger = LoggerFactory.getLogger(UserLoginLogoutTest.class);

    @Test
    @DisplayName("Документация")
    @Description("Переход на вед-страницу с документацией")
    @Link("http://yandex.ru")
    @Issue("https://www.codewars.com/")
    @Severity(SeverityLevel.MINOR)
    public void viewDocsTest() throws InterruptedException {
        logger.info("Start test for login");

        //Вызов метода для перехода на страницу с документацией
        MainMenuPage openDocs = new MainMenuPage(getDriver());
        openDocs.viewDocs();

        Thread.sleep(300);

        List<String> windowHandles = new ArrayList(getDriver().getWindowHandles());
        String secondTab = windowHandles.get(1);

        getDriver().switchTo().window(secondTab);

        //ожидаемый результ - url страницы с документацией
        Assertions.assertEquals(getDriver().getCurrentUrl(),"https://docs.codewars.com/");

        logger.info("Test completed");
    }
}
