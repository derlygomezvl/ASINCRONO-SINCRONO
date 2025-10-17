
package co.edu.unicauca.fiet.notification.service;

import co.edu.unicauca.fiet.notification.messaging.AnteproyectoEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private static final Logger log = LoggerFactory.getLogger(EmailService.class);

    public void enviarCorreoJefe(AnteproyectoEvent event) {
        log.info("==> [SÍNCRONO] Enviando email (simulado) al jefe: de: no-reply@fiet.edu.co | para: {} | asunto: Nuevo anteproyecto {} | body: Favor revisar.",
                event.getJefeDepartamentoEmail(), event.getTitulo());
    }
}
