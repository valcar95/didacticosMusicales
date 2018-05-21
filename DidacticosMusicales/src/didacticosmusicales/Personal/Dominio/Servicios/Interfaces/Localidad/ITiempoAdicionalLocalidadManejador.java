/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Dominio.Servicios.Interfaces.Localidad;

import didacticosmusicales.Personal.Dominio.Entidades.Enumerables.LocalidadEnum;

/**
 *
 * @author XGAnalista2
 */
public interface ITiempoAdicionalLocalidadManejador {
    int ObtenerTiempoAdicionalPorLocalidad(LocalidadEnum localidad);
}
