package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    private FortuneService fortuneService;

    public FootballCoach() {
        System.out.println("inside default constructor - FootballCoach");
    }

    @Autowired //setter injection, we can also use any other method with Autowired annotation to inject dependencies
    @Qualifier("randomFortuneService")
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("inside setter method - FootballCoach");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practicing set-pieces";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
