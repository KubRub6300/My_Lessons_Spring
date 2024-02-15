package my.lessons.AOP;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("my.lessons.AOP")
@EnableAspectJAutoProxy
public class MyConfig {
}
