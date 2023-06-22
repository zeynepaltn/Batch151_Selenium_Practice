package day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02 {
    public static void main(String[] args) {
        System.setProperty("web driver.chromeDriver", "src/resources/drivers/drivers/chromedriver_mac64/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com");
        // arama motorunda nutella yazip aratınız
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nutella"+ Keys.ENTER);
        // Customer Service ve Registry butonlarına sırasıyla tıklayın ve title'larının "Amazon" icerdigini test edin
        for (int i = 0; i <2 ; i++) {
            List<WebElement> butonlar = driver.findElements(By.xpath("(//a[@tabindex='0'])[6] | (//a[@tabindex='0'])[7]"));
            butonlar.get(i).click();
            if (driver.getTitle().contains("Amazon")){
                System.out.println("Title Amazon Iceriyor");
            }else {
                System.out.println("Title Amazon Icermiyor");
            }
            driver.navigate().back();

        }

        // pencereyi kapatiniz
        driver.close();
    }
}
/*
        // "https://www.amazon.com/" adresine gidiniz.
        // "https://www.n11.com/" adresine gidiniz.
        // amazon adresine geri donunuz
        // n11 adresine ilerleyiniz
        // sayfayi yenileyiniz
        // pencereyi kapat
        // Konsola "HER ŞEY YOLUNDA" yazdir





                // "https://teknosa.com/" adresine gidiniz
        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        // Title'in "Teknoloji" kelimesini icerip icermedigini kontrol ediniz
        // URL'in "teknosa" kelimesini icerip icermedigini kontrol ediniz
        // "https://medunna.com/" adresine gidiniz
        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.
        // URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz
        // teknosa adresine geri donunuz
        // Sayfayı yenileyiniz
        // medunna adresine ilerleyiniz
        // Sayfayı yenileyiniz
        // pencereyi kapat
 */
