import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Use RegularTicketBookingFactory
        TicketBookingFactory regularFactory = new RegularTicketBookingFactory();
        Client regularClient = regularFactory.createClient("Volodya", "228");
        Movie regularMovie = regularFactory.createMovie("Titanic", "Drama", LocalDateTime.now().plusHours(4));
        Seat regularSeat = regularFactory.createSeat(10);

        System.out.println("Regular Booking:");
        System.out.println(regularClient);
        System.out.println(regularMovie);
        System.out.println(regularSeat);

        // Use PremiumTicketBookingFactory
        TicketBookingFactory premiumFactory = new PremiumTicketBookingFactory();
        Client vipClient = premiumFactory.createClient("Petya", "822");
        Movie premiumMovie = premiumFactory.createMovie("Avatar", "Sci-Fi", LocalDateTime.now().plusHours(6));
        Seat premiumSeat = premiumFactory.createSeat(1);

        System.out.println("\nPremium Booking:");
        System.out.println(vipClient);
        System.out.println(premiumMovie);
        System.out.println(premiumSeat);
    }
}
