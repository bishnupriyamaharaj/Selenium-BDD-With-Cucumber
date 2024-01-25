package ServBetter.Auto.StepDefinition.BID;

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


import static org.openqa.selenium.support.ui.ExpectedConditions.*;
public class BIDcompletedIndseller {
    public WebDriver driver=null;
       @Given("Open browser and Login with individual seller for Bid job flow")
    public void openBrowserAndLoginWithIndividualSellerForBidJobFlow() {
        System.setProperty("webdriver.chrome.driver","/Users/ajitpatnaik/Desktop/Upwork/Automation Servbetter/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get ("https://servbetter.com/");
       driver.findElement(By.linkText("Seller Login")).click();
       driver.findElement(By.id("email")).sendKeys("businessseller427@gmail.com");
       driver.findElement(By.id("password")).sendKeys("Popopo123!");
       driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

       }
    @When("Click the Bid Job tab from the menubar")
    public void clickTheBidJobTabFromTheMenubar() {
        driver.findElement(By.xpath("//body/div[@id='myHeader']/div[1]/nav[1]/ul[1]/li[3]/a[1]")).click();
 }
    @And("Click the Live BID job")
    public void clickTheLiveBIDJob() throws InterruptedException {
           //need to enter data
        driver.findElement(By.xpath("//tbody/tr[1]/td[9]/a[1]/button[1]")).click();
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,600)");
    }
    @And("Enter all the mandatory field in create quotation section and click place bid button")
    public void enterAllTheMandatoryFieldInCreateQuotationSectionAndClickPlaceBidButton() throws InterruptedException {
        driver.findElement(By.id("offer_cost")).sendKeys("12");
        driver.findElement(By.id("approx_time_needed")).sendKeys("8");
        driver.findElement(By.xpath("//textarea[@id='note']")).sendKeys("test automation");
        driver.findElement(By.xpath("//button[@id='seller_place_bid']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='seller_place_bid']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#DASHBOARD_TEXT_YES")).click();
    }
    @And("Logout from seller and login as buyer and navigate to all project page")
    public void logoutFromSellerAndLoginAsBuyerAndNavigateToAllProjectPage() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("individualbuyer@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[1]/input[1]")).sendKeys("BIDPet Vaccination12th JulyBM");
        Thread.sleep(2000);
        String Status = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status);
        String Svalue = driver.findElement(By.xpath("//tbody/tr[108]/td[9]")).getText();
        System.out.println(Svalue);
        driver.findElement(By.linkText("BIDPet Vaccination12th JulyBM")).click();
    }
    @And("click on the above BID job and click on AWARD button and click proceed from the popup window")
    public void clickOnTheAboveBIDJobAndClickOnAWARDButtonAndClickProceedFromThePopupWindow() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,700)");
        driver.findElement(By.xpath("//button[contains(text(),'Award')]")).click();

