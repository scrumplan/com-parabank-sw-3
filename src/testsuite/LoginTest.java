package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter valid username
        sendTextToElement(By.name("username"), "John12345");

        //Enter valid password
        sendTextToElement(By.name("password"), "John12345");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));

        verifyElements("message  is not matching", "Accounts Overview", By.xpath("//h1[contains(text(),'Accounts Overview')]"));
    }

    @Test
    public void verifyTheErrorMessage() {

        //Enter invalid username
        sendTextToElement(By.name("username"), "John1234+");
        //Enter invalid password
        sendTextToElement(By.name("password"), "John12345+");
        //Click on Login button
        clickOnElement(By.xpath("//div/input[@class='button']"));

        verifyElements("message  is  matching", "The username and password could not be verified.", By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //Enter valid username
        sendTextToElement(By.name("username"), "John12345");
        //Enter valid password
        sendTextToElement(By.name("password"), "John12345");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//div/input[@class='button']"));

        // Click on ‘Log Out’ link
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
        verifyElements("message  is not matching", "Customer Login", By.xpath("//h2[contains(text(),'Customer Login')]"));

    }


}
