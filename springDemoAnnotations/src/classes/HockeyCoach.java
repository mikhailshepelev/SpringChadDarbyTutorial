package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class HockeyCoach implements Coach{

    @Autowired //java uses reflection to inject dependencies using field
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

    @PostConstruct //init and destroy methods should be with no args and public
    public void doStartupStuff(){
        System.out.println("inside doStartupStuff - HockeyCoach");
    }

    @PreDestroy
    public void doCleanupStuff(){
        System.out.println("inside doCleanupStuff - HockeyCoach");
    }

    @Value("${foo.email}")
    public String email;

    @Value("${foo.team}")
    public String team;

    @Value("${foo.id}")
    public String id;

    public HockeyCoach() {
        System.out.println("Inside no arg constructor - hockey coach");
    }

    @Override
    public String getDailyWorkout() {
        return "Practicing slap shot";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
