package nl.acmelabs.someapp.controller;

import nl.acmelabs.someapp.model.User;
import nl.acmelabs.someapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserManualController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/manual/fe/users")
    public ResponseEntity<Iterable<User>> getAll()
    {
        Iterable<User> users = repo.findAll();
        return new ResponseEntity<Iterable<User>>(
                users,
                HttpStatus.OK);
    }

    @GetMapping("manual/fe/users/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id)
    {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Shows to many back references...
    //What if we set them to null here and then return the object.
    @GetMapping("manual/fe/users/findByNameLikeIgnoreCase/{name}")
    public ResponseEntity<List<User>> findByNameLikeIgnoreCase(@PathVariable("name") String name)
    {
        List<User> foundResults = repo.findByNameLikeIgnoreCase(name);
        return ResponseEntity.ok(foundResults);
    }

    // Will not use this for FE but clean without links view on this data.. makes it easier debug and generate Mock Data
    // Yes, we could also create a DTO.. but that is more work.
    public static User removeBackReferences(User user) {

        user.getProjects().forEach((project)->{
            project.user = null;
        });

        return user;
    }
}