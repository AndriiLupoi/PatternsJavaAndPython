//public class SeatAdapter implements Seat {
//    private ExternalSeat externalSeat;
//
//    public SeatAdapter(ExternalSeat externalSeat) {
//        this.externalSeat = externalSeat;
//    }
//
//    @Override
//    public boolean isBooked() {
//        return externalSeat.isReserved();
//    }
//
//    @Override
//    public void setBooked(boolean booked) {
//        if (booked) {
//            externalSeat.reserve();
//        } else {
//            externalSeat.release();
//        }
//    }
//
//    @Override
//    public String toString() {
//        return externalSeat.toString();
//    }
//}
