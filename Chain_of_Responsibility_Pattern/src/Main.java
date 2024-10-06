// Абстрактний клас для обробників
abstract class BookingHandler {
    protected BookingHandler nextHandler;

    public void setNextHandler(BookingHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(Client client, Movie movie, Seat seat);
}

// Конкретний обробник для перевірки наявності місця
class AvailabilityHandler extends BookingHandler {
    @Override
    public void handleRequest(Client client, Movie movie, Seat seat) {
        if (!seat.isBooked()) {
            System.out.println("Місце доступне для бронювання.");
            seat.setBooked(true);  // Бронюємо місце
        } else {
            System.out.println("Місце вже заброньоване.");
        }

        // Передаємо запит далі в ланцюжку, якщо є наступний обробник
        if (nextHandler != null) {
            nextHandler.handleRequest(client, movie, seat);
        }
    }
}

// Конкретний обробник для перевірки ролі користувача
class RoleCheckHandler extends BookingHandler {
    @Override
    public void handleRequest(Client client, Movie movie, Seat seat) {
        if (client.isAdmin()) {
            System.out.println("Адміністратор може бронювати будь-яке місце.");
        } else {
            System.out.println("Перевірка звичайного користувача. Користувач не може змінити вже заброньоване місце.");
        }

        if (nextHandler != null) {
            nextHandler.handleRequest(client, movie, seat);
        }
    }
}

// Клас клієнта
class Client {
    private String name;
    private String number;
    private boolean isAdmin;

    public Client(String name, String number, boolean isAdmin) {
        this.name = name;
        this.number = number;
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return "Client{" + "name='" + name + '\'' + ", number='" + number + '\'' + ", isAdmin=" + isAdmin + '}';
    }
}

// Клас місця
class Seat {
    private int seatNumber;
    private boolean isBooked;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return "Seat{" + "seatNumber=" + seatNumber + ", isBooked=" + isBooked + '}';
    }
}

// Клас фільму
class Movie {
    private String title;
    private String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" + "title='" + title + '\'' + ", genre='" + genre + '\'' + '}';
    }
}

// Головний клас
public class Main {
    public static void main(String[] args) {
        // Створюємо клієнтів та фільми
        Client client1 = new Client("Volodya", "228", true);  // Адміністратор
        Client client2 = new Client("Petya", "822", false);   // Звичайний користувач

        Movie movie1 = new Movie("Titanic", "Драма");
        Movie movie2 = new Movie("Avatar", "Наукова фантастика");

        // Створюємо місця
        Seat seat1 = new Seat(1);
        Seat seat2 = new Seat(2);

        // Створюємо обробники
        AvailabilityHandler availabilityHandler = new AvailabilityHandler();
        RoleCheckHandler roleCheckHandler = new RoleCheckHandler();

        // Формуємо ланцюжок обробників
        availabilityHandler.setNextHandler(roleCheckHandler);

        // Обробляємо бронювання
        System.out.println("Бронювання клієнтом 1:");
        availabilityHandler.handleRequest(client1, movie1, seat1);

        System.out.println("\nБронювання клієнтом 2:");
        availabilityHandler.handleRequest(client2, movie2, seat1);  // Спроба бронювати вже зайняте місце
    }
}
