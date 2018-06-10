package pers.cabin.springdata.jpa.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by caiping on 2017/6/11.
 */
public class ApplicationUtils {
    private static ApplicationContext  context=null;

    private static String config = "classpath:/spring-jpa.xml";
    private ApplicationUtils() {
    }

    public static ApplicationContext getApplicationContext() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext(config);
        }
        return context;
    }
}
