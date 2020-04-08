package pluralsight.video4.model;

import java.awt.*;

public class Square extends Shape {

    public Square() {
        super(Color.WHITE);
    }

    public Square(Color color) {
        super(color);
    }

    @Override
    public String toString() {
        return "Square [color=" + color + "]";
    }
}
