package walmart_java;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;


import org.testng.annotations.*;
import sun.awt.windows.ThemeReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;




public class walmart_test  {
       public  WebDriver driver;

       public  String baseurl = "http://www.walmart.ca";
       public WebDriverWait wait;
       public JavascriptExecutor jse;
        String homefolder = System.getProperty("user.dir");
        String inputfile = homefolder + "\\" + "walmart_testdata.xlsx";
        List<String> inputadd = new ArrayList<String>();




     @BeforeMethod(alwaysRun = true)
        public void setUp() throws InterruptedException {

        System.setProperty  ("webdriver.chrome.driver","chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");


       driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
       jse = (JavascriptExecutor)driver;
      wait = new WebDriverWait(driver, 60);
      driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
     }









         @Test
         public void search_test1() throws Exception

         {

             driver.get(baseurl);

            inputfile=inputfile.replaceAll("\\\\","\\/");

            List<String> searchtest = excelInteraction.getData(inputfile,"Sheet1");
            String searchdata=searchtest.get(0);

            searchtextPage.Searchtext(driver).sendKeys(searchdata);
            searchtextPage.Searchtext(driver).sendKeys(Keys.RETURN);
             jse.executeScript("window.scrollBy(0,500)");
             wait.until(ExpectedConditions.elementToBeClickable(searchtextPage.item(driver)));
            searchtextPage.item(driver).click();
             String price=searchtextPage.itemprice(driver).getText();
             jse.executeScript("window.scrollBy(0,500)");
             cartPage.increasebutton(driver).click();
             cartPage.addtocartitem(driver).click();
                String pricecart=cartPage.itempricecheckout(driver).getText();
                Assert.assertEquals(price,pricecart);
            wait.until(ExpectedConditions.elementToBeClickable(cartPage.scontinue(driver)));
                String successtextvalue = cartPage.successtext(driver).getText();
                Assert.assertEquals(successtextvalue, "You have successfully updated your cart.");
            wait.until(ExpectedConditions.elementToBeClickable(cartPage.scontinue(driver)));
            cartPage.scontinue(driver).click();
                 Assert.assertTrue(cartPage.addtocartitem(driver).isDisplayed());




         }




         @Test
        public void babyMainPage_test2() throws InterruptedException {

             driver.get(baseurl);

            babyPage.babylink(driver).click();
            jse.executeScript("window.scrollBy(0,1000)");
             babyPage.newbornimg(driver).click();
            jse.executeScript("window.scrollBy(0,500)");
            wait.until(ExpectedConditions.elementToBeClickable(babyPage.diaperimg(driver)));
             babyPage.diaperimg(driver).click();
            jse.executeScript("window.scrollBy(0,500)");

            cartPage.addToCart(driver).click();
            wait.until(ExpectedConditions.elementToBeClickable(cartPage.addtoCarttwo(driver)));
           cartPage.addtoCarttwo(driver).click();
             wait.until(ExpectedConditions.elementToBeClickable(cartPage.checkout(driver)));
            cartPage.checkout(driver).click();
            wait.until(ExpectedConditions.elementToBeClickable(cartPage.shoppingcarttext(driver)));

            String stext = cartPage.shoppingcarttext(driver).getText();
            Assert.assertEquals(stext,"Your Shopping Cart");
             jse.executeScript("window.scrollBy(0,500)");
            cartPage.remove(driver).click();

            cartPage.taxeszero(driver).isDisplayed();

        }



        @Test
        public void shopgroceries_test3() throws Exception {

            driver.get(baseurl);

             inputfile=inputfile.replaceAll("\\\\","\\/");

             List<String> searchtest = excelInteraction.getData(inputfile,"Sheet2");
             String postalcode=searchtest.get(0);
             String firstname =searchtest.get(1);
             String lastname=searchtest.get(2);
             String phone=searchtest.get(3);

             Thread.sleep(2000);
             wait.until(ExpectedConditions.elementToBeClickable(shopgroceriesPage.shopgrocerytext(driver)));
             shopgroceriesPage.shopgrocerytext(driver).click();

             String shoponlinetext = shopgroceriesPage.whyonline(driver).getText();
             Assert.assertEquals(shoponlinetext, "Why Shop Groceries Online?");
             String freshtexts = shopgroceriesPage.freshtext(driver).getText();
             Assert.assertEquals(freshtexts, "Freshness guaranteed");
             wait.until(ExpectedConditions.elementToBeClickable(shopgroceriesPage.bookslot(driver)));
             shopgroceriesPage.bookslot(driver).click();
             bookSlotPage.inputaddress(driver).click();

             for (int i = 0; i <= 5; i++) {
                 bookSlotPage.inputaddress(driver).sendKeys(Keys.BACK_SPACE);
             }

             bookSlotPage.inputaddress(driver).sendKeys(postalcode);
             bookSlotPage.submitaddress(driver).click();
            wait.until(ExpectedConditions.elementToBeClickable(bookSlotPage.pickuppostaltext(driver)));
             String ptext = bookSlotPage.pickuppostaltext(driver).getText();

             Assert.assertEquals(ptext, "Grocery PickUp locations near. " + postalcode + ":");

             jse.executeScript("window.scrollBy(0,500)");
             Thread.sleep(2000);
             wait.until(ExpectedConditions.elementToBeClickable(bookSlotPage.sellocationtext(driver)));
             bookSlotPage.sellocationtext(driver).click();

             bookSlotPage.firstname(driver).sendKeys(firstname);
             bookSlotPage.lastname(driver).sendKeys(lastname);
             bookSlotPage.phonet(driver).sendKeys(phone);

             Thread.sleep(2000);
             wait.until(ExpectedConditions.elementToBeClickable(bookSlotPage.datemay30(driver)));
             bookSlotPage.datemay30(driver).click();

             jse.executeScript("window.scrollBy(0,500)");
             wait.until(ExpectedConditions.elementToBeClickable(bookSlotPage.free30(driver)));
             bookSlotPage.free30(driver).click();


             jse.executeScript("window.scrollBy(0,500)");

             String stext=bookSlotPage.schedulepicktext(driver).getText();

             Assert.assertEquals(stext, "Scheduled Pickup");
             bookSlotPage.closepopup(driver).click();

            Thread.sleep(2000);
             bookSlotPage.cancelpick(driver).click();


         }


        @AfterMethod(alwaysRun = true)
         public void cleanup()
        {
        driver.quit();

        }
}


