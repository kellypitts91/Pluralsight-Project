package pluralsight.video3;

import pluralsight.video2.functions.Function;
import pluralsight.video3.model.Person;
import pluralsight.video3.util.Comparator;

public class PlayWithComparators {
    public static void main(String[] args) {
        Person mary = new Person("Mary", 28);
        Person john = new Person("John", 22);
        Person linda = new Person("Linda", 26);
        Person james = new Person("James", 32);
        Person james2 = new Person("James", 26);

        Comparator<Person> cmpName = Comparator.comparing(Person::getName);
        Comparator<Person> cmpNameReversed = cmpName.reversed();

        System.out.println("Mary > John : " + (cmpName.compare(mary, john) > 0));
        System.out.println("John > James : " + (cmpName.compare(john, james) > 0));
        System.out.println("Linda > John : " + (cmpName.compare(linda, john) > 0));

        System.out.println();

        System.out.println("Mary > John : " + (cmpNameReversed.compare(mary, john) > 0));
        System.out.println("John > James : " + (cmpNameReversed.compare(john, james) > 0));
        System.out.println("Linda > John : " + (cmpNameReversed.compare(linda, john) > 0));

        System.out.println();

        Comparator<Person> cmpAge = Comparator.comparing(Person::getAge);
        Comparator<Person> cmpAgeReversed = cmpAge.reversed();

        System.out.println("Mary " + mary.getAge() + " > John " + john.getAge() + " : " + (cmpAge.compare(mary, john) > 0));
        System.out.println("John " + john.getAge() + " > James " + james.getAge() + " : " + (cmpAge.compare(john, james) > 0));
        System.out.println("Linda " + linda.getAge() + " > John " + john.getAge() + " : " + (cmpAge.compare(linda, john) > 0));

        System.out.println();

        System.out.println("Mary " + mary.getAge() + " > John " + john.getAge() + " : " + (cmpAgeReversed.compare(mary, john) > 0));
        System.out.println("John " + john.getAge() + " > James " + james.getAge() + " : " + (cmpAgeReversed.compare(john, james) > 0));
        System.out.println("Linda " + linda.getAge() + " > John " + john.getAge() + " : " + (cmpAgeReversed.compare(linda, john) > 0));

        System.out.println();

        Comparator<Person> cmp = Comparator.comparing(Person::getName)
                                           .thenComparing(Person::getAge);

        System.out.println("Mary " + mary.getAge() + " > John " + john.getAge() + " : " + (cmp.compare(mary, john) > 0));
        System.out.println("John " + john.getAge() + " > James " + james.getAge() + " : " + (cmp.compare(john, james) > 0));
        System.out.println("Linda " + linda.getAge() + " > John " + john.getAge() + " : " + (cmp.compare(linda, john) > 0));
        System.out.println("James " + james.getAge() + " > James2 " + james2.getAge() + " : " + (cmp.compare(james, james2) > 0));
    }
}
