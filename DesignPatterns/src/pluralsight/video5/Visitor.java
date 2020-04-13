package pluralsight.video5;

import pluralsight.video2.functions.Consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public interface Visitor<T, R> {

    static <T, R> X<T, R> forType(Class<T> type) {
        return () -> type;
    }

    static <T, R> Visitor<T, R> of(Consumer<VisitorBuilder<R>> consumer) {
        Map<Class<?>, Function<T, R>> registry = new HashMap<>();
        VisitorBuilder<R> visitorBuilder = new VisitorBuilder<R>() {
            @Override
            public <T> void register(Class<T> type, Function<T, R> function) {
                registry.put(type, function.compose(type::cast));
            }
        };
        consumer.accept(visitorBuilder);
        return o -> registry.get(o.getClass()).apply(o);
    }

    R visit(T o);

    interface X<T, R> {
        Class<T> type();

        default Y<R> execute(Function<T, R> function) {
            return visitorBuilder -> visitorBuilder.register(type(), function);
        }
    }

    interface Y<R> extends Consumer<VisitorBuilder<R>> {
        default <T> Z<T, R> forType(Class<T> type) {
            return index -> index == 0 ? this : type;
        }

        default Y<R> andThen(Y<R> after) {
            return t -> {
                this.accept(t);
                after.accept(t);
            };
        }
    }

    interface Z<T, R> {
        Object get(int index);

        default Class<T> type() {
            return (Class<T>)get(1);
        }

        default Y<R> previousConsumer() {
            return (Y<R>)get(0);
        }

        default Y<R> execute(Function<T, R> function) {
            return previousConsumer().andThen(
                    visitorBuilder -> visitorBuilder.register(type(), function));
        }
    }

//    void visit(Car car);
//    void visit(Wheel wheel);
//    void visit(Engine engine);
//    void visit(Body body);
//    void visit(Bumper bumper);
}
