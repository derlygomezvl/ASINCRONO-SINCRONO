
package co.edu.unicauca.fiet.submission.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class SubmissionPublisher {
    private static final Logger log = LoggerFactory.getLogger(SubmissionPublisher.class);
    private final RabbitTemplate template;

    public SubmissionPublisher(RabbitTemplate template) {
        this.template = template;
    }

    public void publish(AnteproyectoEvent event) {
        log.info("Publicando evento AnteproyectoEvent id={}, titulo={}", event.getId(), event.getTitulo());
        template.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.RK, event);
    }
}
