public class Triangle extends Shape {
    public void draw(int x){
        for(int i=1;i<=x;i+=2){
            for(int j=0;j<(x/2-i/2);j++){
                System.out.print(" ");
            }
            for(int j=0; j<i; j++){
                System.out.print("x");
            }
            for(int j=0; j<(x/2-i/2);j++){
                System.out.print(" ");
            }
            System.out.print(System.lineSeparator());
        }
    }

}
