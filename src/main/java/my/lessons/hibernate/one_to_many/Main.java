package my.lessons.hibernate.one_to_many;

import my.lessons.hibernate.one_to_many.entity.Department;
import my.lessons.hibernate.one_to_many.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Date date = new Date(2002, 9, 4);

        Employee employee_ivan = new Employee("Ivan","Vorobyov","Male","vorob@mail.ru",date,400);
        Employee employee_sergey = new Employee("Sergei","Sidorov","Male","sidoi@mail.ru",date,800);
        Department department = new Department("IT",300,1200);

        department.addEmployeeToDepartment(employee_ivan);
        department.addEmployeeToDepartment(employee_sergey);

        try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            List<Department> departments = session.createQuery("from Department where name = 'IT'").list();
            Employee employee = (Employee) session.createQuery("from Employee where id = 22").list().get(0);
            session.delete(employee);

            departments.forEach(department1->{
                department1.getEmployees().forEach(System.out::println);
            });

            session.getTransaction().commit();

        }
    }
}
