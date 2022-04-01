import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MyStepdefs {

    private String myBrowser, myEmail, myPassword;
    private WebDriver driver;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuMMddHHmm");
    LocalDateTime now = LocalDateTime.now();
    // DateTimeFormatter and LocalDateTime is used to add a kind of timestamp
    // to the email and username and therefor making it unique.


    @Given("I have started a {string} browser")
    public void iUseA(String browser) {
        DriveCreator creator = new DriveCreator();
        myBrowser = browser;
        driver = creator.createBrowser(browser);
        driver.manage().window().setSize(new Dimension(974, 1080));
        driver.get("https://login.mailchimp.com/signup/");
        System.out.println(browser);

    }


    @Given("I enter {string}")
    public void iEnterEmail(String email) throws InterruptedException {
        myEmail = dtf.format(now) + email;
        driver.findElement(By.id("email")).sendKeys(myEmail);
        System.out.println(myEmail);
    }

    @Given("I put {string}")
    public void iEnterUsername(String username) {
        // myUsername = username;
        driver.findElement(By.id("new_username")).sendKeys(myEmail);
        System.out.println(myEmail);
    }

    @Given("I enter a {string}")
    public void iEnterAPassword(String password) {
        myPassword = dtf.format(now) + password;
        driver.findElement(By.id("new_password")).sendKeys(myPassword);
        System.out.println(myPassword);
    }


    @When("I click the signup button")
    public void iClickTheSignupButton() {
        click(driver, By.id("create-account"));


    }


    @Then("I get a {string}")
    public void iGetA(String result) {

        //I can't get/understand the assertEquals.
        //I want to get information from the feature-file but don't know how.
        //Maybe I want the program to do things that it can't do...
        //with my lack of knowledge.

        driver.quit();
    }


    private static void click(WebDriver driver, By by) {
        WebDriverWait foobar = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = foobar.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }




    /*private static void scroll(WebDriver driver, String length) {
        JavascriptException js = (JavascriptException) driver;
        js.executeScript("window.scrollBy (0, 250)", "");
    }

     */


}




