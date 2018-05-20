package didacticosmusicales.Personal.Aplicacion.Interfaces;

import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Material;

import java.util.List;

public interface IMaterialCtrl {
    Response<List<Material>> ObtenerMateriales();
}
