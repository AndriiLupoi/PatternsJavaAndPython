import java.time.LocalDateTime;

public class RegularTicketBookingFactory implements TicketBookingFactory {

    @Override
    public Client createClient(String name, String number) {
        return new RegularClient(name, number);
    }

    @Override
    public Movie createMovie(String title, String genre, LocalDateTime appointmentTime) {
        return new RegularMovie(title, genre, appointmentTime);
    }

    @Override
    public Seat createSeat(int seatNumber) {
        return new RegularSeat(seatNumber);
    }
}
