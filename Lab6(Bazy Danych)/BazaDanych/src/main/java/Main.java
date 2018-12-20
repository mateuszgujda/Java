import sun.font.TrueTypeFont;

import java.util.Scanner;

/**
 * Created by student on 2018-11-27.
 */

public class Main {
    public static void main(String[] args){
        DB db = new DB();
        int wybor = -1;
        Scanner rd = new Scanner(System.in);


        while(wybor !=0){
            System.out.println("Podaj wybor: ");
            System.out.println("1) Wyszukaj po nazwisku autora");
            System.out.println("2) Wyszukaj po numerze ISBN");
            System.out.println("3) Dodaj ksiazke do bazy");
            System.out.println("0) Wyjdz z programu");
            System.out.println("Podaj swoj wybor: ");
            String a = rd.nextLine();
            wybor = Integer.parseInt(a);
            switch (wybor) {
                case 1:
                    System.out.println("Podaj nazwisko autora:");
                    String author = rd.nextLine();
                    db.selectByAuthor(author);
                    break;
                case 2:
                    System.out.println("Podaj numer ISBN: ");
                    String ISBN = rd.nextLine();
                    db.selectByISBN(ISBN);
                    break;
                case 3:
                    System.out.println("Podaj ISBN ksiazki: ");
                    ISBN = rd.nextLine();
                    System.out.println("Podaj tytul ksiazki: ");
                    String title = rd.nextLine();
                    System.out.println("Podaj autora ksiazki: ");
                    author = rd.nextLine();
                    System.out.println("Podaj rok wydania :");
                    String year = rd.nextLine();
                    db.addBook(ISBN,title,author,year);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Bledny wybor");
            }

        }

    }
}
