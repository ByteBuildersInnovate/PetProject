package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ChoiceOptionsCurses {

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

        WebElement optionSQL = driver.findElement(By.xpath("//*[@id=\"setup\"]/div[4]/ul/li[55]/a/div/i"));
        optionSQL.click();

        WebElement optionKotlin = driver.findElement(By.xpath("//*[@id=\"setup\"]/div[4]/ul/li[30]/a/div/i"));
        optionKotlin.click();

        WebElement optionJavaScript = driver.findElement(By.xpath("//*[@id=\"setup\"]/div[4]/ul/li[28]/a/div/i"));
        optionJavaScript.click();

        WebElement checkBoxWeb = driver.findElement(By.xpath("//*[@id=\"career_paths\"]/div[1]/div/div/span[2]/label"));
        checkBoxWeb.click();

        WebElement checkBoxFront = driver.findElement(By.xpath("//*[@id=\"career_paths\"]/div[1]/div/div/span[1]/label"));
        checkBoxFront.click();

        WebElement radioButtonLevelOne = driver.findElement(By.xpath("//*[@id=\"setup\"]/div[3]/div[1]/div/div/span[1]/label"));
        radioButtonLevelOne.click();

        WebElement radioButtonHelp = driver.findElement(By.xpath("//*[@id=\"setup\"]/div[5]/div[1]/div/div/span[1]/label"));
        radioButtonHelp.click();


        WebElement writeFullName = driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
        writeFullName.click();
        writeFullName.sendKeys("Vasily Terkin");

        WebElement writePhone = driver.findElement(By.xpath("//*[@id=\"user_phone\"]"));
        writePhone.click();
        writePhone.sendKeys("+7(495)937-99-92");

        WebElement radioButtonNews = driver.findElement(By.xpath("//*[@id=\"user_weekly_newsletter_false\"]"));
        radioButtonNews.click();

        WebElement radioButtonSave = driver.findElement(By.xpath("//*[@id=\"setup\"]/div[12]/a"));
        radioButtonSave.click();

        //driver.quit();
    }
}
