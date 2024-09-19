class SeatImplementor:
    def reserve(self):
        raise NotImplementedError

    def release(self):
        raise NotImplementedError

    def is_reserved(self):
        raise NotImplementedError


class ExternalSeat:
    def __init__(self, seat_id):
        self.seat_id = seat_id
        self.reserved = False

    def reserve(self):
        self.reserved = True
        print(f"Зовнішнє місце {self.seat_id} заброньовано.")

    def release(self):
        self.reserved = False
        print(f"Зовнішнє місце {self.seat_id} вивільнено.")

    def is_reserved(self):
        return self.reserved


class StandardSeatImplementor(SeatImplementor):
    def __init__(self):
        self.reserved = False

    def reserve(self):
        self.reserved = True
        print("Стандартне місце заброньовано.")

    def release(self):
        self.reserved = False
        print("Стандартне місце вивільнено.")

    def is_reserved(self):
        return self.reserved


class ExternalSeatImplementor(SeatImplementor):
    def __init__(self, external_seat):
        self.external_seat = external_seat

    def reserve(self):
        self.external_seat.reserve()

    def release(self):
        self.external_seat.release()

    def is_reserved(self):
        return self.external_seat.is_reserved()


class SeatBooking:
    def __init__(self, implementor):
        self.implementor = implementor

    def book_seat(self):
        self.implementor.reserve()

    def release_seat(self):
        self.implementor.release()


def main():
    # Використання стандартного місця
    standard_seat = StandardSeatImplementor()
    booking = SeatBooking(standard_seat)

    booking.book_seat()  # Бронюємо стандартне місце
    booking.release_seat()  # Вивільняємо стандартне місце

    # Використання зовнішнього місця через реалізацію мосту
    external_seat = ExternalSeat("E200")
    external_seat_impl = ExternalSeatImplementor(external_seat)
    external_booking = SeatBooking(external_seat_impl)

    external_booking.book_seat()  # Бронюємо зовнішнє місце
    external_booking.release_seat()  # Вивільняємо зовнішнє місце


if __name__ == "__main__":
    main()
