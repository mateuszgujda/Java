package Shape;

public class Triangle extends Shape {

    public Triangle(int x,String nazwa){
        super(x,nazwa);

    }
    public void draw(){
        for(int i=1;i<=length;i+=2){
            for(int j=0;j<(length/2-i/2);j++){
                System.out.print(" ");
            }
            for(int j=0; j<i; j++){
                System.out.print("x");
            }
            for(int j=0; j<(length/2-i/2);j++){
                System.out.print(" ");
            }
            System.out.print(System.lineSeparator());
        }
    }

}
