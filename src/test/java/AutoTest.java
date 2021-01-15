import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

// Для доступа к элементам внутри DOM используются [] скобки.
public class AutoTest {
    public ChromeDriver driver;

    @Before
 public void SetUp(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        System.out.println("open");
    }
    @After
public void SetClose(){
        driver.close();
        System.out.println("close");
    }
    @Test
    public void singUp(){
         driver.get("https://wp-seven.ru/");
         WebElement header = driver.findElementById("headr");
         header.findElement(By.cssSelector("[href=\"/registration/\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signup_submit")));
        driver.findElement(By.id("signup_username")).sendKeys("foagl2021");
        driver.findElement(By.id("signup_email")).sendKeys("valeriyslykin@ukr.net");
        driver.findElement(By.id("signup_password")).sendKeys("Foagl2020");
        driver.findElement(By.id("signup_password_confirm")).sendKeys("Foagl2020");
        driver.findElement(By.id("field_1")).sendKeys("Valerii");
        driver.findElement(By.xpath("//*[@id=\"basic-details-section\"]/div[5]/label[1]")).click(); // Нажатие radio что я не бот ;)
        driver.findElement(By.id("signup_submit")).click();
        String str = driver.findElement(By.xpath("//*[@id=\"basic-details-section\"]/div[7]/div")).getText();
        // строку получил.
        String strAnswer = str.replaceAll("[0-9=? ]", "");
        // создаю новую без цифр из равно вопрос.
        str = str.replaceAll("[^\\d.]", "");
        // удалишнее кроме цифр

        int i=Integer.parseInt(str);
        int j = i / 10;
        int k = i - (j * 10);
        if (strAnswer.equals("-")) System.out.println(" 51 " + (i - j));
        if (strAnswer.equals("+")) System.out.println(" 52 " + (i + j));
        String botStr = String.valueOf(k);
        System.out.println(str);
        System.out.println(j);
        System.out.println(k);
        System.out.println("Answer = " + strAnswer);

        driver.findElement(By.xpath("//*[@id=\"basic-details-section\"]/div[7]/input")).sendKeys(botStr);
        driver.findElement(By.id("signup_submit")).click();

          // Пофиксить нужно: Не убирает из строки strAnswr проблемы, из-за этого не могу пройти проверку на бота.
         // Нужно написать обход рекламы при регистраци.
    }
}
