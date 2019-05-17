package walmart_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class shopgroceriesPage
{

    public static WebElement shopgrocerytext(WebDriver driver)
    {
        return driver.findElement(By.xpath("//div[@class='toggle-grocery-desktop']//a[@class='grocery-toggle']"));
    }
    public static WebElement whyonline(WebDriver driver)
    {
        return driver.findElement(By.xpath("//b[contains(text(),'Why Shop Groceries Online?')]"));
    }

    public static WebElement freshtext(WebDriver driver)
    {
        return driver.findElement(By.xpath("//h3[contains(text(),'Freshness guaranteed')]"));
    }
    public static WebElement bookslot(WebDriver driver)
    {
        return driver.findElement(By.cssSelector("#header-book-a-slot > a:nth-child(1)"));
    }


}
