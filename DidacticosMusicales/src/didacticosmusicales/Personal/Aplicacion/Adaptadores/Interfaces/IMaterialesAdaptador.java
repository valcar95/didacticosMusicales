/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Aplicacion.Adaptadores.Interfaces;

import didacticosmusicales.Personal.Dominio.Entidades.Material;
import java.util.List;

/**
 *
 * @author XGAnalista2
 */
public interface IMaterialesAdaptador {
    List<Material> ObtenerMateriales();
    List<Material> ObtenerMaterialesPorIds(List<Integer> ids);
    Material ObtenerMaterialPorId(int id);
}
