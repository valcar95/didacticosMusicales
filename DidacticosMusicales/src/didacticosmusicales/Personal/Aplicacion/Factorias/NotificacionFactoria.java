/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Aplicacion.Factorias;

import didacticosmusicales.Personal.Dominio.InterfacesComunicacion.INotificacion;
import didacticosmusicales.Personal.Infraestructura.Comunicacion.Notificaciones.CorreoElectronico;

/**
 *
 * @author XGAnalista2
 */
public class NotificacionFactoria {
    public static INotificacion ObtenerInstanciaNotificacion(){
         return new CorreoElectronico();
    }
}
