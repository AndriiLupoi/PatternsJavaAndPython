// Контекст замовлення
public class BookingContext {
    private BookingState state;

    public BookingContext() {
        state = new CreatedState();  // Початковий стан
    }

    public void setState(BookingState state) {
        this.state = state;
    }

    public void proceed() {
        state.handle(this);
    }
}
