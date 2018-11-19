package Shape;

import java.awt.*;
import java.awt.geom.Point2D;

public class Circle extends drawShapes {

    public Circle(int x,String nazwa){
        super(x,nazwa);

    }

    public void draw(Graphics graphic) {
        Graphics2D g = (Graphics2D) graphic;
        g.setPaint(new GradientPaint(new Point2D.Double(0,0),new Color(0, 150, 0),new Point2D.Double(20,20), new Color(0,150,0)));
        g.fillOval(length,length,length,length);
        }
    }

