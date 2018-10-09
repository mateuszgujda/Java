package Punkty;

/**
 * Created by student on 2018-10-09.
 */
public class Punkt2D {
    public Punkt2D(double x_to_set,double y_to_set){
        x = x_to_set;
        y = y_to_set;
    }

    protected double x;
    protected double y;

    public double getX() {return x;}
    public double getY() {return y;}
    public void setX(double x_to_set){ x = x_to_set;}
    public void setY(double y_to_set){ y = y_to_set;}

    public double distance(Punkt2D punkt) {
        return  Math.sqrt((Math.pow(x- punkt.getX(),2))+(Math.pow(y - punkt.getY(),2)));
    }
}
