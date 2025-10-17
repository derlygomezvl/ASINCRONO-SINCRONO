
package co.edu.unicauca.fiet.submission.api;

import co.edu.unicauca.fiet.submission.domain.Anteproyecto;
import co.edu.unicauca.fiet.submission.service.SubmissionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {
    private final SubmissionService service;

    public SubmissionController(SubmissionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Anteproyecto> crear(
            @Valid @RequestBody Anteproyecto body,
            @RequestParam(name = "sync", defaultValue = "false") boolean sync
    ) {
        Anteproyecto saved = service.crearAnteproyecto(body, sync);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
