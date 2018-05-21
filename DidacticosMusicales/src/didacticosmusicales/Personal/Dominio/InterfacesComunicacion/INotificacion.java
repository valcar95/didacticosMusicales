/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Dominio.InterfacesComunicacion;

import didacticosmusicales.Personal.Dominio.Entidades.Asignacion;
import didacticosmusicales.Personal.Dominio.Entidades.Persona;
import didacticosmusicales.Personal.Dominio.Entidades.Servicio;
import java.util.List;

/**
 *
 * @author XGAnalista2
 */
public interface INotificacion {
    void Notificar(List<Persona> personalInvolucrado, Asignacion asignacion);
}
