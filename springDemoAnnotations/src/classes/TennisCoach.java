package classes;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

//@Component("thatSillyCoach") - could be used if we want to specify bean ID
@Component
@Scope("prototype") //define scope, if prototype it will create new instance for every request
public class TennisCoach implements Coach, DisposableBean
{
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("inside default constructor - tennis coach");
    }

    @Autowired //it works fine if there is only one implementation of FortuneService
    public TennisCoach(@Qualifier("RESTFortuneService") FortuneService fortuneService) {
        //if first two letters of class are uppercase spring will generate same bean ID as class name
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @PreDestroy //for prototype scoped beans this method is not called
    public void doDestroy(){
        System.out.println("inside PreDestroy method - tennis Coach");
    }

    //TODO: check how to set up pre destroy method for prototype scoped beans
    @Override
    public void destroy() throws Exception {
        System.out.println("inside destroy() method - tennis Coach");
    }
}
