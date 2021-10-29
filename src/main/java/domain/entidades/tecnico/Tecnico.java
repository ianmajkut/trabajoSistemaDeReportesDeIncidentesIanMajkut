package domain.entidades.tecnico;


import domain.entidades.incidente.Incidente;
import domain.entidades.problema.Problema;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Setter
@Getter
public class Tecnico {
    private String apellido;
    private String nombre;
    private Boolean disponible;
    private String email;
    private List<Especialidad> especialidades;
    private String numeroCompleto;
    private List<Incidente> incidentesCerrados;
    private List<Incidente> incidentesPendientes;

    public Tecnico(){
        this.especialidades = new ArrayList<>();
        this.incidentesCerrados = new ArrayList<>();
        this.incidentesPendientes = new ArrayList<>();
    }


    public Boolean estasDisponible(){
         if(this.disponible){
             return true;
         }else{
             return false;
         }
    }

    public Boolean resolvesProblema(Problema elProblema){
        return this.tengoLasEspecialidadesRequeridasParaSolucionar(elProblema);
    }

    private Boolean tengoLasEspecialidadesRequeridasParaSolucionar(Problema elProblema) {
        return especialidades.stream()
                .anyMatch(e -> elProblema.getEspecialidadQueResuelven().contains(e));
    }

    public void agregarIncidenteCerrado(Incidente ... incidentes){
        Collections.addAll(this.incidentesCerrados, incidentes);
    }

//    public void agregarEspecialidad(Especialidad ... especialidad){
//        Collections.addAll(this.especialidades, especialidad);
//    }
    public void agregarEspecialidad(Especialidad especialidad){
        this.especialidades.add(especialidad);
    }

    public void agregarIncidenteCerrado(Incidente incidente){
        this.incidentesCerrados.add(incidente);
    }


    public void agregarIncidentePendiente(Incidente incidente) {
        this.incidentesPendientes.add(incidente);
    }
}
