
package co.edu.unicauca.fiet.notification.messaging;

import java.util.List;

public class AnteproyectoEvent {
    private Long id;
    private String titulo;
    private String jefeDepartamentoEmail;
    private List<String> emailsEstudiantes;
    private List<String> emailsTutores;

    public AnteproyectoEvent() {}

    public AnteproyectoEvent(Long id, String titulo, String jefeDepartamentoEmail,
                             List<String> emailsEstudiantes, List<String> emailsTutores) {
        this.id = id;
        this.titulo = titulo;
        this.jefeDepartamentoEmail = jefeDepartamentoEmail;
        this.emailsEstudiantes = emailsEstudiantes;
        this.emailsTutores = emailsTutores;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getJefeDepartamentoEmail() { return jefeDepartamentoEmail; }
    public void setJefeDepartamentoEmail(String jefeDepartamentoEmail) { this.jefeDepartamentoEmail = jefeDepartamentoEmail; }
    public List<String> getEmailsEstudiantes() { return emailsEstudiantes; }
    public void setEmailsEstudiantes(List<String> emailsEstudiantes) { this.emailsEstudiantes = emailsEstudiantes; }
    public List<String> getEmailsTutores() { return emailsTutores; }
    public void setEmailsTutores(List<String> emailsTutores) { this.emailsTutores = emailsTutores; }
}
