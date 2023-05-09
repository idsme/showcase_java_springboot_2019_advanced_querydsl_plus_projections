package nl.acmelabs.someapp.controller;

import nl.acmelabs.someapp.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@BasePathAwareController
public class ProjectController {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @PatchMapping(value = "/projects/softdelete/{projectId}")
    ResponseEntity<Long> deleteCustom(@PathVariable("projectId") Long projectId) {
        if (!projectRepository.existsById(projectId)) {
            return ResponseEntity.notFound().build();
        }

        projectRepository.deleteCustom(projectId);
        return ResponseEntity.ok(projectId);
    }
}
