import Exceptions.NoSequenceFoundException;
import Exceptions.WrongFrameSequenceException;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        MicroDVD microDVD = new MicroDVD();

        try {
            Scanner rd = new Scanner(System.in);
            System.out.println("Podaj sciezke do pliku wejsciowego: ");
            String input = rd.nextLine();
            System.out.println("Podaj sciezke do pliku wyjsciowego: ");
            String output = rd.nextLine();
            System.out.print("Podaj opoznienie w milisekundach: ");
            int delay = rd.nextInt();
            rd.nextLine();
            System.out.print("Podaj ilosc klatek na sekunde: ");
            int fps = rd.nextInt();
            microDVD.delay(input,output,delay,fps);
        } catch(IOException|NoSequenceFoundException|WrongFrameSequenceException e){
                System.out.print(e.getMessage());
        } finally {
            System.out.print("Napisy opoznione");
        }

    }
}
