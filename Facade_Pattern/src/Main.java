import java.util.HashMap;
import java.util.Map;

// Enum для типів фільмів
enum MovieType {
    ACTION, COMEDY, DRAMA
}

// Інтерфейс для фільму
interface IMovie {
    String getMovieName();
}


// Реалізація для екшн-фільму
class ActionMovie implements IMovie {
    @Override
    public String getMovieName() {
        return "Action Movie";  // Назва фільму
    }
}

// Реалізація для комедії
class ComedyMovie implements IMovie {
    @Override
    public String getMovieName() {
        return "Comedy Movie";  // Назва фільму
    }
}

// Реалізація для драми
class DramaMovie implements IMovie {
    @Override
    public String getMovieName() {
        return "Drama Movie";  // Назва фільму
    }
}

// Інтерфейс для клієнта
interface ICustomer {
    void requestMovie(IMovie movie);
    Map<Integer, String> selectSeats();
    void watchMovie();
    String getName();
}

// Клас для керування квитками
class TicketingSystem {
    void bookTickets() {
        System.out.println("The tickets are being booked");
    }

    void confirmBooking() {
        System.out.println("Booking confirmed");
    }
}

// Клас для керування клієнтами та квитками
class Clerk {
    void acceptBooking(ICustomer customer) {
        System.out.println("Clerk accepted the booking from " + customer.getName());
    }

    void processBooking() {
        System.out.println("Processing booking in the system");
    }

    void deliverTickets(ICustomer customer) {
        System.out.println("Tickets are ready, delivering to the customer " + customer.getName());
    }
}

// Реалізація клієнта
class Customer implements ICustomer {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void requestMovie(IMovie movie) {
        System.out.println("Customer " + name + " checks the details of " + movie.getMovieName());
    }

    @Override
    public Map<Integer, String> selectSeats() {
        System.out.println("Customer " + name + " selects seats");
        Map<Integer, String> seats = new HashMap<>();
        seats.put(1, "A1");
        seats.put(2, "A2");
        return seats;
    }

    @Override
    public void watchMovie() {
        System.out.println("Customer " + name + " starts watching the movie");
    }

    @Override
    public String getName() {
        return name;
    }
}

// Фасад для кінотеатру
class CinemaFacade {
    private final TicketingSystem ticketingSystem;
    private final Clerk clerk;
    private final Map<MovieType, IMovie> movies;

    public CinemaFacade() {
        this.ticketingSystem = new TicketingSystem();
        this.clerk = new Clerk();
        this.movies = new HashMap<>();
        movies.put(MovieType.ACTION, new ActionMovie());
        movies.put(MovieType.COMEDY, new ComedyMovie());
        movies.put(MovieType.DRAMA, new DramaMovie());
    }

    // Отримати фільм за його типом
    public IMovie getMovie(MovieType type) {
        return movies.get(type);
    }

    // Бронювання квитків
    public void bookTickets(ICustomer customer) {
        clerk.acceptBooking(customer);
        clerk.processBooking();
        ticketingSystemWork();
        clerk.deliverTickets(customer);
    }

    // Процес роботи системи бронювання
    private void ticketingSystemWork() {
        ticketingSystem.bookTickets();
        ticketingSystem.confirmBooking();
    }
}

// Тестовий клас для демонстрації патерну фасад
public class Main {
    public static void main(String[] args) {
        CinemaFacade cinema = new CinemaFacade();
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        customer1.requestMovie(cinema.getMovie(MovieType.ACTION));
        cinema.bookTickets(customer1);

        customer2.requestMovie(cinema.getMovie(MovieType.COMEDY));
        cinema.bookTickets(customer2);

        customer1.watchMovie();
        customer2.watchMovie();
    }
}
