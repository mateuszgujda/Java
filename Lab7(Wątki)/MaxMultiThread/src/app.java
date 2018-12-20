import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class app {
   public static void main(String args[]){

       File file = new File("liczby.txt");
       BufferedWriter writer=null;
       //Zapis pliku
        try {
            writer = new BufferedWriter(new FileWriter(file));
            List<Thread> randomLists = new LinkedList<>();
            for(int j=0;j<100;j++) {
                randomLists.add(new Thread(new GenerateRandoms(writer)));
            }
            for(int j=0;j<100;j++){
                randomLists.get(j).start();
            }
            for(int i=0;i<100; i++){
                randomLists.get(i).join();
                }
                    writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        //Koniec wypelniania pliku

       try {
           Scanner reader = new Scanner(new File("liczby.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter(new File("wyniki.txt")));
            List<Thread> funkcje = new LinkedList<>();
            for(int j=0;j<100;j++) {
                       funkcje.add(new Thread(new MaxMultiThread(out, j % 3, reader.nextLine())));
                    }
                   for (int i = 0; i < 100; i++) {
                       funkcje.get(i).start();
                   }
                   for (int i = 0; i < 100; i++) {
                       funkcje.get(i).join();
                   }

           out.close();

       } catch (Exception e){
           e.printStackTrace();
           System.out.print(e.getMessage());
       }

    }

}

