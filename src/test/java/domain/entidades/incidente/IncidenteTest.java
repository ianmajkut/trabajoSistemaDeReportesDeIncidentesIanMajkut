package domain.entidades.incidente;

import domain.entidades.problema.Problema;
import domain.entidades.tecnico.Especialidad;
import domain.entidades.tecnico.Tecnico;
import org.junit.Before;
import org.junit.Test;

public class IncidenteTest {
    private Tecnico tecnico;
    private Incidente incidente;
    private Problema problema;


    @Before
    public void init() {
        this.tecnico = new Tecnico();
        this.tecnico.setNombre("Sergio");
        this.tecnico.setApellido("Ramos");
        this.tecnico.setEmail("sergioramos@hotmail.com");
        this.tecnico.setNumeroCompleto("123456789");

        this.incidente = new Incidente();
        this.incidente.setTecnico(this.tecnico);

        this.problema = new Problema();
        Especialidad especialidadRequeridaUno = new Especialidad();
        Especialidad especialidadRequeridaDos= new Especialidad();
        Especialidad especialidadRequeridaTres = new Especialidad();
        especialidadRequeridaUno.setNombre("Microsoft");
        especialidadRequeridaDos.setNombre("Mac");
        especialidadRequeridaTres.setNombre("Linux");
        this.problema.agregarEspecialidadQueResuelve(especialidadRequeridaUno);
        this.problema.agregarEspecialidadQueResuelve(especialidadRequeridaDos);
        this.problema.agregarEspecialidadQueResuelve(especialidadRequeridaTres);

        this.incidente.setProblema(this.problema);


    }

    @Test (expected = RuntimeException.class)
    public void empleadoNoEstaDisponible(){
        Especialidad primerEspecialidad = new Especialidad();
        Especialidad segundaEspecialidad= new Especialidad();
        Especialidad terceraEspecialidad = new Especialidad();

        primerEspecialidad.setNombre("DevOps");
        segundaEspecialidad.setNombre("AI");
        terceraEspecialidad.setNombre("MySql");

        this.tecnico.agregarEspecialidad(primerEspecialidad);
        this.tecnico.agregarEspecialidad(segundaEspecialidad);
        this.tecnico.agregarEspecialidad(terceraEspecialidad);

        tecnico.setDisponible(false);

        this.incidente.confirmarse();

    }

    @Test (expected = RuntimeException.class)
    public void empleadoNoTieneLaEspecialidadRequerida(){
        Especialidad primerEspecialidad = new Especialidad();
        Especialidad segundaEspecialidad= new Especialidad();
        Especialidad terceraEspecialidad = new Especialidad();

        primerEspecialidad.setNombre("DevOps");
        segundaEspecialidad.setNombre("AI");
        terceraEspecialidad.setNombre("MySql");

        this.tecnico.agregarEspecialidad(primerEspecialidad);
        this.tecnico.agregarEspecialidad(segundaEspecialidad);
        this.tecnico.agregarEspecialidad(terceraEspecialidad);

        tecnico.setDisponible(true);

        this.incidente.confirmarse();

    }
}
