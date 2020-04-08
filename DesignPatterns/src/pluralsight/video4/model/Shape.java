package pluralsight.video4.model;

import java.awt.Color;

public class Shape {
    protected Color color;

    public Shape() {
        this(Color.WHITE);
    }

    public Shape(Color color) {
        this.color = color;
    }
}
