# Інтерфейс стану
from abc import ABC, abstractmethod

class BookingState(ABC):
    @abstractmethod
    def handle(self, context):
        pass

# Конкретний стан: Створено
class CreatedState(BookingState):
    def handle(self, context):
        print("Замовлення створено. Очікує на оплату.")
        context.set_state(PaidState())  # Перехід до стану "Оплачено"

# Конкретний стан: Оплачено
class PaidState(BookingState):
    def handle(self, context):
        print("Замовлення оплачено. Місця заброньовані.")
        context.set_state(CancelledState())  # Перехід до стану "Скасовано"

# Конкретний стан: Скасовано
class CancelledState(BookingState):
    def handle(self, context):
        print("Замовлення скасовано. Кошти повернуто.")

# Контекст замовлення
class BookingContext:
    def __init__(self):
        self.state = CreatedState()  # Початковий стан

    def set_state(self, state):
        self.state = state

    def proceed(self):
        self.state.handle(self)

# Головний клас
if __name__ == "__main__":
    # Створення нового контексту замовлення
    booking = BookingContext()

    # Перехід через стани
    booking.proceed()  # Створено
    booking.proceed()  # Оплачено
    booking.proceed()  # Скасовано
