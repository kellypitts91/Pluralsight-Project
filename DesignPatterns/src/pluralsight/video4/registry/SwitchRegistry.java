package pluralsight.video4.registry;

import pluralsight.video4.factory.Factory;
import pluralsight.video4.model.Shape;
import pluralsight.video4.model.Square;
import pluralsight.video4.model.Triangle;
import pluralsight.video4.model.Rectangle;

public class SwitchRegistry {

    public Factory<? extends Shape> buildShapeFactory(String shape) {
        switch (shape) {
            case "square" : return () -> new Square();
            case "triangle" : return () -> new Triangle();
            case "rectangle" : return () -> new Rectangle();
            default:
                throw new IllegalArgumentException("Unknown shape: " + shape);
        }
    }
}
