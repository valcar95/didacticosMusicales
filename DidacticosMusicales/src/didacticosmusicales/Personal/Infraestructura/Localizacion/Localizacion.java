/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Infraestructura.Localizacion;

import didacticosmusicales.Personal.Dominio.Entidades.Enumerables.LocalidadEnum;
import didacticosmusicales.Personal.Dominio.InterfacesLocalizacion.ILocalizacion;

/**
 *
 * @author XGAnalista2
 */
public class Localizacion implements ILocalizacion {

    @Override
    public LocalidadEnum ObtenerLocalidadDesdeDireccion(String direccion) {
        if(direccion.toLowerCase().startsWith("cr") || direccion.toLowerCase().startsWith("cl")){
          return LocalidadEnum.Urbano;
        }
        else{
        return LocalidadEnum.Rural;
        }
    }
    
}
