import java.util.ArrayList;
import java.util.List;

// Клас Caretaker зберігає об'єкти Memento
public class Caretaker {
    private List<BookingMemento> mementoList = new ArrayList<>();

    public void add(BookingMemento state) {
        mementoList.add(state);
    }

    public BookingMemento get(int index) {
        return mementoList.get(index);
    }
}
