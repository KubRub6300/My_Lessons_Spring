package my.lessons.spring_introduction;

import my.lessons.spring_introduction.helperClasses.Pet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <h1>Способ конфигурации Spring Context с помощью xml файла.</h1>
 * Для такого способа необходимо создать applicationContext.xml файл в папке с ресурсами.<br><br>
 * В этом файле необходимо создать bean (объект который создаётся и управляется Spring Container).<br>
 * Пример:<br>
 * {@code
 *     <bean id="myPet"
 *          class="my.lessons.spring_introduction.helperClasses.Cat">
 *     </bean>}
 * При работе в java классе с applicationContext таким способом <h2>всегда необходимо закрывать context!</h2>
 * */
public class XMLConfigWay {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Pet pet = context.getBean("myPet",Pet.class);
        pet.say();
        Pet pet2 = context.getBean("myPet", Pet.class);
        System.out.println(String.valueOf(pet==pet2));
        context.close();
    }
}
