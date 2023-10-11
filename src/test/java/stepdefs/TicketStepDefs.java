package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.be.I;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.tickets.Flight;
import model.tickets.Passenger;
import model.tickets.Reservation;
import org.junit.jupiter.api.Assertions;
import pages.BaseFunc;
import pages.HomePage;
import pages.PassengerInfoPage;
import requesters.TickerRequester;

import java.util.List;
import java.util.Map;

public class TicketStepDefs {
    private Passenger passenger = new Passenger();
    private Flight flight = new Flight();
    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage;
    private PassengerInfoPage passengerInfoPage;
    private List<Reservation> reservations;
    private Reservation reservationFromApi;

    @Given("airports:")
    public void set_airports(Map<String, String> params) {
        flight.setDeparture(params.get("from"));
        flight.setArrival(params.get("to"));
    }

    @Given("passenger info is:")
    public void set_passenger_info(Map<String, String> params) {
        passenger.setFirstName(params.get("first_name"));
        passenger.setLastName(params.get("last_name"));
    }

    @Given("flight info is:")
    public void set_flight_info(Map<String, String> params) {
        flight.setDiscount(params.get("discount"));
        flight.setPassengersCount(Integer.parseInt(params.get("passenger_count")));
        flight.setChildCount(Integer.parseInt(params.get("child_count")));
        flight.setLuggageCount(Integer.parseInt(params.get("luggage_count")));
        flight.setFlightDate(params.get("flight_date"));
        flight.setSeatNr(Integer.parseInt(params.get("seat_number")));
    }

    @Given("home page is opened")
    public void open_home_page() {
        baseFunc.openUrl("qaguru.lv:8089/tickets");
        homePage = new HomePage(baseFunc);
    }

    @When("we are selecting airports")
    public void select_airports() {
        homePage.selectDepartureAirport(flight.getDeparture());
        homePage.selectArrivalAirport(flight.getArrival());
        homePage.clickGoGoGoBtn();
        passengerInfoPage = new PassengerInfoPage(baseFunc);
    }

    @Then("selected airport appears on the passenger info page")
    public void selected_airports_on_info_page() {
        //Ass
    }

    @When("we are requesting all reservation via API")
    public void request_all_reservation() throws JsonProcessingException {
        TickerRequester requester = new TickerRequester();
        reservations = requester.getReservations();
    }

    @Then("current reservation exists in the list")
    public void find_reservation() {
        for (Reservation reservation : reservations) {
            if (reservation.getName().equals(passenger.getFirstName())) {
                reservationFromApi = reservation;
                break;
            }
        }
        Assertions.assertNotNull(reservationFromApi, "Can't find reservation!");
    }

    @Then("all data are stored corrected")
    public void check_reservation_data() {
        Assertions.assertEquals(passenger.getLastName(), reservationFromApi.getSurname(), "Wrong Last name!");
        Assertions.assertEquals(flight.getSeatNr(), reservationFromApi.getSeat(), "Wrong Seat Nr!");

    }
}
