package domain.entidades.servicio;

import domain.entidades.problema.TipoProblema;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Servicio {
    private String nombre;
    private List<TipoProblema> tiposDeProblema;

    public Servicio(){
        this.tiposDeProblema = new ArrayList<>();
    }

}
