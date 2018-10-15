import Frame.*;

public class App {
    public static void main(String args[]){
        DataFrame df = new  DataFrame(new String[]{"kol1","kol2","kol3"},
                new String[]{"int","double","String"});
        df.get("kol1").getLista().add(7);
        df.get("kol2").getLista().add(4.5);
        df.get("kol3").getLista().add("ABC");

        System.out.println(df.get("kol3").getLista().get(0));
        System.out.println(df.size());
        DataFrame kopia = df.get(new String[]{"kol2","kol3"},true);
        System.out.println(kopia.get("kol3").getLista());
        kopia = df.get(new String[]{"kol3"}, false);
        System.out.println(kopia.get("kol3").getLista());

        df.get("kol1").getLista().add(14);
        df.get("kol2").getLista().add(5.0);
        df.get("kol3").getLista().add("DEF");

        System.out.println(df.get("kol3").getLista());

        DataFrame obciety = df.iloc(1);
        System.out.println(obciety.get("kol3").getLista());

        df.get("kol1").getLista().add(32);
        df.get("kol2").getLista().add(5.5);
        df.get("kol3").getLista().add("GHI");

        DataFrame obciecie2 = df.iloc(1,3);
        System.out.println(obciecie2.get("kol3").getLista());
    }
}
