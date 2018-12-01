package Cryptography;

public class Polibiusz implements Algorithm {
    final static char[][] check = new char [][] {{'a','b','c','d','e'},
                                                 {'f','g','h','i','k'},
                                                 {'l','m','n','o','p'},
                                                 {'q','r','s','t','u'},
                                                 {'v','w','x','y','z'}};

    @Override
    public String crypt(String word) {
        String crypted ="";
        for(int k=0;k<word.length();k++) {
                char c = word.charAt(k);
                if(c == 'j'){
                    c='i';
                }
                for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(check[i][j] == c){
                        crypted+= Integer.toString(i)+Integer.toString(j);
                        break;
                    }
                }
            }
        }


        return crypted;
    }

    @Override
    public String decrypt(String word) {
        String decrypted="";
        int i=0;
        int j=0;
        for(int k=0;k<word.length();k++){
            if(k%2 == 0){
                i = Character.getNumericValue(word.charAt(k));
            }
            else {
                j = Character.getNumericValue(word.charAt(k));
                decrypted+=check[i][j];
            }
        }

        return decrypted;
    }
}
