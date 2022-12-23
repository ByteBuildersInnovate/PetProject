package org.example.webElements;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChangeTrainingSetupTest extends AbstractTest{

    static Logger logger = LoggerFactory.getLogger(UserProfileChangeNameTest.class);

    @Test
    @DisplayName("Настройки тренинга")
    @Description("Изменение настроек учетной записи для прохождения тренинга")
    @Link("http://yandex.ru")
    @Issue("https://www.codewars.com/")
    @Severity(SeverityLevel.MINOR)
    public void changeTrainingSetupTest() throws InterruptedException {

        logger.info("Start test for login");
        AccountMenuPage changeTrainingSetup = new AccountMenuPage(getDriver());
        changeTrainingSetup.trainingSetup();

        Thread.sleep(3000);

        String trainerBanner = getDriver().findElement(By.xpath("//*[@id='trainer']")).getText();
        Assertions.assertEquals(true, trainerBanner.contains(getDriver().findElement(By.xpath("//*[@id='trainer']")).getText()));

        logger.info("Test completed");

    }
}
