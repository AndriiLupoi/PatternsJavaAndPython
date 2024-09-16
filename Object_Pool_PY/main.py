from datetime import datetime, timedelta

class Seat:
    def __init__(self, seat_number):
        self.seat_number = seat_number
        self.is_booked = False

    def set_booked(self, booked):
        self.is_booked = booked

    def __str__(self):
        booking_status = "Booked" if self.is_booked else "Available"
        return f"Seat Number: {self.seat_number} ({booking_status})"

    def __repr__(self):
        return f"Seat({self.seat_number})"


class SeatPool:
    def __init__(self, number_of_seats):
        self.available_seats = [Seat(i) for i in range(1, number_of_seats + 1)]
        self.booked_seats = []

    def acquire_seat(self):
        if self.available_seats:
            seat = self.available_seats.pop(0)
            self.booked_seats.append(seat)
            return seat
        print("No available seats.")
        return None

    def release_seat(self, seat):
        if seat in self.booked_seats:
            self.booked_seats.remove(seat)
            seat.set_booked(False)  # Reset seat status
            self.available_seats.append(seat)
        else:
            print("This seat is not booked.")

    def get_available_seats(self):
        return self.available_seats

    def get_booked_seats(self):
        return self.booked_seats

class Client:
    def __init__(self, name, number):
        self.name = name
        self.number = number

    def __str__(self):
        return f"Client{{name='{self.name}', number='{self.number}'}}"

class Movie:
    def __init__(self, title, genre, appointment_time):
        self.title = title
        self.genre = genre
        self.appointment_time = appointment_time

    def __str__(self):
        return f"Movie{{title='{self.title}', genre='{self.genre}', showTime={self.appointment_time}}}"

class Order:
    def __init__(self, client, movie, seat):
        self.client = client
        self.movie = movie
        self.seat = seat

    def __str__(self):
        return (f"Order Details: \n"
                f"Client: {self.client}\n"
                f"Movie: {self.movie}\n"
                f"Seat: {self.seat}\n"
                f"-------------------------------")

# Main logic
if __name__ == "__main__":
    # Ініціалізація пулу місць
    seat_pool = SeatPool(10)

    # Створюємо клієнтів і фільми
    client1 = Client("Volodya", "228")
    client2 = Client("Petya", "822")

    movie1 = Movie("Titanic", "Drama", datetime.now() + timedelta(hours=4))
    movie2 = Movie("Avatar", "Sci-Fi", datetime.now() + timedelta(hours=6))

    # Бронювання місць через Object Pool
    seat1 = seat_pool.acquire_seat()
    if seat1 is not None:
        seat1.set_booked(True)
        order1 = Order(client1, movie1, seat1)
        print(order1)

    seat2 = seat_pool.acquire_seat()
    if seat2 is not None:
        seat2.set_booked(True)
        order2 = Order(client2, movie2, seat2)
        print(order2)

    # Повертаємо місця в пул після використання
    seat_pool.release_seat(seat1)
    seat_pool.release_seat(seat2)

    print("Available seats after release:", seat_pool.get_available_seats())
