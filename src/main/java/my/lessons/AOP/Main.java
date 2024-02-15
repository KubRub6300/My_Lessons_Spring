package my.lessons.AOP;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <h1>Aspect Oriented Programming</h1>
 * Парадигма программирования основанная на идеи разделения основного и служебного функционала.
 * Служебный функционал записывается в  Aspect классы.<br>
 * <br>
 * К сквозному функционалу относят:
 * <p>Логирование</p>
 * <p>Проверка прав</p>
 * <p>Обработка транзакций</p>
 * <p>Обработка исключений</p>
 * <p>Кэширование</p>
 * <p>И т.д. всё, что не относится к основной логике</p>
 * <br>
 * <h2>Как реализовать работу AOP:</h2>
 * <p>1. Для класса config пишется аннотация @EnableAspectJAutoProxy в классе конфигурации позволяет использовать AOP за кулисами</p>
 * <p>2. Создаётся класс Aspect (отвечающий за сквозную функциональность). Это обычный класс который помечен аннотацией @Aspect.
 * Для использование этой аннотации надо подключать dependency groupId = org.aspectj artifactId = aspectjweaver</p>
 * <p>3. В самом классе создать advice методы с advice аннотациями (об этом ниже). Это метод который определяет, что должно произойти </p>
 *
 * <h2>Типы Advice:</h2>
 * <p>- Before – перед методом с основной логикой</p>
 * <p>- After returning – выполняется только после нормального окончания метода с основной логикой</p>
 * <p>- After throwing – выполняется поле окончания метода с основной логикой только, если было выброшено исключение</p>
 * <p>- After/After finally – выполняется после окончания метода с основной логикой</p>
 * <p>- Around – выполняется до и после метода с основной логикой</p>
 *
 * @see MyConfig
 * @see my.lessons.AOP.aspects.LoggingAspect
 * @see Library
 * @author kubarevd
 * @version 1.0
 *
 * */
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Library library = context.getBean("library", Library.class);

        Book book = library.getBook();
        System.out.println("Полученная книга: " + book);
        System.out.println("\n");

        try {
            library.returnBook();
        } catch (Exception e) {

        }
        System.out.println("\n");

        library.addBook("dkubarev", context.getBean("book",Book.class));
        System.out.println("\n");

        /*library.getBook("Грокаем алгоритмы");
        System.out.println("\n");*/



        /*library.getBook( context.getBean("book",Book.class));
        System.out.println("\n");*/


        context.close();
    }


}
