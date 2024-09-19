public class StandardSeatImplementor implements SeatImplementor {
    private boolean reserved;

    @Override
    public void reserve() {
        reserved = true;
        System.out.println("Standard seat reserved.");
    }

    @Override
    public void release() {
        reserved = false;
        System.out.println("Standard seat released.");
    }

    @Override
    public boolean isReserved() {
        return reserved;
    }
}
