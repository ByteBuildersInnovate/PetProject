package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ViewLeaderboard {

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

        WebElement leaderboard = driver.findElement(By.xpath("//*[@id=\"sidenav\"]/ul/li[8]/a/div[2]/div[1]"));
        leaderboard.click();

        WebElement completedKata = driver.findElement(By.xpath("//*[@id=\"shell_content\"]/div[3]/div[1]/dl/dd[2]/a"));
        completedKata.click();

        WebElement authoredKata = driver.findElement(By.xpath("//*[@id=\"shell_content\"]/div[3]/div[1]/dl/dd[3]/a"));
        authoredKata.click();

        //driver.quit();

    }

}
