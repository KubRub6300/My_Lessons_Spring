package my.lessons.spring_introduction;


import my.lessons.spring_introduction.helperClasses.Dog;
import my.lessons.spring_introduction.helperClasses.Pet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <h1>Bean life cycle</h1>
 *
 * <h2>Жизненный цикл бина:</h2>
 * <p>1. Запуск приложения</p>
 * <p>2. Начало работы Spring Container</p>
 * <p>3. Создание бина</p>
 * <p>4. DI - внедряются зависимости</p>
 * <h3>5. init method <br>Пример: {@link Dog#init()}</h3>
 * <p>6. Бин готов для использования</p>
 * <p>7. Использование этого бина</p>
 * <p>8. Конец работы Spring Container</p>
 * <h3>9. destroy method <br>Пример: {@link Dog#destroy()} </h3>
 * <p>10. Остановка приложения</p>
 *
 *
 * @author kubarevd
 * @version 1.0
 * */
public class InitAndDestroy {
    public static void main(String[] args) {

        System.out.println("========= Scope singleton =========");
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");
        //сработает init
        Pet pet = context.getBean("myPet", Pet.class);
        pet.say();

        context.close();
        //сработает destroy



        System.out.println("\n\n\n\n========= Scope prototype =========");
        ClassPathXmlApplicationContext context2 =
                new ClassPathXmlApplicationContext("applicationContext3.xml");
        //сработает init для bean c scope = singleton
        Pet pet2 = context2.getBean("myPet2", Pet.class);
        //сработает init
        Pet pet3 = context2.getBean("myPet2", Pet.class);
        //сработает init
        pet.say();
        Pet pet4 = new Dog();

        context.close();
        //НЕ сработает destroy, нужно самому прописывать код для закрытия/освобождения ресурсов!

    }
}
