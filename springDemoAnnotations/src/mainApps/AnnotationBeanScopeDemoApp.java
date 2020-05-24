package mainApps;

import classes.Coach;
import classes.FortuneService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("resources/applicationContext.xml");

        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
        System.out.println("These two objects are equal? - " + theCoach.equals(alphaCoach));
        System.out.println("Memory location for theCoach: " + theCoach);
        System.out.println("Memory location for alphaCoach: " + alphaCoach);

        FortuneService fortuneService = context.getBean("databaseFortuneService", FortuneService.class);

        context.close();
    }
}
