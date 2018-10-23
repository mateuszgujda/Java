import java.util.LinkedList;
import Pracownik.*;

public class App {
   public static LinkedList<Pracownik> lista = new LinkedList<Pracownik>();

    public static void main(String[] args){
        lista.add(new PracownikEtatowy(2000));
        lista.add(new PracownikEtatowy(4000));
        lista.add(new PracownikEtatowy(1000));
        lista.add(new PracownikEtatowy(3000));
        for (Pracownik p: lista) {
            System.out.println(p.wynagrodzenie_brutto);
        }


        lista.sort(new Sort());

        System.out.println("Posortowana");

        for (Pracownik p: lista) {
            System.out.println(p.wynagrodzenie_brutto);
        }
    }
}
