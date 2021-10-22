package domain.entidades.notificaciones.medios;

import domain.entidades.notificaciones.MedioDeNotificacion;
import domain.entidades.notificaciones.Notificacion;

public class NotificadorWpp implements MedioDeNotificacion {
    //TODO
    @Override
    public void enviar(Notificacion unaNotificacion) {
        System.out.println("Envio por Wpp");
    }
}
