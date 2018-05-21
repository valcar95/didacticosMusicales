package didacticosmusicales.Personal.Infraestructura.Repositorio;


import didacticosmusicales.Personal.Dominio.Entidades.Material;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.IMaterialRepositorio;
import java.util.ArrayList;
import java.util.List;

public class MaterialRepositorio implements IMaterialRepositorio {

    private List<Material> materiales;

    public MaterialRepositorio(){
        this.materiales= new ArrayList<Material>();
        materiales.add(new Material(1,"Material 1"));
        materiales.add(new Material(2,"Material 2"));
        materiales.add(new Material(3,"Material 3"));
        materiales.add(new Material(4,"Material 4"));
        materiales.add(new Material(5,"Material 5"));
    }

    @Override
    public List<Material> ObtenerMateriales() {
        return this.materiales;
    }

    @Override
    public List<Material> ObtenerMaterialesPorIds(List<Integer> ids) {
        List<Material> result=new ArrayList<Material>();
        for (int id:ids
             ) {
            Material m=this.ObtenerMaterialPorId(id);
            if(m!=null){
                result.add(m);
            }
        }
        return result;
    }

    @Override
    public Material ObtenerMaterialPorId(int id) {
        Material result=null;
        for (Material m:this.materiales
             ) {
            if(m.getId()==id){
                result=m;
            }
        }
        return result;
    }
}
