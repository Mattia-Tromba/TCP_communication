import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        Client client = new Client("Mattia");
        client.connetti("localhost", 5000);
        boolean x = true;
        Scanner s = new Scanner(System.in);
        while (x){
            System.out.println("-> ");
            client.scrivi(s.nextLine());
            client.leggi();
            System.out.println("Vuoi uscire? exit");
            if (s.nextLine().equals("exit")){
                client.scrivi("exit");
                client.leggi();
                x =  false;
            }
        }
    }
}