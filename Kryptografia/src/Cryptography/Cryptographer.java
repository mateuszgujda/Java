package Cryptography;

import java.io.*;
import java.util.Scanner;

public class Cryptographer {
    public static void cryptfile(FileInputStream to_crypt, FileWriter to_save, Algorithm algorithm){
        BufferedWriter wrt = new BufferedWriter(to_save);
        try (Scanner rd = new Scanner(to_crypt) ){
           while(rd.hasNextLine()){
               String line = rd.nextLine();
               String []words = line.split("\\s+");
               for(String word : words){
                   wrt.append(algorithm.crypt(word.toLowerCase())+" ");
               }
               wrt.append(System.lineSeparator());
           }


           System.out.println("Zaszyfrowano plik");
            rd.close();
           wrt.close();

        } catch(Exception e) {
            System.out.println("Wystapil blad: "+e);
        }

    }

    public static void decryptfile(FileInputStream to_decrypt,FileWriter to_save, Algorithm algorithm){
        BufferedWriter wrt = new BufferedWriter(to_save);
        try(Scanner rd = new Scanner(to_decrypt)){
            while(rd.hasNextLine()){
                String line = rd.nextLine();
                String []words = line.split(" ");
                for(String word : words){
                    wrt.append(algorithm.decrypt(word.toLowerCase())+" ");
                }
                wrt.append(System.lineSeparator());
            }

            System.out.println("Odszyfrowano plik");
            rd.close();
            wrt.close();
        } catch (Exception e) {
            System.out.println("Wystapil blad: "+e);
        }
    }
}
