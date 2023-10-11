package pages;

import model.ReservationInfo;
import org.openqa.selenium.By;

public class PassengerInfoPage {
    private final By FIRTST_NAME_INPUT = By.id("name");
    private final By LAST_NAME_INPUT = By.id("surname");
    private final By DISCOUNT_INPUT = By.id("discount");
    private final By ADULTS_INPUT = By.id("adults");
    private final By CHILDREN_INPUT = By.id("children");
    private final By BAGS_INPUT = By.id("bugs");
    private final By FLIGHT_DROPDOWN = By.id("flight");
    private final By GET_PRICE_LINK = By.xpath(".//span[@onclick='setLang();']");
    private final By BOOK_BTN = By.xpath(".//span[@id = 'book2']");


    private BaseFunc baseFunc;

    public PassengerInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void fillInPassengerInfo(ReservationInfo reservationInfo) {
        baseFunc.type(FIRTST_NAME_INPUT, reservationInfo.getFirstName());
        baseFunc.type(LAST_NAME_INPUT, reservationInfo.getLastName());
        baseFunc.type(DISCOUNT_INPUT, reservationInfo.getDiscount());
        baseFunc.type(ADULTS_INPUT, reservationInfo.getPassengerCount());
        baseFunc.type(CHILDREN_INPUT, reservationInfo.getChildCount());
        baseFunc.type(BAGS_INPUT, reservationInfo.getBagsCount());
        baseFunc.selectByText(FLIGHT_DROPDOWN, reservationInfo.getFlightDate());
    }

    public void clickGetPriceLink() {
        baseFunc.click(GET_PRICE_LINK);
    }

    public void clickBookBtn() {
        baseFunc.click(BOOK_BTN);
    }
}
