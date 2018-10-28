import io.indico.api.utils.IndicoException;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PhotoSort photo = new PhotoSort();
        Scanner rd = new Scanner(System.in);
        System.out.println("Podaj klucz do API Indico: ");
        String API_key = rd.nextLine();
        System.out.println("Podaj folder ze zdjeciami do posortowania");
        String directry = rd.nextLine();

        try {
            photo.dir_sort(API_key, directry);
            System.out.println("Moving files");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
