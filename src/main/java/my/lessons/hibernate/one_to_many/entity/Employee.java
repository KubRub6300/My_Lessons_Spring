package my.lessons.hibernate.one_to_many.entity;

import jakarta.persistence.*;
import my.lessons.hibernate.entity.Bicycle;

import java.util.Date;


/**
 * <h1>Entity класс Employee</h1>
 * Java класс, который отображает информацию таблицы employee в БД.<br>
 *
 * <h3>Аннотации импортировать из JAKARTA!</h3>
 * JPA(Java Persistence API) – стандартная спецификация, которая описывает систему для управления сохранением Java объектов в таблицы базы данных.<br>
 * Hibernate – самая популярная реализация спецификации JPA.<br>
 * Таким образом JPA описывает правила, а Hibernate реализует их.<br>
 * Если в какой-то момент будет решено поменять реализацию JPA, то не прийдётся переписывать весь код.<br>
 * <br>
 * <h2>Необходимые аннотации:</h2>
 * <p>- Entity (говорит, что наш класс Entity)</p>
 * <p>- Table(name="имя таблицы") (говорит, к какой таблице относится наш класс, если не указать название в скобках, то будет использована таблица с таким же названием к у класса, только с маленькой буквы)</p>
 * <p>- Column(name="имя столбца") (связывает поле в класс со столбцом из таблицы)</p>
 * <p>- Id (помечаем поле которое связанно со столбцом primary key)</p>
 * <p>- GeneratedValue(strategy = значение) (описывает стратегию по генерации значений для столбца Primary Key)</p>
 * <pre>
 *      Принимает одно из значений:
 *      1. GenerationType.AUTO – дефолтный тип. Выбор стратегии будет зависеть от типа базы, с которой мы работаем.
 *      2. GenerationType.IDENTITY – полагается на автоматическое увелечения столбца по правилам, прописанным в БД. (НАИБОЛЕЕ ПРАВИЛЬНЫЙ)
 *      3. GenerationType.SEQUENCE – полагается на работу Sequence, созданного в БД.
 *      4. GenerationType.TABLE – полагается на значение столбца таблицы БД. Цель такой таблицы – поддержка уникальности значений.
 * </pre>
 */
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private Date date_of_birth;
    @Column
    private int salary;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "department_id")
    Department department = new Department();
    public Employee() {
    }

    public Employee(String first_name, String last_name, String gender, String email, Date date_of_birth, int salary) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", date_of_birth=" + date_of_birth +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
