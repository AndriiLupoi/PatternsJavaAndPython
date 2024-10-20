from abc import ABC, abstractmethod

# Інтерфейс стратегії
class PaymentStrategy(ABC):
    @abstractmethod
    def pay(self, amount):
        pass

# Конкретна стратегія: Оплата карткою
class CreditCardPayment(PaymentStrategy):
    def __init__(self, card_number):
        self.card_number = card_number

    def pay(self, amount):
        print(f"Оплачено {amount} грн через картку. Номер картки: {self.card_number}")

# Конкретна стратегія: Оплата через PayPal
class PayPalPayment(PaymentStrategy):
    def __init__(self, email):
        self.email = email

    def pay(self, amount):
        print(f"Оплачено {amount} грн через PayPal. Email: {self.email}")

# Контекст: Замовлення
class Booking:
    def __init__(self):
        self.payment_strategy = None

    def set_payment_strategy(self, payment_strategy):
        self.payment_strategy = payment_strategy

    def process_payment(self, amount):
        if self.payment_strategy:
            self.payment_strategy.pay(amount)
        else:
            print("Не вибрано стратегію оплати.")

# Головний клас
if __name__ == "__main__":
    booking = Booking()

    # Використання стратегії оплати карткою
    booking.set_payment_strategy(CreditCardPayment("1234-5678-9876-5432"))
    booking.process_payment(200.0)

    # Використання стратегії оплати через PayPal
    booking.set_payment_strategy(PayPalPayment("user@example.com"))
    booking.process_payment(350.0)
