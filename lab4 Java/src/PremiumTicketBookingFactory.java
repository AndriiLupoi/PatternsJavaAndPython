import java.time.LocalDateTime;

public class PremiumTicketBookingFactory implements TicketBookingFactory {

    @Override
    public Client createClient(String name, String number) {
        return new VIPClient(name, number);
    }

    @Override
    public Movie createMovie(String title, String genre, LocalDateTime appointmentTime) {
        return new PremiumMovie(title, genre, appointmentTime);
    }

    @Override
    public Seat createSeat(int seatNumber) {
        return new PremiumSeat(seatNumber);
    }
}
