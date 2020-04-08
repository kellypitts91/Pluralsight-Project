package pluralsight.video4.model;

import java.awt.*;

public class Rectangle extends Shape {

    public Rectangle() {
        super(Color.WHITE);
    }

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public String toString() {
        return "Rectangle [color=" + color + "]";
    }
}
