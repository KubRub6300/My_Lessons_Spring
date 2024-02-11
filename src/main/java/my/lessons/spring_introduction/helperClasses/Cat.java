package my.lessons.spring_introduction.helperClasses;

public class Cat implements Pet{
    public Cat(){
        System.out.println("[INFO] Create Cat");
    }
    @Override
    public void say() {
        System.out.println("Meow");
    }
}
