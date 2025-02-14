package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    //Set the browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //Verify user should log in successfully.
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Enter username and password into email and password field.
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //click on the login button
        driver.findElement(By.id("login-button")).click();


        //Verify the text “Products”
        String expectedResult = "Products";
        String actualResult = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        Assert.assertEquals("User is not log in successfully", expectedResult, actualResult);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter username and password into email and password field.
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //click on the login button
        driver.findElement(By.id("login-button")).click();

        //Verify that six products are displayed on page
        List<WebElement> productsList = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int expectedNoOfProduct = 6;
        Assert.assertEquals("six products are not displayed on the page", expectedNoOfProduct, productsList.size());

    }

    //close the browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}
