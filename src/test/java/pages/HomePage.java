package pages;

import org.openqa.selenium.By;

public class HomePage {
    private final By DEPARTURE_DROPDOWN = By.id("afrom");
    private final By ARRIVAL_DROPDOWN = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");


    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectDepartureAirport(String airport){
        baseFunc.selectByValue(DEPARTURE_DROPDOWN, airport);
    }

    public void selectArrivalAirport(String airport){
        baseFunc.selectByValue(ARRIVAL_DROPDOWN, airport);
    }

    public void clickGoGoGoBtn() {
        baseFunc.click(GO_BTN);
    }
}
