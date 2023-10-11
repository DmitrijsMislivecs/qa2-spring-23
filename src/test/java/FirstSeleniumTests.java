import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTests {
    private final By REGISTRATION_FORM = By.id("registration-form");
    private final By FIRST_NAME_INPUT_FIELD = By.name("first-name");
    private final By SMART_NET_JOIN_BTN = By.xpath(".//span[@class = 'smart-net-banner__info-button-text']");
    private final By LOGO = By.tagName("img");
    private final By SEARCH_INPUT = By.id("q");

    @Test
    public void firstSeleniumTry() {
        System.setProperty("webdriver.chrome.driver", "/Users/innamisliveca/Downloads/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.get("http://1a.lv");
        //browser.findElement(By.id("top-search-form")).click();
        browser.findElement(SEARCH_INPUT).click();
        browser.findElement(SEARCH_INPUT).sendKeys("Hello world");
        browser.findElement(SEARCH_INPUT).sendKeys(Keys.ENTER);
        //browser.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div[1]/div/a/i")).click();
        //browser.wait(100);
        //browser.close();
    }
}
