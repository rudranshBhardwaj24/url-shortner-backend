//package personal_projects.url_shortner.rabbit;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MessageProducer {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    public void sendMessage(String message) {
//        rabbitTemplate.convertAndSend(
//                RabbitMQConfig.EXCHANGE_NAME,
//                RabbitMQConfig.ROUTING_KEY,
//                message
//        );
//    }
//}
