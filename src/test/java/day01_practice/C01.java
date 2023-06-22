package day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {
        System.setProperty("web driver.chromeDriver", "src/resources/drivers/drivers/chromedriver_mac64/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // "https://testpages.herokuapp.com/styled/calculator" adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/calculator");
        // ilk kutucuga 20 giriniz
       WebElement ilkKutucuk= driver.findElement(By.xpath("//input[@id='number1']"));
       ilkKutucuk.sendKeys("20");
        // ikinci kutucuga 30 giriniz
        WebElement ikinciKutucuk=driver.findElement(By.xpath("//input[@id='number2']"));
        ikinciKutucuk.sendKeys("30");
        // calculate'e tıklayınız
        WebElement calculateButonu=driver.findElement(By.xpath("//input[@id='calculate']"));
        calculateButonu.click();
        // sonucu yazdırınız
        WebElement sonuc=driver.findElement(By.xpath("//span[@id='answer']"));
        System.out.println("Toplama isleminin sonucu= "+sonuc.getText()); //sonuc bir web element o yuzden href verir bize getText() ile string e donusturmemiz lazim
        // sayfayi kapatiniz
        driver.close();

    }
}
