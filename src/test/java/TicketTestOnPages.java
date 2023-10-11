import pages.BaseFunc;
import pages.HomePage;
import pages.PassengerInfoPage;
import pages.SelectSeatNumberPage;
import model.ReservationInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TicketTestOnPages {
    private final String URL = "qaguru.lv:8089/tickets";
    private final String DEPARTURE_AIRPORT = "RIX";
    private final String ARRIVAL_AIRPORT = "MEL";
    private ReservationInfo info = new ReservationInfo("Dimis", "Toster", "AAAAAA", 7,
            5, 8, "11-05-2018");
    private final By FLIGHT_INFO = By.xpath(".//span[@class = 'bTxt']");
    private final By RESPONSE_WITH_TICKET_PRICE = By.xpath(".//div[@id = 'response']");
    private final By RESPONSE_WITH_SELECTED_SEAT_NUMBER = By.xpath(".//div[@class = 'line']");
    private final By FINAL_TXT = By.xpath(".//div[@class = 'finalTxt']");


    @Test
    public void successTicketsBookCheck() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.selectDepartureAirport(DEPARTURE_AIRPORT);
        homePage.selectArrivalAirport(ARRIVAL_AIRPORT);
        homePage.clickGoGoGoBtn();

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        infoPage.fillInPassengerInfo(info);
        infoPage.clickGetPriceLink();

        baseFunc.waitForElementsToBe(FLIGHT_INFO, 5);
        List<WebElement> flightInfo = baseFunc.findElements(FLIGHT_INFO);
        Assertions.assertEquals(DEPARTURE_AIRPORT, flightInfo.get(0).getText(), "Wrong Departure Airport!");
        Assertions.assertEquals(ARRIVAL_AIRPORT, flightInfo.get(1).getText(), "Wrong Arrival Airport!");

        String name = flightInfo.get(2).getText();
        Assertions.assertEquals(info.getFirstName(), name.substring(0, name.length() - 1), "Wrong Name!");

        Assertions.assertEquals(DEPARTURE_AIRPORT, flightInfo.get(3).getText(), "Wrong Departure Airport!");
        Assertions.assertEquals(ARRIVAL_AIRPORT, flightInfo.get(4).getText(), "Wrong Arrival Airport!");

        List<WebElement> response = baseFunc.findElements(RESPONSE_WITH_TICKET_PRICE);
        String[] ticketPrice = response.get(0).getText().split(" ");
        Assertions.assertEquals(1160, Integer.valueOf(ticketPrice[10]), "Wrong ticket Price!");

        infoPage.clickBookBtn();

        SelectSeatNumberPage seatNumberPage = new SelectSeatNumberPage(baseFunc);
        seatNumberPage.selectSeatNumber();
        seatNumberPage.clickBookBtn();

        List<WebElement> responseWithSeatNumber = baseFunc.findElements(RESPONSE_WITH_SELECTED_SEAT_NUMBER);
        String[] selectedSeatNumber = responseWithSeatNumber.get(0).getText().split(" ");
        Assertions.assertEquals(25, Integer.valueOf(selectedSeatNumber[3]), "Wrong Seat Number!" );

        baseFunc.waitForElementsToBe(FINAL_TXT, 1);
        List<WebElement> finalText = baseFunc.findElements(FINAL_TXT);
        Assertions.assertEquals("Thank You for flying with us!", finalText.get(0).getText(),
                "Successful message is incorrect!");

        baseFunc.closeBrowser();
    }
}
