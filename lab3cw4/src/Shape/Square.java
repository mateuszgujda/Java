package Shape;

public class Square extends  Shape{

    public Square(int x,String nazwa){
        super(x,nazwa);

    }

    public void draw() {
        for (int j = 0; j < length; j++) {

        for (int i = 0; i < length; i++) {
            System.out.print("x");
        }
        System.out.print(System.lineSeparator());
    }
    }

}
