package nl.acmelabs.someapp.projections;

import nl.acmelabs.someapp.model.IProject;
import nl.acmelabs.someapp.model.IDescriptions;
import nl.acmelabs.someapp.model.ITimeStamps;
import nl.acmelabs.someapp.model.Project;
import org.springframework.data.rest.core.config.Projection;

// TODO IDSME Create this interface in model package and extend it ..
@Projection(name = "l", types = { Project.class })
public interface PProject extends IProject, IDescriptions, ITimeStamps {
}
