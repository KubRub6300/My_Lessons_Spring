package my.lessons.spring_introduction;

import my.lessons.spring_introduction.helperClasses.ConfigInOnesJavaFile.MyConfig2;
import my.lessons.spring_introduction.helperClasses.ConfigInOnesJavaFile.Person2;
import my.lessons.spring_introduction.helperClasses.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  <h1>Конфигурация с Java Class-а</h1>
 *
 *
 * @see MyConfig
 * @author kubarevd
 * @version 1.0
 * */
public class JavaCode {
    public static void main(String[] args) {

        System.out.println("==========First Way==========");
        firstWay();
        System.out.println("\n==========Second Way==========");
        secondWay();

    }

    public static void firstWay(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Person person = context.getBean("person", Person.class);
        person.callYourPet();

        context.close();
    }

    public static void secondWay(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig2.class);
        Person2 person = context.getBean("person2", Person2.class);
        person.callYourPet();
        System.out.println(person);
        context.close();
    }
}
