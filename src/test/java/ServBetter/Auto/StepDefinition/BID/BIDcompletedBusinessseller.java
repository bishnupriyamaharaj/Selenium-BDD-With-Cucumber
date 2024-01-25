package ServBetter.Auto.StepDefinition.BID;

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

public class BIDcompletedBusinessseller {
    public WebDriver driver=null;

    @Given("Open browser and Login with for business seller")
    public void openBrowserAndLoginWithForBusinessSeller()  {
        System.setProperty("webdriver.chrome.driver","/Users/ajitpatnaik/Desktop/Upwork/Automation Servbetter/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get ("https://servbetter.com/");
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("businesssellerfive@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
       }
    @When("Click the Bid Job tab from the menubar and click the LIVE BID job")
    public void clickTheBidJobTabFromTheMenubarAndClickTheLIVEBIDJob() throws InterruptedException {
    driver.findElement(By.xpath("//body/div[@id='myHeader']/div[1]/nav[1]/ul[1]/li[3]/a[1]")).click();
           //need to enter data
        driver.findElement(By.xpath("//tbody/tr[1]/td[9]/a[1]/button[1]")).click();
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,600)");
    }

    @And("Enter all the mandatory field and click place bid button")
    public void enterAllTheMandatoryFieldAndClickPlaceBidButton() throws InterruptedException {
        driver.findElement(By.id("offer_cost")).sendKeys("12");
        driver.findElement(By.id("approx_time_needed")).sendKeys("8");
        driver.findElement(By.xpath("//textarea[@id='note']")).sendKeys("test automation");
        driver.findElement(By.xpath("//button[@id='seller_place_bid']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='seller_place_bid']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#DASHBOARD_TEXT_YES")).click();
    }
    @And("Logout from seller and login as buyer and navigate to all project page to award the BID JOB")
    public void logoutFromSellerAndLoginAsBuyerAndNavigateToAllProjectPageToAwardTheBIDJOB() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("individualbuyer2@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(9000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[1]/input[1]")).sendKeys("BID Pet Vaccination 2nd aug BM");
//        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[1]/div[1]/button[3]")).click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0,400)");
        String Status1 = driver.findElement(By.xpath("//thead/tr/th[8]")).getText();
        System.out.println(Status1);
        String Svalue1 = driver.findElement(By.xpath("//tbody/tr[9]/td[9]")).getText();
        System.out.println(Svalue1);
         //need to enter data
        driver.findElement(By.linkText("BID Pet Vaccination 2nd aug BM")).click();
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,700)");
    }

    @And("complete the payment as buyer")
    public void completeThePaymentAsBuyer() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Award')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[@id='awardModal']/div[1]/div[1]/form[1]/div[3]/button[1]")).click();
        Thread.sleep(2000);
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
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(9000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[1]/input[1]")).sendKeys("BID Pet Vaccination 2nd aug BM");
        String Status1 = driver.findElement(By.xpath("//thead/tr/th[8]")).getText();
        System.out.println(Status1);
        String Svalue1 = driver.findElement(By.xpath("//tbody/tr[9]/td[9]")).getText();
        System.out.println(Svalue1);
    }
    @And("buyer logout and login as seller and Click on Sellerongoing button and complete the process")
    public void buyerLogoutAndLoginAsSellerAndClickOnSellerongoingButtonAndCompleteTheProcess() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("businesssellerfive@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
//        driver.findElement(By.linkText("My Bids")).click();
//        Thread.sleep(2000);
//        //need to enter data
//        driver.findElement(By.xpath("//tbody/tr[9]/td[7]/a[1]/button[1]")).click();
//        Thread.sleep(4000);
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0,1000)");
//        driver.findElement(By.xpath("//button[contains(text(),'Create Notes')]")).click();
//        driver.findElement(By.xpath("//body/div[@id='jobnotespaper']/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/textarea[1]")).sendKeys("Notepad test");
//        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
//       // driver.findElement(By.xpath("//body/div[@id='jobnotespaper']/div[1]/div[1]/div[1]/button[1]")).click();
//        Thread.sleep(2000);
//        jse.executeScript("window.scrollBy(0,1000)");
//        driver.findElement(By.xpath("//abbr[contains(text(),'Create New Quotation')]")).click();
//        driver.findElement(By.xpath("/html[1]/body[1]/div[23]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys("test1");
//        driver.findElement(By.xpath("/html[1]/body[1]/div[23]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/input[1]")).sendKeys("45");
//        driver.findElement(By.xpath("/html[1]/body[1]/div[23]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/input[1]")).sendKeys("4");
//        driver.findElement(By.xpath("/html[1]/body[1]/div[23]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[4]/input[1]")).click();
//
//        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
//        jse2.executeScript("window.scrollBy(0,3000)");
//
//        driver.findElement(By.xpath("//button[@id='costmanage']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//div[@id='']")).click();
//        driver.findElement(By.xpath("//body/div[@id='calenderModal_forBOOK']/div[2]/div[1]/div[2]/form[1]/div[1]/div[3]/div[1]/div[1]/input[1]")).click();
//        driver.findElement(By.xpath("//body/div[@id='calenderModal_forBOOK']/div[2]/div[1]/div[2]/form[1]/div[1]/div[3]/div[2]/div[1]/input[1]")).click();
//        driver.findElement(By.xpath("//body/div[@id='calenderModal_forBOOK']/div[2]/div[1]/div[2]/form[1]/div[1]/div[3]/div[1]/div[4]/div[2]/input[1]")).click();
//        jse.executeScript("window.scrollBy(0,400)");
//        driver.findElement(By.xpath("//input[@id='selectFromtime']")).sendKeys("10:30");
//        driver.findElement(By.xpath("//input[@id='selectTotime']")).sendKeys("11:00");
//        driver.findElement(By.xpath("//button[contains(text(),'YES')]")).click();
        driver.findElement(By.linkText("My Bids")).click();
        Thread.sleep(2000);
        //need to enter data
        driver.findElement(By.xpath("//tbody/tr[1]/td[7]/a[1]/button[1]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Seller OnGoing/Buyer Arrived')]")).click();
