package ZaleniumClass;

import okio.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleTest extends ZaleniumTestNGTest {

    @Test(priority = 0)
    public void searchEpam(){
        driver.findElement(By.name("q")).sendKeys("EPAM");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='SPZz6b']/h2/span")).isDisplayed();
        String title = driver.findElement(By.xpath("//div[@class='SPZz6b']/h2/span")).getText();
        Assert.assertEquals(title, "EPAM Systems");
        Cookie cookie = new Cookie("zaleniumTestPassed", "true");
        driver.manage().addCookie(cookie);
    }

    @Test(priority = 1)
    public void searchIndore(){
        driver.findElement(By.name("q")).sendKeys("Indore");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='fYOrjf kp-hc']/descendant::h2/span")).isDisplayed();
        String title = driver.findElement(By.xpath("//div[@class='fYOrjf kp-hc']/descendant::h2/span")).getText();
        Assert.assertEquals(title, "Indore");
        Cookie cookie = new Cookie("zaleniumTestPassed", "true");
        driver.manage().addCookie(cookie);
    }

    @Test(priority = 2)
    public void searchPune(){
        driver.findElement(By.name("q")).sendKeys("Pune");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='fYOrjf kp-hc']/descendant::h2/span")).isDisplayed();
        String title = driver.findElement(By.xpath("//div[@class='fYOrjf kp-hc']/descendant::h2/span")).getText();
        Assert.assertEquals(title, "Punee");
        Cookie cookie = new Cookie("zaleniumTestPassed", "true");
        driver.manage().addCookie(cookie);
    }
}
