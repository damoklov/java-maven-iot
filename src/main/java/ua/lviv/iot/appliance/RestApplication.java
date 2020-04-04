package ua.lviv.iot.appliance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("ua.lviv.iot.appliance.dataaccess")
@ComponentScan({
        "ua.lviv.iot.appliance.controller",
        "ua.lviv.iot.appliance.dataaccess",
        "ua.lviv.iot.appliance.business" })
public class RestApplication {
  public static void main(String[] args) {
    SpringApplication.run(RestApplication.class, args);
  }
}
