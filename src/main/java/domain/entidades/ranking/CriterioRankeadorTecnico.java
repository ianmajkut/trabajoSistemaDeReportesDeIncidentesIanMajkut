package domain.entidades.ranking;

import domain.entidades.tecnico.Tecnico;

import java.util.List;

public interface CriterioRankeadorTecnico {

    Tecnico obtenerTecnico(List<Tecnico> tecnicos);
}
