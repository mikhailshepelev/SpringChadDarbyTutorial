package mainApps;

import classes.Coach;
import classes.HockeyCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        //read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        //get the bean from spring contaner
        //could be used with specified bean ID
        //Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
        //---------------------------------
        //demonstration of using default bean ID
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        //call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        //usage of setter injection demonstration
        Coach otherCoach = context.getBean("footballCoach", Coach.class);
        System.out.println(otherCoach.getDailyWorkout());
        System.out.println(otherCoach.getDailyFortune());

        //usage of field injection demo
        HockeyCoach hockeyCoach = context.getBean("hockeyCoach", HockeyCoach.class);
        System.out.println(hockeyCoach.getDailyWorkout());
        System.out.println(hockeyCoach.getDailyFortune());
        System.out.println(hockeyCoach.email + " " + hockeyCoach.team + " " + hockeyCoach.id);

        System.out.println("=============================");
        Coach pokerCoach = context.getBean("pokerCoach", Coach.class);
        System.out.println(pokerCoach.getDailyWorkout());
        System.out.println(pokerCoach.getDailyFortune());

        //close the context
        context.close();
    }
}
