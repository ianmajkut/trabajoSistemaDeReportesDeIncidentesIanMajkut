package domain.entidades.personas;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Cliente {
    private String cuit;
    private String email;
    private String numeroCompleto;
    private String razonSocial;
}
