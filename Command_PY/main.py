# Інтерфейс команди
class Command:
    def execute(self):
        pass

    def undo(self):
        pass

# Клас для бронювання місця
class BookSeatCommand(Command):
    def __init__(self, seat):
        self.seat = seat

    def execute(self):
        if not self.seat.is_booked:
            self.seat.is_booked = True  # Бронюємо місце
            print(f"Місце {self.seat.seat_number} заброньовано.")
        else:
            print(f"Місце {self.seat.seat_number} вже заброньовано.")

    def undo(self):
        self.seat.is_booked = False  # Скасовуємо бронювання
        print(f"Бронювання місця {self.seat.seat_number} скасовано.")

# Клас для скасування бронювання
class CancelBookingCommand(Command):
    def __init__(self, seat):
        self.seat = seat

    def execute(self):
        if self.seat.is_booked:
            self.seat.is_booked = False  # Скасовуємо бронювання
            print(f"Бронювання місця {self.seat.seat_number} скасовано.")
        else:
            print(f"Місце {self.seat.seat_number} не було заброньовано.")

    def undo(self):
        self.seat.is_booked = True  # Відновлюємо бронювання
        print(f"Місце {self.seat.seat_number} знову заброньовано.")

# Клас місця
class Seat:
    def __init__(self, seat_number):
        self.seat_number = seat_number
        self.is_booked = False

# Клас для виконання команд
class BookingInvoker:
    def __init__(self):
        self.command = None

    def set_command(self, command):
        self.command = command

    def execute_command(self):
        if self.command:
            self.command.execute()  # Виконуємо команду

    def undo_command(self):
        if self.command:
            self.command.undo()  # Скасовуємо команду

# Головна програма
if __name__ == "__main__":
    # Створюємо місця
    seat1 = Seat(1)
    seat2 = Seat(2)

    # Створюємо команди
    book_seat1 = BookSeatCommand(seat1)
    cancel_seat1 = CancelBookingCommand(seat1)
    book_seat2 = BookSeatCommand(seat2)
    cancel_seat2 = CancelBookingCommand(seat2)

    # Створюємо інвокера
    invoker = BookingInvoker()

    # Бронюємо перше місце
    invoker.set_command(book_seat1)
    invoker.execute_command()

    # Скасовуємо бронювання першого місця
    invoker.set_command(cancel_seat1)
    invoker.execute_command()

    # Бронюємо друге місце
    invoker.set_command(book_seat2)
    invoker.execute_command()

    # Скасовуємо бронювання другого місця
    invoker.set_command(cancel_seat2)
    invoker.execute_command()
