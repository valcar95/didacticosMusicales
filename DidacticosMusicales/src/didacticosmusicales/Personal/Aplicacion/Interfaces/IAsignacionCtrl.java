/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Aplicacion.Interfaces;

import didacticosmusicales.Personal.Aplicacion.DTO.AsignacionDTO;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Asignacion;
import java.util.List;

/**
 *
 * @author XGAnalista2
 */
public interface IAsignacionCtrl {
    Response<Boolean> RegistrarAsignacionCliente(AsignacionDTO a);
    Response<List<Asignacion>> ObtenerAsignacionesPorCedulaTrabajador(String cedula);
}
