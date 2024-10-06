// Інтерфейс команди
interface Command {
    void execute(); // Метод для виконання команди
    void undo();    // Метод для скасування команди
}

// Клас для бронювання місця
class BookSeatCommand implements Command {
    private Seat seat;

    public BookSeatCommand(Seat seat) {
        this.seat = seat;
    }

    @Override
    public void execute() {
        if (!seat.isBooked()) {
            seat.setBooked(true); // Бронюємо місце
            System.out.println("Місце " + seat.getSeatNumber() + " заброньовано.");
        } else {
            System.out.println("Місце " + seat.getSeatNumber() + " вже заброньовано.");
        }
    }

    @Override
    public void undo() {
        seat.setBooked(false); // Скасовуємо бронювання
        System.out.println("Бронювання місця " + seat.getSeatNumber() + " скасовано.");
    }
}

// Клас для скасування бронювання
class CancelBookingCommand implements Command {
    private Seat seat;

    public CancelBookingCommand(Seat seat) {
        this.seat = seat;
    }

    @Override
    public void execute() {
        if (seat.isBooked()) {
            seat.setBooked(false); // Скасовуємо бронювання
            System.out.println("Бронювання місця " + seat.getSeatNumber() + " скасовано.");
        } else {
            System.out.println("Місце " + seat.getSeatNumber() + " не було заброньовано.");
        }
    }

    @Override
    public void undo() {
        seat.setBooked(true); // Відновлюємо бронювання
        System.out.println("Місце " + seat.getSeatNumber() + " знову заброньовано.");
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
}

// Клас для виконання команд
class BookingInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        if (command != null) {
            command.execute(); // Виконуємо команду
        }
    }

    public void undoCommand() {
        if (command != null) {
            command.undo(); // Скасовуємо команду
        }
    }
}

// Головний клас
public class Main {
    public static void main(String[] args) {
        // Створюємо місця
        Seat seat1 = new Seat(1);
        Seat seat2 = new Seat(2);

        // Створюємо команди
        Command bookSeat1 = new BookSeatCommand(seat1);
        Command cancelSeat1 = new CancelBookingCommand(seat1);
        Command bookSeat2 = new BookSeatCommand(seat2);
        Command cancelSeat2 = new CancelBookingCommand(seat2);

        // Створюємо інвокера
        BookingInvoker invoker = new BookingInvoker();

        // Бронюємо перше місце
        invoker.setCommand(bookSeat1);
        invoker.executeCommand();

        // Скасовуємо бронювання першого місця
        invoker.setCommand(cancelSeat1);
        invoker.executeCommand();

        // Бронюємо друге місце
        invoker.setCommand(bookSeat2);
        invoker.executeCommand();

        // Відновлюємо бронювання другого місця
        invoker.setCommand(cancelSeat2);
        invoker.executeCommand();
    }
}
