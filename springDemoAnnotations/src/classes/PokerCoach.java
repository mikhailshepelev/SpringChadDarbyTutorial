package classes;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PokerCoach implements Coach {

    private FortuneService fortuneService;

    public PokerCoach(@Qualifier("databaseFortuneService")FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Grinding 10 hours...";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
