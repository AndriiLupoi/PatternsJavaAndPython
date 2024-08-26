public class Client {
    private String name;
    private String number;

    public Client(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Client{" + "name='" + name + '\'' + ", number='" + number + '\'' + '}';
    }

}
