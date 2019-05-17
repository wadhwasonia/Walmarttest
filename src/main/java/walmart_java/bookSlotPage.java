package walmart_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class bookSlotPage

{

    public static WebElement cancelpick(WebDriver driver)
    {
        return driver.findElement(By.xpath("//div[@id='pickup-slot-details']//button[@type='button'][contains(text(),'Cancel this Pickup time')]"));
    }

    public static WebElement closepopup(WebDriver driver)
    {
        return driver.findElement(By.xpath(" //div[@class='lightbox lightbox-with-close slot-listing-pickup-lightbox narrow']//i[@class='gicon-cross']"));
    }


    public static WebElement schedulepicktext(WebDriver driver)
    {
        return driver.findElement(By.xpath("//div[@class='lightbox lightbox-with-close slot-listing-pickup-lightbox narrow']//span[@class='shipping-type'][contains(text(),'Scheduled Pickup')]"));
    }

    public static WebElement free30(WebDriver driver)
    {
        return driver.findElement(By.xpath("//button[@title='2019-05-30 10:00 - 11:00am FREE']"));
    }

    public static WebElement datemay30(WebDriver driver)
    {
        return driver.findElement(By.xpath("//div[@id='pickup-calendar']//button[@title='30, Thursday May 2019'][contains(text(),'30')]"));
    }

    public static WebElement phonet(WebDriver driver)
    {
        return driver.findElement(By.xpath("//input[@id='pickup-by-phone']"));
    }

    public static WebElement lastname(WebDriver driver)
    {
        return driver.findElement(By.xpath("//input[@id='pickup-by-last-name']"));
    }

    public static WebElement firstname(WebDriver driver)
    {
        return driver.findElement(By.xpath("//input[@id='pickup-by-first-name']"));
    }


    public static WebElement sellocationtext(WebDriver driver)
    {
        return driver.findElement(By.cssSelector(".marker1061 > div:nth-child(3) > button:nth-child(1)"));
    }

    public static WebElement inputaddress(WebDriver driver)
    {
        return driver.findElement(By.xpath("//input[@id='address']"));
    }
    public static WebElement submitaddress(WebDriver driver)
    {
        return driver.findElement(By.xpath("//button[@id='submit-address']"));
    }
    public static WebElement pickuppostaltext(WebDriver driver)
    {
        return driver.findElement(By.xpath("//p[@id='pickup-postal']"));
    }



}