//        WebElement SELLER_ID = driver.findElement(By.xpath("//h2[contains(text(),'businessseller five')]"));
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].scrollIntoView()",SELLER_ID);
//        Thread.sleep(2000);
//       if(SELLER_ID.getText().contains("businessseller five")){
//            driver.findElement(By.xpath("//body/div[9]/div[1]/div[3]/div[4]/div[2]/div[2]/div[1]/div[5]/div[1]/a[1]/button[1]")).click();
//        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[@id='awardModal']/div[1]/div[1]/form[1]/div[3]/button[1]")).click();
        Thread.sleep(2000);
    }
    @And("complete the payment")
    public void completeThePayment() throws InterruptedException {
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
    @And("navigate back to buyer homepage logout and login as seller")
    public void navigateBackToBuyerHomepageLogoutAndLoginAsSeller() {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("businessseller427@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
     }

    @And("Click MyBid button from menu bar and click on the Bid job which already awarded")
    public void clickMyBidButtonFromMenuBarAndClickOnTheBidJobWhichAlreadyAwarded() throws InterruptedException {
        driver.findElement(By.linkText("My Bids")).click();
        Thread.sleep(2000);
        //need to enter data
        driver.findElement(By.xpath("//tbody/tr[1]/td[8]/a[1]/button[1]")).click();
        Thread.sleep(4000);

    }

    @And("Click on Sellerongoing button and complete the process")
    public void clickOnSellerongoingButtonAndCompleteTheProcess() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Seller OnGoing/Buyer Arrived')]")).click();
    Thread.sleep(2000);
       }

    @And("Logout from seller and login to Buyer again and navigate to my project and click on the sellerongoing BID job")
    public void logoutFromSellerAndLoginToBuyerAgainAndNavigateToMyProjectAndClickOnTheSellerongoingBIDJob() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("individualbuyer@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[1]/input[1]")).sendKeys("BID Pet Vaccination 21 th JulyBM");
        String Status = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status);
        String Svalue = driver.findElement(By.xpath("//tbody/tr[108]/td[9]")).getText();
        System.out.println(Svalue);
        driver.findElement(By.linkText("BIDPet Vaccination12th JulyBM")).click();
        Thread.sleep(2000);
      }

    @And("click on workstart button")
    public void clickOnWorkstartButton() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='security_code_btn']")).click();
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[1]/input[1]")).sendKeys("19 jan BM");
        String Status = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status);
        String Svalue = driver.findElement(By.xpath("//tbody/tr[108]/td[9]")).getText();
        System.out.println(Svalue);
           }

    @And("Logout from buyer and login as individual seller and My bid tab and click on the Work start project")
    public void logoutFromBuyerAndLoginAsIndividualSellerAndMyBidTabAndClickOnTheWorkStartProject() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("businessseller427@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Thread.sleep(4000);
        driver.findElement(By.linkText("My Bids")).click();
        Thread.sleep(3000);
        //need to enter data
        driver.findElement(By.xpath("//tbody/tr[1]/td[8]/a[1]/button[1]")).click();
        Thread.sleep(3000);

       }

    @And("Click on Mark complete button and complete the complete process and click next button")
    public void clickOnMarkCompleteButtonAndCompleteTheCompleteProcessAndClickNextButton() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Mark Complete')]")).click();
        driver.findElement(By.id("text_note")).sendKeys("Automation test");
        driver.findElement(By.id("job_doc_attachment")).sendKeys("/Users/ajitpatnaik/Desktop/uploadauto.png");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[@id='markCompleteProfileModal']/div[1]/div[1]/form[1]/div[3]/div[2]/button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[@id='markCompleteProfileModal']/div[1]/div[1]/form[1]/div[3]/div[1]/button[2]")).click();
       Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @And("Logout from seller and login to Buyer to accept the bid completed job")
    public void logoutFromSellerAndLoginToBuyerToAcceptTheBidCompletedJob() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("individualbuyer@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[1]/input[1]")).sendKeys("BID Pet Vaccination 21 th JulyBM");
        String Status = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status);
        String Svalue = driver.findElement(By.xpath("//tbody/tr[108]/td[9]")).getText();
        System.out.println(Svalue);
        driver.findElement(By.linkText("BIDPet Vaccination12th JulyBM")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'Approve')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[19]/div[1]/div[1]/form[1]/div[3]/button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[1]/input[1]")).sendKeys("BID Pet Vaccination 21 th JulyBM");
        String Status1 = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status1);
        String Svalue1 = driver.findElement(By.xpath("//tbody/tr[108]/td[9]")).getText();
        System.out.println(Svalue1);
    }

    @And("Navigate to Your profile and click on buyer finance and verify the data")
    public void navigateToYourProfileAndClickOnBuyerFinanceAndVerifyTheData() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Profile Page"))).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Buyer Finance")).click();
        String Buyerheader = driver.findElement(By.cssSelector("thead")).getText();
        System.out.println(Buyerheader);
        String Buyerfinance = driver.findElement(By.cssSelector("div.section-wrap:nth-child(15) div.section.overflowable div.content.right table.table.table-striped tbody:nth-child(2) > tr:nth-child(1)")).getText();
        System.out.println(Buyerfinance);

//        List<WebElement> allData=driver.findElements(By.xpath("//body/div[12]/div[1]/div[2]/table[1]"));
//        boolean buyerfinance=false;
//        for(WebElement ele:allData){
//            String value=ele.getText();
//            System.out.println(value);
//            if(value.contains("Automation BID 16th Jun Bid Faciasl")){
//                buyerfinance=true;
//                break;
//            }
//        }
//        Assert.assertTrue(buyerfinance,"Record not found");
    }

    @And("logout from buyer and login as seller")
    public void logoutFromBuyerAndLoginAsSeller()  {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("businessseller427@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    }

    @And("Navigate to Your profile and click on Seller finance and verify the data")
    public void navigateToYourProfileAndClickOnSellerFinanceAndVerifyTheData() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Profile Page"))).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Seller Finance")).click();
        String Sellerheader = driver.findElement(By.xpath("//thead//tr")).getText();
        System.out.println(Sellerheader);
        String Sellerfinance = driver.findElement(By.cssSelector("div.section-wrap:nth-child(15) div.section.overflowable div.content.right div.table-responsive table.table.table-striped.tbale-main-bgbackground.tablethfied tbody:nth-child(2) > tr:nth-child(1)")).getText();
        System.out.println(Sellerfinance);

//        List<WebElement> allData=driver.findElements(By.xpath("//body/div[12]/div[1]/div[2]/div[3]/table[1]"));
//        boolean SellerFinance=false;
//        for(WebElement ele:allData){
//            String value=ele.getText();
//            System.out.println(value);
//            if(value.contains("1")){
//                SellerFinance=true;
//                break;
//            }
//        }
//        Assert.assertTrue(SellerFinance,"Record not found");
    }

    @Then("BID Job completed")
    public void bidJobCompleted() {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
      driver.close();
    }

}
