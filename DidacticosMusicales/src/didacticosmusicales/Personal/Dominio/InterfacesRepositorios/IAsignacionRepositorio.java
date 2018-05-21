/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Dominio.InterfacesRepositorios;

import didacticosmusicales.Personal.Dominio.Entidades.Asignacion;
import java.util.List;

/**
 *
 * @author XGAnalista2
 */
public interface IAsignacionRepositorio {
    void InsertarAsignacion (Asignacion a) throws Exception;
    List<Asignacion> ObtenerAsignacionesPorCedulaTrabajador(String cedula) throws Exception;
}
