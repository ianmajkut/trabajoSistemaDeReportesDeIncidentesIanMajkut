package domain.entidades.problema;

import domain.entidades.tecnico.Especialidad;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Problema {
    private String descripcion;
    private List<Especialidad> especialidadQueResuelven;
    private String nombre;
    private Double tiempoEstimadoResolucion;

    public Problema(){
        this.especialidadQueResuelven = new ArrayList<>();
    }

    public void agregarEspecialidadQueResuelve(Especialidad especialidad){
        this.especialidadQueResuelven.add(especialidad);
    }

}
