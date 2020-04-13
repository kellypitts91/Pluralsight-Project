package pluralsight.video4;

import pluralsight.video2.functions.Consumer;
import pluralsight.video4.factory.Factory;
import pluralsight.video4.model.Rectangle;
import pluralsight.video4.model.Shape;
import pluralsight.video4.model.Square;
import pluralsight.video4.model.Triangle;
import pluralsight.video4.registry.Builder;
import pluralsight.video4.registry.Registry;

public class PlayWithRegistryBuilder {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Consumer<Builder<Shape>> consumer1 =
                builder -> builder.register("rectangle", Rectangle::new);
        Consumer<Builder<Shape>> consumer2 =
                builder -> builder.register("triangle", Triangle::new);

        Consumer<Builder<Shape>> initializer = consumer1.andThen(consumer2);

        Registry registry = Registry.createRegistry(initializer,  s -> {
            throw new IllegalArgumentException("Unknown shape: " + s);
        });

        Factory<Rectangle> buildRectangleFactory =
                (Factory<Rectangle>) registry.buildShapeFactory("rectangle");
        Rectangle rectangle = buildRectangleFactory.newInstance();
        System.out.println("Rectangle = " + rectangle);

        Factory<Triangle> buildTriangleFactory =
                (Factory<Triangle>) registry.buildShapeFactory("triangle");
        Triangle triangle = buildTriangleFactory.newInstance();
        System.out.println("Triangle = " + triangle);

        Factory<Square> buildSquareFactory = (Factory<Square>) registry.buildShapeFactory("square");
        Square square = buildSquareFactory.newInstance();
    }
}
