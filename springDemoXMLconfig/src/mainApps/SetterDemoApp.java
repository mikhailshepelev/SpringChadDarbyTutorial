package mainApps;

import classes.CricketCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        //we use CricketCoach var type because Coach class doesnt have methods getEmail and getTeam
        CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getEmailAddress());
        System.out.println(theCoach.getTeam());

        CricketCoach otherCoach = context.getBean("otherCricketCoach", CricketCoach.class);
        System.out.println(otherCoach.getEmailAddress());
        System.out.println(otherCoach.getTeam());
        context.close();
    }
}
