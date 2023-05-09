package nl.acmelabs.someapp.repositories;

import nl.acmelabs.someapp.model.User;
import nl.acmelabs.someapp.projections.PUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "users", path = "users", excerptProjection = PUser.class)
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByNameIgnoreCase(@Param("name") String name);
    long countByNameIgnoreCase(@Param("name") String name);
    List<User> findByNameLikeIgnoreCase(@Param("name") String name);
}
