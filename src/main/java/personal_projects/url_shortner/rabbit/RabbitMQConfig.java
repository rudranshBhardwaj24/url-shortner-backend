//package personal_projects.url_shortner.rabbit;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQConfig {
//
//    public static final String QUEUE_NAME = "testing-queue";
//    public static final String EXCHANGE_NAME = "testing-exchange";
//    public static final String ROUTING_KEY = "testing-routing-key";
//
//    @Bean
//    public Queue queue() {
//        return new Queue(QUEUE_NAME);
//    }
//
//    @Bean
//    public DirectExchange exchange() {
//        return new DirectExchange(EXCHANGE_NAME);
//    }
//
//    @Bean
//    public Binding binding(Queue queue, DirectExchange exchange) {
//        return BindingBuilder
//                .bind(queue)
//                .to(exchange)
//                .with(ROUTING_KEY);
//    }
//}
