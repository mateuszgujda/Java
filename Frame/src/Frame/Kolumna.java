package Frame;


import java.util.ArrayList;

public class Kolumna implements Cloneable {
    private String name;
    private String type;
    private ArrayList<Object> lista;

    public  Kolumna(String nazwa, String typ){
       name = nazwa;
       type= typ;
       lista = new ArrayList<Object>();
   }

   public ArrayList getLista(){
        return lista;
   }

   public String getName(){
        return name;
   }

   public String getType() {
        return type;
   }
}
