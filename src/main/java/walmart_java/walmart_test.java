package walmart_java;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class walmart_test {
       public  WebDriver driver;
       public    String baseurl = "http://www.walmart.ca";
       public WebDriverWait wait;
       public JavascriptExecutor jse;


         By shopgroceries = By.xpath("//*[@id='hdr-grocery-toggle-tablet-txt']");
         By cart=By.id("shopping-cart-icon");
         By Searchtext=By.id("global-search");
         By item = By.xpath("//*[@id=\"thumb-10289102\"]/a/div[2]/div[2]/img");
         By addtocart=By.cssSelector(".css-1i45fk4");
         By scontinue= By.cssSelector("button.css-1njsjus:nth-child(6)");
         By nothanks = By.className("acsInviteButton acsDeclineButton");
         By increasebutton = By.cssSelector(".e5qqw234");
         By successtext=By.cssSelector(".css-17u5a6w");
         By walmartlogo = By.xpath("//*[@id=\"logo\"]");
         By motherdayicon = By.cssSelector("#header-mothers-day > a:nth-child(1)");
         By motherdaytext=By.cssSelector(".H1 > h1:nth-child(1)");
         By shop=By.xpath("//a[@href='/en/N-33951']");
         By addtocartchild=By.xpath("//*[@id=\"thumb-6000199452219\"]/div/button");
         By checkout=By.xpath("//a[@class='button']");
         By shoppingcarttext=By.xpath("//div[@class='title wgrid-5of12 wgrid-3of8 wgrid-3of4 marg-l-0']");
         By remove = By.xpath("//span[contains(text(),'Remove')]");
         By shopgrocerytext=By.xpath("//div[@class='toggle-grocery-desktop']//a[@class='grocery-toggle']");
         By shopwalmart=By.xpath("//div[@class='toggle-walmart-desktop']//a[@class='walmart-toggle']");
         By whyonline=By.xpath("//b[contains(text(),'Why Shop Groceries Online?')]");
         By howorks=By.xpath("//b[contains(text(),'How It Works')]");
         By freshtext= By.xpath("//h3[contains(text(),'Freshness guaranteed')]");
         By scheduletext=By.xpath("//h3[contains(text(),'Shop on your own schedule')]");
         By foodsavingstext=By.xpath("//h3[contains(text(),'Food and savings you love')]");
         By shopaisletext=By.xpath("//h3[contains(text(),'Shop our grocery aisles')]");
         By savemoneytext=By.xpath("//h3[contains(text(),'Save time and money')]");
         By pickuptext=By.xpath("//h3[contains(text(),'Enjoy Grocery Pickup*')]");
            By bookslot=By.cssSelector("#header-book-a-slot > a:nth-child(1)");
            By groceryordertext=By.xpath("//span[contains(text(),'Your Grocery Order')]");
        By inputaddress = By.xpath("//input[@id='address']");
        By submitaddress =By.xpath("//button[@id='submit-address']");
        By pickuppostaltext=By.xpath("//p[@id='pickup-postal']");
        
        By sellocationtext=By.cssSelector(".marker1061 > div:nth-child(3) > button:nth-child(1)");
        By firstname=By.xpath("//input[@id='pickup-by-first-name']");
        By lastname=By.xpath("//input[@id='pickup-by-last-name']");
        By phonet=By.xpath("//input[@id='pickup-by-phone']");
        By datemay17=By.xpath("//div[@id='pickup-calendar']//button[@title='17, Friday May 2019'][contains(text(),'17')]");
        By free = By.xpath("//button[@title='2019-05-17 10:00 - 11:00am FREE']");
        By itemprice=By.xpath("//span[@class='css-rykmet esdkp3p2']//span[@class='css-2vqe5n esdkp3p0'][contains(text(),'$1.97')]");
        By itempricecheckout=By.xpath("//div[@class='css-r4gvbm elsmchb6']//span[@class='css-2vqe5n esdkp3p0'][contains(text(),'$1.97')]");

        By schedulepicktext=By.xpath("//div[@class='lightbox lightbox-with-close slot-listing-pickup-lightbox narrow']//span[@class='shipping-type'][contains(text(),'Scheduled Pickup')]");
        By closepopup=By.xpath(" //div[@class='lightbox lightbox-with-close slot-listing-pickup-lightbox narrow']//i[@class='gicon-cross']");
        By cancelpick=By.xpath("//div[@id='pickup-slot-details']//button[@type='button'][contains(text(),'Cancel this Pickup time')]");




         public walmart_test() throws FileNotFoundException {
         }

         @BeforeTest
        public void declaration()
        {
            System.setProperty("webdriver.chrome.driver", "C:/Users/s5415792/chromedriver/chrome74/chromedriver.exe");
            driver = new ChromeDriver();
            jse = (JavascriptExecutor)driver;
            wait = new WebDriverWait(driver, 60);
            driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

        }

        @Parameters({"textsearch"})
         @Test
         public void search_test1(String param) throws InterruptedException {
             driver.get(baseurl);
             driver.manage().window().maximize();
             driver.findElement(Searchtext).sendKeys(param);
             driver.findElement(Searchtext).sendKeys(Keys.RETURN);
             jse.executeScript("window.scrollBy(0,500)");
             driver.findElement(item).click();
             Thread.sleep(5000);
                String price=driver.findElement(itemprice).getText();
             jse.executeScript("window.scrollBy(0,500)");
                 driver.findElement(increasebutton).click();
             driver.findElement(addtocart).click();

             String pricecart=driver.findElement(itempricecheckout).getText();
             Assert.assertEquals(price,pricecart);
             wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(scontinue));

             String successtextvalue = driver.findElement(successtext).getText();

             Assert.assertEquals(successtextvalue, "You have successfully updated your cart.");
             wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(scontinue));
             driver.findElement(scontinue).click();
             Assert.assertTrue(driver.findElement(addtocart).isDisplayed());


         }


         @Test

         public void motherday_test2() throws InterruptedException
         { driver.get(baseurl);
             driver.manage().window().maximize();
             driver.findElement(motherdayicon).click();
             String mtext = driver.findElement(motherdaytext).getText();
            Assert.assertEquals(mtext,"Mother's Day 2019");
             jse.executeScript("window.scrollBy(0,1000)");
             wait.until(ExpectedConditions.visibilityOfElementLocated(shop));
             driver.findElement(shop).click();

             Set<String> id = driver.getWindowHandles();
             Iterator<String> iterate = id.iterator();
             String parentid = iterate.next();
             String childid = iterate.next();

             driver.switchTo().window(childid);
             jse.executeScript("window.scrollBy(0,500)");
             driver.findElement(addtocartchild).click();
             wait.until(ExpectedConditions.visibilityOfElementLocated(checkout));
             driver.findElement(checkout).click();
             wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingcarttext));
             String stext = driver.findElement(shoppingcarttext).getText();
             Assert.assertEquals(stext,"Your Shopping Cart");
             driver.findElement(remove).click();
         }
         @Parameters({"addsearch","fname","lname","phone"})
        @Test
        public void shopgroceries_test3(String add,String fname,String lname,String phone) throws InterruptedException {
             driver.get(baseurl);
             driver.manage().window().maximize();
             wait.until(ExpectedConditions.visibilityOfElementLocated(shopgrocerytext));
             driver.findElement(shopgrocerytext).click();
             String shoponlinetext = driver.findElement(whyonline).getText();
             Assert.assertEquals(shoponlinetext, "Why Shop Groceries Online?");
             String freshtexts = driver.findElement(freshtext).getText();
             Assert.assertEquals(freshtexts, "Freshness guaranteed");
             wait.until(ExpectedConditions.visibilityOfElementLocated(bookslot));
             driver.findElement(bookslot).click();
             driver.findElement(inputaddress).click();
             for (int i = 0; i <= 5; i++) {
                 driver.findElement(inputaddress).sendKeys(Keys.BACK_SPACE);
             }

             driver.findElement(inputaddress).sendKeys(add);
             driver.findElement(submitaddress).click();
             wait.until(ExpectedConditions.visibilityOfElementLocated(pickuppostaltext));
             String ptext = driver.findElement(pickuppostaltext).getText();
             Assert.assertEquals(ptext, "Grocery PickUp locations near. " + add + ":");

             jse.executeScript("window.scrollBy(0,500)");
             Thread.sleep(2000);
             wait.until(ExpectedConditions.visibilityOfElementLocated(sellocationtext));
             driver.findElement(sellocationtext).click();

             driver.findElement(firstname).sendKeys(fname);
             driver.findElement(lastname).sendKeys(lname);
             driver.findElement(phonet).sendKeys(phone);
             Thread.sleep(2000);
             wait.until(ExpectedConditions.visibilityOfElementLocated(datemay17));
             driver.findElement(datemay17).click();
             jse.executeScript("window.scrollBy(0,500)");
             wait.until(ExpectedConditions.visibilityOfElementLocated(free));
            driver.findElement(free).click();

             jse.executeScript("window.scrollBy(0,500)");
             Thread.sleep(2000);
             String stext = driver.findElement(schedulepicktext).getText();
             Assert.assertEquals(stext, "Scheduled Pickup");
             driver.findElement(closepopup).click();
             Thread.sleep(2000);

             driver.findElement(cancelpick).click();

         }


        @AfterTest
         public void cleanup()
        {
        driver.quit();

        }



     }
