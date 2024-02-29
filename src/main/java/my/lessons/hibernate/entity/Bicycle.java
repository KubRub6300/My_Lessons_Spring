package my.lessons.hibernate.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "bicycle")
public class Bicycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "make")
    private String make;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private double price;

    @OneToOne(mappedBy = "bicycle", cascade = CascadeType.ALL)//Указываем, что связь таблиц уже реализована в классе Employee в столбце bicycle
    Employee employee;

    public Bicycle() {
    }

    public Bicycle(String make, String type, double price) {
        this.make = make;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
