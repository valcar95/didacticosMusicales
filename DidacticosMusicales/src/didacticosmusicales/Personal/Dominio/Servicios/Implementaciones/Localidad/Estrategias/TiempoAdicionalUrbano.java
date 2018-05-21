/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Dominio.Servicios.Implementaciones.Localidad.Estrategias;

import didacticosmusicales.Personal.Dominio.Servicios.Interfaces.Localidad.TiempoAdicionalLocalidad;


/**
 *
 * @author XGAnalista2
 */
public class TiempoAdicionalUrbano extends TiempoAdicionalLocalidad {

    @Override
    public int ObtenerMinutosAdicionales() {
       return 30;
    }
    
}
