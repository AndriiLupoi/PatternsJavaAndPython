public class VIPClient implements Client {
    private String name;
    private String number;

    public VIPClient(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "VIPClient{" + "name='" + name + '\'' + ", number='" + number + '\'' + '}';
    }
}
