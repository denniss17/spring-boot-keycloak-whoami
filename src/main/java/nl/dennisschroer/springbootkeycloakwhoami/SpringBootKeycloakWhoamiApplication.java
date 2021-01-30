package nl.dennisschroer.springbootkeycloakwhoami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class SpringBootKeycloakWhoamiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKeycloakWhoamiApplication.class, args);
    }

}
