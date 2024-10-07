from abc import ABC, abstractmethod

# Інтерфейс медіатора, який координує взаємодію між компонентами.
class Mediator(ABC):
    @abstractmethod
    def notify(self, sender: object, event: str) -> None:
        pass

# Конкретний медіатор, який обробляє запити і взаємодію між компонентами системи.
class TicketMediator(Mediator):
    def __init__(self):
        self.user = None
        self.cinema = None
        self.payment_gateway = None

    def set_user(self, user):
        self.user = user

    def set_cinema(self, cinema):
        self.cinema = cinema

    def set_payment_gateway(self, payment_gateway):
        self.payment_gateway = payment_gateway

    # Метод для обробки подій від компонентів
    def notify(self, sender: object, event: str) -> None:
        if isinstance(sender, User) and event == "buy_ticket":
            print("Медіатор: користувач хоче купити квиток.")
            self.cinema.book_seat()
        elif isinstance(sender, Cinema) and event == "seat_booked":
            print("Медіатор: місце заброньовано, обробка платежу.")
            self.payment_gateway.process_payment()
        elif isinstance(sender, PaymentGateway) and event == "payment_processed":
            print("Медіатор: оплата пройшла успішно. Видача квитка.")
            self.user.receive_ticket()


# Базовий клас для компонентів, що взаємодіють через медіатора.
class Component:
    def __init__(self, mediator: Mediator):
        self.mediator = mediator

    def send_event(self, event: str) -> None:
        self.mediator.notify(self, event)

# Клас користувача, що взаємодіє з медіатором для купівлі квитка.
class User(Component):
    def buy_ticket(self):
        print("Користувач: хочу купити квиток.")
        self.send_event("buy_ticket")

    def receive_ticket(self):
        print("Користувач: отримав квиток.")


# Клас кінотеатру, що надає місця для бронювання через медіатора.
class Cinema(Component):
    def book_seat(self):
        print("Кінотеатр: бронювання місця.")
        self.send_event("seat_booked")

# Клас для обробки платежів через медіатора.
class PaymentGateway(Component):
    def process_payment(self):
        print("Платіжна система: обробка платежу.")
        self.send_event("payment_processed")

# Основний клас для запуску системи.
if __name__ == "__main__":
    mediator = TicketMediator()

    user = User(mediator)
    cinema = Cinema(mediator)
    payment_gateway = PaymentGateway(mediator)

    mediator.set_user(user)
    mediator.set_cinema(cinema)
    mediator.set_payment_gateway(payment_gateway)

    # Користувач купує квиток
    user.buy_ticket()
