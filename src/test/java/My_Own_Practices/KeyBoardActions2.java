package My_Own_Practices;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions2 extends TestBase {
    @Test
    public void test01() {
        //1.Bir Class olusturalim KeyboardActions2
        //2.https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe");
        //3.video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);
        //4.videoyu izlemek icin Play tusuna basin
        WebElement iframe=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        bekle(2);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        //5.videoyu calistirdiginizi test edin
        driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']")).isDisplayed();


    }
}
