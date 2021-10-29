package domain.entidades.incidente;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class EstadoIncidente {
    private LocalDateTime fechaHora;
    private Boolean estaCerrado;
    private PosibleEstadoIncidente posibleEstadoIncidente;
}
