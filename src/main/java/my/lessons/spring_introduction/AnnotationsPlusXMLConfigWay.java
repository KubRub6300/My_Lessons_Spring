package my.lessons.spring_introduction;

import my.lessons.spring_introduction.helperClasses.Person;
import my.lessons.spring_introduction.helperClasses.Pet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <h1>Конфигурация с помощью аннотаций</h1>
 * Аннотации – это специальные комментарии/метки/метаданные, которые нужны для передачи определённой информации.<br>
 * Конфигурация с помощью аннотаций более короткий и быстрый способ, чем конфигурация с помощь XML файла. {@link XMLConfigWay}<br><br>
 * Для этого в xml файле указывается какой пакет нужно сканировать для поиска аннотаций.
 * <h3>Пример: </h3>{@code
 *     <context:component-scan
 *             base-package="my.lessons.spring_introduction"/> <!--Указание в каком пакете (и его подпакетах) искать аннотацию component-->}<br>
 * А в самом класс пишется аннотация для класса. Пример такого класса: {@link my.lessons.spring_introduction.helperClasses.Cat}
 *
 * <h2>Внедрение зависимостей</h2>
 * Для внедрения зависимостей с помощью аннотаций используется аннотация @Autowired<br>
 * Типы autowiring-a или где мы можем использовать данные DI:<br>
 * <p>- Конструкторы</p>
 * <p>- Сеттеры(любые методы)</p>
 * <p>- Поле</p>
 *
 * <br>Если при использовании {@code @Autowired} spring не находит бин подходящего типа, то выбрасывается исключение.<br>
 * Если находит более одного бин, то тоже выбрасывает исключение.<Br>
 * Во втором случае можно указать @Qualifier для того, чтобы указать какой конкретно бин должен быть внедрён.<br>
 *
 * <h2>{@code  @Qualifier}</h2>
 * После {@code @Autowired} для поля или сеттера пишется аннотация @Qualifier, для того чтобы явно указать какой bean будет использоваться.<br>
 * Для конструктора с {@code @Autowired} {@code  @Qualifier} пишется перед параметром<br>
 * Примеры:<br>
 * {@code
 *      @Autowired //DI для поля
 *      @Qualifier("dog") //Указываем, что будет использоваться bean dog для DI
 *      private Pet pet;}<br><br>
 * {@code
 *      @Autowired //DI для конструктора
 *      public Person (@Qualifier("dog") Pet pet){
 *      System.out.println("[INFO] Create person use constructor with parameters");
 *      this.pet = pet;
 *     }}
 *
 * <h2>@Value</h2>
 * Позволяет устанавливать значения для переменных.
 *
 * <h2>@Scope</h2>
 * Пишется после @Component, для указания области видимости.
 *
 * <h2>@PostConstruct</h2>
 * Аннотация для указания метода init,  пишется перед методом.
 *
 * <h2>@PreDestroy</h2>
 * Аннотация для указания метода destroy, пишется перед методом.
 *
 * <h2>ПОДКЛЮЧЕНИЕ @PostConstruct и @PreDestroy</h2>
 * Для этого нужно установить dependency jakarta.annotation-api в Maven
 *
 * @see IoC
 * @author kubarevd
 * @version 1.0
 * */
public class AnnotationsPlusXMLConfigWay {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextForAnnotations.xml");
        Pet pet = context.getBean("mouseBean",Pet.class);
        pet.say();

        Person person = context.getBean("person", Person.class);
        person.callYourPet();
        System.out.println("Person name: " + person.getName());
        System.out.println("Person age: " + person.getAge());

        context.close();
    }
}
