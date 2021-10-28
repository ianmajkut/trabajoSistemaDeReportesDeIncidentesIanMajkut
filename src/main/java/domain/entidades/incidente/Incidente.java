package domain.entidades.incidente;

import domain.entidades.notificaciones.Notificacion;
import domain.entidades.notificaciones.Notificador;
import domain.entidades.problema.Problema;
import domain.entidades.servicio.ServicioContratado;
import domain.entidades.tecnico.Tecnico;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Incidente {
    private String descripcion;
    private List<EstadoIncidente>estados;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaCierre;
    private LocalDate fechaPosibleResolucion;
    private Problema problema;
    private ServicioContratado servicioCliente;
    private Tecnico tecnico;


    public Incidente(){
        this.estados = new ArrayList<>();
    }
    // TODO
    public void confirmarse(){
        if(this.tecnico.estasDisponible() && this.tecnico.resolvesProblema(this.problema)){
            this.fechaAlta = LocalDateTime.now();

            //Notificacion Tecnico
            Notificacion notificacionTecnico = new Notificacion();
            notificacionTecnico.setEmailDestinatario(this.tecnico.getEmail());
            notificacionTecnico.setMensaje(this.descripcion);
            notificacionTecnico.setNroDestinatario(this.tecnico.getNumeroCompleto());

            Notificador notificadorTecnico = new Notificador();
            notificadorTecnico.enviar(notificacionTecnico);

            //Notificacion Cliente
            Notificacion notificacionCliente = new Notificacion();
            notificacionCliente.setEmailDestinatario(this.servicioCliente.getCliente().getEmail());
            notificacionCliente.setMensaje("Su problema ha sido ingresado y la fecha posible de cierre es: " + fechaPosibleResolucion);
            notificacionCliente.setNroDestinatario(this.servicioCliente.getCliente().getNumeroCompleto());

            Notificador notificadorCliente = new Notificador();
            notificadorCliente.enviar(notificacionCliente);

            //Asignacion de estado
            EstadoIncidente estadoInicial = new EstadoIncidente();
            estadoInicial.setFechaHora(LocalDate.now());

            PosibleEstadoIncidente estadoIncidente = new PosibleEstadoIncidente();
            estadoIncidente.setNombre("El incidente a sido asignado");
            estadoInicial.setPosibleEstadoIncidente(estadoIncidente);
            agregarEstado(estadoInicial);

        }else if(!this.tecnico.estasDisponible()){
            throw new RuntimeException("No se puede confirmar porque el tecnico no esta disponible");
        }else if(!this.tecnico.resolvesProblema(this.problema)){
            throw new RuntimeException("No se puede confirmar porque el tecnico no puede resolver el problema");
        }
    }

    public void cerrar(){
        if(estados.stream().map(EstadoIncidente::getEstaCerrado).anyMatch(val -> val == true)){
            this.fechaCierre = LocalDateTime.now();

        }
    }


    public LocalDate fechaEstimadaResolucion(){
        return fechaPosibleResolucion;
    }

    public void agregarEstado(EstadoIncidente estado){
        this.estados.add(estado);
    }

//    public Boolean elEstadoDelIncidenteEsResuelto(List<EstadoIncidente> estados){
//        return this.tengoAlgunEstadoResuelto(estados);
//    }

//    public Boolean tengoAlgunEstadoResuelto(List<EstadoIncidente> estados){
//        return this.estados
//    }

//    public Integer diferenciaEntreFechaDeAltaYFechaFechaDeCierre(LocalDateTime fechaAlta, LocalDateTime fechaCierre){
//       return (Duration.between(fechaCierre, fechaAlta));
//    }

}
