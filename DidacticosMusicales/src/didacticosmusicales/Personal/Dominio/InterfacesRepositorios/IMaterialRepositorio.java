package didacticosmusicales.Personal.Dominio.InterfacesRepositorios;
import didacticosmusicales.Personal.Dominio.Entidades.Material;
import java.util.List;

public interface IMaterialRepositorio {
    List<Material> ObtenerMateriales();
    List<Material> ObtenerMaterialesPorIds(List<Integer> ids);
    Material ObtenerMaterialPorId(int id);
}
