import java.util.LinkedList;
import java.util.List;

import Pracownik.*;
import db.DB;

public class App {
   public static List<Pracownik> lista = new LinkedList<Pracownik>();

    public static void main(String[] args){
        DB db = new DB();

        lista = db.getAllWorkers();
        lista.sort(new Sort());

        System.out.println("Posortowana");

        for (Pracownik p: lista) {
            System.out.println(p.wynagrodzenie_brutto);
        }
    }
}
