package hw4;

public class Area {

    public static double calculate(double a, double b, double c) {

        double p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));

    }

    public static double calculate(double a, double b) {

        return a * b;

    }

    public static double calculate(double r) {

        return Math.PI * Math.pow(r, 2);

    }
}
