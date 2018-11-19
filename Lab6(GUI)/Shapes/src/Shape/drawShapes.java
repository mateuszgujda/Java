package Shape;

import java.awt.*;

public abstract class drawShapes {
    public String name;
    public int length;


    public drawShapes(int x, String nazwa){
        length=x;
        name = nazwa;
    }
    /**
     * Metoda rysujaca w konsoli dany kształt
     */
    public abstract void draw(Graphics graphic);
}
