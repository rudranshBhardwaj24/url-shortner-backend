package personal_projects.url_shortner.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import personal_projects.url_shortner.entity.Urls;
import personal_projects.url_shortner.entity.Users;

import java.util.Optional;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
    Optional<Users> findByEmail(String email); // find using email field
}

