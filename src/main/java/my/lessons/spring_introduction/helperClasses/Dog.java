package my.lessons.spring_introduction.helperClasses;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Dog implements Pet{
    public Dog(){
        System.out.println("[INFO] Create Dog");
    }
    public void say(){
        System.out.println("Bow-wow");
    }

    @PostConstruct
    public void init(){
        System.out.println("[INFO] Dog method init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("[INFO] Dog method destroy");
    }
}
