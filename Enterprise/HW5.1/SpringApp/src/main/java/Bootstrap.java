import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Bootstrap {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "aop-context.xml");
        Executor executor = applicationContext.getBean("executor", Executor.class);
        executor.execute();
    }


}
