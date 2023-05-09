package nl.acmelabs.someapp.projections;

import nl.acmelabs.someapp.model.Project;
import nl.acmelabs.someapp.model.Reference;
import nl.acmelabs.someapp.model.User;
import org.springframework.data.rest.core.config.Projection;

// Tested and works
@Projection(name = "d", types = { Reference.class , User.class, Project.class})
public interface PDescription {
    Long getId();
}
