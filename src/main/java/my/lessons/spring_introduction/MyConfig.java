package my.lessons.spring_introduction;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Класс конфигурации, заменяет xml файл
 * */
@Configuration//Указываем, что это класс конфигурации Spring
@ComponentScan("my.lessons.spring_introduction") //Указываем какой пакет сканировать
public class MyConfig {
}
