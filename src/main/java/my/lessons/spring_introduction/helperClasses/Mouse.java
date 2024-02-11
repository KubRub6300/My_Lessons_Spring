package my.lessons.spring_introduction.helperClasses;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component("mouseBean") //Создаём аннотацию для класса, а в скобках указываем id для bean.
@Scope("prototype")
// Если не указывать id, то оно будет равно названию класса, просто первая буква станет прописной.
// НО если хотя бы первые две буквы будут заглавными, то id станет равным названию класса.
// Примеры: Mouse -> mouse; SQLConnect -> SQLConnect
public class Mouse implements Pet{
    @Override
    public void say() {
        System.out.println("Pi – pi – pi");
    }
}
