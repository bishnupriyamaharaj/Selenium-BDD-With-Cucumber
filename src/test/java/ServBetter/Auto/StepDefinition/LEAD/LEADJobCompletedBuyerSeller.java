package ServBetter.Auto.StepDefinition.LEAD;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class LEADJobCompletedBuyerSeller {

    public WebDriver driver=null;
     @Given("Open browser and Login with individual buyer")
    public void openBrowserAndLoginWithIndividualBuyer() {
        System.setProperty("webdriver.chrome.driver","/Users/ajitpatnaik/Desktop/Upwork/Automation Servbetter/chromedriver");
        driver = new ChromeDriver();
        //WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get ("https://servbetter.com/");
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("individualbuyer2@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    }
      @When("Click on POST A JOB Button")
    public void clickOnPOSTAJOBButton() {
        driver.findElement(By.xpath("//body/div[@id='myHeader']/div[1]/nav[1]/ul[1]/li[3]/a[1]")).click();
    }
    @And("Enter all the Mandatory Field for LEAD job and click submit")
    public void enterAllTheMandatoryFieldForLEADJobAndClickSubmit() throws InterruptedException {
        WebElement catagoryddown = driver.findElement(By.id("category"));
        Select catagory = new Select(catagoryddown);
        catagory.selectByVisibleText("Home Services");
        sleep(2000);
        WebElement subcatagoryddown = driver.findElement(By.id("subcategory"));
        Select subcatagory = new Select(subcatagoryddown);
        subcatagory.selectByVisibleText("Plumbing");
        driver.findElement(By.id("zipcode")).sendKeys("test123");
        WebElement Urgency = driver.findElement(By.id("job_level"));
        Select JobUrgency = new Select(Urgency);
        JobUrgency.selectByVisibleText("Medium");
        driver.findElement(By.id("job_title")).sendKeys("PlumbingAutomationB 30 Aug BM");
        driver.findElement(By.id("job_description")).sendKeys("PlumbingAutomationBM description 30Aug");

       sleep(4000);
        driver.findElement(By.xpath("//input[@id='job_start_date']")).click();
        driver.findElement((By.xpath("//a[contains(text(),'30')]"))).click();

        sleep(3000);
        WebElement Pricetype = driver.findElement(By.id("price_type"));
        Select ptype = new Select(Pricetype);
        ptype.getFirstSelectedOption().getText();
        sleep(1000);
        WebElement Pricerange = driver.findElement(By.id("PriceMinMax"));
        Select pRange = new Select(Pricerange);
        pRange.selectByVisibleText("Upto £50");
        sleep(1000);
        WebElement jobType = driver.findElement(By.id("job_type"));
        Select Jtype = new Select(jobType);
        Jtype.selectByVisibleText("LEAD");
        sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Submit Job')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
        String Status = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status);
        String Svalue = driver.findElement(By.xpath("//tbody/tr[1]/td[9]")).getText();
        System.out.println(Svalue);
     }
    @And("Logout the individual Buyer and login as individual seller")
    public void logoutTheIndividualBuyerAndLoginAsIndividualSeller() {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("businesssellerfive@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    }
      @And("Click on Lead job tab from the bar")
    public void clickOnLeadJobTabFromTheBar() {
          driver.findElement(By.linkText("Lead Jobs")).click();
    }

    @And("Click on show details from the first lead job")
    public void clickOnShowDetailsFromTheFirstLeadJob() {
        driver.findElement(By.xpath("//tbody/tr[1]/td[9]/a[1]/button[1]")).click();
    }

    @And("Click on Pay Now from the LEAD job details page")
    public void clickOnPayNowFromTheLEADJobDetailsPage() {
        driver.findElement(By.xpath("//body/div[9]/div[1]/div[1]/div[1]/div[2]/button[1]")).click();
    }

    @And("Click on Yes from the Confirmation popup")
    public void clickOnYesFromTheConfirmationPopup() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'YES')]")).click();
        Thread.sleep(4000);
    }
    @And("Click on Sellerongoing button")
    public void clickOnSellerongoingButton() {
            driver.findElement(By.xpath("//button[contains(text(),'Seller OnGoing')]")).click();
          }
    @And("Logout and Login as Individual Buyer")
    public void logoutAndLoginAsIndividualBuyer() {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(visibilityOfElementLocated(By.linkText("Log Out"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("individualbuyer2@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    }

    @And("Click on All project option and click on first LEAD job")
    public void clickOnAllProjectOptionAndClickOnFirstLEADJob() throws InterruptedException {
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
//        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[1]/input[1]")).sendKeys("BIDPet Vaccination12th JulyBM");
//        Thread.sleep(2000);
        String Status = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status);
        String Svalue = driver.findElement(By.xpath("//tbody/tr[1]/td[9]")).getText();
        System.out.println(Svalue);
        driver.findElement(By.linkText("PlumbingAutomationB 30 Aug BM")).click();
//
//        driver.findElement(By.linkText("My Projects")).click();
//        Thread.sleep(11000);
//        driver.findElement(By.xpath("//body[1]/div[9]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/a[1]")).click();
    }
    @And("Click on Work Start button")
    public void clickOnWorkStartButton() throws InterruptedException {
         Thread.sleep(2000);
        driver.findElement(By.id("security_code_btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
//        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[1]/input[1]")).sendKeys("BIDPet Vaccination12th JulyBM");
//        Thread.sleep(2000);
        String Status = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status);
        String Svalue = driver.findElement(By.xpath("//tbody/tr[1]/td[9]")).getText();
        System.out.println(Svalue);
        driver.findElement(By.linkText("PlumbingAutomationB 30 Aug BM")).click();
    }
    @And("Click on Job Done")
    public void clickOnJobDone() throws InterruptedException {
         Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Job Done')]")).click();
    }
    @And("Click on Yes from the Job done confirmation popup")
    public void clickOnYesFromTheJobDoneConfirmationPopup() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[9]/div[1]/div[3]/div[4]/div[2]/div[1]/div[1]/div[3]/a[1]/button[1]")).click();

    }
    @And("Click on close rating popup")
    public void clickOnCloseRatingPopup() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body/div[9]/div[1]/div[3]/div[4]/div[4]/div[1]/div[1]/button[1]")).click();
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
//        driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[1]/input[1]")).sendKeys("BIDPet Vaccination12th JulyBM");
//        Thread.sleep(2000);
        String Status = driver.findElement(By.xpath("//thead/tr/th[9]")).getText();
        System.out.println(Status);
        String Svalue = driver.findElement(By.xpath("//tbody/tr[1]/td[9]")).getText();
        System.out.println(Svalue);
    }

    @Then("Buyer should able to Complete successfully A LEAD job end to end flow")
    public void buyerShouldAbleToCompleteSuccessfullyALEADJobEndToEndFlow() throws InterruptedException {
        Thread.sleep(3000);
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.close();
    }

  }
