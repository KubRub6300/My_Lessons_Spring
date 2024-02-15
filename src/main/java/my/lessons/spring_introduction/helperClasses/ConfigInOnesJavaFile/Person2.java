package my.lessons.spring_introduction.helperClasses.ConfigInOnesJavaFile;

import my.lessons.spring_introduction.helperClasses.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class Person2 {
    private Pet pet;

    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;


    public Person2(Pet pet) {
        System.out.println("[INFO] Create person use constructor with parameters");
        this.pet = pet;
    }

    public Person2() {
        System.out.println("[INFO] Create person use constructor without parameters");
    }

    public void callYourPet() {
        System.out.println("Hello my pet!");
        pet.say();
    }

    public void setPet(Pet pet) {
        System.out.println("[INFO] Set pet for person");
        this.pet = pet;
    }

    public void setName(String name) {
        System.out.println("[INFO] Set name for person");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        System.out.println("[INFO] Set age for person");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
