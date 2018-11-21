package Shape;

import java.awt.*;
import java.awt.geom.Path2D;

public abstract class drawShapes {
    public String name;
    public int length;
    public int y;
    public int x;
    public Path2D myPath;


    public drawShapes(int len, String nazwa,int x, int y){
        length=len;
        name = nazwa;
        this.x = x;
        this.y = y;
    }
    /**
     * Metoda rysujaca w konsoli dany kształt
     */
    public abstract void draw(Graphics graphic);
}
