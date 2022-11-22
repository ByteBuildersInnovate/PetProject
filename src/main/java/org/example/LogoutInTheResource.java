// Не реализован до конца!
package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class LogoutInTheResource {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.codewars.com/");

        WebElement buttonWithLogin = driver.findElement(By.xpath("//*[@id=\"login-btn\"]"));
        buttonWithLogin.click();

        WebElement writeLogin = driver.findElement(By.xpath("//*[@id=\"user_email\"]"));
        writeLogin.click();
        writeLogin.sendKeys("ivsOrigin@gmail.com");

        WebElement writePassword = driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
        writePassword.click();
        writePassword.sendKeys("162018Bobbi");

        WebElement singIn = driver.findElement(By.xpath("//*[@id=\"new_user\"]/button[2]"));
        singIn.click();

        //не разоьрался как выьрать элемент из Drop-Down если у элемента есть только class
        WebElement dropDownList = driver.findElement(By.className("menu shadow-lg"));
        Select select = new Select(dropDownList);
        select.selectByIndex(5);

        //driver.quit();
    }
}
