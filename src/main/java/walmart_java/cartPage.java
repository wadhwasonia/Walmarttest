package walmart_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cartPage

{


    public static WebElement taxeszero(WebDriver driver)
    {
        return driver.findElement(By.xpath("//dd[@data-automation='empty-taxes-value']"));
    }

    public static WebElement remove(WebDriver driver)
    {
        return driver.findElement(By.xpath("//span[contains(text(),'Remove')]"));
    }

    public static WebElement shoppingcarttext(WebDriver driver)
    {
        return driver.findElement(By.xpath("//div[@class='title wgrid-5of12 wgrid-3of8 wgrid-3of4 marg-l-0']"));
    }

    public static WebElement checkout(WebDriver driver)
    {
        return driver.findElement(By.xpath("//a[@class='button']"));
    }

    public static WebElement addToCart(WebDriver driver) {
        //return driver.findElement(By.xpath("//div[@class='touch-device-slider standard-thumbnail']//article[@id='thumb-6000198331194']//button[@class='button add-to-cart-btn available']"));
        return driver.findElement(By.cssSelector("article.simplified-thumb:nth-child(1) > div:nth-child(2) > button:nth-child(1) > span:nth-child(2)"));
    }

    public static WebElement addtoCarttwo(WebDriver driver)

    {

        return driver.findElement(By.xpath("//div[@class='submit-btn not-on-pip']//button[@class='button add-to-cart-btn available']"));
    }

    public static WebElement increasebutton(WebDriver driver)
    {
        return driver.findElement(By.cssSelector(".e5qqw234"));
    }
    public static WebElement addtocartitem(WebDriver driver)
    {
        return driver.findElement(By.cssSelector(".css-1i45fk4"));
    }
    public static WebElement itempricecheckout(WebDriver driver)
    {
        return driver.findElement(By.xpath("//div[@class='css-r4gvbm elsmchb6']//span[@class='css-2vqe5n esdkp3p0'][contains(text(),'$1.97')]"));
    }

    public static WebElement scontinue(WebDriver driver)
    {
        return driver.findElement(By.cssSelector("button.css-1njsjus:nth-child(6)"));
    }

    public static WebElement successtext(WebDriver driver)
    {
        return driver.findElement(By.cssSelector(".css-17u5a6w"));
    }

}
