package domain.entidades.ranking.criterios;

import domain.entidades.ranking.CriterioRankeadorTecnico;
import domain.entidades.tecnico.Especialidad;
import domain.entidades.tecnico.Tecnico;

import java.util.List;

public class MayorIncidentesEspecialidadDia implements CriterioRankeadorTecnico {
    private Especialidad especialidad;
    private Integer nDia;

    //TODO
    @Override
    public Tecnico obtenerTecnico(List<Tecnico> tecnicos) {
        return null;
    }
}
