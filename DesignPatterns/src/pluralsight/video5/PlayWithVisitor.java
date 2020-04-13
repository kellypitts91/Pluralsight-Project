package pluralsight.video5;

import pluralsight.video2.functions.Consumer;
import pluralsight.video5.model.Body;
import pluralsight.video5.model.Car;
import pluralsight.video5.model.Engine;

public class PlayWithVisitor {
    public static void main(String[] args) {
        Car car = new Car();
        Engine engine = new Engine();
        Body body = new Body();

        Consumer<VisitorBuilder<String>> consumer =
                Visitor.<Car, String>forType(Car.class).execute(c -> "Visiting car: " + c)
                        .forType(Engine.class).execute(e -> "Visiting engine: " + e)
                        .forType(Body.class).execute(b -> "Visiting engine: " + b);

        Visitor<Object, String> visitor = Visitor.of(consumer);

        String visitedCar = visitor.visit(car);
        System.out.println("Car: " + visitedCar);
        String visitedEngine = visitor.visit(engine);
        System.out.println("Engine: " + visitedEngine);
        String visitedBody = visitor.visit(body);
        System.out.println("Body: " + visitedBody);
    }
}
