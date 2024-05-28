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

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /*
    userShouldLoginSuccessfullyWithValid Credentials
    * Enter “standard_user” username
    * Enter “secret_sauce” password
    * Click on ‘LOGIN’ button
    * Verify the text “PRODUCTS”
    */
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
/*
    verifyThatSixProductsAreDisplayedOnPage
* Enter “standard_user” username
* Enter “secret_sauce” password
* Click on ‘LOGIN’ button
* Verify that six products are displayed on
            page
*/

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        int expectedProducts = 6;
        Assert.assertEquals("User cannot see 6 product", expectedProducts, products.size());
    }


    @After
    public void tearDown() {
        //  closeBrowser();
    }
}