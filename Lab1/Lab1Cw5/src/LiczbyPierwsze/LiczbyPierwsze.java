package LiczbyPierwsze;

public class LiczbyPierwsze {
    public static boolean czyLiczbaPierwsza(int liczba){
        boolean czyPierwsza=true;
        for(int i=2; i< liczba; i++){
            if(liczba%i ==0){
                czyPierwsza = false;
                break;
            }
        }
        return czyPierwsza;
    };
   public static void wyszukaj(int liczba){
       String newLine = System.lineSeparator();
       for(int i=2; i < liczba ; i++){
            if(czyLiczbaPierwsza(i)){
                System.out.print(i+newLine);
            }
        }
    };

}
