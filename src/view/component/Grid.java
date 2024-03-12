package view.component;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import Interface.ShapeInterface;
import Class.Camera;
import Class.Context;

public class Grid extends javax.swing.JPanel {

    private final List<ShapeInterface> shapes;
    private ShapeInterface previsualize;

    public Grid() {
        new JPanel();
        //new ColorComponent(this, 50, 500);
        shapes = Context.getInstance().getShapes();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ShapeInterface shape: shapes) {
            shape.drawShape(g);
        }
        if (this.previsualize != null) {
            this.previsualize.drawShape(g);
        }
    }

    public void create(ShapeInterface shapeInterface) {
        shapeInterface.calc3dCoordinate(shapeInterface.getCoordinate());
        repaint();
    }

    public void previsualize(ShapeInterface shapeInterface) {
        shapeInterface.calc3dCoordinate(shapeInterface.getCoordinate());
        this.previsualize = shapeInterface;
        repaint();
    }

    @Override
    public void repaint() {
        if (shapes != null) {
            for (ShapeInterface shape : shapes) {
                shape.calc3dCoordinate(shape.getCoordinate());
            }
        }
//        System.out.println(Camera.getInstance().x);
//        System.out.println(Camera.getInstance().y);
//        System.out.println(Camera.getInstance().z);
//        System.out.println(Camera.getInstance().ax);
//        System.out.println(Camera.getInstance().ay);
//        System.out.println(Camera.getInstance().az);
//        System.out.println(Camera.getInstance().areax);
//        System.out.println(Camera.getInstance().areay);
//        System.out.println(Camera.getInstance().areaz);

        super.repaint();
    }
}
