package pluralsight.video4.model;

import java.awt.Color;

public class Circle extends Shape {

    public Circle() {
        super(Color.WHITE);
    }

    public Circle(Color color) {
        super(color);
    }

    @Override
    public String toString() {
        return "Circle [color=" + color + "]";
    }
}
