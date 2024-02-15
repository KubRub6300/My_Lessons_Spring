package my.lessons.spring_introduction.helperClasses.ConfigInOnesJavaFile;

import my.lessons.spring_introduction.helperClasses.Pet;

public class Dog2 implements Pet {
    public Dog2(){
        System.out.println("[INFO] Create Dog2");
    }
    @Override
    public void say() {
        System.out.println("Bow-wow");
    }
}
