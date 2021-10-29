package domain.entidades.ranking.criterios;

import domain.entidades.incidente.Incidente;
import domain.entidades.ranking.CriterioRankeadorTecnico;
import domain.entidades.tecnico.Tecnico;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MasRapido implements CriterioRankeadorTecnico {
    //TODO
    @Override
    public Tecnico obtenerTecnico(List<Tecnico> tecnicos) {
        return null;//return Collections.min(tecnicos, Comparator.comparing(Incidente::getDuracion));
    }
}
