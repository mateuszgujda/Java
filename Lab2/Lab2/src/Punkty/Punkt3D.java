package Punkty;

/**
 * Created by student on 2018-10-09.
 */
public class Punkt3D extends Punkt2D{
    private  double z;

    public Punkt3D(double x_to_set, double y_to_set , double z_to_set ){
        super(x_to_set, y_to_set);
        z = z_to_set;
    }

    public void setZ(double z_to_set) {z = z_to_set;}

    public double getZ(){return z;}

    public double distance(Punkt3D punkt){
        return Math.sqrt(Math.pow(x-punkt.getX(),2) + Math.pow(y-punkt.getY(),2) + Math.pow(z-punkt.getZ(),2));
    }
}
