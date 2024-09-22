import java.util.ArrayList;
import java.util.List;

// Композит (група місць)
// Представляє групу місць і дозволяє бронювати або вивільняти всі місця в групі
class SeatGroup implements SeatComponent {
    private List<SeatComponent> seats = new ArrayList<>();  // Список компонентів (окремих місць або інших груп)

    // Додає місце в групу
    public void addSeat(SeatComponent seat) {
        seats.add(seat);
    }

    // Видаляє місце з групи
    public void removeSeat(SeatComponent seat) {
        seats.remove(seat);
    }

    // Метод для бронювання всіх місць у групі
    @Override
    public void reserve() {
        for (SeatComponent seat : seats) {
            seat.reserve();  // Бронюємо кожне місце окремо
        }
        System.out.println("Група місць заброньована.");
    }

    // Метод для вивільнення всіх місць у групі
    @Override
    public void release() {
        for (SeatComponent seat : seats) {
            seat.release();  // Вивільняємо кожне місце окремо
        }
        System.out.println("Група місць вивільнена.");
    }

    // Метод для перевірки, чи заброньовані всі місця в групі
    @Override
    public boolean isReserved() {
        for (SeatComponent seat : seats) {
            if (!seat.isReserved()) {  // Якщо хоча б одне місце не заброньоване, група не заброньована повністю
                return false;
            }
        }
        return true;  // Якщо всі місця заброньовані, група вважається заброньованою
    }
}
