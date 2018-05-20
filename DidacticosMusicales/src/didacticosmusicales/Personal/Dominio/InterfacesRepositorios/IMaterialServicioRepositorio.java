package didacticosmusicales.Personal.Dominio.InterfacesRepositorios;

import didacticosmusicales.Personal.Dominio.Entidades.Material;
import java.util.List;

public interface IMaterialServicioRepositorio {
    List<Material> ObtenerMaterialesServicioPorIdServicio(int idServicio)  throws Exception;
    void InsertarMaterialServicio (int idMaterial, int idServicio) throws Exception;
    void EliminarMaterialServicio (int idMaterial, int idServicio) throws Exception;
}
