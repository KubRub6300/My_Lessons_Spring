package my.lessons.spring_introduction;


import my.lessons.spring_introduction.helperClasses.Pet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <h1>Bean Scope</h1>
 * Scope (область видимости) определяет:<br>
 * <p>- жизненный цикл бина</p>
 * <p>- возможное кол-во создаваемых бинов</p>
 * <br>
 * <h2>Разновидности bean scope:</h2>
 * <p>- singleton {@link BeanScope#singletonScope()}</p>
 * <p>- prototype {@link BeanScope#prototypeScope}</p>
 * <p>- request</p>
 * <p>- session</p>
 * <p>- global-session</p>
 * <p>P.S.: последние 3 относятся к web разработке</p>
 * <br>
 * Scope указывается в самом бине. По умолчанию он равен singleton.<br>
 * Пример:<br>
 * {@code
 *     <bean id="myPet"
 *           class="my.lessons.spring_introduction.helperClasses.Dog"
 *           scope="prototype">
 *     </bean>}
 * @author kubarevd
 * @version 1.0
 * */
public class BeanScope {
    public static void main(String[] args) {
        //singletonScope();
        prototypeScope();
    }

    /**
     * <h1>Bean Scope Singleton</h1>
     * Является scope-ом для всех бинов по умолчанию.
     * <h2>Его особенности:</h2>
     * <p>- Такой бин создаётся сразу после прочтения Spring Container-ом конфига файла</p>
     * <p>- Является общим для всех, кто запросит его у Spring Container-a </p>
     * <p>Подходит для stateless объектов (объекты состояние которых менять не приходится)</p>
     *
     * */
    private static void singletonScope(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml"); //В этот момент создастся bean
        Pet pet1 = context.getBean("myPet", Pet.class);
        Pet pet2 = context.getBean("myPet", Pet.class);
        System.out.println("pet1 == pet2: " + String.valueOf(pet1==pet2));
        context.close();
    }

    /**
     * <h1>Bean Scope Prototype</h1>
     * <h2>Его особенности:</h2>
     * <p>- Такой бин создаётся только после обращения к Spring Container-у с помощью метода getBean</p>
     * <p>- Для каждого обращения создаётся новый бин в Spring Container-е </p>
     * <p>Подходит для stateful объектов ()</p>
     *
     * */
    private static void prototypeScope(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");//Bean ещё не создан
        Pet pet1 = context.getBean("myPet2", Pet.class);//создаёт новый bean
        Pet pet2 = context.getBean("myPet2", Pet.class);//создаёт новый bean
        System.out.println("pet1 == pet2: " + String.valueOf(pet1==pet2));
        context.close();
    }
}
