package Shape;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class Triangle extends drawShapes {

    public Triangle(int x,String nazwa){
        super(x,nazwa);

    }
    public void draw(Graphics graphic){
        Graphics2D g = (Graphics2D) graphic;
        g.setPaint(new GradientPaint(new Point2D.Double(0,0),new Color(0, 150, 0),new Point2D.Double(20,20), new Color(0,150,0)));
        Path2D myPath = new Path2D.Double();
        double firstX = (length / 2.0) * (1 - 1 / Math.sqrt(3));
        double firstY = 3.0 * length / 4.0;

        myPath.moveTo(firstX, firstY);
        myPath.lineTo(length - firstX, firstY);
        myPath.lineTo(length / 2.0, length / 4.0);
        myPath.closePath();

        g.fill(myPath);
    }

}
