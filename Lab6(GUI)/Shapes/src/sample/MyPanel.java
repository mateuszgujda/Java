package sample;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;

import Shape.*;

public class MyPanel extends Panel{
    List<drawShapes> shapes = new LinkedList<drawShapes>();
    public MyPanel(){
        MyMouseAdapter myMouseAdapter = new MyMouseAdapter(this);
        addMouseListener(myMouseAdapter);
        addMouseMotionListener(myMouseAdapter);

    }


    @Override
    public void paint(Graphics g){
       super.paint(g);
       for(drawShapes sh : shapes){
           sh.draw(g);
       }
    }

}
