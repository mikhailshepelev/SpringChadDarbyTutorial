package mainApps;

import classes.BasketballConfig;
import classes.Coach;
import classes.SportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getDailyWorkout());

        context.close();

        AnnotationConfigApplicationContext context1 =
                new AnnotationConfigApplicationContext(BasketballConfig.class);
        Coach baskCoach = context1.getBean("baskCoach", Coach.class);
        System.out.println(baskCoach.getDailyWorkout());
        System.out.println(baskCoach.getDailyFortune());

    }
}
