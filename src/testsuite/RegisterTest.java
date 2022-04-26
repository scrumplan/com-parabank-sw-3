package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {

        //click on the ‘Register’ link
        clickOnElement(By.linkText("Register"));

        verifyElements("Register tab is not matching", "Signing up is easy!", By.xpath("//div[@id = 'mainPanel']/descendant::div[9]/child::h1"));

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {

        //click on the ‘Register’ link
        clickOnElement(By.linkText("Register"));
        //Enter First name
        sendTextToElement(By.id("customer.firstName"), "Jhon");
        //Enter Last name
        sendTextToElement(By.id("customer.lastName"), "Smith");
        //Enter Address
        sendTextToElement(By.id("customer.address.street"), "39,jhonestreet");
        //Enter City
        sendTextToElement(By.id("customer.address.city"), "Lester");
        //Enter State
        sendTextToElement(By.id("customer.address.state"), "london");
        //Enter Zip Code
        sendTextToElement(By.id("customer.address.zipCode"), "1234");
        //Enter Phone
        sendTextToElement(By.id("customer.phoneNumber"), "+447512121234");
        //Enter SSN
        sendTextToElement(By.id("customer.ssn"), "12345");
        //Enter Username
        sendTextToElement(By.id("customer.username"), "John12345+");
        //Enter Password
        sendTextToElement(By.id("customer.password"), "John12345");
        //Enter Confirm
        sendTextToElement(By.id("repeatedPassword"), "John12345");
        //Click on REGISTER button
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));

        verifyElements("Register tab is not matching", "Your account was created successfully. You are now logged in.", By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));


    }

}
