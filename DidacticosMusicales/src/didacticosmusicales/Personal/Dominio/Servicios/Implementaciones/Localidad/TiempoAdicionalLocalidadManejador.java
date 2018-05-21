/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Dominio.Servicios.Implementaciones.Localidad;

import didacticosmusicales.Personal.Dominio.Entidades.Enumerables.LocalidadEnum;
import didacticosmusicales.Personal.Dominio.Servicios.Implementaciones.Localidad.Estrategias.TiempoAdicionalRural;
import didacticosmusicales.Personal.Dominio.Servicios.Implementaciones.Localidad.Estrategias.TiempoAdicionalUrbano;
import didacticosmusicales.Personal.Dominio.Servicios.Interfaces.Localidad.ITiempoAdicionalLocalidadManejador;
import didacticosmusicales.Personal.Dominio.Servicios.Interfaces.Localidad.TiempoAdicionalLocalidad;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author XGAnalista2
 */
public class TiempoAdicionalLocalidadManejador implements ITiempoAdicionalLocalidadManejador {
    private Map<LocalidadEnum,TiempoAdicionalLocalidad> estrategias;
    public TiempoAdicionalLocalidadManejador(){
        this.estrategias=new HashMap<LocalidadEnum, TiempoAdicionalLocalidad>();
        this.estrategias.put(LocalidadEnum.Urbano, new TiempoAdicionalUrbano());
        this.estrategias.put(LocalidadEnum.Rural, new TiempoAdicionalRural());
    }

    @Override
    public int ObtenerTiempoAdicionalPorLocalidad(LocalidadEnum localidad) {
        TiempoAdicionalLocalidad estrategia=this.estrategias.get(localidad);
        return estrategia.ObtenerMinutosAdicionales();
    }
}
