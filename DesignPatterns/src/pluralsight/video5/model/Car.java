package pluralsight.video5.model;

import pluralsight.video5.Visitor;

public class Car {
    private Engine engine;
    private Body body;
    private Wheel wheel1;
    private Bumper bumper;

//    void accept(Visitor visitor) {
//        engine.accept(visitor);
//        body.accept(visitor);
//        wheel1.accept(visitor);
//        bumper.accept(visitor);
//
//        visitor.visit(this);
//    }

    @Override
    public String toString() {
        return "Car []";
    }
}
