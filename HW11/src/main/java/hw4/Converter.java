package hw4;

public class Converter {

    public static double convertToCelsius (double f) {

        return (f - 32) / 1.8;

    }

    public static double convertToFahrenheit (double c) {

        return (c * 1.8) + 32;

    }

}
