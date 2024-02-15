package my.lessons.AOP.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(* get*(..))") //Объявление pointCut
    public void allGetMethodsParam(){}

    @Pointcut ("execution(* return*(..))")
    public void allReturnMethodsParam(){}

    @Pointcut ("execution(* add*(..))")
    public void allAddMethodsParam(){}

    @Pointcut("allGetMethodsParam() || allReturnMethodsParam()") //Объединение Pointcut-ов сработает для одно из них
    public void allGetAndReturnMethodsZeroParam(){}


    @Pointcut("!allGetAndReturnMethodsZeroParam()")//Все методы кроме get и return
    public void allNotGetAndReturnMethodsZeroParam(){}
}
