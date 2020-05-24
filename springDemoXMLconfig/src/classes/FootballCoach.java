package classes;

public class FootballCoach implements Coach {

    private FortuneService fortuneService;

    public FootballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public FootballCoach() {
    }

    @Override
    public String getDailyWorkout() {
        return "Practicing set pieces...";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
