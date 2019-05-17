package walmart_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchtextPage {


    public static WebElement Searchtext(WebDriver driver)
    {
        return driver.findElement(By.id("global-search"));
    }


        public static WebElement itemprice(WebDriver driver)
         {
        return driver.findElement(By.xpath("//span[@class='css-rykmet esdkp3p2']//span[@class='css-2vqe5n esdkp3p0'][contains(text(),'$1.97')]"));
        }

    public static WebElement item(WebDriver driver)
    {
        return driver.findElement(By.xpath("//h2[contains(text(),'Great Value Apple Strawberry Snack Sweetened Cups')]"));

    }








}


