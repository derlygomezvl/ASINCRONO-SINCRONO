
package co.edu.unicauca.fiet.notification.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {
    private static final Logger log = LoggerFactory.getLogger(NotificationListener.class);

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void onMessage(@Payload AnteproyectoEvent event) {
        log.info("==> [ASÍNCRONO] Recibido AnteproyectoEvent id={}, titulo={}", event.getId(), event.getTitulo());
        // Simular envío de correos
        log.info("de: no-reply@fiet.edu.co | para: {} | asunto: Nuevo anteproyecto {} | body: Favor revisar.",
                event.getJefeDepartamentoEmail(), event.getTitulo());
        event.getEmailsEstudiantes().forEach(e ->
                log.info("de: no-reply@fiet.edu.co | para: {} | asunto: Registro anteproyecto {} | body: Gracias por su envío.",
                        e, event.getTitulo()));
        event.getEmailsTutores().forEach(e ->
                log.info("de: no-reply@fiet.edu.co | para: {} | asunto: Asignación anteproyecto {} | body: Se ha registrado un nuevo anteproyecto.",
                        e, event.getTitulo()));
    }
}
