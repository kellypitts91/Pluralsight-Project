package pluralsight.video4.model;

import java.awt.*;

public class Triangle extends Shape {

    public Triangle() {
        super(Color.WHITE);
    }

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public String toString() {
        return "Triangle [color=" + color + "]";
    }
}
