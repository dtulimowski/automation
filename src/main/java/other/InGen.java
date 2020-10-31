package other;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InGen {
    private String name = "Darek";

    public void setName(String name) {
        this.name = name;
    }
    @Bean
    public String getName() {
       return name;
    }
}
