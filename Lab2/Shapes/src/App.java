import Shape.*;

import java.util.LinkedList;
import java.util.Scanner;

public class App {
   public static LinkedList<Shape> lista = new LinkedList<Shape>();
    public static void main(String []args){

        Scanner rd = new Scanner(System.in);
        int wybor=0;
        while(wybor != 3){
            printMenu();
            wybor = rd.nextInt();
            switch (wybor){
                case 1:
                    dodaj();
                    break;
                case 2:
                    przegladaj();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Bledny znak");
                    rd.nextLine();

            }
        }
    rd.close();

    }

    public static void printMenu(){
        System.out.println("1) Dodaj elementy do listy");
        System.out.println("2) Przegladaj liste");
        System.out.println("3) Wyjscie");

        System.out.print("Twoj wybor: ");
    }

    public static void dodaj(){
        Scanner rd = new Scanner(System.in);
        int wybor = 0;
        String nazwa;
        int x;

        System.out.println("Wybierz jaki obiekt chcesz utworzyc: ");
        System.out.println("1) Kwadrat");
        System.out.println("2) Trojkat");
        System.out.println("3) Kolo");
        System.out.print("Twoj wybor: ");
        wybor = rd.nextInt();

        switch(wybor){
            case 1:
                System.out.println("Podaj nazwe kwadratu: ");
                rd.nextLine();
                nazwa = rd.nextLine();

                System.out.print("Podaj bok kwadratu: ");
                x = rd.nextInt();
                lista.add(new Square(x,nazwa));
                break;
            case 2:
                System.out.print("Podaj nazwe trojkata: ");
                rd.nextLine();
                nazwa = rd.nextLine();
                System.out.print("Podaj podstawe trojkata: ");
                x = rd.nextInt();
                lista.add(new Triangle(x,nazwa));
                break;
            case 3:
                System.out.print("Podaj nazwe kola: ");
                rd.nextLine();
                nazwa = rd.nextLine();
                System.out.print("Podaj  promien kola: ");
                x = rd.nextInt();
                lista.add(new Circle(x,nazwa));
                break;
            default:
                System.out.println("Bledny znak");
                rd.nextLine();
        }

    }

    public static void przegladaj(){
        for(Shape figura : lista){
            System.out.println("Nazwa : "+ figura.name);
            figura.draw();
        }

    }
}
