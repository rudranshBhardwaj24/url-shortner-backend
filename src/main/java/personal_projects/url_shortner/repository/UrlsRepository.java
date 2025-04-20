package personal_projects.url_shortner.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import personal_projects.url_shortner.entity.Urls;

import java.util.Optional;

@Repository
public interface UrlsRepository extends MongoRepository<Urls, String> {
    Optional<Urls> findByKey(String key);
}
