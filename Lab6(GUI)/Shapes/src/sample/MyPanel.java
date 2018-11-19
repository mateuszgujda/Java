package sample;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import Shape.*;

public class MyPanel extends Panel {
    List<drawShapes> shapes = new LinkedList<drawShapes>();
    @Override
    public void paint(Graphics g){
       super.paint(g);
       for(drawShapes sh : shapes){
           sh.draw(g);
       }
    }
}
