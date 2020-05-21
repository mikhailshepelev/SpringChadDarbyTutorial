package mainApps;

import classes.Coach;
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
        //close the context
        context.close();
    }
}
