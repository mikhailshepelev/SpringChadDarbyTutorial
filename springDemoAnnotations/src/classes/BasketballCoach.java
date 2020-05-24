package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BasketballCoach implements Coach{

    FortuneService fortuneService;

    public BasketballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practicing 3 pointers...";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
