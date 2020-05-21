package classes;

import org.springframework.stereotype.Component;

//@Component("thatSillyCoach") - could be used if we want to specify bean ID
@Component
public class TennisCoach implements Coach
{
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
