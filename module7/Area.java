
public class Area {

    public static double calculate(double a, double b, double c) { //make a variables final

        double p = (a + b + c) / 2; // make a variable final

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));

    }

    public static double calculate(double a, double b) { //make a variables final

        return a * b;

    }

    public static double calculate(double r) { //make a variable final

        return Math.PI * Math.pow(r, 2);

    }
}
