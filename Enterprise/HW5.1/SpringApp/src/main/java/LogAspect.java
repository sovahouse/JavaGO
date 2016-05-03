import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {

    public Object onExecute(ProceedingJoinPoint pjp) throws Throwable {
        Logger log = Logger.getLogger(LogAspect.class.getName());
        log.info("LogAspect. Before method " + pjp.getSignature().getName() + " was called");
        Object result = pjp.proceed();
        log.info("LogAspect. After method " +pjp.getSignature().getName() + " was called");

        return result;
    }


}
