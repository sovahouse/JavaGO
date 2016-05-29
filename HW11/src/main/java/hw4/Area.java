package hw4;

class Area {

    static double calculate(double a, double b, double c) {

        double p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));

    }

    static double calculate(double a, double b) {

        return a * b;

    }

    static double calculate(double r) {

        return Math.PI * Math.pow(r, 2);

    }
}
