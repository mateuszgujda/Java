import Cryptography.Cryptographer;
import Cryptography.Polibiusz;
import Cryptography.ROT11;

import java.util.Scanner;
import java.io.*;

public class App {
    public static void main(String args[]){
        Cryptographer crpt = new Cryptographer();
        Scanner reader = new Scanner(System.in);

        System.out.println("Podaj nazwe pliku do odczytu: ");
        try (FileInputStream input = new FileInputStream(reader.nextLine())) {
            System.out.println("Podaj nazwe pliku do zapisu: ");
            FileWriter to_write = new FileWriter(reader.nextLine());

            System.out.println("Wybierz algorytm szyfrowania/deszyfrowania: ");
            System.out.println("1)ROT 11");
            System.out.println("2)Polibiusz");
            int wybor1 = reader.nextInt();
            System.out.println("Wybierz szyfrowanie lub deszyfrowanie: ");
            System.out.println("1)Szyfrowanie");
            System.out.println("2)Deszyfrowanie");
            int wybor2= reader.nextInt();
            switch (wybor1){
                case 1:
                    if(wybor2 == 1)
                        Cryptographer.cryptfile(input,to_write,new ROT11());
                    else if(wybor2 == 2)
                        Cryptographer.decryptfile(input,to_write,new ROT11());
                    break;
                case 2:
                    if(wybor2 == 1)
                        Cryptographer.cryptfile(input,to_write,new Polibiusz());
                    else if(wybor2 == 2)
                        Cryptographer.decryptfile(input,to_write,new Polibiusz());
                    break;
                default:
                    break;
            }


        } catch(Exception e) {
            System.out.println("Brak takiego pliku lub bledny wybor");
        }

    }
}
