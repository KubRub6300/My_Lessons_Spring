package my.lessons.hibernate.many_to_many;

import my.lessons.hibernate.many_to_many.entity.Child;
import my.lessons.hibernate.many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * <h1>Many to Many</h1>
 * Для организации такой связи реализуется Join Table.<br>
 *
 * <h2>Join Table</h2>
 * Это таблица, которая отображает связь между строками 2-ух таблиц.<br>
 * Столбцы Join Table – это внешние ключи, которые ссылаются на внешние ключи связываемых таблиц.<br>
 *
 * <h3>Аннотация @JoinTable</h3>
 * <p>- Мы прописываем название таблицы, которая выполняет роль Join Table.</p>
 * <p>- В joinColumns мы указываем столбец таблицы JoinTable, который ссылается на primary Key source таблицы.</p>
 * <p>- В inverseJoinColumns мы указываем столбец таблицы Join Table, который ссылается на Primary Key target таблицы</p>
 * <br>
 * Пример аннотации для класса Child:
 * <pre>{@code
 * @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
 *             fetch = FetchType.LAZY)
 * @JoinTable(name = "child_section",
 *            joinColumns = @JoinColumn(name = "child_id"),
 *            inverseJoinColumns = @JoinColumn(name = "section_id"))
 * private List<Section> sections;}</pre>
 * <br>
 * Пример аннотации для класса Section:
 * <pre>{@code
 * @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
 *             fetch = FetchType.LAZY)
 * @JoinTable(name = "child_section",
 *            joinColumns = @JoinColumn(name = "section_id"),
 *            inverseJoinColumns = @JoinColumn(name ="child_id"))
 * private List<Child> children;}</pre>
 *
 *
 * @see Child
 * @see Section
 * @author kubarevd
 * @version 1.0
 * */
public class Main {

    public static void main(String[] args) {
        Child child = new Child("Igor",5);
        Child child1 = new Child("Olya",7);
        Section section = new Section("dance");
        Section section1 = new Section("basketball");

        child.addSectionToChild(section);
        section1.addChildToSection(child1);
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Child.class).addAnnotatedClass(Section.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession()){

            session.beginTransaction();

            session.persist(child);
            session.persist(section1);

            session.getTransaction().commit();

        }

    }
}
