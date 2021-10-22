package domain.entidades.ranking;

import domain.entidades.tecnico.Tecnico;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class RankeadorTecnico {
    private CriterioRankeadorTecnico criterio;
    private List<Tecnico> tecnicos;

    public RankeadorTecnico(){
        this.tecnicos = new ArrayList<>();
    }

    public Tecnico obtenerTecnico(){
       return this.criterio.obtenerTecnico(this.tecnicos);
    }

    public void agregarTecnicos(Tecnico ... tecnicos){
        Collections.addAll(this.tecnicos, tecnicos);
    }
}
