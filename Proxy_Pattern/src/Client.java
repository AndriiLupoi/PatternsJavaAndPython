import java.time.LocalDateTime;

public class Client {
    private String name;
    private String number;

    public Client(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Client{" + "name='" + name + '\'' + ", number='" + number + '\'' + '}';
    }
}



