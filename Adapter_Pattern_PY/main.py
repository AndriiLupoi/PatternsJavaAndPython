class ExternalSeat:
    def __init__(self, seat_id):
        self.seat_id = seat_id
        self.reserved = False

    def reserve(self):
        self.reserved = True
        print(f"External seat {self.seat_id} reserved.")

    def release(self):
        self.reserved = False
        print(f"External seat {self.seat_id} released.")

    def is_reserved(self):
        return self.reserved

class Seat:
    def reserve(self):
        raise NotImplementedError

    def release(self):
        raise NotImplementedError

    def is_reserved(self):
        raise NotImplementedError

class ExternalSeatAdapter(Seat):
    def __init__(self, external_seat):
        self.external_seat = external_seat

    def reserve(self):
        self.external_seat.reserve()

    def release(self):
        self.external_seat.release()

    def is_reserved(self):
        return self.external_seat.is_reserved()

def main():
    # Використання адаптера для зовнішнього місця
    external_seat = ExternalSeat("E100")
    seat_adapter = ExternalSeatAdapter(external_seat)

    seat_adapter.reserve()   # Бронювання зовнішнього місця
    print(f"Seat reserved: {seat_adapter.is_reserved()}")
    seat_adapter.release()   # Вивільнення зовнішнього місця
    print(f"Seat reserved: {seat_adapter.is_reserved()}")

if __name__ == "__main__":
    main()
