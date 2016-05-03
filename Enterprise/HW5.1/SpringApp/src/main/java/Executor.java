import java.util.Scanner;

public class Executor {

    private Calculator calculator;

    public Executor(Calculator calculator) {
        this.calculator = calculator;
    }

    public void execute() {

        System.out.print("Enter the expression:");
        Scanner sc = new Scanner(System.in);
        String result = calculator.calculate(sc.next());

        System.out.println(result);

    }

}
