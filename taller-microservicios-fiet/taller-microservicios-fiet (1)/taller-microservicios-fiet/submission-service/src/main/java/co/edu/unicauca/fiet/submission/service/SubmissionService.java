
package co.edu.unicauca.fiet.submission.service;

import co.edu.unicauca.fiet.submission.domain.Anteproyecto;
import co.edu.unicauca.fiet.submission.messaging.AnteproyectoEvent;
import co.edu.unicauca.fiet.submission.messaging.SubmissionPublisher;
import co.edu.unicauca.fiet.submission.rest.NotificationClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SubmissionService {
    private static final Logger log = LoggerFactory.getLogger(SubmissionService.class);
    private final SubmissionPublisher publisher;
    private final NotificationClient notificationClient;

    private final ConcurrentHashMap<Long, Anteproyecto> db = new ConcurrentHashMap<>();

    public SubmissionService(SubmissionPublisher publisher, NotificationClient notificationClient) {
        this.publisher = publisher;
        this.notificationClient = notificationClient;
    }

    public Anteproyecto crearAnteproyecto(Anteproyecto dto, boolean sync) {
        // "Persistir" en memoria
        db.put(dto.getId(), dto);
        log.info("Anteproyecto persistido id={} titulo={}", dto.getId(), dto.getTitulo());

        // Construir evento
        List<String> ests = new ArrayList<>();
        dto.getEstudiantes().forEach(p -> ests.add(p.getEmail()));
        List<String> tuts = new ArrayList<>();
        dto.getTutores().forEach(p -> tuts.add(p.getEmail()));

        AnteproyectoEvent event = new AnteproyectoEvent(
                dto.getId(), dto.getTitulo(), dto.getJefeDepartamentoEmail(), ests, tuts
        );

        if (sync) {
            notificationClient.enviarCorreoAnteproyecto(event);
        } else {
            publisher.publish(event);
        }
        return dto;
    }
}
