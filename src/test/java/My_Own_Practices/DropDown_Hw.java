package My_Own_Practices;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class DropDown_Hw extends TestBase {
    @Test
    public void test01() {
        //1- amazon gidin
        driver.get("https://www.amazon.com");
        //2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm=driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select=new Select(ddm);
        List<WebElement> allOptions=select.getOptions();
        allOptions.forEach(t-> System.out.println(t.getText()));
        //3. dropdown menude 40 eleman olduğunu doğrulayın
        System.out.println("No of All Options= "+allOptions.size());
        Assert.assertTrue(allOptions.size()==28);

    }

    @Test
    public void test02() {
       // 1. dropdown menuden elektronik bölümü seçin
        driver.get("https://www.amazon.com");
        WebElement ddm=driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Electronics");

       // 2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
        WebElement result=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String stringResult=result.getText();
        String actualResult=stringResult.replaceAll("[^a-zA-Z0-9]"," ");
        String numberOfResults[]=actualResult.split(" ");
        System.out.println("Number of Results From The Search is= "+numberOfResults[1]);

        // 3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(result.getText().contains("iphone"));

       // 4. ikinci ürüne relative locater kullanarak tıklayin
        WebElement bununSaginda=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        WebElement bununUstunde=driver.findElement(By.xpath("(//img[@class='s-image'])[7]"));
        WebElement ikinciUrun=driver.findElement(with(By.tagName("img")).above(bununUstunde).toRightOf(bununSaginda));
        ikinciUrun.click();

       // 5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
       // WebElement productTitle=driver.findElement(By.xpath("//h1[@id='title']"));
       // WebElement productPrice=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
    }

    @Test
    public void test03() {
        //1. yeni bir sekme açarak amazon anasayfaya gidin
        
        //2. dropdown’dan bebek bölümüne secin
        //3. bebek puset aratıp bulundan sonuç sayısını yazdırın
        //4. sonuç yazsının puset içerdiğini test edin
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
    }
}
