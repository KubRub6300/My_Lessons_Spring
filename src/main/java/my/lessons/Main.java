package my.lessons;

/**
 * <h1>Spring Framework.</h1>
 * Позволяет облегчить программирование на Java.<br>
 * <h2>Темы пройденный в Spring:</h2>
 * <p>- Inversion of Control {@link my.lessons.spring_introduction.IoC}</p>
 * <p>- Dependency Injection {@link my.lessons.spring_introduction.DI}</p>
 * <p>- Bean Scope {@link my.lessons.spring_introduction.BeanScope}</p>
 * <p>- Init and Destroy methods {@link my.lessons.spring_introduction.InitAndDestroy}</p>
 * <p>- Aspect-oriented programming {@link my.lessons.AOP.Main}</p>
 * <p>- Hibernate base {@link my.lessons.hibernate.Main}</p>
 *
 * @author kubarevd
 * @version 1.0
 * */
public class Main {
    public static void main(String[] args) {

    }
    public int[] getConcatenation(int[] nums) {
        int[] resultNums = new int[nums.length*2];
        for(int i = 0; i<nums.length;i++){
            resultNums[i] = nums[i];
            resultNums[i+nums.length] = nums[i];
        }
        return resultNums;
    }
}
