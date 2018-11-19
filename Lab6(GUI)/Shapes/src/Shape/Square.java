package Shape;

import java.awt.*;
import java.awt.geom.Point2D;

public class Square extends drawShapes {

    public Square(int x,String nazwa){
        super(x,nazwa);

    }

    public void draw(Graphics graphic) {
        Graphics2D g = (Graphics2D) graphic;
        g.setPaint(new GradientPaint(new Point2D.Double(0,0),new Color(0, 150, 0),new Point2D.Double(20,20), new Color(0,150,0)));
        g.fillRect(length,length,length,length);
    }

}
