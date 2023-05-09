package nl.acmelabs.someapp.controller;

import nl.acmelabs.someapp.model.Project;
import nl.acmelabs.someapp.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectManualController {
    @Autowired
    private ProjectRepository repo;

    @GetMapping("/manual/fe/projects")
    public ResponseEntity<Iterable<Project>> getAll()
    {
        Iterable<Project> Projects = repo.findAll();
        return new ResponseEntity<Iterable<Project>>(
                Projects,
                HttpStatus.OK);
    }

    //Shows to many back references...
    //What if we set them to null here and then return the object.
    @GetMapping("manual/fe/projects/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") Long id)
    {
        return repo.findById(id)
                .map(ProjectManualController::removeBackReferences)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Shows to many back references...
    //What if we set them to null here and then return the object.
    @GetMapping("manual/fe/projects/findByNameLikeIgnoreCase/{name}")
    public ResponseEntity<List<Project>> findByNameLikeIgnoreCase(@PathVariable("name") String name)
    {
        List<Project> foundResults = repo.findByNameLikeIgnoreCase(name);
        foundResults.forEach(ProjectManualController::removeBackReferences);
        return ResponseEntity.ok(foundResults);
    }

    // Will not use this for FE but clean without links view on this data.. makes it easier debug and generate Mock Data
    // Yes, we could also create a DTO.. but that is more work.
    public static Project removeBackReferences(Project project) {
        project.user.setProjects(null);
        return project;
    }
}