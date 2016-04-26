import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Runner runner = applicationContext.getBean("runner", Runner.class);
        runner.execute();
    }

    private void execute() {

        Calculator calculator = new Calculator();

        System.out.print("Enter the expression:");
        Scanner sc = new Scanner(System.in);
        String result = calculator.calculate(sc.next());

        System.out.println(result);

    }
}
