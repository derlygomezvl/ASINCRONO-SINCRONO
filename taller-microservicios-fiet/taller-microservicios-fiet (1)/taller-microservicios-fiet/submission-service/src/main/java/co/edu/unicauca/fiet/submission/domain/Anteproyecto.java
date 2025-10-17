
package co.edu.unicauca.fiet.submission.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class Anteproyecto {
    @NotNull
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    @Email
    private String jefeDepartamentoEmail;
    @NotNull
    private List<Persona> estudiantes;
    @NotNull
    private List<Persona> tutores;

    public static class Persona {
        @NotBlank
        private String nombre;
        @NotBlank
        @Email
        private String email;
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getJefeDepartamentoEmail() { return jefeDepartamentoEmail; }
    public void setJefeDepartamentoEmail(String jefeDepartamentoEmail) { this.jefeDepartamentoEmail = jefeDepartamentoEmail; }
    public List<Persona> getEstudiantes() { return estudiantes; }
    public void setEstudiantes(List<Persona> estudiantes) { this.estudiantes = estudiantes; }
    public List<Persona> getTutores() { return tutores; }
    public void setTutores(List<Persona> tutores) { this.tutores = tutores; }
}
