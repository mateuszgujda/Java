//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    public Reader() {
    }

    public static void main(String[] argv) {
        InputStreamReader rd = new InputStreamReader(System.in);
        BufferedReader bfr = new BufferedReader(rd);
        System.out.print("Wpisz jakis tekst: ");
        String text = null;

        try {
            text = bfr.readLine();
        } catch (IOException var5) {
            System.out.print(var5);
        }

        System.out.println(text);
    }
}
