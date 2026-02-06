import java.io.IOException;
import java.net.Socket;

public class Client {
    private String nome;
    private String colore;
    private Socket socket;

    public Client(String nome, String colore) {
        this.nome = nome;
        this.colore = colore;
    }

    public Client(String nome) {
        this.nome = nome;
    }

    public int connetti(String nomeServer, int portaServer) {
        try {
            socket = new Socket(nomeServer, portaServer);
            System.out.println("Connessione al server riuscita");
            return 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
