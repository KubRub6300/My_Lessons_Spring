package my.lessons.spring_introduction.helperClasses.ConfigInOnesJavaFile;

import my.lessons.spring_introduction.helperClasses.Dog;
import my.lessons.spring_introduction.helperClasses.Person;
import my.lessons.spring_introduction.helperClasses.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:myApp.properties")
public class MyConfig2 {

    @Bean
    public Pet petBean(){
        return new Dog2();
    }

    @Bean
    public Person2 person2(){
        return new Person2(petBean());
    }

}
