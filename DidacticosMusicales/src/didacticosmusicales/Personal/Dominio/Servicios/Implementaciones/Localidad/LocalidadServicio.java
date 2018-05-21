/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Dominio.Servicios.Implementaciones.Localidad;

import didacticosmusicales.Personal.Dominio.Entidades.Enumerables.LocalidadEnum;
import didacticosmusicales.Personal.Dominio.Servicios.Interfaces.Localidad.ILocalidadServicio;
import didacticosmusicales.Personal.Dominio.Servicios.Interfaces.Localidad.ITiempoAdicionalLocalidadManejador;

/**
 *
 * @author XGAnalista2
 */
public class LocalidadServicio implements ILocalidadServicio {

    private ITiempoAdicionalLocalidadManejador tiempoAdicionalLocalidadManejador;
    
    public LocalidadServicio(){
    this.tiempoAdicionalLocalidadManejador=new TiempoAdicionalLocalidadManejador();
    }
    
    @Override
    public int ObtenerMinutosAdicionalesPorLocalidad(LocalidadEnum localidad) {
       return this.tiempoAdicionalLocalidadManejador.ObtenerTiempoAdicionalPorLocalidad(localidad);
    }
    
}
