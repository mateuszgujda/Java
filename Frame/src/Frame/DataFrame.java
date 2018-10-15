package Frame;

import java.util.ArrayList;
import java.util.List;

public class DataFrame implements Cloneable {

    ArrayList<Kolumna> ListaKolumn = new ArrayList<Kolumna>();


    public DataFrame(String[] kolumny , String[] typy){
        for (int i =0 ; i< kolumny.length; i++){
           ListaKolumn.add(new Kolumna(kolumny[i],typy[i]));
        }
    }

    public DataFrame(ArrayList<Kolumna> do_kopii){
        ListaKolumn = do_kopii;
    }
    public int size(){
        return ListaKolumn.get(0).getLista().size();
    }

    public Kolumna get(String colname){
        Kolumna szukana = null;
        for(int i=0; i < ListaKolumn.size(); i++){
            if(ListaKolumn.get(i).getName() == colname)
            {
                szukana = ListaKolumn.get(i);
                break;
            }
        }
        return szukana;
    }


    public DataFrame get(String[] cols, boolean copy){
        ArrayList<Kolumna> Nowe = new ArrayList<Kolumna>();
        if(copy) {
            for (int i = 0; i < cols.length; i++) {
                Nowe.add(get(cols[i]));
            }

        } else {
            String typ;
            String nazwa;
            for (int i = 0; i< cols.length; i++){
                typ = ListaKolumn.get(i).getType();
                nazwa = ListaKolumn.get(i).getName();

                Nowe.add(new Kolumna(nazwa,typ));
                for(int j=0; j< ListaKolumn.size(); j++){
                    Nowe.get(i).getLista().add(this.get(nazwa).getLista().get(j));
                }

            }

        }
        return new DataFrame(Nowe);
    }

    public DataFrame iloc(int i){


        DataFrame Nowa = makeBase();

        for(int j =0 ;j <ListaKolumn.size(); i++){
           Kolumna kol =  ListaKolumn.get(j);
         Nowa.ListaKolumn.get(j).getLista().add(kol.getLista().get(i));
        }


        return Nowa;
    }

    public DataFrame iloc(int from, int to){
        DataFrame Nowa = makeBase();

        for(int i=0;i<ListaKolumn.size(); i++){
            Kolumna kol = ListaKolumn.get(i);
            for(int j=from; j < to ; j++){
                Nowa.ListaKolumn.get(i).getLista().add(kol.getLista().get(j));
            }
        }


        return Nowa;
    }

    public DataFrame makeBase(){
        String[] cols = new String[ListaKolumn.size()];
        String[] types = new String[ListaKolumn.size()];
        for(int j=0; j< ListaKolumn.size(); j++){
            cols[j] = ListaKolumn.get(j).getName();
            types[j] = ListaKolumn.get(j).getType();
        }

        return new DataFrame(cols,types);
    }
}
