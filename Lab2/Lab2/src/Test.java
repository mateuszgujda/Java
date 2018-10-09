/**
 * Created by student on 2018-10-09.
 */
import Punkty.*;

import java.util.LinkedList;
import java.util.Scanner;

public class Test {
   public static LinkedList<Punkt3D> punkty = new LinkedList<Punkt3D>();

   public static void main(String[] args){
       int wybor = 0;
        while(wybor!= 4){
        wybor = menu();
            switch (wybor){
                case 1:
                    wczytaj();
                    break;
                case 2:
                    wyswietl();
                    break;
                case 3:
                    odleglosc();
                    break;
            }
    }

    }

    public static int menu(){
        Scanner reader = new Scanner(System.in);

        System.out.print("1. Wczytaj punkt 3D" + System.lineSeparator());
        System.out.print("2.Wyswietl wszystkie punkty" + System.lineSeparator());
        System.out.print("3. Oblicz odleglosc" + System.lineSeparator());
        System.out.print("4. Zakoncz" + System.lineSeparator());

        int n = reader.nextInt();

        return n;
    }

    public static void wczytaj(){
        punkty.add(nowyPunkt());
    }

    public static void wyswietl(){
       if(punkty.size()== 0 ) {
           System.out.print("Brak punktow" + System.lineSeparator());
           return;
       }
        for(int i =0 ;i<punkty.size(); i++){
            System.out.print("Punkt" + (i+1) +" X: "+ punkty.get(i).getX() +" Y:" + punkty.get(i).getY() + " Z:" + punkty.get(i).getZ() + System.lineSeparator() );
        }
    }

    public static void odleglosc() {
       System.out.print("Podaj wspolrzedne punktow miedzy ktorymi chcesz sprawdzic odleglosc:" + System.lineSeparator());
       System.out.print("Punkt 1 : " + System.lineSeparator());
        Punkt3D punkt1 = nowyPunkt();

        System.out.print("Punkt 2 : " + System.lineSeparator());
        Punkt3D punkt2 = nowyPunkt();


        System.out.print("Odleglosc miedzy punktami wynosi: " +  punkt1.distance(punkt2));
    }

    public static Punkt3D nowyPunkt(){
       double x,y,z;
       Scanner rd = new Scanner(System.in);
        System.out.print("Podaj parametry punktu: " + System.lineSeparator());
        System.out.print ("Podaj wspolrzedna x punktu : ");
        x = rd.nextDouble();
        System.out.print ("Podaj wspolrzedna y punktu : ");
        y = rd.nextDouble();
        System.out.print ("Podaj wspolrzedna z punktu : ");
        z = rd.nextDouble();

        return new Punkt3D(x,y,z);
    }

}


