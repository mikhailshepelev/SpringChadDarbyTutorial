package mainApps;

import classes.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("resources/beanLifeCycle-applicationContext.xml");
        Coach theCoach = context.getBean("myCoach", Coach.class);
        System.out.println(theCoach.getDailyWorkout());
        context.close();

        System.out.println("=========================================");

        ClassPathXmlApplicationContext context1 =
                new ClassPathXmlApplicationContext("resources/beanLifeCycle-applicationContext.xml");
        //demonstration how destroy method works for prototype scoped beans
        Coach otherCoach = context1.getBean("otherCoach", Coach.class);
        System.out.println(otherCoach.getDailyWorkout());
        context1.close();
        //TODO: understand why init method called twice second time
    }
}
