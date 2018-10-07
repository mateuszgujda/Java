package javaIn;

import java.io.*;

public class JIn {
    public static String getString() {
        String text = null;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            text = bfr.readLine();
        }catch(IOException e){e.printStackTrace();}
        return text;
    }

    public static int getInt() {
        int number = 0;
        String textNumber = null;
        try {
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);
            textNumber = bfr.readLine();

        } catch (IOException e) {e.printStackTrace();}
        try {
            number = Integer.parseInt(textNumber);

        } catch (NumberFormatException e) {
            System.out.print("To nie jest liczba");
        }
            return number;
        }
}