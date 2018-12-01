package Shape;

public class Circle extends Shape {

    public Circle(int x,String nazwa){
        super(x,nazwa);

    }

    public void draw() {
        for (int i = -length; i <= length; i++) {
            for (int j = -length; j <= length; j++) {
                if (i * i + j * j <= length * length) System.out.print("x ");
                else System.out.print("  ");
            }
            System.out.print(System.lineSeparator());
        }
    }

}
