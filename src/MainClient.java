public class MainClient {
    public static void main(String[] args) {
        Client client = new Client("Mattia");
        client.connetti("localhost", 5000);
    }
}