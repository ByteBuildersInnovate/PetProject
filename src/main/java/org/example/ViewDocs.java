package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ViewDocs {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://docs.codewars.com/");

        WebElement buttonNext = driver.findElement(By.xpath("//*[@id=\"__docusaurus\"]/div[3]/div/main/div/div/div/div/nav/a/div[1]"));
        buttonNext.click();

        //Не разобрался со скролом.
        //JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript("window.scrollTo(0, 20000);");

        //WebElement buttonPrevios = driver.findElement(By.xpath("//*[@id=\"__docusaurus\"]/div[2]/div/main/div/div/div[1]/div/nav/a[1]"));
        //buttonPrevios.click();

        //driver.quit();

    }
}
