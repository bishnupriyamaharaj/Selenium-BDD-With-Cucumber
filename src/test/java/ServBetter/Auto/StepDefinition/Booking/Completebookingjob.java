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

public class Completebookingjob {
    public WebDriver driver=null;
    @Given("Open browser and Login with individual Buyer for complete booking job")
    public void openBrowserAndLoginWithIndividualBuyerForCompleteBookingJob(){
        System.setProperty("webdriver.chrome.driver","/Users/ajitpatnaik/Desktop/Upwork/Automation Servbetter/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get ("https://servbetter.com/");
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("manikraj0912@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Work098765@#");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
       }
    @When("Click the service dropdown and Book a Booking job")
    public void clickTheServiceDropdownAndBookABookingJob() throws InterruptedException {
        driver.findElement(By.partialLinkText("SERVIC")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body/div[@id='myHeader']/div[1]/nav[1]/ul[1]/li[2]/div[1]/div[1]/button[5]")).click();
        //driver.findElement(By.xpath("//body/div[@id='myHeader']/div[1]/nav[1]/ul[1]/li[2]/div[1]/div[1]/button[7]")).click();
        driver.findElement(By.linkText("Graphics and Design")).click();
        Thread.sleep(4000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[10]/div[1]/div[2]/article[1]/div[1]/div[6]/div[2]/div[1]/div[4]/div[1]/button[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[10]/div[1]/div[2]/article[1]/div[1]/div[6]/div[2]/div[1]/div[4]/div[3]/div[1]/div[2]/div[1]/div[2]/a[2]")).click();
//        jse.executeScript("window.scrollBy(0,300)");
//        driver.findElement(By.xpath("//body/div[10]/div[1]/div[2]/article[1]/div[1]/div[6]/div[2]/div[1]/div[4]/div[3]/div[1]/div[5]/div[1]/div[2]/a[2]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='ratedate']")).sendKeys("04.08.2022");
        driver.findElement(By.xpath("//input[@id='ratetime']")).sendKeys("23:55");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("nicezip");
        WebElement travelopt = driver.findElement(By.id("travel"));
        Select Toption = new Select(travelopt);
        Toption.selectByVisibleText("YES");
        driver.findElement(By.xpath("//input[@id='136']")).click();
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
    @And("Logout from Buyer and login as seller to accept")
    public void logoutFromBuyerAndLoginAsSellerToAccept()   throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("dominiceichmann97@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Work098765@#");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Booking List")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tbody/tr[1]/td[9]/div[1]/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("DASHBOARD_TEXT_YES_MARKCOMPLETE")).click();
    }

    @And("Logout from Seller and login as buyer to Award")
    public void logoutFromSellerAndLoginAsBuyerToAward()  throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("manikraj0912@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Work098765@#");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
        String Status = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status);
        String Svalue = driver.findElement(By.xpath("//tbody/tr[1]/td[9]")).getText();
        System.out.println(Svalue);
        driver.findElement(By.xpath("//body[1]/div[9]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")).click();
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,900)");
        driver.findElement(By.xpath("//body/div[9]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).click();
//        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[7]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).click();
//        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[7]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).click();
        driver.findElement(By.xpath("//body/div[9]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys("test123automation@gmail.com");
        driver.findElement(By.id("cardNumber")).sendKeys("4242 4242 4242 4242");
        driver.findElement(By.id("cardExpiry")).sendKeys("02/28");
        driver.findElement(By.id("cardCvc")).sendKeys("125");
        driver.findElement(By.id("billingName")).sendKeys("AutomationBM");
        WebElement country = driver.findElement(By.id("billingCountry"));
        Select catagory = new Select(country);
        catagory.selectByVisibleText("India");
       driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[2]/button[1]/div[3]")).click();
        Thread.sleep(6000);
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(9000);
        String Status1 = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status1);
        String Svalue1 = driver.findElement(By.xpath("//tbody/tr[1]/td[9]")).getText();
        System.out.println(Svalue1);
    }
    @And("Logout from Buyer and login to seller to make the status SellerongoingBuyerArrived")
    public void logoutFromBuyerAndLoginToSellerToMakeTheStatusSellerongoingBuyerArrived() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("dominiceichmann97@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Work098765@#");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Booking List")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tbody/tr[1]/td[8]/div[1]/form[1]/button[1]")).click();
   }

    @And("Logout from Seller and login to Buyer to make work start")
    public void logoutFromSellerAndLoginToBuyerToMakeWorkStart() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("manikraj0912@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Work098765@#");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
        String Status = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status);
        String Svalue = driver.findElement(By.xpath("//tbody/tr[1]/td[9]")).getText();
        System.out.println(Svalue);
        driver.findElement(By.xpath("//body[1]/div[9]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")).click();
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.xpath("//button[contains(text(),'Work Start')]")).click();
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(9000);
        String Status1 = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status1);
        String Svalue1 = driver.findElement(By.xpath("//tbody/tr[1]/td[9]")).getText();
        System.out.println(Svalue1);
    }
    @And("Logout buyer and login seller to complete the booking job")
    public void logoutBuyerAndLoginSellerToCompleteTheBookingJob()  throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("dominiceichmann97@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Work098765@#");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Booking List")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tbody/tr[1]/td[8]/div[1]/button[1]")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("DASHBOARD_TEXT_YES_MARKCOMPLETE")).click();
    }
    @And("Logout from seller and login as buyer to approve the booking job")
    public void logoutFromSellerAndLoginAsBuyerToApproveTheBookingJob() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("manikraj0912@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Work098765@#");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
        String Status = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status);
        String Svalue = driver.findElement(By.xpath("//tbody/tr[1]/td[9]")).getText();
        System.out.println(Svalue);
        driver.findElement(By.xpath("//body[1]/div[9]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Approve')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[1]/div[1]/form[1]/div[3]/button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
        String Status1 = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status1);
        String Svalue1 = driver.findElement(By.xpath("//tbody/tr[1]/td[9]")).getText();
        System.out.println(Svalue1);
    }
    @And("Verify the buyer transaction")
    public void verifyTheBuyerTransaction()throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Business')]"));
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
    @And("Logout Buyer and login as Seller")
    public void logoutBuyerAndLoginAsSeller()  {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("dominiceichmann97@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Work098765@#");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
      }
    @And("Verify the Seller transaction")
    public void verifyTheSellerTransaction()throws InterruptedException {
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
    @Then("logout seller and close the app")
    public void logoutSellerAndCloseTheApp() {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.close();
    }
 }
