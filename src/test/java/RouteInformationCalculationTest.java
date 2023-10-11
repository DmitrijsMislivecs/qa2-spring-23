import model.Airplane;
import model.Car;
import model.Route;
import model.Train;
import org.junit.jupiter.api.Test;

public class RouteInformationCalculationTest {
    @Test
    public void RequiredAmountOfFuelСalculation() {
        Airplane airplane = new Airplane();
        Train train = new Train();
        Car car = new Car();
        Route route = new Route();

        airplane.setFuelConsumption(75L);
        train.setFuelConsumption(40L);
        car.setFuelConsumption(9L);
        route.setDistanceBetweenTwoPoints(1250);

        System.out.println("Required amount of fuel for the: \nAirplane: " +
                route.getDistanceBetweenTwoPoints() * airplane.getFuelConsumption() / 100 + " l.");
        System.out.println("Train: " + route.getDistanceBetweenTwoPoints() *
                train.getFuelConsumption() / 100 + " l.");
        System.out.println("Car: " + route.getDistanceBetweenTwoPoints() * car.getFuelConsumption() / 100 + " l.");
    }
}
