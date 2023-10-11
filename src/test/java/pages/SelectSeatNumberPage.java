package pages;

import org.openqa.selenium.By;

public class SelectSeatNumberPage {

    private final By SEAT_NUMBER = By.xpath(".//div[@onclick = 'seat(25)']");
    private final By LAST_BOOK_BTN = By.xpath(".//span[@id = 'book3']");


    private BaseFunc baseFunc;

    public SelectSeatNumberPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectSeatNumber() {
        baseFunc.findElement(SEAT_NUMBER).click();
    }

    public void clickBookBtn() {
        baseFunc.findElement(LAST_BOOK_BTN).click();
    }


}
