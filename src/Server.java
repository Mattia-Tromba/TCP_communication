import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private final int porta;
    private DataInputStream in;

    public Server(int porta){
        this.porta = porta;
        try {
            serverSocket = new ServerSocket(porta);

        } catch (IOException e) {
            System.err.println("impossibile connettersi");
        }
    }

    public Socket attendi(){
        try {
            System.out.println("Il server è in ascolto");
            clientSocket = serverSocket.accept();
            System.out.println("Il server è connesso al client");
        }
        catch (BindException b){
            throw new IOException(b.getMessage());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            return clientSocket;
        }
    }

    public void scrivi(){

    }

    public void leggi(){
        try {
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String testo = br.readLine();
            System.out.println("testo: " + testo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void chiudi(){
        try {
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void termina(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
