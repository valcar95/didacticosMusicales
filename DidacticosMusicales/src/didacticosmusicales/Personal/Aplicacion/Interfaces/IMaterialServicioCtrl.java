package didacticosmusicales.Personal.Aplicacion.Interfaces;

import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Material;

import java.util.List;

public interface IMaterialServicioCtrl {
    Response<List<Material>> ObtenerMaterialesServicioPorIdServicio(int idServicio);
    Response<Boolean> InsertarMaterialServicio (int isMaterial, int idServicio);
    Response<Boolean> EliminarMaterialServicio (int isMaterial, int idServicio);
}
