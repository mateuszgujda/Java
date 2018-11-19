package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import  Shape.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static javafx.application.Application.launch;


public class Main{

    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        MyPanel panel = new MyPanel();
        panel.shapes.add(new Circle(100,"loko"));
        panel.shapes.add(new Triangle(50,"loko2"));
        panel.shapes.add(new Square(70,"rect"));
        f.setContentPane(panel);
        f.setSize(800,375);
        f.setVisible(true);
    }

}
