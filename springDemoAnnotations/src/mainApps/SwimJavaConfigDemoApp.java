package mainApps;

import classes.SportConfig;
import classes.SwimCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getEmail() + " " + theCoach.getTeam());

        context.close();
    }
}
