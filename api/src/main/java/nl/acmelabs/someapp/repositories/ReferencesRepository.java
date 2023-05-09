package nl.acmelabs.someapp.repositories;

import nl.acmelabs.someapp.model.Reference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "references", path = "references")
public interface ReferencesRepository extends CrudRepository<Reference, Long> {

    List<Reference> findByNameIgnoreCase(@Param("name") String name);
    List<Reference> findByTypeIgnoreCase(@Param("type") String type);
    List<Reference> findByNameLikeIgnoreCase(@Param("name") String name);

}
