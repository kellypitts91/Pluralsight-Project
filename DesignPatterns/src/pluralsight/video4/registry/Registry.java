package pluralsight.video4.registry;

import pluralsight.video2.functions.Consumer;
import pluralsight.video4.factory.Factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public interface Registry<T> {

    Factory<? extends T> buildShapeFactory(String shape);

    public static <T> Registry<T> createRegistry(Consumer<Builder<T>> consumer,
                                                 Function<String, Factory<T>> errorFunction) {
        Map<String, Factory<T>> map = new HashMap<>();
        Builder<T> builder = map::put;
        consumer.accept(builder);

        return shape -> map.computeIfAbsent(shape, errorFunction);
    }
}
