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

public class Bidjobcreated {

    public WebDriver driver=null;
    @Given("Open browser and Login with individual buyer for Bid job")
    public void openBrowserAndLoginWithIndividualBuyerForBidJob() {
        System.setProperty("webdriver.chrome.driver","/Users/ajitpatnaik/Desktop/Upwork/Automation Servbetter/chromedriver");
        driver = new ChromeDriver();
        //WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get ("https://servbetter.com/");
         driver.findElement(By.linkText("Buyer Login")).click();
        driver.findElement(By.id("username")).sendKeys("individualbuyer@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    }
    @When("Click on POST A JOB Button for Bid job")
    public void clickOnPOSTAJOBButtonForBidJob() {
        driver.findElement(By.xpath("//body/div[@id='myHeader']/div[1]/nav[1]/ul[1]/li[3]/a[1]")).click();
    }
    @And("Enter all the Mandatory Field for BID job and click submit")
    public void enterAllTheMandatoryFieldForBIDJobAndClickSubmit() throws InterruptedException {
        WebElement catagoryddown = driver.findElement(By.id("category"));
        Select catagory = new Select(catagoryddown);
        catagory.selectByVisibleText("IT, Design and Engineering");
        Thread.sleep(3000);
        WebElement subcatagoryddown = driver.findElement(By.id("subcategory"));
        Select subcatagory = new Select(subcatagoryddown);
        subcatagory.selectByVisibleText("Product Design");
        driver.findElement(By.id("zipcode")).sendKeys("test123");
        WebElement Urgency = driver.findElement(By.id("job_level"));
        Select JobUrgency = new Select(Urgency);
        JobUrgency.selectByVisibleText("Medium");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.id("job_title")).sendKeys("BID Product Design 19 Apr BM");
        driver.findElement(By.id("job_description")).sendKeys("BID Product Design 19 Apr BM");

        //Thread.sleep(000);
        jse.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("//input[@id='job_start_date']")).click();
        driver.findElement((By.xpath("//a[contains(text(),'19')]"))).click();

        //Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,400)");
        WebElement Pricetype = driver.findElement(By.id("price_type"));
        Select ptype = new Select(Pricetype);
        ptype.getFirstSelectedOption().getText();
        Thread.sleep(1000);
        WebElement Pricerange = driver.findElement(By.id("PriceMinMax"));
        Select pRange = new Select(Pricerange);
        pRange.selectByVisibleText("Upto £50");
        Thread.sleep(1000);
        WebElement jobType = driver.findElement(By.id("job_type"));
        Select Jtype = new Select(jobType);
        Jtype.selectByVisibleText("BID");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Submit Job')]")).click();
        //jse.executeScript("window.scrollBy(0,900)");
    }
    @And("Logout the individual Buyer")
    public void logoutTheIndividualBuyer() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.linkText("My Projects")).click();
        Thread.sleep(12000);
        String Buyerheader =driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[2]/table[1]/thead[1]/tr[1]")).getText();
        System.out.println(Buyerheader);
        String Buyerproject = driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]")).getText();
        System.out.println(Buyerproject);
        String Buyerproject1 = driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[2]")).getText();
        System.out.println(Buyerproject1);
        String Buyerproject2 = driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[3]")).getText();
        System.out.println(Buyerproject2);
        String Buyerproject3 = driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[4]")).getText();
        System.out.println(Buyerproject3);
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        //WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Buyer Individual')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();

    }
    @Then("Buyer should able to Create successfully BID job")
    public void buyerShouldAbleToCreateSuccessfullyBIDJob() {
        driver.close();
    }
}
