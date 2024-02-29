package my.lessons.hibernate;

import my.lessons.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.util.List;


/**
 * <h1>Hibernate</h1>
 * Hibernate – framework, который используется для сохранения, получения, изменения и удаления Java объектов из БД.<br>
 * <br>
 * <h3>Плюсы:</h3>
 * <p>1. Предоставляет технологию ORM (Object to Relation Mapping – преобразование объекта в строку в таблице и обратное преобразование)</p>
 * <p>2. Регулирует SQL запросы</p>
 * <p>3. Уменьшает кол-во кода для написания</p>
 * <br>
 * <h3>Подключение в Maven:</h3>
 * <pre>{@code
 *     <dependency>
 *       <groupId>org.hibernate.orm</groupId>
 *       <artifactId>hibernate-core</artifactId>
 *       <version>6.4.1.Final</version>
 *     </dependency>
 *
 *     <dependency>
 *       <groupId>org.postgresql</groupId>
 *       <artifactId>postgresql</artifactId>
 *       <version>42.6.0</version>
 *     </dependency>}
 * </pre>
 *
 * <h3>Настройки hibernate хранятся в resources/hibernate.cfg.xml</h3>
 * <h3>hibernate.cfg.xml:</h3>
 * <pre>
 * {@code
 * <?xml version='1.0' encoding='utf-8'?>
 * <!DOCTYPE hibernate-configuration PUBLIC
 *         "-//Hibernate/Hibernate Configuration DTD//EN"
 *         "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
 * <hibernate-configuration>
 *     <session-factory>
 *         <property name="connection.url">jdbc:postgresql://localhost:5432/mylessonsjava?useSSL=false</property>
 *         <property name="connection.driver_class">org.postgresql.Driver</property>
 *         <property name="connection.username">postgres</property>
 *         <property name="connection.password">852456</property>
 *
 *         <property name="current_session_context_class">thread</property>
 *         <property name="dialect">org.hibernate.dialect.PostgreSQLDialect</property>
 *         <property name="show_sql">true</property>
 *
 *     </session-factory>
 * </hibernate-configuration>
 * }
 * </pre>
 *
 * <h2>Entity класс</h2>
 * Entity класс – Java класс, который отображает информацию определённой таблицы в БД.<br>
 * Entity класс – это POJO класс, в котором мы используем определённые Hibernate аннотации для связи класса с таблицей из базы.<br>
 * <br>
 * PPJO(Plain Old Java Class) – класс, удовлетворяющий ряду условий:
 * <p>- private поля</p>
 * <p>- getter-ы и setter-ы</p>
 * <p>- конструктор без аргументов</p>
 * <p>- и т.д.</p>
 * Пример Entity класса - {@link Employee}
 *
 * <h2>Как работать с такими классами</h2>
 * Смотри метод {@link Main#main(String[])}
 *
 * @author kubarevd
 * @version 1.0
 * @see Employee
 */
public class Main {
    /**
     * <h2>Создание сессии</h2>
     * Для это нам нужна фабрика по производству сессий.
     * <pre>
     *     {@code
     *     SessionFactory sessionFactory = new Configuration()
     *                 .configure("hibernate.cfg.xml")
     *                 .addAnnotatedClass(Employee.class)
     *                 .buildSessionFactory();
     *      Session session = sessionFactory.getCurrentSession();}
     * </pre>
     *
     * <h2>Открытие транзакции</h2>
     * {@code session.beginTransaction();}
     *
     * <h2>Сохранение объекта в базу</h2>
     * {@code session.save(employee);}
     *
     * <h2>Закрытие транзакции</h2>
     * {@code session.getTransaction().commit();}
     * <h2>ПОСЛЕ ЗАКРЫТИЕ ТРАНЗАКЦИИ НУЖНО ЗАНОВО ПОЛУЧАТЬ СЕССИЮ!</h2>
     *
     *
     * <h2>Закрытие SessionFactory</h2>
     * {@code sessionFactory.close();}
     */
    public static void main(String[] args) {
//        SessionFactory sessionFactory = new Configuration().
//                configure("hibernate.cfg.xml").
//                addAnnotatedClass(Employee.class).
//                buildSessionFactory();
//
//        Session session = sessionFactory.getCurrentSession();
//        Date date = new Date(2002, 9, 4);
//        Employee employee = new Employee("Danil", "Kubarev", "Male", "danilkubaerv1@yandex.ru", date, 3);
//
//        session.beginTransaction();
//
//        session.save(employee);
//        session.getTransaction().commit();
//
//        sessionFactory.close();

        //getDBValue();
        updateDBValue();
    }


    public static void getDBValue() {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            //Employee employee = session.get(Employee.class,1);//Получение по Primary Key
            //System.out.println(employee);

            List<Employee> employees = session.createQuery("from Employee").list();//Получение всех объектов из таблицы
            List<Employee> employeesMale = session.createQuery("from Employee where gender = 'Male'").list();//Получение всех мужчин из таблицы (Employee и gender это название столбцов)
            System.out.println("--------------------------------------------- Все работники ---------------------------------------------");
            employees.forEach(System.out::println);
            System.out.println("----------------------------------------------------------------------------------------------------------");

            System.out.println("----------------------------------------------- Все мужчины -----------------------------------------------");
            employeesMale.forEach(System.out::println);
            System.out.println("----------------------------------------------------------------------------------------------------------");

            session.getTransaction().commit();



        }
    }

    public static void updateDBValue(){

        try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory()){

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class,1); // Update значения в одной записи
            employee.setEmail("djkub@gmail.com");

            session.createQuery("update Employee set email = 'brokenenail@mail.com' where id  = 4").executeUpdate();// Update значений в нескольких записях

            session.getTransaction().commit();

        }
    }

    public static void deleteDBValue(){

        try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class,2);
            session.delete(employee); //Удаление одного объекта

            session.createQuery("delete Employee where id = 2").executeUpdate(); //Удаление любого количества объектов с использованием hql

            session.getTransaction().commit();

        }
    }
}
