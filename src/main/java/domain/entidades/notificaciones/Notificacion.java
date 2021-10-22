package domain.entidades.notificaciones;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notificacion {
    private String emailDestinatario;
    private String emailRemitente;
    private String mensaje;
    private String nroDestinatario;
    private String nroRemitente;
}
