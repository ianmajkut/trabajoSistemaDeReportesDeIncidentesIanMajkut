package domain.entidades.servicio;

import domain.entidades.personas.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter

public class ServicioContratado {
    private Cliente cliente;
    private LocalDate fechaAlta;
    private Servicio servicio;
}
