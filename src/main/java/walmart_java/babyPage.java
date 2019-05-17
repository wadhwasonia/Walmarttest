package walmart_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class babyPage {

    public static WebElement babylink(WebDriver driver)
    {
        return driver.findElement(By.className("baby"));
    }

    public static WebElement newbornimg(WebDriver driver)
    {
        return driver.findElement(By.xpath("//img[@src='//i.walmartimages.ca/img/category/baby/hero/2019/Week51/BabyL1/CUS_WMS_BA-Newborn_20190110_E.jpg']"));
    }
    public static WebElement diaperimg(WebDriver driver) {
        return driver.findElement(By.xpath("//article[@title='Diapering']"));

    }

}
