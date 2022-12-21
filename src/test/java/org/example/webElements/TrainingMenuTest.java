package org.example.webElements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrainingMenuTest extends AbstractTest {

    static Logger logger = LoggerFactory.getLogger(UserLoginLogoutTest.class);

    @Test
    public void trainingMenuPracticeTest() throws InterruptedException {

        logger.info("Start test for login");

        //practice
        MainMenuPage practiceMenu = new MainMenuPage(getDriver());
        practiceMenu.practiceMenu();

        Thread.sleep(300);

        //ожидаемый результ - url страницы меню practice
        Assertions.assertEquals(getDriver().getCurrentUrl(),"https://www.codewars.com/kata/latest/my-languages?beta=false");

        Thread.sleep(300);

        //freestyleSparing
        MainMenuPage freestyleSparing = new MainMenuPage(getDriver());
        freestyleSparing.freestyleSparingMenu();

        Thread.sleep(300);

        //ожидаемый результ - url страницы меню freestyle sparring
        Assertions.assertEquals(getDriver().getCurrentUrl(),"https://www.codewars.com/kumite");

        Thread.sleep(300);

        logger.info("Test completed");
    }

}
