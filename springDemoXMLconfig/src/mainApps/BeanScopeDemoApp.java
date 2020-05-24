package mainApps;

import classes.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("resources/beanScope-applicationContext.xml");
        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);
        System.out.println("Pointing to the same object: " + theCoach.equals(alphaCoach));
        System.out.println("Memory location for theCoach: " + theCoach);
        System.out.println("Memory location for alphaCoach: " + alphaCoach);

        Coach theCoachPrototype = context.getBean("otherCoach", Coach.class);
        Coach alphaCoachPrototype = context.getBean("otherCoach", Coach.class);
        System.out.println("Pointing to the same object: " + theCoachPrototype.equals(alphaCoachPrototype));
        System.out.println("Memory location for theCoach: " + theCoachPrototype);
        System.out.println("Memory location for alphaCoach: " + alphaCoachPrototype);

        System.out.println("=========================================");

        Coach footballCoach = context.getBean("footballCoach", Coach.class);
        Coach otherFootballCoach = context.getBean("footballCoach", Coach.class);
        System.out.println("Pointing to the same object: " + footballCoach.equals(otherFootballCoach));
        System.out.println("Memory location for theCoach: " + footballCoach);
        System.out.println("Memory location for alphaCoach: " + otherFootballCoach);

        context.close();
    }
}
