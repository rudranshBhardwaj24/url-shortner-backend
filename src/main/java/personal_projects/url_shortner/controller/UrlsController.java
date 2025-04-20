package personal_projects.url_shortner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal_projects.url_shortner.entity.Urls;
import personal_projects.url_shortner.service.UrlsService;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/url")
public class UrlsController {


private final UrlsService urlsService;

public UrlsController(UrlsService urlsService){
    this.urlsService = urlsService;
}


    @PostMapping("/save")
    public String saveUrl(@RequestBody Urls request) {
        return "url-shortner-backend-ssdt.onrender.com/api/url/get?key="  + urlsService.saveUrl(request.getKey(),request.getValue());
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getUrl(@RequestParam String key) {
        System.out.println(key);
        Optional<Urls> res = urlsService.getShortendUrl(key);

        return res.map(url -> ResponseEntity.status(HttpStatus.FOUND)
                        .location(URI.create(url.getValue()))
                        .build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
