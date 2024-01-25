package ServBetter.Auto.StepDefinition.Booking;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SellerCanceledbookingSELLERONGOING {
    public WebDriver driver=null;
    @Given("Open browser and Login with individual Buyer for Booking job cancelled flow")
    public void openBrowserAndLoginWithIndividualBuyerForBookingJobCancelledFlow() {
        System.setProperty("webdriver.chrome.driver","/Users/ajitpatnaik/Desktop/Upwork/Automation Servbetter/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get ("https://servbetter.com/");
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("individualbuyer2@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

       }
    @When("Click the service dropdown from the buyer menubar")
    public void clickTheServiceDropdownFromTheBuyerMenubar() throws InterruptedException {
        driver.findElement(By.partialLinkText("SERVIC")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body/div[@id='myHeader']/div[1]/nav[1]/ul[1]/li[2]/div[1]/div[1]/button[7]")).click();
        driver.findElement(By.linkText("Basic safety awareness")).click();
        Thread.sleep(4000);
    }
    @And("Book a Bookinglist job for seller")
    public void bookABookinglistJobForSeller() throws InterruptedException {
//        WebElement SELLER_ID = driver.findElement(By.xpath("//h2[contains(.,'businesssellerfive')]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].scrollIntoView()",SELLER_ID);
        jse.executeScript("window.scrollBy(0,2000)");
         Thread.sleep(2000);
//        if(SELLER_ID.getText().contains("five")){
        driver.findElement(By.xpath("/html[1]/body[1]/div[10]/div[1]/div[2]/article[1]/div[1]/div[6]/div[2]/div[1]/div[4]/div[1]/button[3]")).click();
            Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("//body/div[10]/div[1]/div[2]/article[1]/div[1]/div[6]/div[2]/div[1]/div[4]/div[3]/div[1]/div[7]/div[1]/div[2]/a[2]")).click();
//        }

        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='ratedate']")).sendKeys("24.06.2022");
        driver.findElement(By.xpath("//input[@id='ratetime']")).sendKeys("01:05");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("nicezip");
        WebElement travelopt = driver.findElement(By.id("travel"));
        Select Toption = new Select(travelopt);
        Toption.selectByVisibleText("NO");
        driver.findElement(By.xpath("//input[@id='117']")).click();
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("want the service");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='remove_next_btn']//button[@id='DASHBOARD_TEXT_YES']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='complete_proceed_desc_btn']//button[@id='DASHBOARD_TEXT_YES']")).click();
        Thread.sleep(2000);
    }
    @And("Logout from Buyer and login as seller to accept the Booking job")
    public void logoutFromBuyerAndLoginAsSellerToAcceptTheBookingJob() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("businesssellerfive@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Booking List")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tbody/tr[1]/td[9]/div[1]/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("DASHBOARD_TEXT_YES")).click();
    }
    @And("Logout from Seller and login as buyer to Award the booking job")
    public void logoutFromSellerAndLoginAsBuyerToAwardTheBookingJob() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("individualbuyer2@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath("//body[1]/div[9]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/a[1]")).click();
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,900)");
        driver.findElement(By.xpath("//body/div[9]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/input[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[7]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[7]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).click();
        //driver.findElement(By.xpath("//body/div[9]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[6]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("3");
        driver.findElement(By.xpath("//body/div[9]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[8]/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys("test123automation@gmail.com");
        driver.findElement(By.id("cardNumber")).sendKeys("4242 4242 4242 4242");
        driver.findElement(By.id("cardExpiry")).sendKeys("02/28");
        driver.findElement(By.id("cardCvc")).sendKeys("125");
        driver.findElement(By.id("billingName")).sendKeys("AutomationBM");
        WebElement country = driver.findElement(By.id("billingCountry"));
        Select catagory = new Select(country);
        catagory.selectByVisibleText("India");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[2]/button[1]/div[3]")).click();
        Thread.sleep(8000);
    }
    @And("Logout from Buyer and login as Seller to Cancel the booking job")
        public void logoutFromBuyerAndLoginAsSellerToCancelTheBookingJob()  throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("businesssellerfive@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Booking List")).click();
        driver.findElement(By.xpath("//tbody/tr[1]/td[8]/div[1]/form[1]/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//tbody/tr[1]/td[2]/a[1]")).click();
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[12]/div[1]/div[1]/form[1]/div[3]/button[1]")).click();
        Thread.sleep(1000);
    }
    @And("Verify the transaction for Seller and seller should get half refund")
    public void verifyTheTransactionForSellerAndSellerShouldGetHalfRefund() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Profile Page"))).click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,600)");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Seller Finance")).click();
        String Sellerheader = driver.findElement(By.xpath("//thead//tr")).getText();
        System.out.println(Sellerheader);
        String Sellerfinance = driver.findElement(By.cssSelector("div.section-wrap:nth-child(15) div.section.overflowable div.content.right div.table-responsive table.table.table-striped.tbale-main-bgbackground.tablethfied tbody:nth-child(2) > tr:nth-child(1)")).getText();
        System.out.println(Sellerfinance);
    }
    @And("Logout from Seller to check Buyer transaction")
    public void logoutFromSellerToCheckBuyerTransaction() {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
    }
    @And("Logout from Seller and login as Buyer to verify the transaction and Buyer should get half")
    public void logoutFromSellerAndLoginAsBuyerToVerifyTheTransactionAndBuyerShouldGetHalf()throws InterruptedException {
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("individualbuyer2@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Profile Page"))).click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Buyer Finance")).click();
        String Buyerheader = driver.findElement(By.cssSelector("thead")).getText();
        System.out.println(Buyerheader);
        String Buyerfinance = driver.findElement(By.cssSelector("div.section-wrap:nth-child(15) div.section.overflowable div.content.right table.table.table-striped tbody:nth-child(2) > tr:nth-child(1)")).getText();
        System.out.println(Buyerfinance);
    }
    @Then("Booking Job cancelled by seller")
    public void bookingJobCancelledBySeller(){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.close();
    }
}
