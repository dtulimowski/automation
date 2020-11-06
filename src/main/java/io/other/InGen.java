package io.jobee.other;

import org.springframework.stereotype.Component;

@Component
public class InGen {
    private String name = "Darek";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        System.out.println("\n\n" + name + "\n\n");
       return name;
    }
}
