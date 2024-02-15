package my.lessons.AOP.aspects;

import my.lessons.AOP.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.SoftException;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * <h1>Aspect класс отвечающий за сквозную функциональность.</h1>
 * Содержит Advice методы.<br>
 * Перед этими методами пишется одна из аннотаций:
 * <p>- Before (Перед началом метода) | Пример: {@link LoggingAspect#beforeGetLoggingAdvice()}</p>
 * <p>- AfterReturning (После успешного окончания метода) | Пример: {@link  LoggingAspect#afterReturningGetBookAdvice(Book)}</p>
 * <p>- AfterThrowing (После окончания метода из за ошибки) | Пример: {@link LoggingAspect#afterThrowingReturnBookAdvice}</p>
 * <p>- After (После любого окончания метода) | Пример: {@link LoggingAspect#afterReturnBookAdvice()}</p>
 * <p>- Around (Внутри него вызывается метод) | Пример: {@link LoggingAspect#aroundAddBookMethod(ProceedingJoinPoint)}</p>
 * и после этих аннотаций в круглых скобках указывается Pointcut.<br>
 * <h2>Pointcut</h2>
 * – выражение, описывающие где должен быть применён Advice.<br>
 * <h3>Структура execution pointcut:</h3>
 * 1. modifies pattern<br>
 * 2. return type pattern<br>
 * 3. declaring type pattern<br>
 * 4. method name pattern(parameters pattern)<br>
 * 5. throws pattern<br>
 * <br>
 * Пример: public void my.lessons.AOP.Library.getBook() throw Exception<br>
 * Пример: public void get*() Все методы начинающиеся на get (конечно public void)<br>
 * Пример: * getBook() Все методы getBook с любы return type<br>
 * Пример: public void getBook(String) Все методы public void getBook с одним параметром<br>
 * Пример: public void *(*) Все методы public void с любым названием и одним параметром<br>
 * Пример: public void *(..) Все методы public void с любым названием и любыми параметрами параметрами (или без них)<br>
 * Пример: public void getBook(my.lessons.AOP.Book) Все методы public void getBook и параметром класса Book<br>
 * <br>
 * <h2>Join Point</h2>
 * Join Point – это точка/момент в выполняемой программе когда следует применить Advice.
 * Т.е. это точка переплетения метода с основной логикой и метода со служебным функционалом.<br>
 * Прописав Join Point в параметре метода Advice, мы получаем доступ к информации о сигнатуре и параметрах метода
 * с основной логикой.
 *
 * @author kubarevd
 * @version 1.0
 * @see my.lessons.AOP.Main
 * @see my.lessons.AOP.MyConfig
 * @see my.lessons.AOP.Library
 */
@Component
@Aspect //Говорит о том, что это аспект класс
@Order(20) //Приоритет запуска этого аспекта (чем меньше, тем раньше)
public class LoggingAspect {


    /*@Before("execution(public void getBook())")//Говорим перед каким методом сработать
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }

    @Before("execution(public void getBook(String))")//Говорим перед каким методом сработать
    public void beforeGetBookParamStringAdvice(){
        System.out.println("beforeGetBookParamStringAdvice: попытка получить книгу с параметром строкой");
    }

    @Before("execution(public void *(*))")//Говорим перед каким методом сработать
    public void beforeAnyMethodOnceAnyParamAdvice(){
        System.out.println("beforeAnyMethodOnceAnyParamAdvice: какая-то сквозная функциональность");
    }

    @Before("execution(public void *(..))")//Говорим перед каким методом сработать
    public void beforeAnyMethodAnyParamAdvice(){
        System.out.println("beforeAnyMethodAnyParamAdvice: какая-то сквозная функциональность");
    }

    @Before("execution(public void getBook(my.lessons.AOP.Book))")//Говорим перед каким методом сработать
    public void beforeGetBookBookParamAdvice(){
        System.out.println("beforeGetBookBookParamAdvice: берём книгу с параметром класса Book");
    }*/

    @Before("my.lessons.AOP.aspects.MyPointcuts.allGetMethodsParam()")
    public void beforeGetLoggingAdvice() {
        System.out.println("----------------------------------------------------");
        System.out.println("beforeGetLoggingAdvice: write Log #1L");
    }

    @Before("my.lessons.AOP.aspects.MyPointcuts.allReturnMethodsParam()")
    public void beforeReturnLoggingAdvice() {
        System.out.println("----------------------------------------------------");
        System.out.println("beforeReturnLoggingAdvice: write Log #2L");
    }

    @Before("my.lessons.AOP.aspects.MyPointcuts.allGetAndReturnMethodsZeroParam()")
    public void beforeGetAndReturnLoggingAdvice() {
        System.out.println("----------------------------------------------------");
        System.out.println("beforeGetAndReturnLoggingAdvice: write Log #3L");
    }

    @Before("my.lessons.AOP.aspects.MyPointcuts.allNotGetAndReturnMethodsZeroParam()")
    public void beforeNotGetAndReturnLoggingAdvice() {
        System.out.println("----------------------------------------------------");
        System.out.println("beforeNotGetAndReturnLoggingAdvice: write Log #4L");
    }

    @Before("my.lessons.AOP.aspects.MyPointcuts.allAddMethodsParam()")
    public static void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        System.out.println("----------------------------------------------------");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        if (methodSignature.getName().equals("addBook")) {
            Object[] args = joinPoint.getArgs();

            for (Object obj : args) {
                if (obj instanceof String) {
                    System.out.println("user name: " + obj);
                } else if (obj instanceof Book) {
                    System.out.println("book: " + ((Book) obj).getName());
                    System.out.println("author: " + ((Book) obj).getAuthor());
                }
            }
        }
    }

    @AfterReturning(pointcut = "my.lessons.AOP.aspects.MyPointcuts.allGetMethodsParam()",
    returning = "book")
    public void afterReturningGetBookAdvice(Book book){
        book.setName(book.getName() + " Отредактировал название книги с помощью AOP");
    }

    @AfterThrowing(pointcut = "my.lessons.AOP.aspects.MyPointcuts.allReturnMethodsParam()",
    throwing = "exception")
    public void afterThrowingReturnBookAdvice(Throwable exception){
        System.out.println("afterThrowingReturnBookAdvice: можно прочитать ошибку, но нельзя её обработать");
        System.out.println("afterThrowingReturnBookAdvice: Ошибка: " + exception);
    }

    @After("my.lessons.AOP.aspects.MyPointcuts.allReturnMethodsParam()")
    public void afterReturnBookAdvice(){
        System.out.println("afterReturnBookAdvice: заканчиваем возврат книги в любом случае");
    }

    /**
     * Берёт на себя ответственность за вызов функции.
     * Если таргет метод выбросит исключение, то его можно обработать, в отличие от AfterThrowing.
     * И после этого пробросить исключение дальше, чтобы не скрывать его, а просто записать в логи.
     * */
    @Around("my.lessons.AOP.aspects.MyPointcuts.allAddMethodsParam()")
    public Object aroundAddBookMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("aroundAddBookMethod: Начало добавления книги");
        long startTime = System.currentTimeMillis();
        Object result;
        try {
            result = proceedingJoinPoint.proceed();
        }catch (Exception exception){
            System.out.println("aroundAddBookMethod: было поймано исключение" + exception);
            throw exception;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("aroundAddBookMethod: Конец добавления книги");
        System.out.println("aroundAddBookMethod: Время добавления книги = " + (endTime - startTime) + " мс");
        return result;

    }
}
