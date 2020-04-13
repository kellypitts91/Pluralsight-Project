package pluralsight.video4.registry;

import pluralsight.video4.factory.Factory;

public interface Builder<T> {
    void register(String label, Factory<T> factory);
}
