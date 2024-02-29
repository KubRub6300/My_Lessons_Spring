package my.lessons.hibernate;

import my.lessons.hibernate.entity.Bicycle;
import my.lessons.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.function.EveryAnyEmulation;
import org.w3c.dom.ls.LSException;

import java.sql.Date;
import java.util.List;

public class OneToOne {
    public static void main(String[] args) {

        try(SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Bicycle.class).buildSessionFactory();
            Session session = sessionFactory.getCurrentSession()){

            session.beginTransaction();

            Date date = new Date(2002, 9, 4);
//            Employee employee = new Employee("Zaur","Pedorov","Male","zaur@mail.ru",date);
//
//            Bicycle bicycle = new Bicycle("PromVel","Sport",3420.0);
//            employee.setBicycle(bicycle);
//
//            session.save(employee);//Благодаря каскаду создаст и запись в велосипедах

//            List<Employee> employees = session.createQuery("from Employee where bicycle is not null").list();// Получение всех работников с велосипедами
//            employees.forEach((employee)->{
//                System.out.println("----------------------------------------------------------- Employee -----------------------------------------------------------");
//                System.out.println(employee);
//                System.out.println(employee.getBicycle());
//                return;
//            });


            Employee employee = new Employee("Petr","Sokolv","Male","sokol@mail.ru",date);

            Bicycle bicycle = new Bicycle("IProfTrans","Sport",11000.0);
            employee.setBicycle(bicycle);

            bicycle.setEmployee(employee);


            session.save(bicycle);//Благодаря каскаду создаст и запись в велосипедах


            session.getTransaction().commit();
        }

    }
}
