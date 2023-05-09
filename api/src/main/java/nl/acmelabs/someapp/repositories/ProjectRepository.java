package nl.acmelabs.someapp.repositories;

import nl.acmelabs.someapp.model.Project;
import nl.acmelabs.someapp.projections.PProject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "projects", path = "projects", excerptProjection = PProject.class)
public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findByNameIgnoreCase(@Param("name") String name);
    List<Project> findByNameLikeIgnoreCase(@Param("name") String name);

    List<Project> findByUser_NameLikeIgnoreCase(@Param("userName") String userName);

    List<Project> findByUser_Id(@Param("userId")Long id);
    List<Project> findByUser_Name(@Param("userName") String name);

    List<Project> findByNameLikeIgnoreCaseOrUser_NameLikeIgnoreCase(@Param("name") String name, @Param("userName") String userName);

    List<Project> findByNameIgnoreCaseAndUser_NameIgnoreCase(@Param("name") String name, @Param("userName") String userName);
    long countByNameIgnoreCaseAndUser_NameIgnoreCase(@Param("name") String name, @Param("userName") String userName);

    @RestResource(exported = false)
    @Transactional
    @Modifying
    @Query("UPDATE Project e set e.deleted=1 where e.id = ?1")
    void deleteCustom(Long projectId);

}
