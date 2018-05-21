/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Dominio.Servicios.Interfaces;

import didacticosmusicales.Personal.Dominio.Entidades.Asignacion;
import didacticosmusicales.Personal.Dominio.Entidades.Trabajador;
import java.util.List;

/**
 *
 * @author XGAnalista2
 */
public interface IAsignacionServicio {
    boolean ValidarRegistroDeAsignacion(Asignacion asignacion, List<Asignacion> asignaciones) throws Exception;
}
