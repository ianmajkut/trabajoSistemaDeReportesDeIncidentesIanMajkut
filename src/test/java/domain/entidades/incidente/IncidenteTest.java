package domain.entidades.incidente;

import domain.entidades.problema.Problema;
import domain.entidades.tecnico.Especialidad;
import domain.entidades.tecnico.Tecnico;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class IncidenteTest {
    private Tecnico tecnico;
    private Incidente incidente;
    private Problema problema;
    private PosibleEstadoIncidente posibleEstadoIncidente;
    private Especialidad especialidadUno, especialidadDos, especialidadTres ,especialidadCuatro;


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
        this.especialidadUno = new Especialidad();
        this.especialidadDos= new Especialidad();
        this.especialidadTres = new Especialidad();
        this.especialidadCuatro = new Especialidad();
        this.especialidadUno.setNombre("Microsoft");
        this.especialidadDos.setNombre("Mac");
        this.especialidadTres.setNombre("Linux");
        this.especialidadCuatro.setNombre("Java");
        this.problema.agregarEspecialidadQueResuelve(this.especialidadUno);
        this.problema.agregarEspecialidadQueResuelve(this.especialidadDos);
        this.problema.agregarEspecialidadQueResuelve(this.especialidadTres);

//        Especialidad especialidadRequeridaUno = new Especialidad();
//        Especialidad especialidadRequeridaDos= new Especialidad();
//        Especialidad especialidadRequeridaTres = new Especialidad();
//        especialidadRequeridaUno.setNombre("Microsoft");
//        especialidadRequeridaDos.setNombre("Mac");
//        especialidadRequeridaTres.setNombre("Linux");
//        this.problema.agregarEspecialidadQueResuelve(especialidadRequeridaUno);
//        this.problema.agregarEspecialidadQueResuelve(especialidadRequeridaDos);
//        this.problema.agregarEspecialidadQueResuelve(especialidadRequeridaTres);

        this.incidente.setProblema(this.problema);

        this.posibleEstadoIncidente = new PosibleEstadoIncidente();
        this.posibleEstadoIncidente.setNombre("Confirmado");
    }

    @Test (expected = RuntimeException.class)
    public void empleadoNoEstaDisponible(){
//        Especialidad primerEspecialidad = new Especialidad();
//        Especialidad segundaEspecialidad= new Especialidad();
//        Especialidad terceraEspecialidad = new Especialidad();
//
//        primerEspecialidad.setNombre("Microsoft");
//        segundaEspecialidad.setNombre("AI");
//        terceraEspecialidad.setNombre("MySql");

        this.tecnico.agregarEspecialidad(this.especialidadUno);


        tecnico.setDisponible(false);

        this.incidente.confirmarse(this.posibleEstadoIncidente, this.tecnico);

    }

    @Test (expected = RuntimeException.class)
    public void empleadoNoTieneLaEspecialidadRequerida(){
//        Especialidad primerEspecialidad = new Especialidad();
//        Especialidad segundaEspecialidad= new Especialidad();
//        Especialidad terceraEspecialidad = new Especialidad();
//
//        primerEspecialidad.setNombre("DevOps");
//        segundaEspecialidad.setNombre("AI");
//        terceraEspecialidad.setNombre("MySql");

        this.tecnico.agregarEspecialidad(this.especialidadCuatro);


        tecnico.setDisponible(true);

        this.incidente.confirmarse(this.posibleEstadoIncidente, this.tecnico);

    }


}
