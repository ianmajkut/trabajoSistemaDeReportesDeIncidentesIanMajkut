package domain.entidades.incidente;

import domain.entidades.personas.Cliente;
import domain.entidades.problema.TipoProblema;
import domain.entidades.servicio.Servicio;
import domain.entidades.servicio.ServicioContratado;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServicioTest {
    Cliente cliente;
    Servicio servicio, servicio2;
    ServicioContratado servicioContratado;
    TipoProblema tipoProblema;

    @Before
    public void init(){
        cliente =  new Cliente();
        servicio = new Servicio();
        servicio2 = new Servicio();
        servicioContratado = new ServicioContratado();

        cliente.setEmail("ian@gmail.com");
        cliente.setCuit("20-12345678-9");
        cliente.setNumeroCompleto("12345678");
        cliente.setRazonSocial("nose que va");

        servicio.setNombre("DevOps");
        servicio.getTiposDeProblema().add(tipoProblema);
        servicioContratado.setCliente(cliente);
        servicioContratado.setServicio(servicio);

        servicio2.setNombre("Linux");
        servicio2.getTiposDeProblema().add(tipoProblema);
    }

    @Test
    public void clienteContratoElServicio(){
        Assert.assertEquals(servicioContratado.getServicio().getNombre(), servicio.getNombre());
    }

    @Test
    public void clienteNoContratoElServicio(){
        Assert.assertEquals(servicioContratado.getServicio().getNombre(), "DevOps");
    }
}
