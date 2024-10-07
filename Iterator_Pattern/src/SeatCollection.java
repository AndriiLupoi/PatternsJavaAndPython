import java.util.ArrayList;
import java.util.List;

// Колекція місць, яка підтримує ітерацію
public class SeatCollection implements IterableCollection<Seat> {
    private List<Seat> seats;

    public SeatCollection() {
        this.seats = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        seats.add(seat);  // Додаємо нове місце до колекції
    }

    @Override
    public Iterator<Seat> createIterator() {
        return new SeatIterator(seats);  // Створюємо ітератор для списку місць
    }
}
