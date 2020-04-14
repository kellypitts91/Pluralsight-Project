package pluralsight.video6;

import pluralsight.video6.model.Person;
import pluralsight.video6.util.Validator;

public class PlayWithValidator {
    public static void main(String[] args) {
        Person sarah = new Person("Sarah", 29);
        Person james = new Person(null, 29);
        Person mary = new Person("Mary", -10);
        Person john = new Person("John", 1_000);
        Person linda = new Person(null, 1_000);

        sarah = getValidate(sarah);
        System.out.println("Sarah: " + sarah);

        james = getValidate(james);
        System.out.println("James: " + james);

        mary = getValidate(mary);
        System.out.println("Mary: " + mary);

        john = getValidate(john);
        System.out.println("John: " + john);

        linda = getValidate(linda);
        System.out.println("Linda: " + linda);
    }

    private static Person getValidate(Person person) {
        return Validator.validate(p -> p.getName() != null, "The name should not be null")
                .thenValidate(p -> p.getAge() > 0, "The age should be greeter than 0")
                .thenValidate(p -> p.getAge() < 150, "The age should be less than 150")
                .on(person)
                .validate();
    }
}
