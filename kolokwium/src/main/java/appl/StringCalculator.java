package appl;

import excp.BadInputException;
import excp.NothingToSubstractFromException;
import excp.TooBigNumberException;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by student on 2018-11-06.
 */
public class StringCalculator extends Calculator implements  Cloneable{
    private String result;

    public String getResult(){return result;}
    public void setResult(String to_set){
        result = to_set;
    }

    public StringCalculator(){
        result="";
    }

    public StringCalculator(String to_set){
        setResult(to_set);
    }

    public void SaveToFile(String x, String filename) throws IOException{
        BufferedWriter wrt = new BufferedWriter(new FileWriter(filename));
        wrt.append(x);
        wrt.close();
    }

    public String Add(String x){
      String new_result = getResult().concat(x);
        return new_result;
    }

    public String Substract(String x) throws BadInputException, NothingToSubstractFromException{
        if(getResult().equals(""))
            throw new NothingToSubstractFromException("Result jest puste");
        if(!getResult().contains(x))
            throw new BadInputException("Nie ma tego slowa w result");

        String new_result = getResult().replaceAll(x,"");
        return new_result;
    }

    public  String Multiply(int x) throws TooBigNumberException{
        if(x>5)
            throw new TooBigNumberException("x jest wieksze niz 5");
        String new_result = "";
        for(int i =0; i<x;i++){
            new_result+=getResult() ;
        }
        return new_result;
    }

    @Override
    public StringCalculator clone(){
        StringCalculator foo = new StringCalculator(this.result);
        return foo;
    }

    public static void main(String []args){
        try{
            StringCalculator calculator = new StringCalculator();
            calculator.setResult("abcdefg");

           System.out.println(calculator.Add("asf"));
            System.out.println(calculator.Substract("f"));
            System.out.println(calculator.Multiply(2));


        } catch (Exception e){
            System.out.print("Wyjatek: "+e+ e.getLocalizedMessage());
        }
    }

}
