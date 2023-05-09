package nl.acmelabs.someapp.projections;

import nl.acmelabs.someapp.model.IDescriptions;
import nl.acmelabs.someapp.model.IUser;
import nl.acmelabs.someapp.model.ITimeStamps;
import nl.acmelabs.someapp.model.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "user", types = { User.class })
public interface PUser extends IUser, IDescriptions, ITimeStamps {
}
