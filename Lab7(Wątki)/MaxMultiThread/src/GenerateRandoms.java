import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class GenerateRandoms implements Runnable {

    public  GenerateRandoms(BufferedWriter writer){
        this.writer = writer;
    }

    public   BufferedWriter writer;

    @Override
    public void run() {
            action();
        }

        public void action(){
            String toPrint = "";
            for(int i=0;i<1000;i++) {
                double n = Math.random() * 100 + 1;
                toPrint+= Double.toString(Math.round(n)) + " ";
            }
            try {
                synchronized (writer) {
                    writer.append(toPrint);
                    writer.newLine();
                    System.out.println(Thread.currentThread().getName() + " is printing");
                }
            } catch (IOException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } finally {
                System.out.println(Thread.currentThread().getName()+ "finished");
                return;
            }
        }
}
