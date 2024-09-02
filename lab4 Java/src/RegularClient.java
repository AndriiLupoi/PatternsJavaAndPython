public class RegularClient implements Client {
    private String name;
    private String number;

    public RegularClient(String name, String number) {
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
        return "RegularClient{" + "name='" + name + '\'' + ", number='" + number + '\'' + '}';
    }
}
