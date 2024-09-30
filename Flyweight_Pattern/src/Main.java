import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Клас MovieTicket, який містить загальний стан (назва фільму та час сеансу)
// Метод equals і hashCode перевизначені для порівняння квитків за спільним станом
class MovieTicket {
    private final String movieTitle;
    private final String showTime;

    // Конструктор MovieTicket
    public MovieTicket(String movieTitle, String showTime) {
        this.movieTitle = movieTitle;
        this.showTime = showTime;
    }

    // Конструктор копіювання для створення нового квитка з існуючим спільним станом
    public MovieTicket(MovieTicket sharedState) {
        this(sharedState.movieTitle, sharedState.showTime);
    }

    // Перевизначення методу toString для зручного відображення інформації про квиток
    @Override
    public String toString() {
        return "(" + movieTitle + ", " + showTime + ")";
    }

    // Перевизначення методу equals для порівняння квитків за спільними даними
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieTicket that = (MovieTicket) o;
        return Objects.equals(movieTitle, that.movieTitle) &&
                Objects.equals(showTime, that.showTime);
    }

    // Перевизначення методу hashCode для правильного хешування об'єктів
    @Override
    public int hashCode() {
        return Objects.hash(movieTitle, showTime);
    }
}

// Клас BookingContext містить унікальний ідентифікатор бронювання та загальний стан квитка
class BookingContext {
    private final String bookingID;
    private final MovieTicket sharedState;

    // Конструктор BookingContext
    public BookingContext(String bookingID, MovieTicket sharedState) {
        this.bookingID = bookingID;
        this.sharedState = sharedState;
    }

    // Метод для зручного відображення бронювання
    @Override
    public String toString() {
        return "Booking ID: " + bookingID + " || Ticket: " + sharedState;
    }
}

// Клас фабрики TicketFlyWeightFactory для створення та керування Flyweight об'єктами
class TicketFlyWeightFactory {
    private final List<MovieTicket> flyweights = new ArrayList<>();

    // Метод для отримання Flyweight квитка або створення нового, якщо він ще не існує
    public MovieTicket getFlyWeight(MovieTicket sharedState) {
        for (MovieTicket ticket : flyweights) {
            if (ticket.equals(sharedState)) {
                return ticket;
            }
        }
        flyweights.add(sharedState);
        return sharedState;
    }

    // Метод для підрахунку загальної кількості унікальних квитків
    public int getTotal() {
        return flyweights.size();
    }
}

// Клас CinemaOrderMarket для створення та зберігання замовлень квитків
class CinemaOrderMarket {
    private final String uniqueState;
    private final MovieTicket sharedState;

    // Конструктор CinemaOrderMarket
    public CinemaOrderMarket(String uniqueState, MovieTicket sharedState) {
        this.uniqueState = uniqueState;
        this.sharedState = sharedState;
    }

    // Метод для створення нового замовлення, використовуючи фабрику Flyweight
    public static CinemaOrderMarket makeCinemaOrder(String uniqueState, MovieTicket sharedState, TicketFlyWeightFactory factory) {
        MovieTicket flyweight = factory.getFlyWeight(sharedState);
        return new CinemaOrderMarket(uniqueState, flyweight);
    }

    // Метод для зручного відображення замовлення
    @Override
    public String toString() {
        return "Order for " + uniqueState + " with ticket: " + sharedState;
    }
}

// Клас для тестування та демонстрації патерну Flyweight
public class Main {
    public static void main(String[] args) {
        TicketFlyWeightFactory flyweightFactory = new TicketFlyWeightFactory();

        // Створення унікальних квитків на фільми з однаковим спільним станом
        MovieTicket ticket1 = new MovieTicket("Avengers", "18:00");
        MovieTicket ticket2 = new MovieTicket("Avengers", "18:00");
        MovieTicket ticket3 = new MovieTicket("Inception", "20:00");

        // Створення замовлень квитків через Flyweight Factory
        CinemaOrderMarket order1 = CinemaOrderMarket.makeCinemaOrder("Order001", ticket1, flyweightFactory);
        CinemaOrderMarket order2 = CinemaOrderMarket.makeCinemaOrder("Order002", ticket2, flyweightFactory);
        CinemaOrderMarket order3 = CinemaOrderMarket.makeCinemaOrder("Order003", ticket3, flyweightFactory);

        // Виведення інформації про замовлення
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);

        // Виведення кількості унікальних квитків
        System.out.println("Total unique tickets: " + flyweightFactory.getTotal());
    }
}
