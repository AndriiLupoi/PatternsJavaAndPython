public class ExternalSeat {
    private String seatId;
    private boolean reserved;

    public ExternalSeat(String seatId) {
        this.seatId = seatId;
        this.reserved = false;
    }

    public String getSeatId() {
        return seatId;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void reserve() {
        this.reserved = true;
    }

    public void release() {
        this.reserved = false;
    }

    @Override
    public String toString() {
        return "ExternalSeat ID: " + seatId + " (" + (reserved ? "Reserved" : "Available") + ")";
    }
}
