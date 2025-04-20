package personal_projects.url_shortner.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageProducer producer;

    @PostMapping
    public String sendMessage(@RequestBody String message) {
        producer.sendMessage(message);
        return "Message sent: " + message;
    }
}

