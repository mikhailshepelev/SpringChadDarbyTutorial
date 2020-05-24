package classes;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DatabaseFortuneService implements FortuneService {

    private static List<String> list = new ArrayList<>();

    static {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/mikhailshepelev/IdeaProjects/SpringChadDarbyTutorial/springDemoAnnotations/src/resources/RandomFortune"));
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void readFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/mikhailshepelev/IdeaProjects/SpringChadDarbyTutorial/springDemoAnnotations/src/resources/PostConstructFile"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    private Random myRandom = new Random();

    @Override
    public String getFortune() {
        int index = myRandom.nextInt(list.size());
        return list.get(index);
    }
}
