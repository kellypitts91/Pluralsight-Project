package pluralsight;

import pluralsight.video2.functions.Function;
import pluralsight.model.Meteor;

public class PlayWithFunctions {
    public static void main(String[] args) {
        //Composition is only for functions

        Meteor meteor = new Meteor(10);

        Function<Meteor, Integer> readCelsius = Meteor::getTemperature;
        Function<Integer, Double> celsiusToFahrenheit = t -> t*9d/5d +32d;

        Function<Meteor, Double> readFahrenheit1 = readCelsius.andThen(celsiusToFahrenheit);
        Function<Meteor, Double> readFahrenheit2 = celsiusToFahrenheit.composing(readCelsius);

        System.out.println("AndThen Meteor is F " + readFahrenheit1.apply(meteor));
        System.out.println("Composing Meteor is F " + readFahrenheit2.apply(meteor));
    }
}
