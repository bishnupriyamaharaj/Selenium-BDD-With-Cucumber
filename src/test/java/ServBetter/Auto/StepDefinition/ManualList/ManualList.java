package ServBetter.Auto.StepDefinition.ManualList;

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

public class ManualList {

    public WebDriver driver=null;
    @Given("Open browser and Login with seller for Manuallist job")
    public void openBrowserAndLoginWithSellerForManuallistJob()  {
        System.setProperty("webdriver.chrome.driver","/Users/ajitpatnaik/Desktop/Upwork/Automation Servbetter/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get ("https://servbetter.com/");
         driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("businesssellerseven@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    }
    @When("Navigate to Manuallist job tab and Click on Add project Button")
    public void navigateToManuallistJobTabAndClickOnAddProjectButton() {
        driver.findElement(By.linkText("Manual List")).click();
        driver.findElement(By.xpath("//body/div[9]/div[1]/div[1]/div[1]/a[1]/button[1]")).click();
    }
    @And("Enter all the Mandatory Field for Manuallist job and click submit")
    public void enterAllTheMandatoryFieldForManuallistJobAndClickSubmit()  throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");
        WebElement subcatagoryddown = driver.findElement(By.id("sel_subcategory"));
        Select subcatagory = new Select(subcatagoryddown);
        subcatagory.selectByVisibleText("Graphics and Design");
        driver.findElement(By.id("sel_zipcode")).sendKeys("test123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='buyerName']")).sendKeys("individualbuyer2");
        driver.findElement(By.xpath("//input[@id='buyerEmail']")).sendKeys("individualbuyer2@gmail.com");
        driver.findElement(By.xpath("//input[@id='buyerPhoneNumber']")).sendKeys("985756874569");
        driver.findElement(By.xpath("//input[@id='sel_job_title']")).sendKeys("manualjob29th Aug");
        driver.findElement(By.xpath("//textarea[@id='sel_job_description']")).sendKeys("manualjob29th Aug");
        jse.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("//input[@id='sel_job_start_date']")).sendKeys("26.08.2022");
        driver.findElement(By.xpath("//input[@id='sel_job_price']")).sendKeys("50");
        WebElement status = driver.findElement(By.xpath("//select[@id='status']"));
        Select subcatagory3 = new Select(status);
        subcatagory3.selectByVisibleText("JOB COMPLETED PAYMENT DONE");
        driver.findElement(By.xpath("//button[contains(text(),'Submit Job')]")).click();
    }
    @And("Verify the created job and logout from Seller")
    public void verifyTheCreatedJobAndLogoutFromSeller()throws InterruptedException {
        Thread.sleep(2000);
        String Manualheader =driver.findElement(By.xpath("//thead//tr")).getText();
        System.out.println(Manualheader);
        String Manualproject = driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]")).getText();
        System.out.println(Manualproject);
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();

    }
    @Then("Seller should able to Create successfully manuallist job")
    public void sellerShouldAbleToCreateSuccessfullyManuallistJob()  {
        driver.close();
    }
 }
