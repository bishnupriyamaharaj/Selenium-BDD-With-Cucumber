package ServBetter.Auto.StepDefinition.Accounting;

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

public class QuotationAdded {

    public WebDriver driver=null;
    @Given("Open browser and Login with Seller and navigate to Accounting panel")
    public void openBrowserAndLoginWithSellerAndNavigateToAccountingPanel() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/ajitpatnaik/Desktop/Upwork/Automation Servbetter/chromedriver");
        driver = new ChromeDriver();
        //WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get ("https://servbetter.com/");
        driver.findElement(By.linkText("Seller Login")).click();
        driver.findElement(By.id("email")).sendKeys("businesssellerfive@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Seller Business')]"));
        action.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Profile Page"))).click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,800)");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Accounting Panel")).click();
    }
    @When("Click on customer vendor tab")
    public void clickOnCustomerVendorTab() {
        driver.findElement(By.xpath("//span[contains(text(),'Customers/Vendor')]")).click();
        driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/a[1]/i[1]")).click();
    }
    @And("Enter all the Mandatory Field and click submit")
    public void enterAllTheMandatoryFieldAndClickSubmit() throws InterruptedException {
        driver.findElement(By.name("name")).sendKeys("vendorauto");
        driver.findElement(By.name("company_name")).sendKeys("oiiuuzz123");
        driver.findElement(By.name("email")).sendKeys("Xdsfsdeuto1@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("7856456423");
        WebElement userType = driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/select[1]"));
        Select Utype = new Select(userType);
        Utype.selectByVisibleText("vendor");
        driver.findElement(By.name("billing_address")).sendKeys("address1");
        driver.findElement(By.name("billing_city")).sendKeys("address1");
        WebElement Country = driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[2]/div[1]/form[1]/div[5]/div[2]/select[1]"));
        Select ctry = new Select(Country);
        ctry.selectByVisibleText("UK");
        driver.findElement(By.name("billing_zipcode")).sendKeys("45896");
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1200)");
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
    }
    @Then("Verify that customer added successfully")
    public void verifyThatCustomerAddedSuccessfully() {
        String customerheader = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]")).getText();
        System.out.println(customerheader);
        String customerdetails = driver.findElement(By.cssSelector("#custtbl")).getText();
        System.out.println(customerdetails);
        driver.close();
    }

    @Given("Open browser and Login with Seller and navigate to Accounting panel to add Quotation")
    public void openBrowserAndLoginWithSellerAndNavigateToAccountingPanelToAddQuotation() {
    }

    @When("Click on Quotation tab")
    public void clickOnQuotationTab() {
    }

    @And("Enter all the Mandatory Field and click submit for Quotation")
    public void enterAllTheMandatoryFieldAndClickSubmitForQuotation() {
    }

    @Then("Verify that Quotation added successfully")
    public void verifyThatQuotationAddedSuccessfully() {
    }
}
