import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class MaxMultiThread implements   Runnable{

    private BufferedWriter writer;
    private Scanner reader;
    private  int method =0;
    private String line;

    public MaxMultiThread(BufferedWriter writer, int method, String line){
        this.writer = writer;
        this.method = method;
        this.line= line;
    }


    public  void doAction(){
        String[] nums = line.split(" ");
        String toPrint = "";
        for(String num : nums){
            double n = Double.parseDouble(num);
            double result = 0.0;
            switch (method){
                case 0:
                    result= kwadrat(n);
                case 1:
                    result= pierwiastek(n);
                case 2:
                    result= szescian(n);
            }
            toPrint+=Double.toString(result)+" ";
        }
        try {
            synchronized (writer) {
                writer.append(toPrint);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("Finished parsing");
            return;
        }


    }


    public double kwadrat(double n){
        return n*n;
    }

    public double pierwiastek(double n){
        return Math.sqrt(n);
    }
    public double szescian(double n){
        return n*n*n;
    }

    @Override
    public void run() {
        doAction();
    }
}
