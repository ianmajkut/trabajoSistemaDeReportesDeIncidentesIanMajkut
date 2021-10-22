package domain.entidades.notificaciones.medios;

import domain.entidades.notificaciones.MedioDeNotificacion;
import domain.entidades.notificaciones.Notificacion;

public class NotificadorEmail implements MedioDeNotificacion {
    //TODO
    @Override
    public void enviar(Notificacion unaNotificacion) {
        System.out.println("Envio por Mail");
    }
}
