package nl.acmelabs.someapp.projections;

import nl.acmelabs.someapp.model.IReference;
import nl.acmelabs.someapp.model.Project;
import nl.acmelabs.someapp.model.Reference;
import nl.acmelabs.someapp.model.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "r", types = { Reference.class , User.class, Project.class})
public interface PReference extends IReference {
}
