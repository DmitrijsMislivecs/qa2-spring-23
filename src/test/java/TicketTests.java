import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TicketTests {
    private final String URL = "http://qaguru.lv:8089/tickets";
    private final String DEPARTURE_AIRPORT = "RIX";
    private final String ARRIVAL_AIRPORT = "MEL";

    private final By FROM_DROPDOWN = By.id("afrom");
    private final By TO_DROPDOWN = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");
    private final By FLIGHT_INFO = By.xpath(".//span[@class = 'bTxt']");
    private final By RESPONSE_WITH_TICKET_PRICE = By.xpath(".//div[@id = 'response']");
    private final By BOOK_BTN = By.xpath(".//span[@id = 'book2']");
    private final By SEAT_NUMBER = By.xpath(".//div[@onclick = 'seat(25)']");
    private final By RESPONSE_WITH_SELECTED_SEAT_NUMBER = By.xpath(".//div[@class = 'line']");
    private final By LAST_BOOK_BTN = By.xpath(".//span[@id = 'book3']");
    private final By FINAL_TXT = By.xpath(".//div[@class = 'finalTxt']");

    private final By SELECTED_AIRPORT = By.xpath(".//span[@class = 'bTxt']");

    private final By GET_PRICE_LINK = By.xpath(".//span[@onclick='setLang();']");

    private final By NAME_INPUT = By.id("name");
    private final By SURNAME_INPUT = By.id("surname");
    private final By DISCOUNT_INPUT = By.id("discount");
    private final By ADULTS_INPUT = By.id("adults");
    private final By CHILDREN_INPUT = By.id("children");
    private final By BUGS_INPUT = By.id("bugs");
    private final By FLIGHT_DROPDOWN = By.id("flight");
    private final String NAME = "MyName";
    private final String SURNAME = "MySurname";
    private final String DISCOUNT = "No";
    private final String ADULTS = "2";
    private final String CHILDREN = "6";
    private final String BUGS = "8";
    private final String NEXT_FLIGHT = "14";

    @Test
    public void successTicketsBookCheck() {
        //Open Browser
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();

        //Open Home Page
        browser.get(URL);

        //Select Departure airport
        WebElement fromDropdown = browser.findElement(FROM_DROPDOWN);
        Select fromSelect = new Select(fromDropdown);
        fromSelect.selectByValue(DEPARTURE_AIRPORT);

        //Select Arrival airport
        WebElement toDropdown = browser.findElement(TO_DROPDOWN);
        Select toSelect = new Select(toDropdown);
        toSelect.selectByValue(ARRIVAL_AIRPORT);

        //Press GoGoGo btn
        browser.findElement(GO_BTN).click();

        //Check if selected airport appears
        List<WebElement> selectedAirports = browser.findElements(SELECTED_AIRPORT);
        System.out.println("First airport: " + selectedAirports.get(0).getText());
        System.out.println("Second airport: " + selectedAirports.get(1).getText());

        //Fill in personal info
        browser.findElement(NAME_INPUT).sendKeys(NAME);
        browser.findElement(SURNAME_INPUT).sendKeys(SURNAME);
        browser.findElement(DISCOUNT_INPUT).sendKeys(DISCOUNT);
        browser.findElement(ADULTS_INPUT).sendKeys(ADULTS);
        browser.findElement(CHILDREN_INPUT).sendKeys(CHILDREN);
        browser.findElement(BUGS_INPUT).sendKeys(BUGS);
        WebElement flightDropdown = browser.findElement(FLIGHT_DROPDOWN);
        Select flightSelect = new Select(flightDropdown);
        flightSelect.selectByValue(NEXT_FLIGHT);

        //Press Get Price link
        browser.findElement(GET_PRICE_LINK).click();

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe(FLIGHT_INFO, 5));

        List<WebElement> flightInfo = browser.findElements(FLIGHT_INFO);
        Assertions.assertEquals(DEPARTURE_AIRPORT, flightInfo.get(0).getText(), "Wrong Departure Airport!");
        Assertions.assertEquals(ARRIVAL_AIRPORT, flightInfo.get(1).getText(), "Wrong Arrival Airport!");

        String name = flightInfo.get(2).getText();
        Assertions.assertEquals(NAME, name.substring(0, name.length() - 1), "Wrong Name!");

        Assertions.assertEquals(DEPARTURE_AIRPORT, flightInfo.get(3).getText(), "Wrong Departure Airport!");
        Assertions.assertEquals(ARRIVAL_AIRPORT, flightInfo.get(4).getText(), "Wrong Arrival Airport!");

        List<WebElement> response = browser.findElements(RESPONSE_WITH_TICKET_PRICE);
        String[] ticketPrice = response.get(0).getText().split(" ");
        Assertions.assertEquals(1160, Integer.valueOf(ticketPrice[10]), "Wrong ticket Price!");

        //Press Book btn
        browser.findElement(BOOK_BTN).click();

        //Select seat number
        wait.until(ExpectedConditions.numberOfElementsToBe(SEAT_NUMBER, 1));

        browser.findElement(SEAT_NUMBER).click();
        List<WebElement> responseWithSeatNumber = browser.findElements(RESPONSE_WITH_SELECTED_SEAT_NUMBER);
        String[] selectedSeatNumber = responseWithSeatNumber.get(0).getText().split(" ");
        Assertions.assertEquals(25, Integer.valueOf(selectedSeatNumber[3]), "Wrong Seat Number!" );

        //Press Book btn
        browser.findElement(LAST_BOOK_BTN).click();

        //Check if successful message appears
        wait.until(ExpectedConditions.numberOfElementsToBe(FINAL_TXT, 1));
        List<WebElement> finalText = browser.findElements(FINAL_TXT);
        Assertions.assertEquals("Thank You for flying with us!", finalText.get(0).getText(),
                "Successefull message is incorrect!");

        //Close Browser
        browser.close();
    }
}
