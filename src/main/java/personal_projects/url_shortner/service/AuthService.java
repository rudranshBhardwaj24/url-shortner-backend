package personal_projects.url_shortner.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import personal_projects.url_shortner.entity.Users;
import personal_projects.url_shortner.repository.UsersRepository;

import java.util.Optional;

@Service
public class AuthService {

    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UsersRepository usersRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean login(String email, String password) {
        Optional<Users> user = usersRepository.findByEmail(email);

        if (user.isPresent()) {
            return passwordEncoder.matches(password, user.get().getPassword());
        }
        return false; // User not found or password doesn't match
    }
}
