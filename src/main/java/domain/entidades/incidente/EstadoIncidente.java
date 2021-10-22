package domain.entidades.incidente;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EstadoIncidente {
    private LocalDate fechaHora;
    private PosibleEstadoIncidente posibleEstadoIncidente;
}
