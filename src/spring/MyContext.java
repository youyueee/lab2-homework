package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyContext {
    private static ApplicationContext ac;
    static {
        ac = new ClassPathXmlApplicationContext("spring/context.xml");
    }
    private MyContext() {}
    public static ApplicationContext getAC() {
        return ac;
    }
}
