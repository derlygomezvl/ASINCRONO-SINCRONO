
package co.edu.unicauca.fiet.notification.api;

import co.edu.unicauca.fiet.notification.messaging.AnteproyectoEvent;
import co.edu.unicauca.fiet.notification.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final EmailService emailService;

    public NotificationController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/anteproyecto")
    public ResponseEntity<Void> enviarCorreoAnteproyecto(@RequestBody AnteproyectoEvent event) {
        emailService.enviarCorreoJefe(event);
        return ResponseEntity.ok().build();
    }
}
