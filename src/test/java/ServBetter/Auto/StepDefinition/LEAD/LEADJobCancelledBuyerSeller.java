package ServBetter.Auto.StepDefinition.LEAD;

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

import static java.lang.Thread.sleep;

public class LEADJobCancelledBuyerSeller {

    public WebDriver driver=null;
    @Given("Open browser and Login with buyer")
    public void openBrowserAndLoginWithBuyer(){
        System.setProperty("webdriver.chrome.driver","/Users/ajitpatnaik/Desktop/Upwork/Automation Servbetter/chromedriver");
        driver = new ChromeDriver();
        //WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get ("https://servbetter.com/");
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("j7455893@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Work098765@#");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    }
    @When("Click on POST A JOB Button and Enter all the Mandatory Field for LEAD job and click submit")
    public void clickOnPOSTAJOBButtonAndEnterAllTheMandatoryFieldForLEADJobAndClickSubmit() throws InterruptedException {
        driver.findElement(By.xpath("//body/div[@id='myHeader']/div[1]/nav[1]/ul[1]/li[3]/a[1]")).click();
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
        driver.findElement(By.id("job_title")).sendKeys("PlumbingAutomationB30Aug BM");
        driver.findElement(By.id("job_description")).sendKeys("PlumbingAutomationBM description 30Aug Aug");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,800)");
        sleep(4000);
        driver.findElement(By.xpath("//input[@id='job_start_date']")).click();
        driver.findElement((By.xpath("//a[contains(text(),'30')]"))).click();
        sleep(3000);
        jse.executeScript("window.scrollBy(0,600)");
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

    @And("Logout the Buyer and login as Seller")
    public void logoutTheBuyerAndLoginAsSeller()  {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("tom624563@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Work098765@#");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    }
    @And("Click on Lead job tab from the menubar and Click on show details from the first lead job")
    public void clickOnLeadJobTabFromTheMenubarAndClickOnShowDetailsFromTheFirstLeadJob(){
          driver.findElement(By.linkText("Lead Jobs")).click();
        driver.findElement(By.xpath("//tbody/tr[1]/td[9]/a[1]/button[1]")).click();
    }
    @And("Click on Pay Now from the LEAD job details page and Click on Yes from the Confirmation popup")
    public void clickOnPayNowFromTheLEADJobDetailsPageAndClickOnYesFromTheConfirmationPopup() throws InterruptedException {
        driver.findElement(By.xpath("//body/div[9]/div[1]/div[1]/div[1]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'YES')]")).click();
        Thread.sleep(4000);
    }
    @And("enter amount and select cancel from the dropdown and click on submit button")
    public void enterAmountAndSelectCancelFromTheDropdownAndClickOnSubmitButton()  {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1200)");
        driver.findElement(By.xpath("//input[@id='lead_amt']")).sendKeys("25");
        driver.findElement(By.xpath("//select[@id='cars']")).click();
        WebElement status = driver.findElement(By.xpath("//select[@id='cars']"));
        Select subcatagory3 = new Select(status);
        subcatagory3.selectByVisibleText("Cancel");
        driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();
    }

    @And("Get the text from the page to verify the status")
    public void getTheTextFromThePageToVerifyTheStatus(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,700)");
        String amount = driver.findElement(By.xpath("//body/div[9]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/form[1]/div[1]/input[3]")).getText();
        System.out.println(amount);
        String Lstatus = driver.findElement(By.xpath("//select[@id='cars']")).getText();
        System.out.println(Lstatus);
    }
    @And("logout from seller and Login as Buyer")
    public void logoutFromSellerAndLoginAsBuyer() {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
        driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("j7455893@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Work098765@#");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    }

    @And("Click on All project option and Search the previous LEAD project")
    public void clickOnAllProjectOptionAndSearchThePreviousLEADProject() throws InterruptedException {
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(11000);
        //driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[1]/input[1]")).sendKeys("PlumbingAutomationB29Aug BM");
            }
    @And("Verify the status")
    public void verifyTheStatus() {
        String Status = driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[2]/table[1]/thead[1]")).getText();
        System.out.println(Status);
        String Svalue = driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]")).getText();
        System.out.println(Svalue);
    }

     @Then("Logout from the Buyer and close the webpage")
    public void logoutFromTheBuyerAndCloseTheWebpage() throws InterruptedException {
         Thread.sleep(3000);
         Actions action = new Actions(driver);
         WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
         action.moveToElement(element).build().perform();
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
         driver.close();
    }
}
