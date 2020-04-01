package pluralsight.video3.util;

import pluralsight.video2.functions.Function;
import pluralsight.video3.model.Person;

import java.util.Objects;

@FunctionalInterface
public interface Comparator<T> {
    int compare(T t1, T t2);

    static <T, U extends Comparable<U>> Comparator<T> comparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (p1, p2) -> {
            U s1 = keyExtractor.apply(p1);
            U s2 = keyExtractor.apply(p2);
            return s1.compareTo(s2);
        };
    }

    default Comparator<T> reversed() {
        return (t1, t2) -> this.compare(t2, t1);
    }

    default Comparator<T> thenComparing(Comparator<T> other) {
        Objects.requireNonNull(other);
        return (t1, t2) -> {
            int compare = this.compare(t1, t2);
            if(compare == 0) {
                return other.compare(t1, t2);
            }
            return compare;
        };
    }
}
