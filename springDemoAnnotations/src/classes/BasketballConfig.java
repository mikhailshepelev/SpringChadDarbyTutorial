package classes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasketballConfig {

    @Bean
    public FortuneService fantasticFortune(){
        return new SuperFortune();
    }

    @Bean Coach baskCoach(){
        return new BasketballCoach(fantasticFortune());
    }

}
