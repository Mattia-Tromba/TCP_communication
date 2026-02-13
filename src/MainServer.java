import java.io.IOException;
import java.net.ServerSocket;

public class MainServer {
    public static void main(String[] args){
        int port = 5000;
        System.out.println("Server started on port " + port);

        Server s = new Server(5000);
        s.attendi();
        s.leggi();
        s.scrivi();
    }
}