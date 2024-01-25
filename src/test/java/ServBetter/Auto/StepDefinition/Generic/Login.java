package ServBetter.Auto.StepDefinition.Generic;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Login {
public WebDriver driver=null;
    @Given("Open Browser")
    public void open_browser() {

        System.setProperty("webdriver.chrome.driver","/Users/ajitpatnaik/Desktop/Upwork/Automation Servbetter/chromedriver");
        driver = new ChromeDriver();
        //WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
            }
    @When("Enter the url")
    public void enter_the_url() {
        // System.out.println("Login to Homepage");
        driver.get ("https://servbetter.com/");

    }
    @And("Click on Seller login Button")
    public void click_on_seller_login_button() {
        // System.out.println("Login popup opens");
        driver.findElement(By.linkText("Seller Login")).click();
    }
    @And("Enter valid username and password")
    public void enter_valid_username_and_password() {
        // System.out.println("Entered the credentials");
        driver.findElement(By.id("email")).sendKeys("Businesssellerfive@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Popopo123!");
    }
    @And("click on submit button")
    public void click_on_submit_button() {
        // System.out.println("Click submit");

        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

    }
    @Then("User should successfully login to the Home page")
    public void user_should_successfully_login_to_the_home_page() {
        System.out.println("Login to seller home page");
        driver.close();
   }

}
