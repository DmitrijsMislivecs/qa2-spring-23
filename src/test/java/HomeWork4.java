import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork4 {
    private final By LANGUAGE_SWITCHER = By.xpath(".//li[@class = 'site-top__menu-right-item language-switcher']");
    private final By OFFER_FOR_BUSINESS = By.linkText("https://www.1a.lv/kp/piedavajums-biznesam/fn");

    @Test
    public void locatorTest(){
        System.setProperty("webdriver.chrome.driver", "/Users/innamisliveca/Downloads/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://1a.lv");
        //browser.findElement(By.id("top-search-form")).click();
        browser.findElement(LANGUAGE_SWITCHER).click();
        browser.findElement(OFFER_FOR_BUSINESS).click();
        browser.close();

    }

}
