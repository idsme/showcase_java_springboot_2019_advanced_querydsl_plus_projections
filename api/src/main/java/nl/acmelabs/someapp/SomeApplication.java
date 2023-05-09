package nl.acmelabs.someapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "nl.acmelabs.someapp.repositories")
public class SomeApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SomeApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<SomeApplication> applicationClass = SomeApplication.class;


}
