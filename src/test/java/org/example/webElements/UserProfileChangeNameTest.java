package org.example.webElements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserProfileChangeNameTest extends AbstractTest{

    static Logger logger = LoggerFactory.getLogger(UserProfileChangeNameTest.class);

    @Test
    public void userProfileChangeNameTest() throws InterruptedException {
        logger.info("Start test for login");

        Actions builder = new Actions(getDriver());
        WebElement dropDownList = getDriver().findElement(By.xpath("//*[@id='main_header']/ul/li[4]"));
        builder.moveToElement(dropDownList).moveToElement(getDriver().findElement(By.xpath("//*[@id='main_header']/ul/li[4]/div/div/ul/li[2]/a"))).click().build().perform();

        Thread.sleep(3000);

        WebElement writeUserName = getDriver().findElement(By.xpath("//*[@id='user_name']"));
        writeUserName.clear();
        writeUserName.sendKeys("NewUser");

        WebElement buttonUpdate = getDriver().findElement(By.xpath("//*[@id='edit_user']/input[3]"));
        buttonUpdate.click();

        String succsess = getDriver().findElement(By.xpath("//*[@id='flash']/div/div/div")).getText();
        Assertions.assertEquals(true, succsess.contains(getDriver().findElement(By.xpath("//*[@id='flash']/div/div/div")).getText()));

        logger.info("Test completed");
    }

}
