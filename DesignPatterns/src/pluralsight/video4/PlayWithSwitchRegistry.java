package pluralsight.video4;

import pluralsight.video4.factory.Factory;
import pluralsight.video4.model.Rectangle;
import pluralsight.video4.registry.SwitchRegistry;

public class PlayWithSwitchRegistry {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        SwitchRegistry registry = new SwitchRegistry();

        Factory<Rectangle> rectangleFactory =
                (Factory<Rectangle>)registry.buildShapeFactory("rectangle");
        System.out.println("Rectangle : " + rectangleFactory.newInstance());
    }
}
