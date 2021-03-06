package pers.cabin.demo.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by caiping on 2017/3/17.
 */
public class SpringUtils {
    private static ApplicationContext applicationContext;

    public SpringUtils() {
    }


    public static ApplicationContext getApplicationContext() {
        if (applicationContext != null) {
            return applicationContext;
        }

        applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-context.xml"});
        return applicationContext;
    }
}
