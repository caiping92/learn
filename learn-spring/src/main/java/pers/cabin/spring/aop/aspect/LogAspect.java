package pers.cabin.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 当我们使用 @Aspect 来修饰一个 Java 类之后，Spring 将不会把该 Bean 当成组件 Bean 处理，
 * 因此负责自动增强的后处理 Bean 将会略过该 Bean，不会对该 Bean 进行任何增强处理。
 * 无须担心使用 @Aspect 定义的方面类被增强处理，当 Spring 容器检测到某个 Bean 类使用了
 *
 * @Aspect 标注之后，Spring 容器不会对该 Bean 类进行增强。
 * <p>
 * http://wiki.jikexueyuan.com/project/spring/aop-with-spring-framenwork/aspectj-based-aop-with-spring.html
 * <p>
 * https://my.oschina.net/itblog/blog/211693
 * <p>
 * 代理
 * arround  afterReturning 增强处理
 * <p>
 * Created by caiping on 2017/9/23.
 */
@Component
@Aspect
public class LogAspect {
    //    @Pointcut("execution(* pers.cabin.spring.aop.service.*.*(..))")
    @Pointcut("execution(* pers.cabin.spring.aop.service.*.*(..))")
    private void selectAll() {
        System.out.println(">>>>>>>>selectAll()<<<<<<");
    }

    @Pointcut("execution(* pers.cabin.spring.aop.service.*.*(..))")
    private void businessService() {
        System.out.println(">>>>>>>>selectAll()<<<<<<");
    }

    @Before("selectAll()")
    public void beforeAdvice() {
        System.out.println(">>>>>>>>beforeAdvice()<<<<<<");
    }

    @After("selectAll()")
    public void afterAdvice() {
        System.out.println(">>>>>>>>afterAdvice()<<<<<<");
    }

    @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
    public void AfterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("There has been an exception: " + ex.toString());
    }

    @Around("businessService()")
    public Object doAroundTask(ProceedingJoinPoint point) throws Throwable {

        System.out.println(">>>>>>>>>>>doAroundTask<<<<<");
        System.out.println("@Around：执行目标方法之前...");
        //访问目标方法的参数：
        Object[] args = point.getArgs();
        if (args != null && args.length > 0 && args[0].getClass() == String.class) {
            args[0] = "改变后的参数1";
        }
        //用改变后的参数执行目标方法
        Object returnValue = point.proceed(args);
        System.out.println("@Around：执行目标方法之后...");
        System.out.println("@Around：被织入的目标对象为：" + point.getTarget());
        return "原返回值：" + returnValue + "，这是返回结果的后缀";
    }

    @AfterReturning(pointcut = "selectAll()", returning = "retVal")
    public void afterReturningAdvice(JoinPoint point, Object retVal) {
        System.out.println(">>>>>>>>afterAdvice()<<<<<<");

        System.out.println("@AfterReturning：模拟日志记录功能...");
        System.out.println("@AfterReturning：目标方法为：" +
                point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        System.out.println("@AfterReturning：参数为：" +
                Arrays.toString(point.getArgs()));
        System.out.println("@AfterReturning：返回值为：" + retVal);
        System.out.println("@AfterReturning：被织入的目标对象为：" + point.getTarget());
    }
}
