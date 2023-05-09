package nl.acmelabs.someapp.config;

import nl.acmelabs.someapp.model.Project;
import nl.acmelabs.someapp.model.Reference;
import nl.acmelabs.someapp.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class ExposeEntityIdRestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Project.class, User.class, Reference.class);
    }
}