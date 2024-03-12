package Class;

import Interface.ShapeInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Context {
    private static Color c;
    public List<ShapeInterface> shapes = new ArrayList<>();
    private static Context instance;

    public static Context getInstance() {
        if (instance == null) {
            instance = new Context();
        }
        return instance;
    }

    public List<ShapeInterface> getShapes() {
        return shapes;
    }

    public void addShape(ShapeInterface shape) {
        this.shapes.add(shape);
    }

    public void setColor(Color c) {
        this.c = c;
    }

    public static Color getColor() {
        return c;
    }
}
