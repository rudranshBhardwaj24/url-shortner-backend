package personal_projects.url_shortner.service;

import org.springframework.stereotype.Service;
import personal_projects.url_shortner.entity.Urls;
import personal_projects.url_shortner.repository.UrlsRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class UrlsService {

    private final UrlsRepository urlsRepo;

    public UrlsService(UrlsRepository urlsRepo) {
        this.urlsRepo = urlsRepo;
    }

    public String saveUrl(String key, String value) {
        try {
            if (key == null || key.isEmpty()) {
                key = generateShortKey();
            }

            Urls urls = new Urls(key, value);
            urlsRepo.save(urls);

            return key; // return the short key instead of "Urls saved"
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getUrl(String key) {
        Optional<Urls> urlMapping = urlsRepo.findByKey(key);
        return urlMapping.map(Urls::getValue).orElse("No URL found for this key.");
    }

    public Optional<Urls> getShortendUrl(String key){
        return urlsRepo.findByKey(key);


    }

    // ✅ Key generator function
    private String generateShortKey() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid.substring(0, 6); // short 6-character key
    }
}
