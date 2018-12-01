package Shape;

public abstract class Shape{
    public String name;
    public int length;


    public Shape(int x, String nazwa){
        length=x;
        name = nazwa;
    }
    /**
     * Metoda rysujaca w konsoli dany kształt
     */
    public abstract void draw();
}
