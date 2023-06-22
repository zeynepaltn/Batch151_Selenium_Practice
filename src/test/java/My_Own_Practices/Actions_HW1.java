package My_Own_Practices;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actions_HW1 extends TestBase {
    @Test
    public void test01() {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over  Me First" kutusunun ustune gelin
        WebElement hoverOver =driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hoverOver).perform();
        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();
        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold=driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
        actions.moveToElement(clickAndHold).clickAndHold().perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        String yazi=driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]")).getText();
        System.out.println(yazi);
        //8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
        WebElement dC=driver.findElement(By.xpath("//h2[text()='Double Click Me!']"));
        actions.doubleClick(dC).perform();
        WebElement afterDouble=driver.findElement(By.xpath("//div[@class='div-double-click double']"));
        Assert.assertTrue(afterDouble.isDisplayed());

    }
}
