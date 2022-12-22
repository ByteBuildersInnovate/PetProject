package org.example.webElements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserProfileChangeNameTest extends AbstractTest{

    static Logger logger = LoggerFactory.getLogger(UserProfileChangeNameTest.class);

    @Test
    public void userProfileChangeNameTest() throws InterruptedException {
        logger.info("Start test for login");

        AccountMenuPage userProfile = new AccountMenuPage(getDriver());
        userProfile.userProfile();

        Thread.sleep(3000);

        AccountMenuPage changeUserName = new AccountMenuPage(getDriver());
        changeUserName.changeUserName("NewUser");


        String succsess = getDriver().findElement(By.xpath("//*[@id='flash']/div/div/div")).getText();
        Assertions.assertEquals(true, succsess.contains(getDriver().findElement(By.xpath("//*[@id='flash']/div/div/div")).getText()));

        logger.info("Test completed");
    }

}