//        Actions action1 = new Actions(driver);
//        WebElement element1 = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
//        action1.moveToElement(element1).build().perform();
//        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait1.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
//        driver.findElement(By.linkText("Seller Login")).click();
//        driver.findElement(By.id("email")).sendKeys("Employeearun5@gmail.com");
//        driver.findElement(By.id("password")).sendKeys("Popopo123!");
//        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
//        String Employeeheader = driver.findElement(By.xpath("//thead")).getText();
//        System.out.println(Employeeheader);
//        String Empprojdetail = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
//        System.out.println(Empprojdetail);
       }
    @And("Logout from seller and login to Buyer again and click on workstart button")
    public void logoutFromSellerAndLoginToBuyerAgainAndClickOnWorkstartButton() throws InterruptedException {
//        Actions action = new Actions(driver);
//        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Individual')]"));
//        action.moveToElement(element).build().perform();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("individualbuyer2@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(9000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[1]/input[1]")).sendKeys("BID Pet Vaccination 2nd aug BM");
        String Status1 = driver.findElement(By.xpath("//thead/tr/th[8]")).getText();
        System.out.println(Status1);
        String Svalue1 = driver.findElement(By.xpath("//tbody/tr[9]/td[9]")).getText();
        System.out.println(Svalue1);
//
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0,400)");
        //need to enter data
        driver.findElement(By.linkText("BID Pet Vaccination 2nd aug BM")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='security_code_btn']")).click();
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(9000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[1]/input[1]")).sendKeys("BID Pet Vaccination 2nd aug BM");
        String Status = driver.findElement(By.xpath("//thead/tr/th[8]")).getText();
        System.out.println(Status);
        String Svalue = driver.findElement(By.xpath("//tbody/tr[9]/td[9]")).getText();
        System.out.println(Svalue);
    }

    @And("Logout from buyer and login as seller to Click on Mark complete button")
    public void logoutFromBuyerAndLoginAsSellerToClickOnMarkCompleteButton() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("businesssellerfive@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Thread.sleep(4000);
        driver.findElement(By.linkText("My Bids")).click();
        Thread.sleep(3000);
        //need to enter data
        driver.findElement(By.xpath("//tbody/tr[1]/td[7]/a[1]/button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'Mark Complete')]")).click();
        driver.findElement(By.id("text_note")).sendKeys("Automation test");
        driver.findElement(By.id("job_doc_attachment")).sendKeys("/Users/ajitpatnaik/Desktop/uploadauto.png");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[@id='markCompleteProfileModal']/div[1]/div[1]/form[1]/div[3]/div[2]/button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[@id='markCompleteProfileModal']/div[1]/div[1]/form[1]/div[3]/div[1]/button[2]")).click();
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
    }

    @And("Logout from seller and login to Buyer to accept the bid completed job and verify the buyer finance")
    public void logoutFromSellerAndLoginToBuyerToAcceptTheBidCompletedJobAndVerifyTheBuyerFinance() throws InterruptedException {
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
        Thread.sleep(9000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[1]/input[1]")).sendKeys("BID Pet Vaccination 2nd aug BM");
        String Status1 = driver.findElement(By.xpath("//thead/tr/th[8]")).getText();
        System.out.println(Status1);
        String Svalue1 = driver.findElement(By.xpath("//tbody/tr[9]/td[9]")).getText();
        System.out.println(Svalue1);
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0,400)");
        //need to enter data
        driver.findElement(By.linkText("BID Pet Vaccination 2nd aug BM")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'Approve')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#DASHBOARD_TEXT_YES")).click();
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(9000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[1]/input[1]")).sendKeys("BID Pet Vaccination 2nd aug BM");
        String Status = driver.findElement(By.xpath("//thead/tr/th[8]")).getText();
        System.out.println(Status);
        String Svalue = driver.findElement(By.xpath("//tbody/tr[9]/td[9]")).getText();
        System.out.println(Svalue);
        Actions action1 = new Actions(driver);
        WebElement element1 = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action1.moveToElement(element1).build().perform();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Profile Page"))).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Buyer Finance")).click();
        String Buyerheader = driver.findElement(By.cssSelector("thead")).getText();
        System.out.println(Buyerheader);
        String Buyerfinance = driver.findElement(By.cssSelector("div.section-wrap:nth-child(15) div.section.overflowable div.content.right table.table.table-striped tbody:nth-child(2) > tr:nth-child(1)")).getText();
        System.out.println(Buyerfinance);
    }
    @And("logout from buyer and login as seller and verify the Seller finance")
    public void logoutFromBuyerAndLoginAsSellerAndVerifyTheSellerFinance() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("businesssellerfive@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Actions action1 = new Actions(driver);
        WebElement element1 = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action1.moveToElement(element1).build().perform();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Profile Page"))).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Seller Finance")).click();
        String Sellerheader = driver.findElement(By.xpath("//thead//tr")).getText();
        System.out.println(Sellerheader);
        String Sellerfinance = driver.findElement(By.cssSelector("div.section-wrap:nth-child(15) div.section.overflowable div.content.right div.table-responsive table.table.table-striped.tbale-main-bgbackground.tablethfied tbody:nth-child(2) > tr:nth-child(1)")).getText();
        System.out.println(Sellerfinance);
    }
    @Then("BID Job completed and close the window")
    public void bidJobCompletedAndCloseTheWindow() {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.close();
    }
}
