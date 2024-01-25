package ServBetter.Auto.StepDefinition.Booking;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BuyerCanceledbookingAWARDED {
    public WebDriver driver=null;
    @Given("Open browser and Login with individual Buyer for Booking job flow")
    public void openBrowserAndLoginWithIndividualBuyerForBookingJobFlow() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/ajitpatnaik/Desktop/Upwork/Automation Servbetter/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get ("https://servbetter.com/");
        driver.findElement(By.linkText("Buyer Login")).click();
//        driver.findElement(By.id("username")).sendKeys("manikraj0912@gmail.com");
//        driver.findElement(By.id("password")).sendKeys("Work098765@#");
        driver.findElement(By.id("username")).sendKeys("j7455893@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Work098765@#");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

       }

    @When("Click the service dropdown from the menubar")
    public void clickTheServiceDropdownFromTheMenubar() throws InterruptedException {
        driver.findElement(By.partialLinkText("SERVIC")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body/div[@id='myHeader']/div[1]/nav[1]/ul[1]/li[2]/div[1]/div[1]/button[7]")).click();
        //driver.findElement(By.xpath("//body/div[@id='myHeader']/div[1]/nav[1]/ul[1]/li[2]/div[1]/div[1]/button[7]")).click();
        driver.findElement(By.linkText("Hobby and Lifestyle")).click();
        Thread.sleep(4000);
    }

    @And("Book a plumbing job for individual seller")
    public void bookAPlumbingJobForIndividualSeller() throws InterruptedException {
         JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[10]/div[1]/div[2]/article[1]/div[1]/div[6]/div[2]/div[1]/div[4]/div[1]/button[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'book now')]")).click();
//        jse.executeScript("window.scrollBy(0,300)");
//        driver.findElement(By.xpath("//body/div[10]/div[1]/div[2]/article[1]/div[1]/div[6]/div[2]/div[1]/div[4]/div[3]/div[1]/div[5]/div[1]/div[2]/a[2]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='ratedate']")).sendKeys("8.11.2022");
        driver.findElement(By.xpath("//input[@id='ratetime']")).sendKeys("21:33");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("nicezip");
        WebElement travelopt = driver.findElement(By.id("travel"));
        Select Toption = new Select(travelopt);
        Toption.selectByVisibleText("YES");
        driver.findElement(By.xpath("//input[@id='137']")).click();
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("want the service");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='remove_next_btn']//button[@id='DASHBOARD_TEXT_YES']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='complete_proceed_desc_btn']//button[@id='DASHBOARD_TEXT_YES']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
        String Status = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status);
        String Svalue = driver.findElement(By.xpath("//tbody/tr[1]/td[9]")).getText();
        System.out.println(Svalue);
    }
    @And("Logout from Buyer and login as seller to accept the Booking list job")
    public void logoutFromBuyerAndLoginAsSellerToAcceptTheBookingListJob() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("tom624563@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Work098765@#");
//        driver.findElement(By.id("email")).sendKeys("businesssellerseven@gmail.com");
//        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Booking List")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tbody/tr[1]/td[9]/div[1]/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='DASHBOARD_TEXT_YES_MARKCOMPLETE']")).click();
    }

    @And("Logout from Seller and login as buyer to Award the booking list job")
    public void logoutFromSellerAndLoginAsBuyerToAwardTheBookingListJob() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("j7455893@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Work098765@#");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
        String Status1 = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status1);
        String Svalue1 = driver.findElement(By.xpath("//tbody/tr[1]/td[9]")).getText();
        System.out.println(Svalue1);
        driver.findElement(By.xpath("//body[1]/div[9]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")).click();
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,900)");
        driver.findElement(By.xpath("//input[@id='serviceIds']")).click();
        //driver.findElement(By.xpath("//body/div[9]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/input[1]")).click();
        driver.findElement(By.xpath("//body/div[9]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/button[1]")).click();
             Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("autobm@hotmail.com");
        driver.findElement(By.id("cardNumber")).sendKeys("4242 4242 4242 4242");
        driver.findElement(By.id("cardExpiry")).sendKeys("09/23");
        driver.findElement(By.id("cardCvc")).sendKeys("622");
        driver.findElement(By.id("billingName")).sendKeys("Lucia auto");
        WebElement country = driver.findElement(By.id("billingCountry"));
        Select catagory = new Select(country);
        catagory.selectByVisibleText("India");
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("//input[@id='billingPostalCode']")).sendKeys("SE288BB");
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[2]/button[1]/div[3]")).click();
        Thread.sleep(8000);
    }

    @And("Cancel the booking list job")
    public void cancelTheBookingListJob() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='cancelButton']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[14]/div[1]/div[1]/form[1]/div[3]/button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
        String Status1 = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status1);
        String Svalue1 = driver.findElement(By.xpath("//tbody/tr[1]/td[9]")).getText();
        System.out.println(Svalue1);
            }


    @And("Verify the transaction for buyer and buyer should get half refund")
    public void verifyTheTransactionForBuyerAndBuyerShouldGetHalfRefund() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Profile Page"))).click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        System.out.println("BuyerFinance");
        driver.findElement(By.linkText("Buyer Finance")).click();
        String Buyerheader = driver.findElement(By.cssSelector("thead")).getText();
        System.out.println(Buyerheader);
        String Buyerfinance = driver.findElement(By.cssSelector("div.section-wrap:nth-child(15) div.section.overflowable div.content.right table.table.table-striped tbody:nth-child(2) > tr:nth-child(1)")).getText();
        System.out.println(Buyerfinance);
    }
    @And("Logout from buyer to check seller transaction")
    public void logoutFromBuyerToCheckSellerTransaction() {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
    }

    @And("Logout from buyer and login as seller to verify the transaction and seller should get half")
    public void logoutFromBuyerAndLoginAsSellerToVerifyTheTransactionAndSellerShouldGetHalf() throws InterruptedException {
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("tom624563@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Work098765@#");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Profile Page"))).click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,600)");
        Thread.sleep(2000);
        System.out.println("SellerFinance");
        driver.findElement(By.linkText("Seller Finance")).click();
        String Sellerheader = driver.findElement(By.xpath("//thead//tr")).getText();
        System.out.println(Sellerheader);
        String Sellerfinance = driver.findElement(By.cssSelector("div.section-wrap:nth-child(15) div.section.overflowable div.content.right div.table-responsive table.table.table-striped.tbale-main-bgbackground.tablethfied tbody:nth-child(2) > tr:nth-child(1)")).getText();
        System.out.println(Sellerfinance);
    }

    @Then("Booking Job Cancelled")
    public void bookingJobCancelled(){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.close();
    }

}
