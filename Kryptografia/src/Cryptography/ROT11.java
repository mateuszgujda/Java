package Cryptography;

public class ROT11 implements Algorithm{
    static final char[]  Alfabet =new char[]{'a','b','c','d','e','f','g','h','i',
    'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    static final int rotation =11;

    @Override
    public String crypt(String word) {
        String crypted="";
        for(int i=0; i<word.length(); i++){
          char c = word.charAt(i);
          int indeks =0;
          for(int j=0; j<Alfabet.length; j++){
              if(c==Alfabet[j]){
                  indeks=j;
                  break;
              }
          }
          if((indeks+rotation)> Alfabet.length){
              indeks=indeks+rotation-Alfabet.length;
          }
          else {
              indeks=indeks+rotation;
          }
          crypted+= Alfabet[indeks];
        }

        return crypted;
    }

    @Override
    public String decrypt(String word){
        String decrypted="";
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            int indeks =0;
            for(int j=0; j<Alfabet.length; j++){
                if(c==Alfabet[j]){
                    indeks=j;
                    break;
                }
            }
            if((indeks-rotation)<0){
                indeks=Alfabet.length+indeks-rotation;
            }
            else {
                indeks = indeks -rotation;
            }
            decrypted+= Alfabet[indeks];
        }


        return decrypted;
    }

}
