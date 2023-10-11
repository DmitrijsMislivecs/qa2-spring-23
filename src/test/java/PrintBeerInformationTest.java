import model.Beer;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class PrintBeerInformationTest {
    @Test
    public void CreateNewBeerObject() {
        Beer beer = new Beer();

        beer.setManufacturer("Aldaris");
        beer.setName("Premium");
        beer.setType("Brown");
        beer.setVolume(0.7F);
        beer.setTare("Bottle");
        beer.setAlcohol(7);
        beer.setBestBeforeDate(new Date(2023, 12, 25));

        beer.showBeerInformation();
    }
}
