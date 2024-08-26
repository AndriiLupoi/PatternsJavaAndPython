class ClientFactory {
    public Client createClient(String name, String number) {
        return new Client(name, number);
    }
}