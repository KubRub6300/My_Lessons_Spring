package my.lessons.spring_introduction;

import my.lessons.spring_introduction.helperClasses.Dog;
import my.lessons.spring_introduction.helperClasses.Person;
import my.lessons.spring_introduction.helperClasses.Pet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <h1>Dependency Injection (DI)</h1>
 * - внедрение зависимостей.<br>
 *
 * DI делает объекты нашего приложения слабо зависимыми друг от друга.<br><br>
 *
 * <h2>Способы внедрения зависимостей:</h2>
 * <p>- С помощью конструкторов {@link DI#usingConstructor()}</p>
 * <p>- С помощью сеттеров {@link DI#usingSetter()}</p>
 * <p>- Autowiring</p>
 * */
public class DI {
    public static void main(String[] args) {
//        Старый код без использования Spring
//        Pet pet = new Dog();
//        Person person = new Person(pet);
//        person.callYourPet();

        usingConstructor();
    }

    private static void usingConstructor(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person = context.getBean("myPerson", Person.class);
        person.callYourPet();
        System.out.println(person);
        context.close();
    }

    private static void usingSetter(){

    }
}
