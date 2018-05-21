/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Infraestructura.Comunicacion.Notificaciones;

import didacticosmusicales.Personal.Dominio.Entidades.Asignacion;
import didacticosmusicales.Personal.Dominio.Entidades.Persona;
import didacticosmusicales.Personal.Dominio.InterfacesComunicacion.INotificacion;
import java.util.List;

/**
 *
 * @author XGAnalista2
 */
public class MsgTexto implements INotificacion{

    @Override
    public void Notificar(List<Persona> personalInvolucrado, Asignacion asignacion) {
       //TODO: Implementar envio de mensaje de texto
    }
    
}
