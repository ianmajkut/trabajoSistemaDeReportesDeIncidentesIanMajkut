package domain.entidades.problema;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TipoProblema {
    private String nombre;
    private List<Problema> problemas;

    public TipoProblema(){
        this.problemas = new ArrayList<>();
    }

}
