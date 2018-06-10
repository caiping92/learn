package pers.cabin.spring.utils;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by caiping on 2017/3/19.
 */
public class SpringUtils {
    private static XmlBeanFactory xmlBeanFactory;
    private static ApplicationContext applicationContext;
    private SpringUtils() {
    }

    private static Resource resource=new ClassPathResource("spring-context.xml");
    @Deprecated
    public static XmlBeanFactory getBeanFactory() {
        if (xmlBeanFactory != null) {
            return xmlBeanFactory;
        }
        xmlBeanFactory= new XmlBeanFactory(resource);
        return xmlBeanFactory;
    }

    public static ApplicationContext getApplicationContext() {
        if (applicationContext != null) {
            return applicationContext;
        }
        return new ClassPathXmlApplicationContext("spring-context.xml");
    }
}
