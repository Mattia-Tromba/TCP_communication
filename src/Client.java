import java.io.*;
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

    public void connetti(String nomeServer, int portaServer) {
        try {
            socket = new Socket(nomeServer, portaServer);
            System.out.println("Connessione al server riuscita");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrivi (String message){
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);
            pw.print(message + "\n\r");
            pw.flush();
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void leggi (){
        try{
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String testo = br.readLine();
            System.out.println("testo: " + testo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
