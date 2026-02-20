import java.util.Scanner;

public class MainServer {
    public static void main(String[] args){
        int port = 5000;
        System.out.println("Server started on port " + port);
        Server s = new Server(5000);
        Scanner scanner = new Scanner(System.in);
        boolean y = true;
        while (y){
            s.attendi();
            boolean x = true;
            while (x) {
                String testo = (s.leggi());
                System.out.println(testo);
                System.out.println("-> ");
                s.scrivi(scanner.nextLine());
                if (testo.equals("testo: exit")) {
                    x = false;
                }
            }
            System.out.println("chiudi? si/no");
            if (scanner.nextLine().equals("si")) {
                y = false;
            }
        }
        s.chiudi();
        s.termina();
    }
}