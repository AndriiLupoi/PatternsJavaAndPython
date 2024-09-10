import java.util.ArrayList;
import java.util.List;

public class SeatPool {
    private List<Seat> availableSeats;
    private List<Seat> bookedSeats;

    public SeatPool(int numberOfSeats) {
        availableSeats = new ArrayList<>();
        bookedSeats = new ArrayList<>();

        // Ініціалізація пулу з певною кількістю сидінь
        for (int i = 1; i <= numberOfSeats; i++) {
            availableSeats.add(new Seat(i));
        }
    }

    // Метод для отримання доступного місця з пулу
    public Seat acquireSeat() {
        if (!availableSeats.isEmpty()) {
            Seat seat = availableSeats.remove(0);
            bookedSeats.add(seat);
            return seat;
        }
        System.out.println("No available seats.");
        return null;
    }

    // Метод для повернення місця в пул після використання
    public void releaseSeat(Seat seat) {
        if (bookedSeats.contains(seat)) {
            bookedSeats.remove(seat);
            seat.setBooked(false);  // Ресет статусу місця
            availableSeats.add(seat);
        } else {
            System.out.println("This seat is not booked.");
        }
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }
}
