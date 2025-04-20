package personal_projects.url_shortner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal_projects.url_shortner.entity.Users;
import personal_projects.url_shortner.service.UsersService;

@RestController
@RequestMapping("api/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(@RequestBody Users req) {
        try {
            Users user = new Users();
            user.setFirstName(req.getFirstName());
            user.setLastName(req.getLastName());
            user.setEmail(req.getEmail());
            user.setPassword(req.getPassword());

            usersService.saveUser(user);
            return ResponseEntity.ok("User saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving user: " + e.getMessage());
        }
    }

    @PostMapping("/get-user")
    public ResponseEntity<?> getUser(@RequestBody Users req) {
        try {
            Users user = usersService.findUserByEmail(req.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found with email: " + req.getEmail());
        }
    }
}
