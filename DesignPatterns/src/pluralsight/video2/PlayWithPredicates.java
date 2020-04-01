package pluralsight.video2;

import pluralsight.video2.functions.Predicate;

import java.util.Objects;

public class PlayWithPredicates {
    public static void main(String[] args) {

        Predicate<String> p1 = Objects::nonNull;
        Predicate<String> p2 = String::isEmpty;
        Predicate<String> p3 = p1.and(p2.negate());

//        Predicate<String> p2 = p -> !p.isEmpty();
//        Predicate<String> p3 = p1.and(p2);

        System.out.println("Test for null " + p3.test(null));
        System.out.println("Test for empty " + p3.test(""));
        System.out.println("Test for non empty " + p3.test("Hello"));
    }
}
