public class Client implements TickedBookingSystemPrototype {
    private String name;
    private String number;

    public Client(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public Client clone() {
        return new Client(this.name, this.number);
    }

    @Override
    public String toString() {
        return "Client{" + "name='" + name + '\'' + ", number='" + number + '\'' + '}'+"\n";
    }
}
