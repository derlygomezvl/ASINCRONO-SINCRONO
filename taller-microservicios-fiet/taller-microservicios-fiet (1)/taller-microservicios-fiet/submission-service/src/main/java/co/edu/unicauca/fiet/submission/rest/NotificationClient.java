
package co.edu.unicauca.fiet.submission.rest;

import co.edu.unicauca.fiet.submission.messaging.AnteproyectoEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class NotificationClient {
    private static final Logger log = LoggerFactory.getLogger(NotificationClient.class);

    private final RestClient rest;
    private final String baseUrl;

    public NotificationClient(@Value("${notification.base-url:http://localhost:8082}") String baseUrl) {
        this.baseUrl = baseUrl;
        this.rest = RestClient.builder().baseUrl(baseUrl).build();
    }

    public void enviarCorreoAnteproyecto(AnteproyectoEvent event) {
        log.info("[SÍNCRONO] Llamando a Notification Service en {}/api/notifications/anteproyecto", baseUrl);
        ResponseEntity<Void> response = rest.post()
                .uri("/api/notifications/anteproyecto")
                .body(event)
                .retrieve()
                .toBodilessEntity();
        log.info("Respuesta Notification Service: {}", response.getStatusCode());
    }
}
