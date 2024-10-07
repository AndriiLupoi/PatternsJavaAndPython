import java.util.List;

// Реалізація ітератора для списку місць
public class SeatIterator implements Iterator<Seat> {
    private List<Seat> seats;  // Список місць
    private int position = 0;  // Поточна позиція

    public SeatIterator(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public boolean hasNext() {
        return position < seats.size();  // Перевіряє, чи є наступний елемент у списку
    }

    @Override
    public Seat next() {
        return seats.get(position++);  // Повертає наступний елемент і збільшує позицію
    }
}
