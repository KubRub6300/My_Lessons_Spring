package my.lessons.AOP.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)//Приоритет запуска этого аспекта (чем меньше, тем раньше)
public class SecurityAspect {


    @Before("my.lessons.AOP.aspects.MyPointcuts.allGetMethodsParam()")
    public void beforeGetSecurityAdvice(){
        System.out.println("----------------------------------------------------");
        System.out.println("beforeGetSecurityAdvice: write Log #1S");
    }

}
