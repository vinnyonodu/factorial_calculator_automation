package test;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestBase;


public class SevenFactorialCheck extends TestBase {

    @Test
    public void sevenFactorialCheck() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);

        String numberTest = "7";
        String expectedResult = "The factorial of 7 is: 5040";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("number")));
        Thread.sleep(500);
        getDriver().findElement(By.id("number")).sendKeys(numberTest);
        Thread.sleep(500);
        getDriver().findElement(By.id("getFactorial")).click();
        Thread.sleep(1000);
        String actualResult = getDriver().findElement(By.id("resultDiv")).getText();
        Thread.sleep(500);
        Assert.assertEquals(expectedResult, actualResult);  //to verify the accurate result for 7!
    }

    @Test
    public void invalidInputCheckUsingXpath() throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);

        String expectedErrorMessage = "Please enter an integer";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("number")));
        getDriver().findElement(By.id("number")).clear();
        getDriver().findElement(By.id("number")).sendKeys("a");
        Thread.sleep(500);
        getDriver().findElement(By.id("getFactorial")).click();
        Thread.sleep(1000);
        String actualErrorMessage = getDriver().findElement(By.xpath("//p[@id='resultDiv']")).getText();
        Thread.sleep(500);
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);  //to verify the accurate error message displayed
    }



}
